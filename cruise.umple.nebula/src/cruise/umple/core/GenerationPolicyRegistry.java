/*******************************************************************************
* Copyright (c) 2013 Ahmed M.Orabi, Mahmoud M.Orabi.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     Ahmed M.Orabi
*     Mahmoud M.Orabi
*
* Please refer to the code authors before making any changes. 
* For any code reuse or copy, contact the authors and it is a MUST 
* to refer author names.
*
* @author -Ahmed M.Orabi {@link ahmedvc@hotmail.com}
* @author Mahmoud M.Orabi {@link mahmoud_3rabi@hotmail.com}
*******************************************************************************/
package cruise.umple.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationArguments;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationLoopPath;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationCallback.GenerationStringSegment;
import cruise.umple.core.GenerationCallback.WatchedObjectValue;
import cruise.umple.core.GenerationPoint.InterceptorResponse;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.modeling.handlers.cpp.ICppDefinitions;
import cruise.umple.templates.GenerationTemplateDelegator;
import cruise.umple.templates.IGenerationTemplateRegistry;
import cruise.umple.values.GenerationValueGetterDelegator;
import cruise.umple.values.IGenerationValueGetter;


public class GenerationPolicyRegistry implements IGenerationTemplateRegistry, IGenerationValueGetter{
	
	private GenerationTemplateDelegator generationTemplateDelegator;
	private IGenerationValueGetter generationValueGetter;
	
	private static List<Class<?>> parsedClasses= new ArrayList<Class<?>>();
	private static Map<String, List<GenerationPointObject>> _pointsInvocations= new HashMap<String, List<GenerationPointObject>>();
	private static Map<String, List<Object>> _parsedDecisionClasses= new HashMap<String, List<Object>>();
	private static Map<String, Map<String, List<LoopObject>>> _loopInvocations= new HashMap<String, Map<String, List<LoopObject>>>();
	protected static Map<String, GenerationGroupDefinition> groupDefnitions= new HashMap<String, GenerationGroupDefinition>();
	private static Map<String, List<Object>> _parsedClasses= new WeakHashMap<String, List<Object>>();
	
	
	private static Map<String, List<LoopProcessorObject>> _loopProcessorsInocations= new HashMap<String, List<LoopProcessorObject>>();
	private static Map<String, List<GenerationPointObject>> _watchingPointsInvocations= new HashMap<String, List<GenerationPointObject>>();
	private static Map<String, List<DecisionObject>> _decisionInvocations= new HashMap<String, List<DecisionObject>>();
	private static boolean processed= false;

	private Map<Object, TreeMap<String, Object>> objectsPathMap= new HashMap<Object, TreeMap<String, Object>>();
	protected ArgumentsRetrieval generationObjectsRetriever= new ArgumentsRetrieval();
	protected ArgumentsRetrieval decisionObjectsRetriever= new ArgumentsRetrieval();
	private ArgumentsRetrieval interceptedObjectsRetriever= new ArgumentsRetrieval();
	
	protected GenerationLogger generationLogger;
	
	public GenerationPolicyRegistry() {
		super();
		
		this.generationLogger= new GenerationLogger();
		
		this.generationValueGetter= new GenerationValueGetterDelegator(this);
		this.generationTemplateDelegator= new GenerationTemplateDelegator(this);
		processGroupDefinitions(GenerationGroupDefinition.class);
	}
	
	public void registerGenerationPolicy(Object policy){
		this.generationValueGetter.register(policy);
	}
	
	public boolean decisionPoint(Object obj, GenerationPolicyRegistry registry, String decisionPoint, Object... arguments){
		return this.processDecisionPointsMethods(obj, registry, decisionPoint, false, arguments);
	}
	
	public void process(Object obj){
		postRegister();
		HashMap<String, Object> values = new HashMap<String, Object>();
		values.put(CommonConstants.BLANK, obj);
		process(obj, Collections.<String> emptyList(), values, CommonConstants.BLANK);
	}
	
	public void process(Object obj, List<String> path, Map<String, Object> values, String key){
		processRoot(obj, LoopAspectConstants.BEFORE);
		process(obj, path, values, key, LoopAspectConstants.BEFORE);
		
		
		processRoot(obj, LoopAspectConstants.DEFAULT);
		process(obj, path, values, key, LoopAspectConstants.DEFAULT);
		
		processRoot(obj, LoopAspectConstants.PRE);
		process(obj, path, values, key, LoopAspectConstants.PRE);
		
		processRoot(obj, LoopAspectConstants.AFTER);
		process(obj, path, values, key, LoopAspectConstants.AFTER);
		
		processRoot(obj, LoopAspectConstants.FINALIZE);
		process(obj, path, values, key, LoopAspectConstants.FINALIZE);
		
	}

	private void process(Object obj, List<String> path, Map<String, Object> values, String key, String aspect) {
		Map<String, List<LoopObject>> map = this._loopInvocations.get(key);
		if(map== null){
			return;
		}
		for(String item: map.keySet()){
			List<LoopObject> list = map.get(item);
			for(LoopObject loopObject: list){
				String id = loopObject.fGenerationLoopAnnotation.id();
				List<String> newPath= new ArrayList<String>(path);
				newPath.add(id);
				
				try {
					List<LoopProcessorObject> processors = this._loopProcessorsInocations.get(newPath.toString());
					
					List<LoopProcessorObject> currentLoop= new ArrayList<LoopProcessorObject>();
					List<LoopProcessorObject> defaultLoop= new ArrayList<LoopProcessorObject>();
					
					if(processors!= null){
						for(LoopProcessorObject loopProcessorObject: processors){
							String currentAspect = getAspect(loopProcessorObject);
							if(currentAspect.equals(aspect)){
								currentLoop.add(loopProcessorObject);
							}else if(LoopAspectConstants.ALL.equals(currentAspect)){
								defaultLoop.add(loopProcessorObject);
							}
						}
					}
					
					Object invoke = loopObject.fMethod.invoke(loopObject.fInstance, getParameters(obj, this, loopObject.fMethod));
					if(invoke instanceof List<?>){
						List<?> sub= (List<?>) invoke;
						
						if(!currentLoop.isEmpty()){
							Collections.sort(currentLoop, new Comparator<LoopProcessorObject>() {

								@Override
								public int compare(LoopProcessorObject o1, LoopProcessorObject o2) {
									int priority1 = o1.fLoopProcessorAnnotation.priority();
									int priority2 = o2.fLoopProcessorAnnotation.priority();
									
									LoopProcessorAnnotations loopProcessorAnnotations1 = o1.fLoopProcessorAnnotations;
									if(loopProcessorAnnotations1!= null){
										priority1 = loopProcessorAnnotations1.priority();
									}
									
									LoopProcessorAnnotations loopProcessorAnnotations2 = o2.fLoopProcessorAnnotations;
									if(loopProcessorAnnotations2!= null){
										priority2 = loopProcessorAnnotations2.priority();
									}
									
									if(priority1== priority2){
										return 0;
									}
									
									return priority1> priority2? -1: 1;
								}
							});
							
							for(Object subObject: sub){
								TreeMap<String, Object> newMap = new TreeMap<String, Object>(values);
								newMap.put(id, subObject);
								this.objectsPathMap.put(subObject, newMap);
								
								process(subObject, currentLoop);
								process(subObject, newPath, newMap, id, aspect);
							}
						}else{
							for(Object subObject: sub){
								HashMap<String, Object> newMap = new HashMap<String, Object>(values);
								newMap.put(id, subObject);
								process(subObject, newPath, newMap, id, aspect);
							}
						}
					}
				} catch (Exception e) {
					this.generationLogger.addError(e);
				}
			}
		}
	}
	
	private static String getAspect(LoopProcessorObject processorObject){
		LoopProcessorAnnotations loopProcessorAnnotations = processorObject.fLoopProcessorAnnotations;
		if(loopProcessorAnnotations!= null){
			return loopProcessorAnnotations.aspect();
		}
		return processorObject.fLoopProcessorAnnotation.aspect();
	}
	
	private void processRoot(Object obj, String aspect) {
		TreeMap<String, Object> hashMap = getPathMap(obj);
		if(hashMap== null){
			hashMap= new TreeMap<String, Object>();
			hashMap.put(CommonConstants.BLANK, obj);
			this.objectsPathMap.put(obj, hashMap);
		}
		
		List<LoopProcessorObject> processors = this._loopProcessorsInocations.get(Collections.<String> emptyList().toString());
		
		if(processors!= null){
			List<LoopProcessorObject> list= new ArrayList<GenerationPolicyRegistry.LoopProcessorObject>();
			for(LoopProcessorObject loopProcessorObject: processors){
				if(aspect.equals(loopProcessorObject.fLoopProcessorAnnotation.aspect())){
					list.add(loopProcessorObject);
				}
			}
			
			try {
				process(obj, list);
			} catch (Exception e) {
				this.generationLogger.addError(e);
			}
		}
		
		
	}

	private void process(Object obj, List<LoopProcessorObject> pre)
			throws IllegalAccessException, InvocationTargetException {
		for(LoopProcessorObject loopProcessorObject: pre){
			if(!checkConditions(obj, loopProcessorObject)){
				continue;
			}
			loopProcessorObject.fMethod.invoke(loopProcessorObject.fInstance,
					getParameters(obj, this, loopProcessorObject.fMethod));
		}
	}

	private boolean checkConditions(Object element, LoopProcessorObject loopProcessorObject) {
		LoopProcessorAnnotation loopProcessorAnnotation = loopProcessorObject.fLoopProcessorAnnotation;
		LoopProcessorAnnotations loopProcessorAnnotations= loopProcessorObject.fLoopProcessorAnnotations;
		
		if(loopProcessorAnnotations!= null){
			if(!checkConditions(element, loopProcessorAnnotations.ifConditionIds(), 
					loopProcessorAnnotations.ifNotConditionIds())){
				return false;
			}
		}
		
		return checkConditions(element, loopProcessorAnnotation.ifConditionIds(), loopProcessorAnnotation.ifNotConditionIds());
	}

	private boolean checkConditions(Object element, String[] ifConditionIds,
			String[] ifNotConditionIds) {
		for(int index=0; index<ifConditionIds.length; index++){
			if (!decisionPoint(element, this, ifConditionIds[index])) {
				return false;
			}
		}
		
		for(int index=0; index<ifNotConditionIds.length; index++){
			if (processDecisionPointsMethods(element, this, ifNotConditionIds[index], true)) {
				return false;
			}
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> generationPointList(Object element, String generationPoint, Object... arguments){
		List<Object> value = this.interceptedObjectsRetriever.getValue(generationPoint, element, arguments);
		if(!value.isEmpty()){
			Object object = value.get(0);
			if(object instanceof ArrayList){
				return (List<Object>) object;
			}
			return new ArrayList<Object>();
		}
		
		List<Object> all= new ArrayList<Object>();

		List<GenerationPointObject> list = this._pointsInvocations.get(generationPoint);
		if(list== null){
			return all;
		}
		
		for(GenerationPointObject generationPointObject: list){
			try {
				Object invoke= generationPointObject.invoke(element, this, null, null, arguments);
				
				if(invoke instanceof Collection== false){
					continue;
				}
				
				Collection<?> newCollection= (Collection<?>) invoke;
				all.addAll(newCollection);
				
				if(generationPointObject.unique()){
					this.interceptedObjectsRetriever.setValue(generationPoint, all, true, element, arguments);
					return all;
				}
			} catch (Exception e) {
				this.generationLogger.addError(e);
			}
		}
		this.interceptedObjectsRetriever.setValue(generationPoint, all, true, element, arguments);
		return all;
	}
	
	public String generationPointString(Object element, String generationPoint, Object... arguments){
		List<Object> value = this.interceptedObjectsRetriever.getValue(generationPoint, element, arguments);
		if(!value.isEmpty()){
			Object object = value.get(0);
			if(object instanceof String){
				return (String) object;
			}
			return CommonConstants.BLANK;
		}
		
		String all= CommonConstants.BLANK;

		List<GenerationPointObject> list = this._pointsInvocations.get(generationPoint);
		if(list== null){
			return CommonConstants.BLANK;
		}
		
		for(GenerationPointObject generationPointObject: list){
			try {
				if(generationPointObject.fGenerationPoint.defaulted()&& !all.isEmpty()){
					continue;
				}
				
				Object invoke= generationPointObject.invoke(element, this, all, null, arguments);
				
				if(generationPointObject.unique()&& invoke instanceof Boolean&& (((Boolean)invoke)).booleanValue()){
					this.interceptedObjectsRetriever.setValue(generationPoint, all, true, element, arguments);
					return all;
				}
				
				if(invoke instanceof String== false){
					continue;
				}
				
				all= all+ invoke;
				
				if(generationPointObject.unique()){
					this.interceptedObjectsRetriever.setValue(generationPoint, invoke, true, element, arguments);
					return (String) invoke;
				}
				
			} catch (Exception e) {
				this.generationLogger.addError(e);
			}
		}
		this.interceptedObjectsRetriever.setValue(generationPoint, all, true, element, arguments);
		return all;
	}

	public Integer generationPointInteger(Object element, String generationPoint, Object... arguments){
		List<Object> value = this.interceptedObjectsRetriever.getValue(generationPoint, element, arguments);
		if(!value.isEmpty()){
			Object object = value.get(0);
			if(object instanceof Integer){
				return (Integer) object;
			}
			return Integer.valueOf(0);
		}
		
		Integer returnValue = null;
		int currentPriority = 0;
		List<GenerationPointObject> list = this._pointsInvocations.get(generationPoint);
		if(list== null){
			this.interceptedObjectsRetriever.setValue(generationPoint, Integer.valueOf(0), true, element, arguments);
			return Integer.valueOf(0);
		}
		
		for(GenerationPointObject generationPointObject: list){
			try {
				Object invoke= generationPointObject.invoke(element, this, null, null, arguments);
				
				if(invoke!= null){
					if(invoke instanceof Integer== false){
						continue;
					}
					
					int currentValue = ((Integer) invoke).intValue();
					
					if(generationPointObject.unique()){
						this.interceptedObjectsRetriever.setValue(generationPoint, Integer.valueOf(currentValue), true, element, arguments);
						return Integer.valueOf(currentValue);
					}
					
					if(invoke instanceof Integer){
						int priority = generationPointObject.fGenerationPoint.priority();
						if(priority>currentPriority){
							returnValue= Integer.valueOf(currentValue);
							currentPriority= priority;
						}
					}
				}
			} catch (Exception e) {
				this.generationLogger.addError(e);
			}
		}
		this.interceptedObjectsRetriever.setValue(generationPoint, returnValue, true, element, arguments);
		return returnValue;
	}

	
	@Override
	public synchronized void register(Object handler) {
		if(handler instanceof Class<?>){
			if(this.parsedClasses.contains(handler)){
				return;
			}
			Class<?> clazz = (Class<?>) handler;
			
			processGroupDefinitions(clazz);
			this.parsedClasses.add(clazz);
			return;
		}
		
		Class<? extends Object> clazz= handler.getClass();
		if(this.parsedClasses.contains(clazz)){
			return;
		}
		this.parsedClasses.add(clazz);
		
		processGroupDefinitions(clazz);
		
		Set<String> toBeSorted= new HashSet<String>();
		
		for (Method method : clazz.getMethods()) {
			GenerationLoopAnnotation generationLoopAnnotation = method.getAnnotation(GenerationLoopAnnotation.class);
			if(generationLoopAnnotation!= null){
				String id = generationLoopAnnotation.id();
				String[] processes = generationLoopAnnotation.processes();
				
				Map<String, List<LoopObject>> map= null;
				
				if(processes.length==0){
					processes= new String[]{CommonConstants.BLANK};
				}
				
				for(String process: processes){
					map = this._loopInvocations.get(process);
					if(map== null){
						map= new HashMap<String, List<LoopObject>>();
						if(this._loopInvocations.get(process)== null){
							this._loopInvocations.put(process, map);
						}
					}
					
					List<LoopObject> list = map.get(id);
					if(list== null){
						list= new ArrayList<LoopObject>();
						map.put(id, list);
					}
					list.add(new LoopObject(method, handler, generationLoopAnnotation));
				}
				continue;
			}
			
			LoopProcessorAnnotation loopProcessorAnnotation = method.getAnnotation(LoopProcessorAnnotation.class);
			if(loopProcessorAnnotation!= null){
				setLoopProcessorAnnotation(handler, method, loopProcessorAnnotation, null);
				continue;
			}
			
			LoopProcessorAnnotations loopProcessorAnnotations = method.getAnnotation(LoopProcessorAnnotations.class);
			if(loopProcessorAnnotations!= null){
				for(LoopProcessorAnnotation loop: loopProcessorAnnotations.loopProcessorAnnotations()){
					setLoopProcessorAnnotation(handler, method, loop, loopProcessorAnnotations);
				}
				continue;
			}
			
			GenerationPoint annotation = method.getAnnotation(GenerationPoint.class);
			if(annotation== null){
				GenerationPoints annotations = method.getAnnotation(GenerationPoints.class);
				if(annotations== null){
					locateDecisionPoints(clazz, method);
					continue;
				}
				
				for(GenerationPoint currentAnnotation: annotations.value()){
					processAnnotationDetails(currentAnnotation, method, clazz, toBeSorted);
				}
			}
			
			processAnnotationDetails(annotation, method, clazz, toBeSorted);
			locateDecisionPoints(handler, method);
		}
		
		for(String generationPoint: toBeSorted){
			List<GenerationPointObject> list = this._pointsInvocations.get(generationPoint);
			final Map<String, List<String>> pathMap= new HashMap<String, List<String>>();
			for(String group: this.groupDefnitions.keySet()){
				List<String> path= new ArrayList<String>();
				GenerationGroupDefinition generationGroupDefinition = this.groupDefnitions.get(group);
				
				String after= generationGroupDefinition.after();
				while(!after.isEmpty()){
					path.add(after);
					after= this.groupDefnitions.get(after).after();
				}
				Collections.reverse(path);
				pathMap.put(group, path);
				
				//orderGroups.addGroup(group, generationGroupDefinition);
			}
			
			Collections.sort(list, new Comparator<GenerationPointObject>() {

				@Override
				public int compare(GenerationPointObject point1, GenerationPointObject point2) {
					Map<String, List<String>> temp= pathMap;
					GenerationPoint annotation1= point1.fGenerationPoint;
					GenerationPoint annotation2 = point2.fGenerationPoint;
					
					String group1 = annotation1.group();
					List<String> group1Path = temp.get(group1);
					String group2 = annotation2.group();
					List<String> group2Path = temp.get(group2);
					
					checkGroup: {
						if(group1Path!=null&& group1Path.equals(group2Path)&& group1.equals(group2)){
							break checkGroup; 
						}
						int group1Priority = GenerationPolicyRegistry.this.groupDefnitions.get(group1).priority();
						int group2Priority = GenerationPolicyRegistry.this.groupDefnitions.get(group2).priority();
						
						for(String segment: group1Path){
							int priority = GenerationPolicyRegistry.this.groupDefnitions.get(segment).priority();
							if(priority<group1Priority){
								group1Priority= priority;
							}
						}
						
						for(String segment: group2Path){
							int priority = GenerationPolicyRegistry.this.groupDefnitions.get(segment).priority();
							if(priority<group2Priority){
								group2Priority= priority;
							}
						}
						
						int size1 = group1Path.size();
						int size2 = group2Path.size();
						if(group1Priority== group2Priority&& size1!= size2){
							if(size1>size2){
								return 1;
							}
							return -1;
						}
						
						int comparePriorities = comparePriorities(group1Priority, group2Priority);
						if(comparePriorities!=0){
							return comparePriorities;
						}
					}
					
					
					
					int priority1 = annotation1.priority();
					int priority2 = annotation2.priority();
					
					
					return comparePriorities(priority1, priority2);
				}

				private int comparePriorities(int priority1, int priority2) {
					if(priority1== priority2){
						return 0;
					}
					
					return priority1< priority2? 1:-1;
				}
			});
		}
	}

	private void processGroupDefinitions(Class<?> clazz) {
		for(Field field: clazz.getDeclaredFields()){
			GenerationGroupDefinition annotation = field.getAnnotation(GenerationGroupDefinition.class);
			if(annotation!= null){
				try {
					Object object = field.get(clazz);
					if(object instanceof String== false){
						continue;
					}
					
					this.groupDefnitions.put((String) object, annotation);
				} catch (Exception e) {
					this.generationLogger.addError(e);
				}
			}
		}
	}
	
	private synchronized void postRegister(){
		if(processed){
			return;
		}
		for(String key: this._decisionInvocations.keySet()){
			List<DecisionObject> list = this._decisionInvocations.get(key);
			for(DecisionObject decisionObject: list){
				for(String condition: decisionObject.fDecisionPoint.watchIf()){
					List<GenerationPointObject> generationsList = this._pointsInvocations.get(condition);
					if(generationsList!= null){
						for(GenerationPointObject object: generationsList){
							object.whenDecisions.add(decisionObject);
						}
					}
				}
				
				for(String condition: decisionObject.fDecisionPoint.watchIfNot()){
					List<GenerationPointObject> generationsList = this._pointsInvocations.get(condition);
					if(generationsList!= null){
						for(GenerationPointObject object: generationsList){
							object.whenNotDecisions.add(decisionObject);
						}
					}
				}
			}
		}
		processed= true;
	}

	private void setLoopProcessorAnnotation(Object handler, Method method, LoopProcessorAnnotation loopProcessorAnnotation, 
			LoopProcessorAnnotations loopProcessorAnnotations) {
		String[] processPath = loopProcessorAnnotation.processPath();
		List<String> asList = Arrays.asList(processPath);
		List<LoopProcessorObject> list = this._loopProcessorsInocations.get(asList.toString());
		if(list== null){
			list= new ArrayList<GenerationPolicyRegistry.LoopProcessorObject>();
			this._loopProcessorsInocations.put(asList.toString(), list);
		}
		
		list.add(new LoopProcessorObject(method, handler, loopProcessorAnnotation, loopProcessorAnnotations));
	}

	private DecisionPoint locateDecisionPoints(Object instance, Method method) {
		DecisionPoint decisionPoint = method.getAnnotation(DecisionPoint.class);
		processDecisionAnnotationDetails(decisionPoint, method, instance);
		return decisionPoint;
	}
	
	private void processAnnotationDetails(GenerationPoint annotation, Method method, Object instance, Set<String> toBeSorted){
		if(annotation== null){
			return;
		}
		String generationPoint = annotation.generationPoint();
		
		List<Object> list = this._parsedClasses.get(generationPoint);
		if(list== null){
			list= new ArrayList<Object>();
		}
		
		Class<? extends Object> clazz = instance.getClass();
		if(!list.contains(clazz)){
			list.add(clazz);
			this._parsedClasses.put(generationPoint, list);
		}
		
		List<GenerationPointObject> pointInvocations = this._pointsInvocations.get(generationPoint);
		if(pointInvocations== null){
			pointInvocations= new ArrayList<GenerationPointObject>();
			this._pointsInvocations.put(generationPoint, pointInvocations);
		}
		
		toBeSorted.add(generationPoint);
		GenerationPointObject generationPointObject = new GenerationPointObject(method, annotation, instance);
		pointInvocations.add(generationPointObject);
		
		String[] watches= annotation.intercept();
		for(String watch: watches){
			List<GenerationPointObject> watchList = this._watchingPointsInvocations.get(watch);
			if(watchList== null){
				watchList= new ArrayList<GenerationPointObject>();
				this._watchingPointsInvocations.put(watch, watchList);
			}
			watchList.add(generationPointObject);
		}
	}
	
	private void processDecisionAnnotationDetails(DecisionPoint annotation, Method method, Object instance){
		if(annotation== null){
			return;
		}
		
		String decisionPoint = annotation.decisionPoint();
		
		List<Object> list = this._parsedDecisionClasses.get(decisionPoint);
		if(list== null){
			list= new ArrayList<Object>();
		}
				
		List<DecisionObject> pointInvocations = this._decisionInvocations.get(decisionPoint);
		if(pointInvocations== null){
			pointInvocations= new ArrayList<DecisionObject>();
			this._decisionInvocations.put(decisionPoint, pointInvocations);
		}
		pointInvocations.add(new DecisionObject(method, annotation, instance));
	}
	
	protected boolean processDecisionPointsMethods(Object element, GenerationPolicyRegistry registry, String generationPoint, boolean inverse, Object... arguments) {
		List<Object> values = registry.generationObjectsRetriever.getValue(generationPoint, 
				element, arguments);
		if(!values.isEmpty()){
			Object object = values.get(0);
			if(object instanceof Boolean){
				return ((Boolean) object).booleanValue();
			}
			return !inverse;
		}
			
		List<DecisionObject> list = this._decisionInvocations.get(generationPoint);
		
		if(list== null){
			Object object = registry.getObject(element, generationPoint, arguments);
			if(object== null){
				registry.generationObjectsRetriever.setValue(generationPoint, (Object)Boolean.valueOf(!inverse), true, element, arguments);
				//why this condition? This is required when we have empty decision point that is intended to be extended by other places,
				//and it will be null unless it is used
				//FIXME: Reconsider this logic. It should be false, and provide a return false decision point instead
				return !inverse;
			}
			//Try on the attribute only in that case
			return registry.getBoolean(element, generationPoint, arguments);
		}
		
		boolean decision= true;
		for(DecisionObject decisionObject: list){
			
			deceision:{
				String[] ifConditionIds = decisionObject.fDecisionPoint.ifConditionIds();
				for(int index=0; index<ifConditionIds.length; index++){
					if (!decisionPoint(element, this, ifConditionIds[index], arguments)) {
						decision= /*decision&&*/false;
						break deceision;
					}
				}
				
				String[] ifNotConditionIds = decisionObject.fDecisionPoint.ifNotConditionIds();
				for(int index=0; index<ifNotConditionIds.length; index++){
					if (processDecisionPointsMethods(element, this, ifNotConditionIds[index], true, arguments)) {
						decision= /*decision&&*/false;
						break deceision;
					}
				}
				
				Method method= decisionObject.fMethod;
				try {
					Object[] parameters = getParameters(element,registry, method, arguments);
					Object result = method.invoke(decisionObject.fInstance, parameters);
					
					if(result instanceof Boolean){
						Boolean invoke = (Boolean) result;
						decision= decision&&invoke.booleanValue();
						if(decisionObject.fDecisionPoint.optimistic()){
							if(invoke.booleanValue()){
								registry.generationObjectsRetriever.setValue(generationPoint, 
										(Object)Boolean.TRUE, true, element, arguments);
								return true;
							}
						}else{
							if(!decision){
								registry.generationObjectsRetriever.setValue(generationPoint, 
										(Object)Boolean.valueOf(decision), true, element, arguments);
								return decision;
							}
						}
					}
				} catch (Exception e) {
					this.generationLogger.addError(e);
				}
			}
			
		}
		registry.generationObjectsRetriever.setValue(generationPoint, 
				(Object)Boolean.valueOf(decision), true, element, arguments);
		
		return decision;
	}
	
	public void setFieldsParameters(Object instance, Object element, Field[] fields, Object... args){
		setFieldsParameters(instance, element, fields, false, args);
	}
	
	public void setFieldsParameters(Object instance, Object element, Field[] fields, boolean typeCheck, Object... args){
		List<FieldDescriptor> fieldsDescriptors = getFieldsParameters(element, fields, typeCheck, args);
		for(FieldDescriptor fieldDescriptor: fieldsDescriptors){
			fieldDescriptor.fField.setAccessible(true);
			try {
				fieldDescriptor.fField.set(instance, fieldDescriptor.fValue);
			} catch (Exception e) {
				this.generationLogger.addError(e);
			}
		}
	}
	
	public List<FieldDescriptor> getFieldsParameters(Object element, Field[] fields, Object... args) {
		return getFieldsParameters(element, fields, false, args);
	}
	
	public List<FieldDescriptor> getFieldsParameters(Object element, Field[] fields, boolean typeCheck, Object... args) {
		Map<String, Object> descriptorMap= new HashMap<String, Object>();
		List<Object> arguments= new ArrayList<Object>();
		Map<String, GenerationArgumentDescriptor> descriptors= new HashMap<String, GenerationArgumentDescriptor>();
		prepareArguments(descriptorMap, descriptors, arguments, args);
		
		List<Annotation> annotationsList= new ArrayList<Annotation>();
		List<Class<?>> parameterTypesList = new ArrayList<Class<?>>();
		List<Field> retrievedFields= new ArrayList<Field>();
		
		for(int index=0; index<fields.length; index++){
			Field field= fields[index];
			Annotation[] fieldAnnotation = field.getAnnotations();
			if(fieldAnnotation.length==0){
				continue;
			}
			retrievedFields.add(field);
			annotationsList.add(fieldAnnotation[0]);
			parameterTypesList.add(field.getType());
		}
		
		Annotation[] annotations= new Annotation[annotationsList.size()];
		Class<?>[] parameterTypes= new Class<?>[parameterTypesList.size()];
		for(int index=0; index<annotations.length; index++){
			annotations[index]= annotationsList.get(index);
			parameterTypes[index]= parameterTypesList.get(index);
		}
		
		List<FieldDescriptor> fieldsDescriptors= new ArrayList<FieldDescriptor>();
		
		Object[] parameters = getParameters(element, null, typeCheck, annotations, parameterTypes, descriptorMap, descriptors, arguments, null, args);
		for(int index=0; index<parameters.length; index++){
			fieldsDescriptors.add(new FieldDescriptor(retrievedFields.get(index), parameters[index]));
		}
		return fieldsDescriptors;
	}

	protected static void prepareArguments(Map<String, Object> descriptorMap,
			Map<String, GenerationArgumentDescriptor> descriptors, List<Object> arguments, Object... args) {
		for(Object object: args){
			if(object instanceof GenerationArgumentDescriptor){
				GenerationArgumentDescriptor descriptor= (GenerationArgumentDescriptor) object;
				String id = descriptor.id();
				descriptorMap.put(id, descriptor.value());
				descriptors.put(id, descriptor);
			}else{
				arguments.add(object);
			}
		}
	}
	
	public class FieldDescriptor{
		public Field fField;
		public Object fValue;
		
		public FieldDescriptor(Field field, Object value) {
			this.fField= field;
			this.fValue= value;
		}
	}
	
	public static Object[] getParameters(Object element, GenerationPolicyRegistry registry, Method fMethod, Object... args) {
		return getParametersValues(element, registry, null, fMethod, false, null, args);
	}
	
	public static Object[] getParametersValues(Object element, GenerationPolicyRegistry registry, String currentString, Method method, boolean typeCheck, Object watchingObject, Object... args) {
		Map<String, Object> descriptorMap= new HashMap<String, Object>();
		Map<String, GenerationArgumentDescriptor> descriptors= new HashMap<String, GenerationArgumentDescriptor>();
		List<Object> arguments= new ArrayList<Object>();
		GenerationPolicyRegistry.prepareArguments(descriptorMap, descriptors, arguments, args);
		
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		
		Annotation[] annotations= new Annotation[parameterAnnotations.length];
		for(int index=0; index<parameterAnnotations.length; index++){
			Annotation[] annotation= parameterAnnotations[index];
			annotations[index]= annotation.length==0?null: annotation[0];
		}
		
		Class<?>[] parameterTypes = method.getParameterTypes();
		
		return registry.getParameters(element, currentString, typeCheck, annotations, parameterTypes, descriptorMap, descriptors, arguments,watchingObject, args);
	}

	private Object[] getParameters(Object element, String currentString, boolean typeCheck, Annotation[] annotations,
			Class<?>[] parameterTypes, Map<String, Object> descriptorMap, Map<String, GenerationArgumentDescriptor> descriptors, 
			List<Object> arguments, Object watchingObject, Object... args) {
		TreeMap<String, Object> values = getPathMap(element);
		
		int length = annotations.length;
		Object[] parameters= new Object[length];
		
		int objectsSetArguments=0;
		
		int argsIndex=0;
		boolean checkArgumentIndex= false;
		for(int index=0; index< annotations.length; index++){
			
			Annotation annotation = annotations[index];
			
			Class<?> classType = parameterTypes[index];
			
			if(annotation==null){
				Object object = arguments.get(argsIndex);
				
				if(typeCheck){
					if(object== null){
						if(isTheSamePrimitiveType(classType, "boolean", Boolean.class.getCanonicalName())){
							object= Boolean.FALSE;
						}else if(isTheSamePrimitiveType(classType, "int", Integer.class.getCanonicalName())){
							object= Integer.valueOf(0);
						}else if(isTheSamePrimitiveType(classType, "float", Float.class.getCanonicalName())){
							object= Float.valueOf(0);
						}else if(isTheSamePrimitiveType(classType, "double", Double.class.getCanonicalName())){
							object= Double.valueOf(0);
						}
						parameters[index]= object;
					}else{
						Class<?> objectType = object.getClass();
						if(classType.isInstance(object)|| isTheSamePrimitiveType(objectType, "boolean", Boolean.class.getCanonicalName())||
								isTheSamePrimitiveType(objectType, "int", Integer.class.getCanonicalName())||
								isTheSamePrimitiveType(objectType, "float", Float.class.getCanonicalName())||
								isTheSamePrimitiveType(objectType, "double", Double.class.getCanonicalName())){
							parameters[index]= object;
						}else{
							return null;
						}
					}
					
				}
				
				argsIndex++;
				continue;
			}
			
			if(annotation instanceof GenerationBaseElement){
				if(typeCheck&& !classType.isInstance(element)){
					return null;
				}
				parameters[index]= element;
			}else if(annotation instanceof WatchedObjectValue){
				parameters[index]= watchingObject;
			}else if(annotation instanceof GenerationProcedureParameter){
				String canonicalName = classType.getCanonicalName();
				if("boolean".equals(canonicalName)|| Boolean.class.getCanonicalName().equals(canonicalName)){
					parameters[index]= Boolean.valueOf(this.decisionPoint(element, this, ((GenerationProcedureParameter)annotation).id(), args));
				}else if("int".equals(canonicalName)||Integer.class.getCanonicalName().equals(canonicalName)){
					parameters[index]= this.generationPointInteger(element, ((GenerationProcedureParameter)annotation).id(), args);
				}else{
					parameters[index]= this.generationPointString(element, ((GenerationProcedureParameter)annotation).id(), args);
				}
			}else if(annotation instanceof GenerationLoopElement){
				if(values== null){
					parameters[index]= null;
				}else{
					GenerationLoopElement generationLoopElement= (GenerationLoopElement) annotation;
					find: {
						String[] ids = generationLoopElement.id();
						if(ids.length==0){
							parameters[index]= values.get(CommonConstants.BLANK);
							break find;
						}
						for(String id:ids){
							Object object = values.get(id);
							if(object!= null){
								parameters[index]= object;
								break;
							}
						}
					}
				}
			}else if(annotation instanceof GenerationLoopPath){
				if(values== null){
					parameters[index]= new TreeMap<String, Object>();
				}else{
					parameters[index]= values;
				}
			}else if(annotation instanceof GenerationArguments){
				parameters[index]= args;
			}else if(annotation instanceof GenerationElementParameter){
				GenerationElementParameter generationElementParameter = (GenerationElementParameter)annotation;
				
				String canonicalName = classType.getCanonicalName();
				if(canonicalName.equals("boolean")){
					parameters[index]= Boolean.valueOf(this.getBoolean(element, generationElementParameter.id(), args));
				}else if(canonicalName.equals("int")){
					parameters[index]= Integer.valueOf(this.getInt(element, generationElementParameter.id(), args));
				}else{
					parameters[index]= this.getObject(element, generationElementParameter.id(), args);
				}
			}else if(annotation instanceof GenerationRegistry){
				parameters[index]= this;
			}else if(annotation instanceof GenerationStringSegment){
				parameters[index]= currentString;
			}else if(annotation instanceof GenerationArgument){
				GenerationArgument generationArgument= (GenerationArgument) annotation;
				String id = generationArgument.id();
				if(!id.isEmpty()){
					Object object = generationArgument.wrapped()? descriptors.get(id): descriptorMap.get(id);
					Object intercepted = processWatchPoints(element, id, object, arguments);
					Object reply = intercepted!=null? intercepted: object;
					
					String canonicalName = classType.getCanonicalName();
					if("boolean".equals(canonicalName)|| Boolean.class.getClass().equals(canonicalName)){
						parameters[index]= reply instanceof Boolean? reply: Boolean.FALSE;
					}else if("int".equals(canonicalName)|| Integer.class.getClass().equals(canonicalName)){
						parameters[index]= reply instanceof Boolean? reply: Integer.valueOf(0);
					}else if(canonicalName.equals(String.class.getCanonicalName())){
						parameters[index]= reply!=null? String.valueOf(reply): null;
					}else{
						parameters[index]= reply;
					}
				}else{
					Object object = arguments.size()>objectsSetArguments?arguments.get(objectsSetArguments): null;
					if(object!= null){
						Class<?> objectType = object.getClass();
						if(classType.isInstance(object)|| isTheSamePrimitiveType(objectType, "boolean", Boolean.class.getCanonicalName())||
								isTheSamePrimitiveType(objectType, "int", Integer.class.getCanonicalName())||
								isTheSamePrimitiveType(objectType, "float", Float.class.getCanonicalName())||
								isTheSamePrimitiveType(objectType, "double", Double.class.getCanonicalName())){
							
							Object intercepted = processWatchPoints(element, id, object, arguments);
							parameters[index]= intercepted!=null? intercepted: object;
							objectsSetArguments++;
						}
					}
					checkArgumentIndex= true;
				}
			}
			
			Object object = parameters[index];
			if(object== null){
				String canonicalName = classType.getCanonicalName();
				if("boolean".equals(canonicalName)|| Boolean.class.getClass().equals(canonicalName)){
					parameters[index]= Boolean.FALSE;
				}else if("int".equals(canonicalName)|| Integer.class.getClass().equals(canonicalName)){
					parameters[index]= Integer.valueOf(0);
				}else if(canonicalName.equals(String.class.getCanonicalName())){
					Annotation current = annotations[index];
					if(current instanceof GenerationArgument&& ((GenerationArgument)current).adjust()){
						parameters[index]= CommonConstants.BLANK;
					}
				}
				
				if(checkArgumentIndex){
					objectsSetArguments++;
					checkArgumentIndex= false;
				}
			}
		}
		
		return parameters;
	}

	public TreeMap<String, Object> getPathMap(Object element) {
		return this.objectsPathMap.get(element);
	}

	private static boolean isTheSamePrimitiveType(Class<?> classType, String type, String perspectiveCanonicalName) {
		return classType.getCanonicalName().equals(type)|| classType.getCanonicalName().equals(perspectiveCanonicalName);
	}
	
	
	
	private class DecisionObject{
		protected Method fMethod;
		protected DecisionPoint fDecisionPoint;
		protected Object fInstance;
		
		public DecisionObject(Method method, DecisionPoint decisionPoint, Object instance) {
			this.fMethod= method;
			this.fInstance= instance;
			this.fDecisionPoint= decisionPoint;
		}
	}
	
	private class LoopObject{
		protected Method fMethod;
		protected Object fInstance;
		protected GenerationLoopAnnotation fGenerationLoopAnnotation;
		
		public LoopObject(Method method, Object instance, GenerationLoopAnnotation generationLoopAnnotation) {
			this.fMethod= method;
			this.fInstance= instance;
			this.fGenerationLoopAnnotation= generationLoopAnnotation;
		}
	}
	
	private class LoopProcessorObject{
		protected Method fMethod;
		protected Object fInstance;
		protected LoopProcessorAnnotation fLoopProcessorAnnotation;
		protected LoopProcessorAnnotations fLoopProcessorAnnotations;
		
		public LoopProcessorObject(Method method, Object instance, LoopProcessorAnnotation loopProcessorAnnotation, LoopProcessorAnnotations loopProcessorAnnotations) {
			this.fMethod= method;
			this.fInstance= instance;
			this.fLoopProcessorAnnotation= loopProcessorAnnotation;
			this.fLoopProcessorAnnotations= loopProcessorAnnotations;
		}
	}
	
	public void addUniqueValue(String id, Object values, Object... element){
		addValue(id, values, true, element);
	}
	
	private ArgumentsRetrieval argumentRetriever= new ArgumentsRetrieval();
	
	public void addList(String id, Object values, boolean unique, Object... element){
		if(values instanceof Collection<?> == false){
			return;
		}
		for(Object value: (Collection<?>)values){
			this.addValue(id, value, unique, element);
		}
	}
	
	public void addValue(String id, Object values, Object... element){
		this.addValue(id, values, false, element);
	}

	private void addValue(String id, Object values, boolean unique, Object... element) {
		this.argumentRetriever.setValue(id, unique, values, element);
	}
	
	public List<Object> getValues(String id, Object... element){
		return this.argumentRetriever.getValue(id, element);
	}
	
	public List<Object> getAllValues(String id, Object... element){
		return this.argumentRetriever.getAllValues(id, element);
	}
	
	public List<Object> getById(String id){
		return this.argumentRetriever.getById(id);
	}
	
	/******************Delegations****************************************/
	
	@Override
	public void define(IGenerationTemplateRegistry generationTemplateRegistry, String id, GenerationCallback callback){
		this.generationTemplateDelegator.define(generationTemplateRegistry, id, callback);
	}
	
	@Override
	public void define(String id, GenerationCallback callback){
		this.generationTemplateDelegator.define(this, id, callback);
	}
	
	@Override
	public void define(String id, IGenerationProcdure... callback) {
		this.generationTemplateDelegator.define(id, callback);
	}

	@Override
	public String generate(String id, Object element, Object... arguments) {
		return this.generationTemplateDelegator.generate(id, element, arguments);
	}
	
	@Override
	public String use(String id, Object... arguments) {
		return this.generationTemplateDelegator.use(id, arguments);
	}
	
	@Override
	public boolean getBoolean(Object classObject, String fieldName, Object... arguments) {
		if(this._decisionInvocations.get(fieldName)!= null){
			return this.decisionPoint(classObject, this, fieldName, arguments);
		}
		boolean value = this.generationValueGetter.getBoolean(classObject, fieldName, arguments);
		Object processWatchPoints = processWatchPoints(classObject, fieldName, Boolean.valueOf(value), arguments);
		if(processWatchPoints instanceof Boolean){
			return ((Boolean) processWatchPoints).booleanValue();
		}
		
		return value;
	}

	@Override
	public Object getObject(Object classObject, String fieldName, Object... arguments) {
		List<Object> value = this.interceptedObjectsRetriever.getValue(fieldName, classObject, arguments);
		if(!value.isEmpty()){
			return value.get(0);
		}
		
		Object object = this.generationValueGetter.getObject(classObject, fieldName, arguments);
		
		Object processWatchPoints = processWatchPoints(classObject, fieldName,object, arguments);
		if(processWatchPoints != null){
			this.interceptedObjectsRetriever.setValue(fieldName, processWatchPoints, true, classObject, arguments);
			return processWatchPoints;
		}
		this.interceptedObjectsRetriever.setValue(fieldName, object, true, classObject, arguments);
		return object;
	}

	@Override
	public int getInt(Object classObject, String fieldName, Object... arguments) {
		List<Object> value = this.interceptedObjectsRetriever.getValue(fieldName, classObject, arguments);
		if(!value.isEmpty()){
			Object object = value.get(0);
			if(object instanceof Integer){
				return ((Integer)object).intValue();
			}
			return 0;
		}
		
		int intValue = this.generationValueGetter.getInt(classObject, fieldName, arguments);
		
		Object processWatchPoints = processWatchPoints(classObject, fieldName, new Integer(intValue), arguments);
		if(processWatchPoints instanceof Integer){
			this.interceptedObjectsRetriever.setValue(fieldName, processWatchPoints, true, classObject, arguments);
			return ((Integer) processWatchPoints).intValue();
		}
		
		this.interceptedObjectsRetriever.setValue(fieldName, Integer.valueOf(intValue), true, classObject, arguments);
		return intValue;
	}

	@Override
	public String getString(Object classObject, String fieldName, Object... arguments) {
		return getString(classObject, false, fieldName, arguments);
	}
	
	public String getString(Object classObject, boolean ignoreInterception, String fieldName, Object... arguments) {
		List<Object> value = this.interceptedObjectsRetriever.getValue(fieldName, classObject, Boolean.valueOf(ignoreInterception), arguments);
		if(!value.isEmpty()){
			Object object = value.get(0);
			if(object instanceof String){
				return (String) object;
			}
			return null;
		}
		
		String stringValue = this.generationValueGetter.getString(classObject, fieldName, arguments);
		
		if(!ignoreInterception){
			Object processWatchPoints = processWatchPoints(classObject, fieldName, stringValue,  arguments);
			if(processWatchPoints instanceof String){
				this.interceptedObjectsRetriever.setValue(fieldName, processWatchPoints, true, classObject, Boolean.valueOf(ignoreInterception), arguments);
				return (String) processWatchPoints;
			}
		}
		
		this.interceptedObjectsRetriever.setValue(fieldName, stringValue, true, classObject, Boolean.valueOf(ignoreInterception), arguments);
		return stringValue;
	}

	private Object processWatchPoints(Object classObject, String interceptId, Object watchingValue, Object... arguments) {
		List<GenerationPointObject> list = this._watchingPointsInvocations.get(interceptId);
		if(list== null){
			return null;
		}
		
		for(GenerationPointObject generationPointObject: list){
			Object invoke = generationPointObject.invoke(classObject, this, interceptId, watchingValue, arguments);
			if(invoke instanceof InterceptorResponse){
				return ((InterceptorResponse)invoke).getValue();
			}
		}
		
		return null;
	}

	@Override
	public List<?> getList(Object classObject, String fieldName,
			Object... arguments) {
		return this.generationValueGetter.getList(classObject, fieldName, arguments);
	}
	
	private class GenerationPointObject{
		protected Method fMethod;
		protected GenerationPoint fGenerationPoint;
		protected Set<DecisionObject> whenDecisions= new HashSet<DecisionObject>();
		protected Set<DecisionObject> whenNotDecisions= new HashSet<DecisionObject>();
		protected Object fInstance;
		
		public GenerationPointObject(Method method, GenerationPoint generationPoint, Object instance) {
			this.fMethod= method;
			this.fGenerationPoint= generationPoint;
			this.fInstance= instance;
		}
		
		public Object invoke(Object element, GenerationPolicyRegistry registry, String currentString, Object watchingObject, Object... arguments){
			try {
				String generationPoint = this.fGenerationPoint.generationPoint();
				List<Object> value = registry.generationObjectsRetriever.getValue(generationPoint, 
						element, arguments, watchingObject);
				if(!value.isEmpty()){
					return value.get(0);
				}
				for(int index=0; index<this.fGenerationPoint.ifConditionIds().length; index++){
					if (!processDecisionPointsMethods(element, registry, this.fGenerationPoint.ifConditionIds()[index], true, arguments)) {
						registry.generationObjectsRetriever.setValue(generationPoint, null, true, element, arguments);
						return null;
					}
				}
				
				for(int index=0; index<this.fGenerationPoint.ifNotConditionIds().length; index++){
					if (processDecisionPointsMethods(element, registry, this.fGenerationPoint.ifNotConditionIds()[index], true, arguments)) {
						registry.generationObjectsRetriever.setValue(generationPoint, null, true, element, arguments);
						return null;
					}
				}
				
				for(DecisionObject decisionObject: this.whenDecisions){
					if(!processDecisionObject(element, registry, decisionObject, arguments)){
						registry.generationObjectsRetriever.setValue(generationPoint, null, true, element, arguments);
						return null;
					}
					
					Object[] parameters = getParametersValues(element, registry, currentString, decisionObject.fMethod, false, watchingObject, arguments);
					Object invoke = decisionObject.fMethod.invoke(decisionObject.fInstance, parameters);
					if(invoke instanceof Boolean){
						if(!((Boolean)invoke).booleanValue()){
							registry.generationObjectsRetriever.setValue(generationPoint, null, true, element, arguments);
							return null;
						}
					}
				}
				
				for(DecisionObject decisionObject: this.whenNotDecisions){
					if(processDecisionObject(element, registry, decisionObject, arguments)){
						registry.generationObjectsRetriever.setValue(generationPoint, null, true, element, arguments);
						return null;
					}
					
					Object[] parameters = GenerationPolicyRegistry.getParametersValues(element, registry, currentString, decisionObject.fMethod, false, watchingObject, arguments);
					Object invoke = decisionObject.fMethod.invoke(decisionObject.fInstance, parameters);
					if(invoke instanceof Boolean){
						if(((Boolean)invoke).booleanValue()){
							registry.generationObjectsRetriever.setValue(generationPoint, null, true, element, arguments);
							return null;
						}
					}
				}
				
				//TODO: caching
				Object[] parameters = GenerationPolicyRegistry.getParametersValues(element, registry, currentString, this.fMethod, false, watchingObject, arguments);
				Object invoke = this.fMethod.invoke(this.fInstance, parameters);
				registry.generationObjectsRetriever.setValue(generationPoint, invoke, true, element, arguments);
				return invoke;
			} catch (Exception e) {
				registry.generationLogger.addError(e);
				return null;
			}
		}

		private boolean processDecisionObject(Object element, GenerationPolicyRegistry registry, DecisionObject decisionObject, Object... arguments) {
			for(String condition: decisionObject.fDecisionPoint.ifConditionIds()){
				if (!decisionPoint(element, registry, condition, arguments)) {
					return false;
				}
			}
			
			for(String condition: decisionObject.fDecisionPoint.ifNotConditionIds()){
				if (processDecisionPointsMethods(element, registry, condition, true, arguments)) {
					return false;
				}
			}
			return true;
		}
		
		public boolean unique(){
			return this.fGenerationPoint.unique();
		}
	}

	@Override
	public GenerationLogger getGenerationLogger() {
		return this.generationLogger;
	}
	
}