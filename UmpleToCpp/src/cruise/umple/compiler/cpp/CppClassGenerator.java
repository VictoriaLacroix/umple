package cruise.umple.compiler.cpp;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class CppClassGenerator implements ILang 
{

  protected static String nl;
  public static synchronized CppClassGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CppClassGenerator result = new CppClassGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/* EXPERIMENTAL CODE - NON COMPILEABLE VERSION OF C++ */" + NL + "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!*/";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = NL + "  //------------------------" + NL + "  // CONSTRUCTOR" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = NL + "    ";
  protected final String TEXT_8 = "();";
  protected final String TEXT_9 = NL + "    ";
  protected final String TEXT_10 = " = true;";
  protected final String TEXT_11 = NL + "    ";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = NL + "    ";
  protected final String TEXT_15 = " = false;";
  protected final String TEXT_16 = NL + "    ";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";";
  protected final String TEXT_19 = NL + "    ";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";";
  protected final String TEXT_22 = NL + "    ";
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = "++;";
  protected final String TEXT_25 = NL + "    if (!";
  protected final String TEXT_26 = "(";
  protected final String TEXT_27 = "))" + NL + "    {" + NL + "      throw (\"Unable to create ";
  protected final String TEXT_28 = " due to ";
  protected final String TEXT_29 = "\");" + NL + "    }";
  protected final String TEXT_30 = NL + "    bool ";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = "(";
  protected final String TEXT_33 = ");" + NL + "    try {" + NL + "\t\t throw  ";
  protected final String TEXT_34 = ";" + NL + "\t\t}" + NL + "\tcatch (exception& e)\t" + NL + "\t{" + NL + "\tcout<<\"Unable to create ";
  protected final String TEXT_35 = ", must have ";
  protected final String TEXT_36 = " ";
  protected final String TEXT_37 = "\";" + NL + "\t}";
  protected final String TEXT_38 = NL + "    bool ";
  protected final String TEXT_39 = " = ";
  protected final String TEXT_40 = "(";
  protected final String TEXT_41 = ");" + NL + "    if (!";
  protected final String TEXT_42 = ")" + NL + "    {" + NL + "    \ttry" + NL + "    \t{    \t" + NL + "      \t  cout<<\"Unable to create ";
  protected final String TEXT_43 = ", must have ";
  protected final String TEXT_44 = " or fewer ";
  protected final String TEXT_45 = ", no duplicates.\";" + NL + "      \t}" + NL + "      \t" + NL + "      \tcatch" + NL + "      \t{" + NL + "      \t\tcerr<<\"exception caught:\"<<e.what()<<endl;" + NL + "      \t}" + NL + "    }";
  protected final String TEXT_46 = NL + "    bool ";
  protected final String TEXT_47 = " = ";
  protected final String TEXT_48 = "(";
  protected final String TEXT_49 = ");" + NL + "    if (!";
  protected final String TEXT_50 = ")" + NL + "    {" + NL + "    " + NL + "    try" + NL + "    \t{    \t" + NL + "      \t  cout<<\"Unable to create ";
  protected final String TEXT_51 = ", must not have duplicate ";
  protected final String TEXT_52 = ".\");" + NL + "      \t}" + NL + "      \t" + NL + "      \tcatch" + NL + "      \t{" + NL + "      \t\tcerr<<\"exception caught:\"<<e.what()<<endl;" + NL + "      \t}" + NL + "    }";
  protected final String TEXT_53 = NL + "   ";
  protected final String TEXT_54 = NL + "    if (";
  protected final String TEXT_55 = " == NULL || ";
  protected final String TEXT_56 = "->";
  protected final String TEXT_57 = "() != NULL)" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_58 = " due to ";
  protected final String TEXT_59 = "\");" + NL + "    }";
  protected final String TEXT_60 = NL + "    ";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = ";";
  protected final String TEXT_63 = NL + "   ";
  protected final String TEXT_64 = NL + "    bool ";
  protected final String TEXT_65 = " = ";
  protected final String TEXT_66 = "(";
  protected final String TEXT_67 = ");" + NL + "    if (!";
  protected final String TEXT_68 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_69 = " due to ";
  protected final String TEXT_70 = "\");" + NL + "    }";
  protected final String TEXT_71 = NL + "    bool ";
  protected final String TEXT_72 = " = ";
  protected final String TEXT_73 = "(";
  protected final String TEXT_74 = ");" + NL + "    try {" + NL + "\t\t throw  ";
  protected final String TEXT_75 = ";" + NL + "\t\t}" + NL + "\tcatch (exception& e)\t" + NL + "\t{" + NL + "\tcout<<\"Unable to create ";
  protected final String TEXT_76 = ", must have ";
  protected final String TEXT_77 = " ";
  protected final String TEXT_78 = "\";" + NL + "\t}";
  protected final String TEXT_79 = ".push_back(";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "    if (";
  protected final String TEXT_82 = " == Null) { ";
  protected final String TEXT_83 = "(";
  protected final String TEXT_84 = "); }";
  protected final String TEXT_85 = NL + "    ";
  protected final String TEXT_86 = "(";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "  ";
  protected final String TEXT_89 = "* ";
  protected final String TEXT_90 = "::getInstance()" + NL + "  {" + NL + "    if(!theInstance)" + NL + "    {" + NL + "      theInstance = new ";
  protected final String TEXT_91 = ";" + NL + "    }" + NL + "    return theInstance;" + NL + "  }";
  protected final String TEXT_92 = NL;
  protected final String TEXT_93 = NL + "  ";
  protected final String TEXT_94 = "::";
  protected final String TEXT_95 = "(";
  protected final String TEXT_96 = ")" + NL + "  {";
  protected final String TEXT_97 = NL + "\t\t";
  protected final String TEXT_98 = NL + "    ";
  protected final String TEXT_99 = "();";
  protected final String TEXT_100 = NL + "    ";
  protected final String TEXT_101 = " = ";
  protected final String TEXT_102 = ";";
  protected final String TEXT_103 = NL + "    ";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = "++;";
  protected final String TEXT_106 = NL + "    ";
  protected final String TEXT_107 = NL + "   ";
  protected final String TEXT_108 = NL + "    bool ";
  protected final String TEXT_109 = " = ";
  protected final String TEXT_110 = "(";
  protected final String TEXT_111 = ");" + NL + "    if (!";
  protected final String TEXT_112 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_113 = " due to ";
  protected final String TEXT_114 = "\");" + NL + "    }";
  protected final String TEXT_115 = NL + "    bool ";
  protected final String TEXT_116 = " = ";
  protected final String TEXT_117 = "(";
  protected final String TEXT_118 = ");" + NL + "    try {" + NL + "\t\t throw  ";
  protected final String TEXT_119 = ";" + NL + "\t\t}" + NL + "\tcatch (exception& e)\t" + NL + "\t{" + NL + "\tcout<<\"Unable to create ";
  protected final String TEXT_120 = ", must have ";
  protected final String TEXT_121 = " ";
  protected final String TEXT_122 = "\";" + NL + "\t}";
  protected final String TEXT_123 = ".push_back(";
  protected final String TEXT_124 = ");";
  protected final String TEXT_125 = NL + "  ";
  protected final String TEXT_126 = NL + "  \t";
  protected final String TEXT_127 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_128 = NL + "  bool ";
  protected final String TEXT_129 = "::";
  protected final String TEXT_130 = "(const ";
  protected final String TEXT_131 = " & ";
  protected final String TEXT_132 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_133 = NL + "    ";
  protected final String TEXT_134 = " = false;";
  protected final String TEXT_135 = NL + "    ";
  protected final String TEXT_136 = " = ";
  protected final String TEXT_137 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_138 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_139 = NL + "  bool ";
  protected final String TEXT_140 = "::";
  protected final String TEXT_141 = "(const ";
  protected final String TEXT_142 = " & ";
  protected final String TEXT_143 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_144 = NL + "    ";
  protected final String TEXT_145 = " = ";
  protected final String TEXT_146 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_147 = NL + "    return wasSet;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_148 = "::";
  protected final String TEXT_149 = "()" + NL + "  {" + NL + "    bool wasReset = false;";
  protected final String TEXT_150 = NL + "    ";
  protected final String TEXT_151 = " = ";
  protected final String TEXT_152 = "();" + NL + "    wasReset = true;";
  protected final String TEXT_153 = NL + "    return wasReset;" + NL + "  }" + NL;
  protected final String TEXT_154 = NL + "  bool ";
  protected final String TEXT_155 = "::";
  protected final String TEXT_156 = "(const ";
  protected final String TEXT_157 = " & ";
  protected final String TEXT_158 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_159 = NL + "    wasAdded = ";
  protected final String TEXT_160 = ".add(";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_163 = "::";
  protected final String TEXT_164 = "(";
  protected final String TEXT_165 = " & ";
  protected final String TEXT_166 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_167 = NL + "    wasRemoved = ";
  protected final String TEXT_168 = ".remove(";
  protected final String TEXT_169 = ");";
  protected final String TEXT_170 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_171 = NL + "  bool ";
  protected final String TEXT_172 = "::";
  protected final String TEXT_173 = "(const ";
  protected final String TEXT_174 = " & ";
  protected final String TEXT_175 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_176 = NL + "    ";
  protected final String TEXT_177 = " = ";
  protected final String TEXT_178 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_179 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_180 = NL + "  bool ";
  protected final String TEXT_181 = "::";
  protected final String TEXT_182 = "(const ";
  protected final String TEXT_183 = " & ";
  protected final String TEXT_184 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_185 = NL + "      wasSet = super::";
  protected final String TEXT_186 = "(";
  protected final String TEXT_187 = ");";
  protected final String TEXT_188 = NL + "    return wasSet;" + NL + "  }" + NL + NL;
  protected final String TEXT_189 = NL + "  bool ";
  protected final String TEXT_190 = "::";
  protected final String TEXT_191 = "(const ";
  protected final String TEXT_192 = " & ";
  protected final String TEXT_193 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_194 = NL + "      wasAdded = super::";
  protected final String TEXT_195 = "(";
  protected final String TEXT_196 = ");";
  protected final String TEXT_197 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_198 = NL + "  bool ";
  protected final String TEXT_199 = "::";
  protected final String TEXT_200 = "(const ";
  protected final String TEXT_201 = " & ";
  protected final String TEXT_202 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_203 = NL + "      wasSet = super::";
  protected final String TEXT_204 = "(";
  protected final String TEXT_205 = ");";
  protected final String TEXT_206 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_207 = NL + "  ";
  protected final String TEXT_208 = " ";
  protected final String TEXT_209 = "::";
  protected final String TEXT_210 = "(int index)" + NL + "  {";
  protected final String TEXT_211 = NL + "    ";
  protected final String TEXT_212 = " ";
  protected final String TEXT_213 = " = ";
  protected final String TEXT_214 = ".get(index);";
  protected final String TEXT_215 = NL + "    return ";
  protected final String TEXT_216 = ";" + NL + "  }" + NL;
  protected final String TEXT_217 = NL + "  ";
  protected final String TEXT_218 = "[] ";
  protected final String TEXT_219 = "::";
  protected final String TEXT_220 = "()" + NL + "  {";
  protected final String TEXT_221 = NL + "    ";
  protected final String TEXT_222 = "[] ";
  protected final String TEXT_223 = " = ";
  protected final String TEXT_224 = ".toArray(new ";
  protected final String TEXT_225 = "[";
  protected final String TEXT_226 = ".size()]);";
  protected final String TEXT_227 = NL + "    return ";
  protected final String TEXT_228 = ";" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_229 = "::";
  protected final String TEXT_230 = "()" + NL + "  {";
  protected final String TEXT_231 = NL + "    int number = ";
  protected final String TEXT_232 = ".size();";
  protected final String TEXT_233 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_234 = "::";
  protected final String TEXT_235 = "()" + NL + "  {";
  protected final String TEXT_236 = NL + "    bool has = ";
  protected final String TEXT_237 = ".size() > 0;";
  protected final String TEXT_238 = NL + "    return has;" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_239 = "::";
  protected final String TEXT_240 = "(";
  protected final String TEXT_241 = "* ";
  protected final String TEXT_242 = ")" + NL + "  {";
  protected final String TEXT_243 = NL + "    int index = find(";
  protected final String TEXT_244 = ".begin(), ";
  protected final String TEXT_245 = ".end(), ";
  protected final String TEXT_246 = ") - ";
  protected final String TEXT_247 = ".begin();";
  protected final String TEXT_248 = NL + "    return index;" + NL + "  }" + NL;
  protected final String TEXT_249 = NL + "  ";
  protected final String TEXT_250 = " ";
  protected final String TEXT_251 = "::";
  protected final String TEXT_252 = "()" + NL + "  {";
  protected final String TEXT_253 = NL + "    ";
  protected final String TEXT_254 = " ";
  protected final String TEXT_255 = " = ";
  protected final String TEXT_256 = ";";
  protected final String TEXT_257 = NL + "    return ";
  protected final String TEXT_258 = ";" + NL + "  }";
  protected final String TEXT_259 = NL + "  ";
  protected final String TEXT_260 = " ";
  protected final String TEXT_261 = "::";
  protected final String TEXT_262 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_263 = ";" + NL + "  }";
  protected final String TEXT_264 = NL + "  ";
  protected final String TEXT_265 = " ";
  protected final String TEXT_266 = "::";
  protected final String TEXT_267 = "()" + NL + "  {";
  protected final String TEXT_268 = NL + "    ";
  protected final String TEXT_269 = " ";
  protected final String TEXT_270 = " = ";
  protected final String TEXT_271 = ";";
  protected final String TEXT_272 = NL + "    return ";
  protected final String TEXT_273 = ";" + NL + "  }";
  protected final String TEXT_274 = NL + "  ";
  protected final String TEXT_275 = " ";
  protected final String TEXT_276 = "::";
  protected final String TEXT_277 = "() const" + NL + "  {";
  protected final String TEXT_278 = NL + "    return ";
  protected final String TEXT_279 = ";" + NL + "  }";
  protected final String TEXT_280 = NL + "  ";
  protected final String TEXT_281 = " ";
  protected final String TEXT_282 = "::";
  protected final String TEXT_283 = "()" + NL + "  {";
  protected final String TEXT_284 = NL + "    ";
  protected final String TEXT_285 = " ";
  protected final String TEXT_286 = " = ";
  protected final String TEXT_287 = ";";
  protected final String TEXT_288 = NL + "    return ";
  protected final String TEXT_289 = ";" + NL + "  }";
  protected final String TEXT_290 = NL + "  ";
  protected final String TEXT_291 = " ";
  protected final String TEXT_292 = "::";
  protected final String TEXT_293 = "() const" + NL + "  {";
  protected final String TEXT_294 = NL + "    return ";
  protected final String TEXT_295 = ";" + NL + "  }" + NL;
  protected final String TEXT_296 = NL + "  public static ";
  protected final String TEXT_297 = " ";
  protected final String TEXT_298 = "(";
  protected final String TEXT_299 = " ";
  protected final String TEXT_300 = ")" + NL + "  {";
  protected final String TEXT_301 = NL + "    ";
  protected final String TEXT_302 = " ";
  protected final String TEXT_303 = " = ";
  protected final String TEXT_304 = ".get(";
  protected final String TEXT_305 = ");";
  protected final String TEXT_306 = NL;
  protected final String TEXT_307 = "    return ";
  protected final String TEXT_308 = ";" + NL + "  }" + NL;
  protected final String TEXT_309 = NL + "  public static ";
  protected final String TEXT_310 = " ";
  protected final String TEXT_311 = "(";
  protected final String TEXT_312 = " ";
  protected final String TEXT_313 = ")" + NL + "  {";
  protected final String TEXT_314 = NL + "    return ";
  protected final String TEXT_315 = ".get(";
  protected final String TEXT_316 = ");" + NL + "  }" + NL;
  protected final String TEXT_317 = NL + "  public static boolean ";
  protected final String TEXT_318 = "(";
  protected final String TEXT_319 = " ";
  protected final String TEXT_320 = ")" + NL + "  {";
  protected final String TEXT_321 = NL + "    boolean ";
  protected final String TEXT_322 = " = ";
  protected final String TEXT_323 = "(";
  protected final String TEXT_324 = ") != null;";
  protected final String TEXT_325 = NL;
  protected final String TEXT_326 = "    return ";
  protected final String TEXT_327 = ";" + NL + "  }" + NL;
  protected final String TEXT_328 = NL + "  public static boolean ";
  protected final String TEXT_329 = "(";
  protected final String TEXT_330 = " ";
  protected final String TEXT_331 = ")" + NL + "  {";
  protected final String TEXT_332 = NL + "    return ";
  protected final String TEXT_333 = "(";
  protected final String TEXT_334 = ") != null;" + NL + "  }" + NL;
  protected final String TEXT_335 = NL + "  ";
  protected final String TEXT_336 = " ";
  protected final String TEXT_337 = "::";
  protected final String TEXT_338 = "()" + NL + "  {";
  protected final String TEXT_339 = NL + "    ";
  protected final String TEXT_340 = " ";
  protected final String TEXT_341 = " = ";
  protected final String TEXT_342 = ";";
  protected final String TEXT_343 = NL + "    return ";
  protected final String TEXT_344 = ";" + NL + "  }";
  protected final String TEXT_345 = NL + "  ";
  protected final String TEXT_346 = " ";
  protected final String TEXT_347 = "::";
  protected final String TEXT_348 = "() const" + NL + "  {";
  protected final String TEXT_349 = NL + "    return ";
  protected final String TEXT_350 = ";" + NL + "  }";
  protected final String TEXT_351 = NL + "  ";
  protected final String TEXT_352 = " ";
  protected final String TEXT_353 = "::";
  protected final String TEXT_354 = "()" + NL + "  {" + NL + "    string answer = ";
  protected final String TEXT_355 = "(";
  protected final String TEXT_356 = ");";
  protected final String TEXT_357 = NL + "    return answer;" + NL + "  }" + NL + "  ";
  protected final String TEXT_358 = NL + "  ";
  protected final String TEXT_359 = "::";
  protected final String TEXT_360 = " ";
  protected final String TEXT_361 = "::";
  protected final String TEXT_362 = "()";
  protected final String TEXT_363 = NL + "  ";
  protected final String TEXT_364 = "bool ";
  protected final String TEXT_365 = "::";
  protected final String TEXT_366 = "(";
  protected final String TEXT_367 = ")" + NL + "  {" + NL + "    bool wasEventProcessed = false;" + NL;
  protected final String TEXT_368 = NL + "    ";
  protected final String TEXT_369 = NL + NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_370 = NL + "  bool ";
  protected final String TEXT_371 = "::";
  protected final String TEXT_372 = "(";
  protected final String TEXT_373 = " ";
  protected final String TEXT_374 = ")" + NL + "  {";
  protected final String TEXT_375 = NL + "    ";
  protected final String TEXT_376 = " = ";
  protected final String TEXT_377 = ";" + NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_378 = NL + "  void ";
  protected final String TEXT_379 = "::";
  protected final String TEXT_380 = "()" + NL + "  {";
  protected final String TEXT_381 = NL + "    switch(";
  protected final String TEXT_382 = ")" + NL + "    {";
  protected final String TEXT_383 = NL + "      ";
  protected final String TEXT_384 = NL + "    }";
  protected final String TEXT_385 = NL + "  }" + NL;
  protected final String TEXT_386 = NL + "  void ";
  protected final String TEXT_387 = "::";
  protected final String TEXT_388 = "(";
  protected final String TEXT_389 = " ";
  protected final String TEXT_390 = ")" + NL + "  {";
  protected final String TEXT_391 = NL + "    ";
  protected final String TEXT_392 = " = ";
  protected final String TEXT_393 = ";";
  protected final String TEXT_394 = NL + "    if (";
  protected final String TEXT_395 = " != ";
  protected final String TEXT_396 = " && ";
  protected final String TEXT_397 = " != ";
  protected final String TEXT_398 = ") { ";
  protected final String TEXT_399 = "(";
  protected final String TEXT_400 = "); }";
  protected final String TEXT_401 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_402 = ")" + NL + "    {";
  protected final String TEXT_403 = NL + "      ";
  protected final String TEXT_404 = NL + "    }";
  protected final String TEXT_405 = NL + "  }" + NL + "  " + NL;
  protected final String TEXT_406 = NL + "  ";
  protected final String TEXT_407 = "* ";
  protected final String TEXT_408 = "::";
  protected final String TEXT_409 = "() " + NL + "  {";
  protected final String TEXT_410 = NL + "    return ";
  protected final String TEXT_411 = ";";
  protected final String TEXT_412 = NL + "    ";
  protected final String TEXT_413 = "* ";
  protected final String TEXT_414 = " = ";
  protected final String TEXT_415 = ";";
  protected final String TEXT_416 = NL + "    return ";
  protected final String TEXT_417 = ";";
  protected final String TEXT_418 = NL + "  }" + NL;
  protected final String TEXT_419 = NL + "  ";
  protected final String TEXT_420 = "* ";
  protected final String TEXT_421 = "::";
  protected final String TEXT_422 = "(int index) " + NL + "  {";
  protected final String TEXT_423 = NL + "    ";
  protected final String TEXT_424 = "* ";
  protected final String TEXT_425 = " = ";
  protected final String TEXT_426 = "[index];";
  protected final String TEXT_427 = NL + "    return ";
  protected final String TEXT_428 = ";" + NL + "  }" + NL + "" + NL + "  vector<";
  protected final String TEXT_429 = "*> ";
  protected final String TEXT_430 = "::";
  protected final String TEXT_431 = "() " + NL + "  {";
  protected final String TEXT_432 = NL + "    vector<";
  protected final String TEXT_433 = "*> ";
  protected final String TEXT_434 = " = ";
  protected final String TEXT_435 = ";";
  protected final String TEXT_436 = NL + "    return ";
  protected final String TEXT_437 = ";" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_438 = "::";
  protected final String TEXT_439 = "()" + NL + "  {";
  protected final String TEXT_440 = NL + "    int number = ";
  protected final String TEXT_441 = ".size();";
  protected final String TEXT_442 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_443 = "::";
  protected final String TEXT_444 = "()" + NL + "  {";
  protected final String TEXT_445 = NL + "    bool has = ";
  protected final String TEXT_446 = ".size() > 0;";
  protected final String TEXT_447 = NL + "    return has;" + NL + "  }" + NL + "  " + NL + "  int ";
  protected final String TEXT_448 = "::";
  protected final String TEXT_449 = "(";
  protected final String TEXT_450 = "* ";
  protected final String TEXT_451 = ")" + NL + "  {";
  protected final String TEXT_452 = NL + "    int index = find(";
  protected final String TEXT_453 = ".begin(), ";
  protected final String TEXT_454 = ".end(), ";
  protected final String TEXT_455 = ") - ";
  protected final String TEXT_456 = ".begin();";
  protected final String TEXT_457 = NL + "    return index;" + NL + "  }" + NL + "  ";
  protected final String TEXT_458 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_459 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_460 = " : ";
  protected final String TEXT_461 = NL + "  bool ";
  protected final String TEXT_462 = "::";
  protected final String TEXT_463 = "()" + NL + "  {";
  protected final String TEXT_464 = NL + "    bool isValid = ";
  protected final String TEXT_465 = "() >= ";
  protected final String TEXT_466 = "();";
  protected final String TEXT_467 = NL + "    bool isValid = ";
  protected final String TEXT_468 = "() >= ";
  protected final String TEXT_469 = "() && ";
  protected final String TEXT_470 = "() <= ";
  protected final String TEXT_471 = "();";
  protected final String TEXT_472 = NL + "    return isValid;" + NL + "  }";
  protected final String TEXT_473 = NL + "  static int ";
  protected final String TEXT_474 = "::";
  protected final String TEXT_475 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_476 = ";" + NL + "  }";
  protected final String TEXT_477 = NL + "  static int ";
  protected final String TEXT_478 = "::";
  protected final String TEXT_479 = "()" + NL + "  {";
  protected final String TEXT_480 = NL + "    int required = ";
  protected final String TEXT_481 = ";";
  protected final String TEXT_482 = NL + "    return required;" + NL + "  }";
  protected final String TEXT_483 = NL + "  static int ";
  protected final String TEXT_484 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_485 = ";" + NL + "  }";
  protected final String TEXT_486 = NL + "  static int ";
  protected final String TEXT_487 = "::";
  protected final String TEXT_488 = "()" + NL + "  {";
  protected final String TEXT_489 = NL + "    int minimum = ";
  protected final String TEXT_490 = ";";
  protected final String TEXT_491 = NL + "    return minimum;" + NL + "  }";
  protected final String TEXT_492 = NL + "  static int ";
  protected final String TEXT_493 = "::";
  protected final String TEXT_494 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_495 = ";" + NL + "  }";
  protected final String TEXT_496 = NL + "  static int ";
  protected final String TEXT_497 = "::";
  protected final String TEXT_498 = "()" + NL + "  {";
  protected final String TEXT_499 = NL + "    int maximum = ";
  protected final String TEXT_500 = ";";
  protected final String TEXT_501 = NL + "    return maximum;" + NL + "  }";
  protected final String TEXT_502 = NL + "  bool ";
  protected final String TEXT_503 = "::";
  protected final String TEXT_504 = "(";
  protected final String TEXT_505 = "* ";
  protected final String TEXT_506 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_507 = NL + "    if (";
  protected final String TEXT_508 = "() >= ";
  protected final String TEXT_509 = "())" + NL + "    {";
  protected final String TEXT_510 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_511 = NL + "    ";
  protected final String TEXT_512 = ".push_back(";
  protected final String TEXT_513 = ");" + NL + "    if (";
  protected final String TEXT_514 = "->";
  protected final String TEXT_515 = "(this) != -1)" + NL + "    {" + NL + "      wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasAdded = ";
  protected final String TEXT_516 = ".";
  protected final String TEXT_517 = "(this);" + NL + "      if (!wasAdded)" + NL + "      {";
  protected final String TEXT_518 = NL + "        ";
  protected final String TEXT_519 = ".erase(find(";
  protected final String TEXT_520 = ".begin(),";
  protected final String TEXT_521 = ".end(),";
  protected final String TEXT_522 = "));" + NL + "      }" + NL + "    }";
  protected final String TEXT_523 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_524 = NL + "  bool ";
  protected final String TEXT_525 = "::";
  protected final String TEXT_526 = "(";
  protected final String TEXT_527 = " ";
  protected final String TEXT_528 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_529 = NL + "    if (!find(";
  protected final String TEXT_530 = ".begin(),";
  protected final String TEXT_531 = ".end(),";
  protected final String TEXT_532 = "))" + NL + "    {";
  protected final String TEXT_533 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = find(";
  protected final String TEXT_534 = ".begin(), ";
  protected final String TEXT_535 = ".end(), ";
  protected final String TEXT_536 = ") - ";
  protected final String TEXT_537 = ".begin();";
  protected final String TEXT_538 = NL + "    ";
  protected final String TEXT_539 = ".erase(find(";
  protected final String TEXT_540 = ".begin(),";
  protected final String TEXT_541 = ".end(),";
  protected final String TEXT_542 = "));" + NL + "    if (";
  protected final String TEXT_543 = "->";
  protected final String TEXT_544 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_545 = "->";
  protected final String TEXT_546 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_547 = NL + "        ";
  protected final String TEXT_548 = ".push_back(oldIndex,";
  protected final String TEXT_549 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_550 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_551 = NL + "  bool ";
  protected final String TEXT_552 = "::";
  protected final String TEXT_553 = "(";
  protected final String TEXT_554 = "* ";
  protected final String TEXT_555 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_556 = NL + "    ";
  protected final String TEXT_557 = " = ";
  protected final String TEXT_558 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_559 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_560 = NL + "  bool ";
  protected final String TEXT_561 = "::";
  protected final String TEXT_562 = "(";
  protected final String TEXT_563 = "* ";
  protected final String TEXT_564 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_565 = NL + "    if (";
  protected final String TEXT_566 = " != NULL)" + NL + "    {";
  protected final String TEXT_567 = NL + "      ";
  protected final String TEXT_568 = " = ";
  protected final String TEXT_569 = ";" + NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_570 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_571 = NL + "  bool ";
  protected final String TEXT_572 = "::";
  protected final String TEXT_573 = "(";
  protected final String TEXT_574 = "* ";
  protected final String TEXT_575 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_576 = NL + "    if (";
  protected final String TEXT_577 = " != NULL && ";
  protected final String TEXT_578 = "!=";
  protected final String TEXT_579 = " && = ";
  protected final String TEXT_580 = "->";
  protected final String TEXT_581 = "())" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_582 = ", as existing ";
  protected final String TEXT_583 = " would become an orphan";
  protected final String TEXT_584 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_585 = NL + "    ";
  protected final String TEXT_586 = " = ";
  protected final String TEXT_587 = ";";
  protected final String TEXT_588 = NL + "    ";
  protected final String TEXT_589 = " ";
  protected final String TEXT_590 = " = ";
  protected final String TEXT_591 = " != NULL ? ";
  protected final String TEXT_592 = "->";
  protected final String TEXT_593 = "() : NULL;" + NL + "" + NL + "    if (this!=";
  protected final String TEXT_594 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_595 = " != NULL)" + NL + "      {";
  protected final String TEXT_596 = NL + "        ";
  protected final String TEXT_597 = "->";
  protected final String TEXT_598 = " = NULL;" + NL + "      }" + NL + "      if (";
  protected final String TEXT_599 = " != NULL)" + NL + "      {";
  protected final String TEXT_600 = NL + "        ";
  protected final String TEXT_601 = "->";
  protected final String TEXT_602 = "(this);" + NL + "      }" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_603 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_604 = NL + "  bool ";
  protected final String TEXT_605 = "::";
  protected final String TEXT_606 = "(";
  protected final String TEXT_607 = " ";
  protected final String TEXT_608 = ")" + NL + "  {" + NL + "    bool";
  protected final String TEXT_609 = NL + "    if (";
  protected final String TEXT_610 = " == NULL)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_611 = " to null, as ";
  protected final String TEXT_612 = " must always be associated to a ";
  protected final String TEXT_613 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_614 = NL + "    ";
  protected final String TEXT_615 = "* ";
  protected final String TEXT_616 = " = ";
  protected final String TEXT_617 = "->";
  protected final String TEXT_618 = "();" + NL + "    if (";
  protected final String TEXT_619 = " != NULL && !=";
  protected final String TEXT_620 = ")" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_621 = ", the current ";
  protected final String TEXT_622 = " already has a ";
  protected final String TEXT_623 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_624 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_625 = NL + "    ";
  protected final String TEXT_626 = "* ";
  protected final String TEXT_627 = " = ";
  protected final String TEXT_628 = ";";
  protected final String TEXT_629 = NL + "    ";
  protected final String TEXT_630 = " = ";
  protected final String TEXT_631 = ";";
  protected final String TEXT_632 = NL + "    ";
  protected final String TEXT_633 = "->";
  protected final String TEXT_634 = "(this);" + NL + "" + NL + "    if (";
  protected final String TEXT_635 = " != NULL)" + NL + "    {";
  protected final String TEXT_636 = NL + "      ";
  protected final String TEXT_637 = "->";
  protected final String TEXT_638 = "(null);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_639 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_640 = NL + "  ";
  protected final String TEXT_641 = " ";
  protected final String TEXT_642 = "::";
  protected final String TEXT_643 = "(";
  protected final String TEXT_644 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_645 = "(";
  protected final String TEXT_646 = ");" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_647 = "::";
  protected final String TEXT_648 = "(";
  protected final String TEXT_649 = "* ";
  protected final String TEXT_650 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_651 = NL + "    ";
  protected final String TEXT_652 = " ";
  protected final String TEXT_653 = " = ";
  protected final String TEXT_654 = "->";
  protected final String TEXT_655 = "();" + NL + "    bool ";
  protected final String TEXT_656 = " = (";
  protected final String TEXT_657 = " != NULL && this != ";
  protected final String TEXT_658 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_659 = " && ";
  protected final String TEXT_660 = "->";
  protected final String TEXT_661 = "() <= ";
  protected final String TEXT_662 = "())" + NL + "    {" + NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_663 = ")" + NL + "    {";
  protected final String TEXT_664 = NL + "      ";
  protected final String TEXT_665 = "->";
  protected final String TEXT_666 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_667 = NL + "      ";
  protected final String TEXT_668 = ".add(";
  protected final String TEXT_669 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_670 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_671 = "::";
  protected final String TEXT_672 = "(";
  protected final String TEXT_673 = "* ";
  protected final String TEXT_674 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\t";
  protected final String TEXT_675 = NL + "    //Unable to remove ";
  protected final String TEXT_676 = ", as it must always have a ";
  protected final String TEXT_677 = NL + "    if (this == ";
  protected final String TEXT_678 = "->";
  protected final String TEXT_679 = "()))" + NL + "    {";
  protected final String TEXT_680 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_681 = " already at minimum (";
  protected final String TEXT_682 = ")" + NL + "    if (";
  protected final String TEXT_683 = "() <= ";
  protected final String TEXT_684 = "())" + NL + "    {";
  protected final String TEXT_685 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_686 = NL + "    ";
  protected final String TEXT_687 = ".remove(";
  protected final String TEXT_688 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_689 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_690 = NL + "  ";
  protected final String TEXT_691 = " ";
  protected final String TEXT_692 = "::";
  protected final String TEXT_693 = "(";
  protected final String TEXT_694 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_695 = "() >= ";
  protected final String TEXT_696 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_697 = "(";
  protected final String TEXT_698 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_699 = "::";
  protected final String TEXT_700 = "(";
  protected final String TEXT_701 = "* ";
  protected final String TEXT_702 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_703 = NL + "    if (";
  protected final String TEXT_704 = "() >= ";
  protected final String TEXT_705 = "())" + NL + "    {";
  protected final String TEXT_706 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_707 = NL + "    ";
  protected final String TEXT_708 = " ";
  protected final String TEXT_709 = " = ";
  protected final String TEXT_710 = "->";
  protected final String TEXT_711 = "();" + NL + "    bool ";
  protected final String TEXT_712 = " = (";
  protected final String TEXT_713 = " != NULL && this!=";
  protected final String TEXT_714 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_715 = " && ";
  protected final String TEXT_716 = "->";
  protected final String TEXT_717 = "() <= ";
  protected final String TEXT_718 = "())" + NL + "    {";
  protected final String TEXT_719 = NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_720 = ")" + NL + "    {";
  protected final String TEXT_721 = NL + "      ";
  protected final String TEXT_722 = "->";
  protected final String TEXT_723 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_724 = NL + "      ";
  protected final String TEXT_725 = ".add(";
  protected final String TEXT_726 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_727 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_728 = "::";
  protected final String TEXT_729 = "(";
  protected final String TEXT_730 = "* ";
  protected final String TEXT_731 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_732 = ".begin(), ";
  protected final String TEXT_733 = ".end(), ";
  protected final String TEXT_734 = ") - ";
  protected final String TEXT_735 = ".begin();";
  protected final String TEXT_736 = NL + "    //Unable to remove ";
  protected final String TEXT_737 = ", as it must always have a ";
  protected final String TEXT_738 = NL + "    if (this == ";
  protected final String TEXT_739 = "->";
  protected final String TEXT_740 = "())" + NL + "    {";
  protected final String TEXT_741 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_742 = " already at minimum (";
  protected final String TEXT_743 = ")" + NL + "    if (";
  protected final String TEXT_744 = "() <= ";
  protected final String TEXT_745 = "())" + NL + "    {";
  protected final String TEXT_746 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_747 = NL + "    ";
  protected final String TEXT_748 = ".erase(find(";
  protected final String TEXT_749 = ".begin(),";
  protected final String TEXT_750 = ".end(),";
  protected final String TEXT_751 = "));" + NL + "\tdelete ";
  protected final String TEXT_752 = "[index];" + NL + "    wasRemoved = true;";
  protected final String TEXT_753 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_754 = NL + "  ";
  protected final String TEXT_755 = " ";
  protected final String TEXT_756 = "::";
  protected final String TEXT_757 = "(";
  protected final String TEXT_758 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_759 = "() >= ";
  protected final String TEXT_760 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_761 = "(";
  protected final String TEXT_762 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_763 = "::";
  protected final String TEXT_764 = "(";
  protected final String TEXT_765 = "* ";
  protected final String TEXT_766 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_767 = NL + "    if (";
  protected final String TEXT_768 = "() >= ";
  protected final String TEXT_769 = "())" + NL + "    {";
  protected final String TEXT_770 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_771 = NL + "    ";
  protected final String TEXT_772 = " ";
  protected final String TEXT_773 = " = ";
  protected final String TEXT_774 = "->";
  protected final String TEXT_775 = "();" + NL + "    bool ";
  protected final String TEXT_776 = " = (";
  protected final String TEXT_777 = " != NULL && this != ";
  protected final String TEXT_778 = ");" + NL + "    if (";
  protected final String TEXT_779 = ")" + NL + "    {";
  protected final String TEXT_780 = NL + "      ";
  protected final String TEXT_781 = "->";
  protected final String TEXT_782 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_783 = NL + "      ";
  protected final String TEXT_784 = ".push_back(";
  protected final String TEXT_785 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_786 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_787 = "::";
  protected final String TEXT_788 = "(";
  protected final String TEXT_789 = "* ";
  protected final String TEXT_790 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_791 = ".begin(), ";
  protected final String TEXT_792 = ".end(), ";
  protected final String TEXT_793 = ") - ";
  protected final String TEXT_794 = ".begin();";
  protected final String TEXT_795 = NL + "    //Unable to remove ";
  protected final String TEXT_796 = ", as it must always have a ";
  protected final String TEXT_797 = NL + "    if (this != ";
  protected final String TEXT_798 = "->";
  protected final String TEXT_799 = "())" + NL + "    {";
  protected final String TEXT_800 = NL + "      ";
  protected final String TEXT_801 = ".erase(find(";
  protected final String TEXT_802 = ".begin(),";
  protected final String TEXT_803 = ".end(),";
  protected final String TEXT_804 = "));" + NL + "\t  delete ";
  protected final String TEXT_805 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_806 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_807 = NL + "  bool ";
  protected final String TEXT_808 = "::";
  protected final String TEXT_809 = "(";
  protected final String TEXT_810 = "... ";
  protected final String TEXT_811 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_812 = NL + "    vector<";
  protected final String TEXT_813 = "*> ";
  protected final String TEXT_814 = ";" + NL + "\t" + NL + "    for (";
  protected final String TEXT_815 = " ";
  protected final String TEXT_816 = " : ";
  protected final String TEXT_817 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_818 = ".begin(),";
  protected final String TEXT_819 = ".end(),";
  protected final String TEXT_820 = ") != ";
  protected final String TEXT_821 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_822 = NL + "      ";
  protected final String TEXT_823 = "->add(";
  protected final String TEXT_824 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_825 = ".size() != ";
  protected final String TEXT_826 = ".length || ";
  protected final String TEXT_827 = ".size() > ";
  protected final String TEXT_828 = "())" + NL + "    {";
  protected final String TEXT_829 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_830 = "*> ";
  protected final String TEXT_831 = ";";
  protected final String TEXT_832 = NL + "    ";
  protected final String TEXT_833 = ".clear();" + NL + "    for (";
  protected final String TEXT_834 = " ";
  protected final String TEXT_835 = " : ";
  protected final String TEXT_836 = ")" + NL + "    {";
  protected final String TEXT_837 = NL + "      ";
  protected final String TEXT_838 = "->add(";
  protected final String TEXT_839 = ");" + NL + "      if (find(";
  protected final String TEXT_840 = ".begin(),";
  protected final String TEXT_841 = ".end(),";
  protected final String TEXT_842 = ") != ";
  protected final String TEXT_843 = ".end())" + NL + "      {";
  protected final String TEXT_844 = NL + "        ";
  protected final String TEXT_845 = ".erase(";
  protected final String TEXT_846 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_847 = NL + "        ";
  protected final String TEXT_848 = "->";
  protected final String TEXT_849 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_850 = " ";
  protected final String TEXT_851 = " : ";
  protected final String TEXT_852 = ")" + NL + "    {";
  protected final String TEXT_853 = NL + "      ";
  protected final String TEXT_854 = "->";
  protected final String TEXT_855 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_856 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_857 = NL + "  ";
  protected final String TEXT_858 = " ";
  protected final String TEXT_859 = "::";
  protected final String TEXT_860 = "(";
  protected final String TEXT_861 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_862 = "(";
  protected final String TEXT_863 = ");" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_864 = "::";
  protected final String TEXT_865 = "(";
  protected final String TEXT_866 = "* ";
  protected final String TEXT_867 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_868 = NL + "    ";
  protected final String TEXT_869 = "* ";
  protected final String TEXT_870 = " = ";
  protected final String TEXT_871 = "->";
  protected final String TEXT_872 = "();" + NL + "    bool ";
  protected final String TEXT_873 = " = (";
  protected final String TEXT_874 = " != NULL && this!=";
  protected final String TEXT_875 = ");" + NL + "    if (";
  protected final String TEXT_876 = ")" + NL + "    {";
  protected final String TEXT_877 = NL + "      ";
  protected final String TEXT_878 = "->";
  protected final String TEXT_879 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_880 = NL + "      ";
  protected final String TEXT_881 = ".push_back(";
  protected final String TEXT_882 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_883 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_884 = "::";
  protected final String TEXT_885 = "(";
  protected final String TEXT_886 = "* ";
  protected final String TEXT_887 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_888 = ".begin(), ";
  protected final String TEXT_889 = ".end(), ";
  protected final String TEXT_890 = ") - ";
  protected final String TEXT_891 = ".begin();";
  protected final String TEXT_892 = NL + "    //Unable to remove ";
  protected final String TEXT_893 = ", as it must always have a ";
  protected final String TEXT_894 = NL + "    if (this!=";
  protected final String TEXT_895 = "->";
  protected final String TEXT_896 = "())" + NL + "    {";
  protected final String TEXT_897 = NL + "      ";
  protected final String TEXT_898 = ".erase(find(";
  protected final String TEXT_899 = ".begin(),";
  protected final String TEXT_900 = ".end(),";
  protected final String TEXT_901 = "));" + NL + "\t  delete ";
  protected final String TEXT_902 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_903 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_904 = NL + "  bool ";
  protected final String TEXT_905 = "::";
  protected final String TEXT_906 = "(";
  protected final String TEXT_907 = "* ";
  protected final String TEXT_908 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_909 = NL + "    if (";
  protected final String TEXT_910 = " == NULL)" + NL + "    {";
  protected final String TEXT_911 = NL + "      ";
  protected final String TEXT_912 = " ";
  protected final String TEXT_913 = " = ";
  protected final String TEXT_914 = ";";
  protected final String TEXT_915 = NL + "      ";
  protected final String TEXT_916 = " = NULL;" + NL + "      " + NL + "      if (";
  protected final String TEXT_917 = " != NULL && ";
  protected final String TEXT_918 = "->";
  protected final String TEXT_919 = "() != NULL)" + NL + "      {";
  protected final String TEXT_920 = NL + "        ";
  protected final String TEXT_921 = "->";
  protected final String TEXT_922 = "(NULL);" + NL + "      }" + NL + "      wasSet = true;";
  protected final String TEXT_923 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_924 = NL + "    ";
  protected final String TEXT_925 = "* ";
  protected final String TEXT_926 = " = ";
  protected final String TEXT_927 = "();" + NL + "    if (";
  protected final String TEXT_928 = " != NULL && ";
  protected final String TEXT_929 = "!=";
  protected final String TEXT_930 = ")" + NL + "    {";
  protected final String TEXT_931 = NL + "      ";
  protected final String TEXT_932 = "->";
  protected final String TEXT_933 = "(NULL);" + NL + "    }" + NL;
  protected final String TEXT_934 = NL + "    ";
  protected final String TEXT_935 = " = ";
  protected final String TEXT_936 = ";";
  protected final String TEXT_937 = NL + "    ";
  protected final String TEXT_938 = "* ";
  protected final String TEXT_939 = " = ";
  protected final String TEXT_940 = "->";
  protected final String TEXT_941 = "();" + NL + "" + NL + "    if (!=";
  protected final String TEXT_942 = ")" + NL + "    {";
  protected final String TEXT_943 = NL + "      ";
  protected final String TEXT_944 = "->";
  protected final String TEXT_945 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_946 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_947 = NL + "  bool ";
  protected final String TEXT_948 = "::";
  protected final String TEXT_949 = "(";
  protected final String TEXT_950 = "* ";
  protected final String TEXT_951 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_952 = ".begin(), ";
  protected final String TEXT_953 = ".end(), ";
  protected final String TEXT_954 = ") - ";
  protected final String TEXT_955 = ".begin();";
  protected final String TEXT_956 = NL + "    if (! find(";
  protected final String TEXT_957 = ".begin(),";
  protected final String TEXT_958 = ".end(),";
  protected final String TEXT_959 = "))" + NL + "    {";
  protected final String TEXT_960 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_961 = "() <= ";
  protected final String TEXT_962 = "())" + NL + "    {";
  protected final String TEXT_963 = NL + "      return wasRemoved;" + NL + "    }" + NL + "\t" + NL + "    int oldIndex = find(";
  protected final String TEXT_964 = ".begin(), ";
  protected final String TEXT_965 = ".end(), ";
  protected final String TEXT_966 = ") - ";
  protected final String TEXT_967 = ".begin();";
  protected final String TEXT_968 = NL + "    ";
  protected final String TEXT_969 = ".erase(find(";
  protected final String TEXT_970 = ".begin(), ";
  protected final String TEXT_971 = ".end(), ";
  protected final String TEXT_972 = "));" + NL + "\tdelete ";
  protected final String TEXT_973 = "[oldIndex];" + NL + "    if (";
  protected final String TEXT_974 = "->";
  protected final String TEXT_975 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_976 = "->";
  protected final String TEXT_977 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_978 = NL + "        ";
  protected final String TEXT_979 = "->add(oldIndex,";
  protected final String TEXT_980 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_981 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_982 = NL + "  bool ";
  protected final String TEXT_983 = "::";
  protected final String TEXT_984 = "(";
  protected final String TEXT_985 = "* ";
  protected final String TEXT_986 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_987 = ".begin(), ";
  protected final String TEXT_988 = ".end(), ";
  protected final String TEXT_989 = ") - ";
  protected final String TEXT_990 = ".begin();";
  protected final String TEXT_991 = NL + "    if (! find(";
  protected final String TEXT_992 = ".begin(),";
  protected final String TEXT_993 = ".end(),";
  protected final String TEXT_994 = ") != ";
  protected final String TEXT_995 = ".end())" + NL + "    {";
  protected final String TEXT_996 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_997 = "() <= ";
  protected final String TEXT_998 = "())" + NL + "    {";
  protected final String TEXT_999 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = find(";
  protected final String TEXT_1000 = ".begin(), ";
  protected final String TEXT_1001 = ".end(), ";
  protected final String TEXT_1002 = ") - ";
  protected final String TEXT_1003 = ".begin();";
  protected final String TEXT_1004 = NL + "    ";
  protected final String TEXT_1005 = ".erase(oldIndex);" + NL + "\tdelete ";
  protected final String TEXT_1006 = "[oldIndex];" + NL + "    if (";
  protected final String TEXT_1007 = "->";
  protected final String TEXT_1008 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_1009 = ".";
  protected final String TEXT_1010 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_1011 = NL + "        ";
  protected final String TEXT_1012 = ".add(oldIndex,";
  protected final String TEXT_1013 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_1014 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1015 = NL + "  bool ";
  protected final String TEXT_1016 = "::";
  protected final String TEXT_1017 = "(";
  protected final String TEXT_1018 = "* ";
  protected final String TEXT_1019 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1020 = NL + "    if (";
  protected final String TEXT_1021 = " != NULL && ";
  protected final String TEXT_1022 = "->";
  protected final String TEXT_1023 = "() >= ";
  protected final String TEXT_1024 = "->";
  protected final String TEXT_1025 = "())" + NL + "    {";
  protected final String TEXT_1026 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1027 = NL + "    ";
  protected final String TEXT_1028 = "* ";
  protected final String TEXT_1029 = " = ";
  protected final String TEXT_1030 = ";";
  protected final String TEXT_1031 = NL + "    ";
  protected final String TEXT_1032 = " = ";
  protected final String TEXT_1033 = ";" + NL + "    if (";
  protected final String TEXT_1034 = " != NULL && ";
  protected final String TEXT_1035 = "!=";
  protected final String TEXT_1036 = ")" + NL + "    {";
  protected final String TEXT_1037 = NL + "      ";
  protected final String TEXT_1038 = "->";
  protected final String TEXT_1039 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1040 = " != null)" + NL + "    {";
  protected final String TEXT_1041 = NL + "      ";
  protected final String TEXT_1042 = "->";
  protected final String TEXT_1043 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1044 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1045 = NL + "  bool ";
  protected final String TEXT_1046 = "::";
  protected final String TEXT_1047 = "(";
  protected final String TEXT_1048 = "* ";
  protected final String TEXT_1049 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1050 = NL + "    if (";
  protected final String TEXT_1051 = " == NULL)" + NL + "    {";
  protected final String TEXT_1052 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1053 = NL + "    ";
  protected final String TEXT_1054 = "* ";
  protected final String TEXT_1055 = " = ";
  protected final String TEXT_1056 = ";";
  protected final String TEXT_1057 = NL + "    ";
  protected final String TEXT_1058 = " = ";
  protected final String TEXT_1059 = ";" + NL + "    if (";
  protected final String TEXT_1060 = " != NULL && ";
  protected final String TEXT_1061 = "!=";
  protected final String TEXT_1062 = ")" + NL + "    {";
  protected final String TEXT_1063 = NL + "      ";
  protected final String TEXT_1064 = "->";
  protected final String TEXT_1065 = "(this);" + NL + "    }";
  protected final String TEXT_1066 = NL + "    ";
  protected final String TEXT_1067 = "->";
  protected final String TEXT_1068 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1069 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1070 = NL + "  bool ";
  protected final String TEXT_1071 = "(";
  protected final String TEXT_1072 = " ";
  protected final String TEXT_1073 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1074 = NL + "    if (";
  protected final String TEXT_1075 = " == null)" + NL + "    {";
  protected final String TEXT_1076 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1077 = NL + "    ";
  protected final String TEXT_1078 = " ";
  protected final String TEXT_1079 = " = ";
  protected final String TEXT_1080 = ";";
  protected final String TEXT_1081 = NL + "    ";
  protected final String TEXT_1082 = " = ";
  protected final String TEXT_1083 = ";" + NL + "    if (";
  protected final String TEXT_1084 = " != null && !";
  protected final String TEXT_1085 = ".equals(";
  protected final String TEXT_1086 = "))" + NL + "    {";
  protected final String TEXT_1087 = NL + "      ";
  protected final String TEXT_1088 = ".";
  protected final String TEXT_1089 = "(this);" + NL + "    }" + NL + "    if (!";
  protected final String TEXT_1090 = ".";
  protected final String TEXT_1091 = "(this))" + NL + "    {";
  protected final String TEXT_1092 = NL + "      ";
  protected final String TEXT_1093 = " = ";
  protected final String TEXT_1094 = ";" + NL + "      wasSet = false;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_1095 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1096 = NL + "  bool ";
  protected final String TEXT_1097 = "::";
  protected final String TEXT_1098 = "(";
  protected final String TEXT_1099 = "* ";
  protected final String TEXT_1100 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1101 = NL + "    //Must provide ";
  protected final String TEXT_1102 = " to ";
  protected final String TEXT_1103 = NL + "    if (";
  protected final String TEXT_1104 = " == NULL)" + NL + "    {";
  protected final String TEXT_1105 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_1106 = " already at maximum (";
  protected final String TEXT_1107 = ")" + NL + "    if (";
  protected final String TEXT_1108 = "->";
  protected final String TEXT_1109 = "() >= ";
  protected final String TEXT_1110 = "->";
  protected final String TEXT_1111 = "())" + NL + "    {";
  protected final String TEXT_1112 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_1113 = NL + "    ";
  protected final String TEXT_1114 = "* ";
  protected final String TEXT_1115 = " = ";
  protected final String TEXT_1116 = ";";
  protected final String TEXT_1117 = NL + "    ";
  protected final String TEXT_1118 = " = ";
  protected final String TEXT_1119 = ";" + NL + "    if (";
  protected final String TEXT_1120 = " != NULL && ";
  protected final String TEXT_1121 = "!=";
  protected final String TEXT_1122 = "))" + NL + "    {" + NL + "      bool didRemove = ";
  protected final String TEXT_1123 = "->";
  protected final String TEXT_1124 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1125 = NL + "        ";
  protected final String TEXT_1126 = " = ";
  protected final String TEXT_1127 = ";";
  protected final String TEXT_1128 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1129 = NL + "    ";
  protected final String TEXT_1130 = "->";
  protected final String TEXT_1131 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1132 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1133 = NL + "  bool ";
  protected final String TEXT_1134 = "::";
  protected final String TEXT_1135 = "(";
  protected final String TEXT_1136 = "* ";
  protected final String TEXT_1137 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1138 = NL + "    //Must provide ";
  protected final String TEXT_1139 = " to ";
  protected final String TEXT_1140 = NL + "    if (";
  protected final String TEXT_1141 = " == NULL)" + NL + "    {";
  protected final String TEXT_1142 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1143 = " != NULL && ";
  protected final String TEXT_1144 = ".";
  protected final String TEXT_1145 = "() <= ";
  protected final String TEXT_1146 = ".";
  protected final String TEXT_1147 = "())" + NL + "    {";
  protected final String TEXT_1148 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1149 = NL + "    ";
  protected final String TEXT_1150 = "* ";
  protected final String TEXT_1151 = " = ";
  protected final String TEXT_1152 = ";";
  protected final String TEXT_1153 = NL + "    ";
  protected final String TEXT_1154 = " = ";
  protected final String TEXT_1155 = ";" + NL + "    if (";
  protected final String TEXT_1156 = " != NULL && ";
  protected final String TEXT_1157 = "!=";
  protected final String TEXT_1158 = ")" + NL + "    {" + NL + "      bool didRemove = ";
  protected final String TEXT_1159 = "->";
  protected final String TEXT_1160 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1161 = NL + "        ";
  protected final String TEXT_1162 = " = ";
  protected final String TEXT_1163 = ";";
  protected final String TEXT_1164 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1165 = NL + "    ";
  protected final String TEXT_1166 = "->";
  protected final String TEXT_1167 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1168 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1169 = NL + "  bool ";
  protected final String TEXT_1170 = "::";
  protected final String TEXT_1171 = "(";
  protected final String TEXT_1172 = "* ";
  protected final String TEXT_1173 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1174 = NL + "    ";
  protected final String TEXT_1175 = "* ";
  protected final String TEXT_1176 = " = ";
  protected final String TEXT_1177 = "->";
  protected final String TEXT_1178 = "();" + NL + "    if (";
  protected final String TEXT_1179 = " == NULL)" + NL + "    {";
  protected final String TEXT_1180 = NL + "      ";
  protected final String TEXT_1181 = "->";
  protected final String TEXT_1182 = "(this);" + NL + "    }" + NL + "    else if (this!=";
  protected final String TEXT_1183 = ")" + NL + "    {";
  protected final String TEXT_1184 = NL + "      ";
  protected final String TEXT_1185 = "->";
  protected final String TEXT_1186 = "(";
  protected final String TEXT_1187 = ");";
  protected final String TEXT_1188 = NL + "      ";
  protected final String TEXT_1189 = "(";
  protected final String TEXT_1190 = ");" + NL + "    } " + NL + "    else" + NL + "    {";
  protected final String TEXT_1191 = NL + "      ";
  protected final String TEXT_1192 = ".push_back(";
  protected final String TEXT_1193 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_1194 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1195 = "::";
  protected final String TEXT_1196 = "(";
  protected final String TEXT_1197 = "* ";
  protected final String TEXT_1198 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1199 = ".begin(), ";
  protected final String TEXT_1200 = ".end(), ";
  protected final String TEXT_1201 = ") - ";
  protected final String TEXT_1202 = ".begin();";
  protected final String TEXT_1203 = NL + "    if (find(";
  protected final String TEXT_1204 = ".begin(),";
  protected final String TEXT_1205 = ".end(),";
  protected final String TEXT_1206 = ")!= ";
  protected final String TEXT_1207 = ".end())" + NL + "    {";
  protected final String TEXT_1208 = NL + "      ";
  protected final String TEXT_1209 = ".erase(find(";
  protected final String TEXT_1210 = ".begin(),";
  protected final String TEXT_1211 = ".end(),";
  protected final String TEXT_1212 = "));";
  protected final String TEXT_1213 = NL + "      ";
  protected final String TEXT_1214 = "->";
  protected final String TEXT_1215 = "(NULL);" + NL + "\t  delete ";
  protected final String TEXT_1216 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1217 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1218 = NL + "  bool ";
  protected final String TEXT_1219 = "::";
  protected final String TEXT_1220 = "(";
  protected final String TEXT_1221 = "* ";
  protected final String TEXT_1222 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1223 = NL + "    ";
  protected final String TEXT_1224 = "* ";
  protected final String TEXT_1225 = " = ";
  protected final String TEXT_1226 = ";";
  protected final String TEXT_1227 = NL + "    ";
  protected final String TEXT_1228 = " = ";
  protected final String TEXT_1229 = ";" + NL + "    if (";
  protected final String TEXT_1230 = " != NULL && ";
  protected final String TEXT_1231 = "!=";
  protected final String TEXT_1232 = ")" + NL + "    {";
  protected final String TEXT_1233 = NL + "      ";
  protected final String TEXT_1234 = "->";
  protected final String TEXT_1235 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1236 = " != NULL)" + NL + "    {";
  protected final String TEXT_1237 = NL + "      ";
  protected final String TEXT_1238 = "->";
  protected final String TEXT_1239 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1240 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1241 = NL + "  bool ";
  protected final String TEXT_1242 = "::";
  protected final String TEXT_1243 = "(";
  protected final String TEXT_1244 = "* ";
  protected final String TEXT_1245 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1246 = NL + "    if (";
  protected final String TEXT_1247 = "() >= ";
  protected final String TEXT_1248 = "())" + NL + "    {";
  protected final String TEXT_1249 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_1250 = NL + "    ";
  protected final String TEXT_1251 = " ";
  protected final String TEXT_1252 = " = ";
  protected final String TEXT_1253 = "->";
  protected final String TEXT_1254 = "();" + NL + "    if (";
  protected final String TEXT_1255 = " == NULL)" + NL + "    {";
  protected final String TEXT_1256 = NL + "      ";
  protected final String TEXT_1257 = "->";
  protected final String TEXT_1258 = "(this);" + NL + "    }" + NL + "    else if (this!=";
  protected final String TEXT_1259 = ")" + NL + "    {";
  protected final String TEXT_1260 = NL + "      ";
  protected final String TEXT_1261 = "->";
  protected final String TEXT_1262 = "(";
  protected final String TEXT_1263 = ");";
  protected final String TEXT_1264 = NL + "      ";
  protected final String TEXT_1265 = "(";
  protected final String TEXT_1266 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1267 = NL + "      ";
  protected final String TEXT_1268 = ".push_back(";
  protected final String TEXT_1269 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_1270 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1271 = "::";
  protected final String TEXT_1272 = "(";
  protected final String TEXT_1273 = "* ";
  protected final String TEXT_1274 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1275 = ".begin(), ";
  protected final String TEXT_1276 = ".end(), ";
  protected final String TEXT_1277 = ") - ";
  protected final String TEXT_1278 = ".begin();";
  protected final String TEXT_1279 = NL + "    if (find(";
  protected final String TEXT_1280 = ".begin(),";
  protected final String TEXT_1281 = ".end(),";
  protected final String TEXT_1282 = ") != ";
  protected final String TEXT_1283 = ".end())" + NL + "    {";
  protected final String TEXT_1284 = NL + "      ";
  protected final String TEXT_1285 = ".remove(";
  protected final String TEXT_1286 = ");";
  protected final String TEXT_1287 = NL + "      ";
  protected final String TEXT_1288 = "->";
  protected final String TEXT_1289 = "(NULL);" + NL + "\t  delete ";
  protected final String TEXT_1290 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1291 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1292 = NL + "  bool ";
  protected final String TEXT_1293 = "::";
  protected final String TEXT_1294 = "(";
  protected final String TEXT_1295 = " ";
  protected final String TEXT_1296 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1297 = NL + "    if (";
  protected final String TEXT_1298 = "() < ";
  protected final String TEXT_1299 = "())" + NL + "    {";
  protected final String TEXT_1300 = NL + "      ";
  protected final String TEXT_1301 = ".push_back(";
  protected final String TEXT_1302 = ");" + NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1303 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1304 = "::";
  protected final String TEXT_1305 = "(";
  protected final String TEXT_1306 = "* ";
  protected final String TEXT_1307 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1308 = ".begin(), ";
  protected final String TEXT_1309 = ".end(), ";
  protected final String TEXT_1310 = ") - ";
  protected final String TEXT_1311 = ".begin();";
  protected final String TEXT_1312 = NL + "    if (!find(";
  protected final String TEXT_1313 = ".begin(),";
  protected final String TEXT_1314 = ".end(),";
  protected final String TEXT_1315 = ") != ";
  protected final String TEXT_1316 = ".end())" + NL + "    {";
  protected final String TEXT_1317 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1318 = "() <= ";
  protected final String TEXT_1319 = "())" + NL + "    {";
  protected final String TEXT_1320 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_1321 = NL + "    ";
  protected final String TEXT_1322 = ".erase(find(";
  protected final String TEXT_1323 = ".begin(),";
  protected final String TEXT_1324 = ".end(),";
  protected final String TEXT_1325 = "));" + NL + "\tdelete ";
  protected final String TEXT_1326 = "[index];" + NL + "    wasRemoved = true;";
  protected final String TEXT_1327 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1328 = NL + "  bool ";
  protected final String TEXT_1329 = "::";
  protected final String TEXT_1330 = "(";
  protected final String TEXT_1331 = "* ";
  protected final String TEXT_1332 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1333 = NL + "    if (";
  protected final String TEXT_1334 = "() >= ";
  protected final String TEXT_1335 = "())" + NL + "    {";
  protected final String TEXT_1336 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_1337 = NL + "    ";
  protected final String TEXT_1338 = " ";
  protected final String TEXT_1339 = " = ";
  protected final String TEXT_1340 = "->";
  protected final String TEXT_1341 = "();" + NL + "    if (";
  protected final String TEXT_1342 = " != NULL && ";
  protected final String TEXT_1343 = "->";
  protected final String TEXT_1344 = "() <= ";
  protected final String TEXT_1345 = "())" + NL + "    {";
  protected final String TEXT_1346 = NL + "      return wasAdded;" + NL + "    }" + NL + "    else if (";
  protected final String TEXT_1347 = " != null)" + NL + "    {";
  protected final String TEXT_1348 = NL + "      ";
  protected final String TEXT_1349 = ".";
  protected final String TEXT_1350 = ".erase(find(";
  protected final String TEXT_1351 = ".begin(),";
  protected final String TEXT_1352 = ".end(),";
  protected final String TEXT_1353 = "));" + NL + "    }";
  protected final String TEXT_1354 = NL + "    ";
  protected final String TEXT_1355 = ".push_back(";
  protected final String TEXT_1356 = ");";
  protected final String TEXT_1357 = NL + "    ";
  protected final String TEXT_1358 = "(";
  protected final String TEXT_1359 = ",this);" + NL + "    wasAdded = true;";
  protected final String TEXT_1360 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1361 = "::";
  protected final String TEXT_1362 = "(";
  protected final String TEXT_1363 = "* ";
  protected final String TEXT_1364 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1365 = ".begin(), ";
  protected final String TEXT_1366 = ".end(), ";
  protected final String TEXT_1367 = ") - ";
  protected final String TEXT_1368 = ".begin();";
  protected final String TEXT_1369 = NL + "    if ((find(";
  protected final String TEXT_1370 = ".begin(),";
  protected final String TEXT_1371 = ".end(),";
  protected final String TEXT_1372 = ") !=";
  protected final String TEXT_1373 = ".end()) && ";
  protected final String TEXT_1374 = "() > ";
  protected final String TEXT_1375 = "())" + NL + "    {";
  protected final String TEXT_1376 = NL + "      ";
  protected final String TEXT_1377 = ".erase(find(";
  protected final String TEXT_1378 = ".begin(),";
  protected final String TEXT_1379 = ".end(),";
  protected final String TEXT_1380 = "));";
  protected final String TEXT_1381 = NL + "      ";
  protected final String TEXT_1382 = "(";
  protected final String TEXT_1383 = ",NULL);" + NL + "\t  delete ";
  protected final String TEXT_1384 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1385 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1386 = NL + "  bool ";
  protected final String TEXT_1387 = "::";
  protected final String TEXT_1388 = "(";
  protected final String TEXT_1389 = "... ";
  protected final String TEXT_1390 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1391 = NL + "    vector<";
  protected final String TEXT_1392 = "*> ";
  protected final String TEXT_1393 = ";" + NL + "\t" + NL + "    for (";
  protected final String TEXT_1394 = " ";
  protected final String TEXT_1395 = " : ";
  protected final String TEXT_1396 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1397 = ".begin(),";
  protected final String TEXT_1398 = ".end(),";
  protected final String TEXT_1399 = ") != ";
  protected final String TEXT_1400 = ".end())" + NL + "      {";
  protected final String TEXT_1401 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1402 = ".";
  protected final String TEXT_1403 = "() != NULL && this!=(";
  protected final String TEXT_1404 = "->";
  protected final String TEXT_1405 = "()))" + NL + "      {";
  protected final String TEXT_1406 = NL + "        return wasSet;" + NL + "      }";
  protected final String TEXT_1407 = NL + "      ";
  protected final String TEXT_1408 = ".push_back(";
  protected final String TEXT_1409 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1410 = ".size() != ";
  protected final String TEXT_1411 = "())" + NL + "    {";
  protected final String TEXT_1412 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1413 = NL + "    ";
  protected final String TEXT_1414 = ".removeAll(";
  protected final String TEXT_1415 = ");" + NL + "    " + NL + "    for (";
  protected final String TEXT_1416 = " orphan : ";
  protected final String TEXT_1417 = ")" + NL + "    {";
  protected final String TEXT_1418 = NL + "      ";
  protected final String TEXT_1419 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1420 = NL + "    ";
  protected final String TEXT_1421 = ".clear();" + NL + "    for (";
  protected final String TEXT_1422 = " ";
  protected final String TEXT_1423 = " : ";
  protected final String TEXT_1424 = ")" + NL + "    {";
  protected final String TEXT_1425 = NL + "      ";
  protected final String TEXT_1426 = "(";
  protected final String TEXT_1427 = ", this);";
  protected final String TEXT_1428 = NL + "      ";
  protected final String TEXT_1429 = ".push_back(";
  protected final String TEXT_1430 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1431 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1432 = NL + "  void ";
  protected final String TEXT_1433 = "::";
  protected final String TEXT_1434 = "(";
  protected final String TEXT_1435 = " ";
  protected final String TEXT_1436 = ", ";
  protected final String TEXT_1437 = " ";
  protected final String TEXT_1438 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1439 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1440 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1441 = ", ";
  protected final String TEXT_1442 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1443 = " to ";
  protected final String TEXT_1444 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1445 = NL + "  bool ";
  protected final String TEXT_1446 = "::";
  protected final String TEXT_1447 = "(";
  protected final String TEXT_1448 = " ";
  protected final String TEXT_1449 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1450 = NL + "    ";
  protected final String TEXT_1451 = ".push_back(";
  protected final String TEXT_1452 = ");" + NL + "    wasAdded = true;";
  protected final String TEXT_1453 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1454 = "::";
  protected final String TEXT_1455 = "(";
  protected final String TEXT_1456 = "* ";
  protected final String TEXT_1457 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1458 = ".begin(), ";
  protected final String TEXT_1459 = ".end(), ";
  protected final String TEXT_1460 = ") - ";
  protected final String TEXT_1461 = ".begin();";
  protected final String TEXT_1462 = NL + "    if (find(";
  protected final String TEXT_1463 = ".begin(),";
  protected final String TEXT_1464 = ".end(),";
  protected final String TEXT_1465 = ") != ";
  protected final String TEXT_1466 = ".end())" + NL + "    {";
  protected final String TEXT_1467 = NL + "      ";
  protected final String TEXT_1468 = ".erase(find(";
  protected final String TEXT_1469 = ".begin(),";
  protected final String TEXT_1470 = ".end(),";
  protected final String TEXT_1471 = "));" + NL + "\t  delete ";
  protected final String TEXT_1472 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1473 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1474 = NL + "  bool ";
  protected final String TEXT_1475 = "::";
  protected final String TEXT_1476 = "(";
  protected final String TEXT_1477 = "* ";
  protected final String TEXT_1478 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1479 = NL + "    if (";
  protected final String TEXT_1480 = "() < ";
  protected final String TEXT_1481 = "())" + NL + "    {";
  protected final String TEXT_1482 = NL + "      ";
  protected final String TEXT_1483 = ".push_back(";
  protected final String TEXT_1484 = ");" + NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1485 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1486 = "::";
  protected final String TEXT_1487 = "(";
  protected final String TEXT_1488 = "* ";
  protected final String TEXT_1489 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1490 = ".begin(), ";
  protected final String TEXT_1491 = ".end(), ";
  protected final String TEXT_1492 = ") - ";
  protected final String TEXT_1493 = ".begin();";
  protected final String TEXT_1494 = NL + "    if (find(";
  protected final String TEXT_1495 = ".begin(),";
  protected final String TEXT_1496 = ".end(),";
  protected final String TEXT_1497 = ") != ";
  protected final String TEXT_1498 = ".end())" + NL + "    {";
  protected final String TEXT_1499 = NL + "      ";
  protected final String TEXT_1500 = ".erase(";
  protected final String TEXT_1501 = ");" + NL + "\t  delete ";
  protected final String TEXT_1502 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1503 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1504 = NL + "  bool ";
  protected final String TEXT_1505 = "::";
  protected final String TEXT_1506 = "(";
  protected final String TEXT_1507 = "* ";
  protected final String TEXT_1508 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1509 = NL + "    ";
  protected final String TEXT_1510 = ".push_back(";
  protected final String TEXT_1511 = ");" + NL + "    wasAdded = true;";
  protected final String TEXT_1512 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1513 = "::";
  protected final String TEXT_1514 = "(";
  protected final String TEXT_1515 = "* ";
  protected final String TEXT_1516 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1517 = ".begin(), ";
  protected final String TEXT_1518 = ".end(), ";
  protected final String TEXT_1519 = ") - ";
  protected final String TEXT_1520 = ".begin();";
  protected final String TEXT_1521 = NL + "    if (!find(";
  protected final String TEXT_1522 = ".begin(),";
  protected final String TEXT_1523 = ".end(),";
  protected final String TEXT_1524 = ") != ";
  protected final String TEXT_1525 = ".end())" + NL + "    {";
  protected final String TEXT_1526 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1527 = "() <= ";
  protected final String TEXT_1528 = "())" + NL + "    {";
  protected final String TEXT_1529 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_1530 = NL + "    ";
  protected final String TEXT_1531 = ".erase(find(";
  protected final String TEXT_1532 = ".begin(),";
  protected final String TEXT_1533 = ".end(),";
  protected final String TEXT_1534 = "));" + NL + "    delete ";
  protected final String TEXT_1535 = "[index];" + NL + "\twasRemoved = true;";
  protected final String TEXT_1536 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1537 = NL + "  bool ";
  protected final String TEXT_1538 = "::";
  protected final String TEXT_1539 = "(";
  protected final String TEXT_1540 = "... ";
  protected final String TEXT_1541 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1542 = NL + "    vector<";
  protected final String TEXT_1543 = "*> ";
  protected final String TEXT_1544 = ";" + NL + "    for (";
  protected final String TEXT_1545 = " ";
  protected final String TEXT_1546 = " : ";
  protected final String TEXT_1547 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1548 = ".begin(),";
  protected final String TEXT_1549 = ".end(),";
  protected final String TEXT_1550 = ") != ";
  protected final String TEXT_1551 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1552 = NL + "      ";
  protected final String TEXT_1553 = ".push_back(";
  protected final String TEXT_1554 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1555 = ".size() != ";
  protected final String TEXT_1556 = ".size() || ";
  protected final String TEXT_1557 = ".size() != ";
  protected final String TEXT_1558 = "())" + NL + "    {";
  protected final String TEXT_1559 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1560 = NL + "    ";
  protected final String TEXT_1561 = ".clear();" + NL + "    for (int i=0; i<";
  protected final String TEXT_1562 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1563 = ".push_back(";
  protected final String TEXT_1564 = "[i]);" + NL + "\t}" + NL + "    wasSet = true;";
  protected final String TEXT_1565 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1566 = NL + "  ";
  protected final String TEXT_1567 = " bool ";
  protected final String TEXT_1568 = "(";
  protected final String TEXT_1569 = "... ";
  protected final String TEXT_1570 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1571 = NL + "    vector<";
  protected final String TEXT_1572 = "*> ";
  protected final String TEXT_1573 = ";" + NL + "    for (int i=0 ; i<";
  protected final String TEXT_1574 = ".size() ; i++)" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1575 = ".begin(),";
  protected final String TEXT_1576 = ".end(),(";
  protected final String TEXT_1577 = ") != ";
  protected final String TEXT_1578 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1579 = NL + "      ";
  protected final String TEXT_1580 = ".push_back(";
  protected final String TEXT_1581 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1582 = ".size() != ";
  protected final String TEXT_1583 = ".length)" + NL + "    {";
  protected final String TEXT_1584 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1585 = NL + "    ";
  protected final String TEXT_1586 = ".clear();";
  protected final String TEXT_1587 = NL + "    ";
  protected final String TEXT_1588 = ".addAll(";
  protected final String TEXT_1589 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1590 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1591 = NL + "  bool ";
  protected final String TEXT_1592 = "::";
  protected final String TEXT_1593 = "(";
  protected final String TEXT_1594 = " ";
  protected final String TEXT_1595 = ")" + NL + "  {" + NL + "    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    // it's not required (No upper bound)" + NL + "    //   " + NL + "    // THIS TEMPLATE IS EXPERIMENTAL" + NL + "    //   I cut/Paste from UmpleToJava/templates/association_SetOptionalOneToMandatoryMany.jet" + NL + "    //   and then converted to cpp. " + NL + "    //" + NL + "    bool wasSet = false;";
  protected final String TEXT_1596 = NL + "    ";
  protected final String TEXT_1597 = " *";
  protected final String TEXT_1598 = " = ";
  protected final String TEXT_1599 = ";" + NL + "\t" + NL + "    if (";
  protected final String TEXT_1600 = " == NULL)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1601 = " != NULL)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1602 = "->";
  protected final String TEXT_1603 = "(this))" + NL + "        {";
  protected final String TEXT_1604 = NL + "          ";
  protected final String TEXT_1605 = " = ";
  protected final String TEXT_1606 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    } " + NL + "    else if (";
  protected final String TEXT_1607 = " != NULL)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1608 = " == NULL)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1609 = "->";
  protected final String TEXT_1610 = "() < ";
  protected final String TEXT_1611 = "->";
  protected final String TEXT_1612 = "())" + NL + "        {";
  protected final String TEXT_1613 = NL + "          ";
  protected final String TEXT_1614 = "->";
  protected final String TEXT_1615 = "(this);";
  protected final String TEXT_1616 = NL + "          ";
  protected final String TEXT_1617 = " = ";
  protected final String TEXT_1618 = ";  // ";
  protected final String TEXT_1619 = " == NULL" + NL + "          wasSet = true;" + NL + "        }" + NL + "      } " + NL + "      else" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1620 = "->";
  protected final String TEXT_1621 = "() < ";
  protected final String TEXT_1622 = "->";
  protected final String TEXT_1623 = "())" + NL + "        {";
  protected final String TEXT_1624 = NL + "          ";
  protected final String TEXT_1625 = "->";
  protected final String TEXT_1626 = "(this);";
  protected final String TEXT_1627 = NL + "          ";
  protected final String TEXT_1628 = "->";
  protected final String TEXT_1629 = "(this);";
  protected final String TEXT_1630 = NL + "          ";
  protected final String TEXT_1631 = " = ";
  protected final String TEXT_1632 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    if (wasSet)" + NL + "    {";
  protected final String TEXT_1633 = NL + "      ";
  protected final String TEXT_1634 = " = ";
  protected final String TEXT_1635 = ";" + NL + "    }" + NL + "    return wasSet;" + NL + "  }" + NL + "  ";
  protected final String TEXT_1636 = NL + "//  bool ";
  protected final String TEXT_1637 = "::";
  protected final String TEXT_1638 = "(";
  protected final String TEXT_1639 = " ";
  protected final String TEXT_1640 = ")" + NL + "//  {" + NL + "//    //" + NL + "//    // The source of the code generation is association_SetOptionalOneToMN.jet" + NL + "//    // (this) set file assumes the generation of a maximumNumberOfXXX " + NL + "//    //   method ";
  protected final String TEXT_1641 = NL + "//    // Currently this will not compile due to Issue351 - the template code is fine." + NL + "//    //" + NL + "//    // THIS TEMPLATE IS EXPERIMENTAL" + NL + "//    //   I cut/Paste from UmpleToJava/templates/association_SetOptionalOneToMandatoryMany.jet" + NL + "//    //   and then converted to cpp. " + NL + "//    //" + NL + "//" + NL + "//    bool wasSet = false;" + NL + "//    ";
  protected final String TEXT_1642 = " *";
  protected final String TEXT_1643 = " = ";
  protected final String TEXT_1644 = ";" + NL + "//\t" + NL + "//    if (";
  protected final String TEXT_1645 = " == null)" + NL + "//    {  " + NL + "//      if (";
  protected final String TEXT_1646 = " != null)" + NL + "//      { " + NL + "//        if (";
  protected final String TEXT_1647 = "->";
  protected final String TEXT_1648 = "(this))" + NL + "//          ";
  protected final String TEXT_1649 = " = ";
  protected final String TEXT_1650 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    else" + NL + "//    {" + NL + "//      if (";
  protected final String TEXT_1651 = " != null)" + NL + "//      {" + NL + "//        if (";
  protected final String TEXT_1652 = " == null)" + NL + "//        {" + NL + "//          if (";
  protected final String TEXT_1653 = "->";
  protected final String TEXT_1654 = " < ";
  protected final String TEXT_1655 = ".";
  protected final String TEXT_1656 = ")" + NL + "//            ";
  protected final String TEXT_1657 = "->";
  protected final String TEXT_1658 = "(this);" + NL + "//            ";
  protected final String TEXT_1659 = " = ";
  protected final String TEXT_1660 = "  // ";
  protected final String TEXT_1661 = " == null;" + NL + "//            wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//      else" + NL + "//      {" + NL + "//        if (   ";
  protected final String TEXT_1662 = "->";
  protected final String TEXT_1663 = " < ";
  protected final String TEXT_1664 = "->";
  protected final String TEXT_1665 = "()" + NL + "//            && ";
  protected final String TEXT_1666 = ".";
  protected final String TEXT_1667 = " > ";
  protected final String TEXT_1668 = "->";
  protected final String TEXT_1669 = "()" + NL + "//           )" + NL + "//          ";
  protected final String TEXT_1670 = "->";
  protected final String TEXT_1671 = "(this);" + NL + "//          ";
  protected final String TEXT_1672 = "->";
  protected final String TEXT_1673 = "(this);" + NL + "//          ";
  protected final String TEXT_1674 = " = ";
  protected final String TEXT_1675 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    " + NL + "//    if (wasSet)" + NL + "//    {" + NL + "//      ";
  protected final String TEXT_1676 = " = ";
  protected final String TEXT_1677 = ";" + NL + "//    }" + NL + "//    " + NL + "//    return wasSet;" + NL + "//  }";
  protected final String TEXT_1678 = NL + "  bool ";
  protected final String TEXT_1679 = "::";
  protected final String TEXT_1680 = "(";
  protected final String TEXT_1681 = "... ";
  protected final String TEXT_1682 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1683 = NL + "    vector<";
  protected final String TEXT_1684 = "*> ";
  protected final String TEXT_1685 = ";" + NL + "    for (";
  protected final String TEXT_1686 = " ";
  protected final String TEXT_1687 = " : ";
  protected final String TEXT_1688 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1689 = ".begin(),";
  protected final String TEXT_1690 = ".end(),";
  protected final String TEXT_1691 = ")!= ";
  protected final String TEXT_1692 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1693 = NL + "      ";
  protected final String TEXT_1694 = "push_back(";
  protected final String TEXT_1695 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1696 = ".size() != ";
  protected final String TEXT_1697 = ".length || ";
  protected final String TEXT_1698 = ".size() < ";
  protected final String TEXT_1699 = "() || ";
  protected final String TEXT_1700 = ".size() > ";
  protected final String TEXT_1701 = "())" + NL + "    {";
  protected final String TEXT_1702 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_1703 = "*> ";
  protected final String TEXT_1704 = " = new vector<";
  protected final String TEXT_1705 = "*>(";
  protected final String TEXT_1706 = ");";
  protected final String TEXT_1707 = NL + "    ";
  protected final String TEXT_1708 = ".clear();" + NL + "    for (";
  protected final String TEXT_1709 = " ";
  protected final String TEXT_1710 = " : ";
  protected final String TEXT_1711 = ")" + NL + "    {";
  protected final String TEXT_1712 = NL + "      ";
  protected final String TEXT_1713 = ".push_back(";
  protected final String TEXT_1714 = ");" + NL + "      if (find(";
  protected final String TEXT_1715 = ".begin(),";
  protected final String TEXT_1716 = ".end(),";
  protected final String TEXT_1717 = ")!= ";
  protected final String TEXT_1718 = ".end())" + NL + "      {";
  protected final String TEXT_1719 = NL + "        ";
  protected final String TEXT_1720 = ".erase(find(";
  protected final String TEXT_1721 = ".begin(),";
  protected final String TEXT_1722 = ".end(),";
  protected final String TEXT_1723 = "));" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1724 = NL + "        ";
  protected final String TEXT_1725 = "->";
  protected final String TEXT_1726 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1727 = " ";
  protected final String TEXT_1728 = " : ";
  protected final String TEXT_1729 = ")" + NL + "    {";
  protected final String TEXT_1730 = NL + "      ";
  protected final String TEXT_1731 = ".";
  protected final String TEXT_1732 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1733 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1734 = NL + "  bool ";
  protected final String TEXT_1735 = "::";
  protected final String TEXT_1736 = "(";
  protected final String TEXT_1737 = "... ";
  protected final String TEXT_1738 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1739 = NL + "    vector<";
  protected final String TEXT_1740 = "*> ";
  protected final String TEXT_1741 = ";" + NL + "\t" + NL + "    for (";
  protected final String TEXT_1742 = " ";
  protected final String TEXT_1743 = " : ";
  protected final String TEXT_1744 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1745 = ".begin(),";
  protected final String TEXT_1746 = ".end(),";
  protected final String TEXT_1747 = ") != ";
  protected final String TEXT_1748 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1749 = NL + "      ";
  protected final String TEXT_1750 = ".push_back(";
  protected final String TEXT_1751 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1752 = ".size() != ";
  protected final String TEXT_1753 = ".length || ";
  protected final String TEXT_1754 = ".size() < ";
  protected final String TEXT_1755 = "())" + NL + "    {";
  protected final String TEXT_1756 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_1757 = "*> ";
  protected final String TEXT_1758 = ";";
  protected final String TEXT_1759 = NL + "    ";
  protected final String TEXT_1760 = ".clear();" + NL + "    for (";
  protected final String TEXT_1761 = " ";
  protected final String TEXT_1762 = " : ";
  protected final String TEXT_1763 = ")" + NL + "    {";
  protected final String TEXT_1764 = NL + "      ";
  protected final String TEXT_1765 = ".push_back(";
  protected final String TEXT_1766 = ");" + NL + "      if (find(";
  protected final String TEXT_1767 = ".begin(),";
  protected final String TEXT_1768 = ".end(),";
  protected final String TEXT_1769 = ")) != ";
  protected final String TEXT_1770 = ".end())" + NL + "      {";
  protected final String TEXT_1771 = NL + "        ";
  protected final String TEXT_1772 = ".erase(";
  protected final String TEXT_1773 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1774 = NL + "        ";
  protected final String TEXT_1775 = "->";
  protected final String TEXT_1776 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1777 = " ";
  protected final String TEXT_1778 = " : ";
  protected final String TEXT_1779 = ")" + NL + "    {";
  protected final String TEXT_1780 = NL + "      ";
  protected final String TEXT_1781 = "->";
  protected final String TEXT_1782 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1783 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1784 = NL + "  bool ";
  protected final String TEXT_1785 = "::";
  protected final String TEXT_1786 = "(";
  protected final String TEXT_1787 = "... ";
  protected final String TEXT_1788 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1789 = NL + "    vector<";
  protected final String TEXT_1790 = "*> ";
  protected final String TEXT_1791 = ";" + NL + "    for (";
  protected final String TEXT_1792 = " ";
  protected final String TEXT_1793 = " : ";
  protected final String TEXT_1794 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1795 = ".begin(),";
  protected final String TEXT_1796 = ".end(),";
  protected final String TEXT_1797 = ") != ";
  protected final String TEXT_1798 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1799 = NL + "      ";
  protected final String TEXT_1800 = "->add(";
  protected final String TEXT_1801 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1802 = ".size() != ";
  protected final String TEXT_1803 = ".size() || ";
  protected final String TEXT_1804 = ".size() < ";
  protected final String TEXT_1805 = "() || ";
  protected final String TEXT_1806 = ".size() > ";
  protected final String TEXT_1807 = "())" + NL + "    {";
  protected final String TEXT_1808 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1809 = NL + "    ";
  protected final String TEXT_1810 = ".clear();" + NL + "\tfor (int i=0; i<";
  protected final String TEXT_1811 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1812 = ".push_back(";
  protected final String TEXT_1813 = "[i]);" + NL + "\t}" + NL + "    " + NL + "    wasSet = true;";
  protected final String TEXT_1814 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1815 = NL + "  bool ";
  protected final String TEXT_1816 = "::";
  protected final String TEXT_1817 = "(";
  protected final String TEXT_1818 = "... ";
  protected final String TEXT_1819 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1820 = NL + "    if (";
  protected final String TEXT_1821 = ".length < ";
  protected final String TEXT_1822 = "()";
  protected final String TEXT_1823 = ")" + NL + "    {";
  protected final String TEXT_1824 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_1825 = "*> ";
  protected final String TEXT_1826 = ";" + NL + "\t" + NL + "    map<";
  protected final String TEXT_1827 = ",int> ";
  protected final String TEXT_1828 = ";" + NL + "    for (";
  protected final String TEXT_1829 = " ";
  protected final String TEXT_1830 = " : ";
  protected final String TEXT_1831 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1832 = ".begin(),";
  protected final String TEXT_1833 = ".end(),";
  protected final String TEXT_1834 = ") != ";
  protected final String TEXT_1835 = ".end())" + NL + "      {";
  protected final String TEXT_1836 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1837 = "->";
  protected final String TEXT_1838 = "() != NULL && this!=";
  protected final String TEXT_1839 = "->";
  protected final String TEXT_1840 = "())" + NL + "      {";
  protected final String TEXT_1841 = NL + "        ";
  protected final String TEXT_1842 = "* ";
  protected final String TEXT_1843 = " = ";
  protected final String TEXT_1844 = ".";
  protected final String TEXT_1845 = "();" + NL + "        if (!";
  protected final String TEXT_1846 = ".find(";
  protected final String TEXT_1847 = "))" + NL + "        {";
  protected final String TEXT_1848 = NL + "          ";
  protected final String TEXT_1849 = ".insert(";
  protected final String TEXT_1850 = ", new int(";
  protected final String TEXT_1851 = "->";
  protected final String TEXT_1852 = "()));" + NL + "        }" + NL + "        int currentCount = ";
  protected final String TEXT_1853 = ".find(";
  protected final String TEXT_1854 = ")->firtst;" + NL + "        int nextCount = currentCount - 1;" + NL + "        if (nextCount < ";
  protected final String TEXT_1855 = ")" + NL + "        {";
  protected final String TEXT_1856 = NL + "          return wasSet;" + NL + "        }";
  protected final String TEXT_1857 = NL + "        ";
  protected final String TEXT_1858 = ".insert(";
  protected final String TEXT_1859 = ", new int(nextCount));" + NL + "      }";
  protected final String TEXT_1860 = NL + "      ";
  protected final String TEXT_1861 = ".push_back(";
  protected final String TEXT_1862 = ");" + NL + "    }" + NL;
  protected final String TEXT_1863 = NL + "    ";
  protected final String TEXT_1864 = ".removeAll(";
  protected final String TEXT_1865 = ");" + NL + "" + NL + "    for (";
  protected final String TEXT_1866 = " orphan : ";
  protected final String TEXT_1867 = ")" + NL + "    {";
  protected final String TEXT_1868 = NL + "      ";
  protected final String TEXT_1869 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1870 = NL + "    ";
  protected final String TEXT_1871 = ".clear();" + NL + "    for (";
  protected final String TEXT_1872 = " ";
  protected final String TEXT_1873 = " : ";
  protected final String TEXT_1874 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1875 = ".";
  protected final String TEXT_1876 = "() != null)" + NL + "      {";
  protected final String TEXT_1877 = NL + "        ";
  protected final String TEXT_1878 = ".";
  protected final String TEXT_1879 = "()->";
  protected final String TEXT_1880 = ".erase(";
  protected final String TEXT_1881 = ");" + NL + "      }";
  protected final String TEXT_1882 = NL + "      ";
  protected final String TEXT_1883 = "(";
  protected final String TEXT_1884 = ", this);";
  protected final String TEXT_1885 = NL + "      ";
  protected final String TEXT_1886 = ".push_back(";
  protected final String TEXT_1887 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1888 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1889 = NL + "  void ";
  protected final String TEXT_1890 = "::";
  protected final String TEXT_1891 = "(";
  protected final String TEXT_1892 = " ";
  protected final String TEXT_1893 = ", ";
  protected final String TEXT_1894 = " ";
  protected final String TEXT_1895 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1896 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1897 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1898 = ", ";
  protected final String TEXT_1899 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1900 = " to ";
  protected final String TEXT_1901 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1902 = NL + "  bool ";
  protected final String TEXT_1903 = "::";
  protected final String TEXT_1904 = "(";
  protected final String TEXT_1905 = "... ";
  protected final String TEXT_1906 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1907 = NL + "    vector<";
  protected final String TEXT_1908 = "*> ";
  protected final String TEXT_1909 = ";" + NL + "    for (";
  protected final String TEXT_1910 = " ";
  protected final String TEXT_1911 = " : ";
  protected final String TEXT_1912 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1913 = ".begin(),";
  protected final String TEXT_1914 = ".end(),(";
  protected final String TEXT_1915 = ")) - ";
  protected final String TEXT_1916 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1917 = NL + "      ";
  protected final String TEXT_1918 = ".push_back(";
  protected final String TEXT_1919 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1920 = ".size() != ";
  protected final String TEXT_1921 = ".size() || ";
  protected final String TEXT_1922 = ".size() > ";
  protected final String TEXT_1923 = "())" + NL + "    {";
  protected final String TEXT_1924 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1925 = NL + "    ";
  protected final String TEXT_1926 = ".clear();" + NL + "    for (int i=0; i<";
  protected final String TEXT_1927 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1928 = ".push_back(";
  protected final String TEXT_1929 = "[i]);" + NL + "\t}" + NL + "    wasSet = true;";
  protected final String TEXT_1930 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1931 = NL + "  bool ";
  protected final String TEXT_1932 = "::";
  protected final String TEXT_1933 = "(";
  protected final String TEXT_1934 = "... ";
  protected final String TEXT_1935 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1936 = NL + "    vector<";
  protected final String TEXT_1937 = "*> ";
  protected final String TEXT_1938 = ";" + NL + "    for (";
  protected final String TEXT_1939 = " ";
  protected final String TEXT_1940 = " : ";
  protected final String TEXT_1941 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1942 = ".begin(),";
  protected final String TEXT_1943 = ".end(),";
  protected final String TEXT_1944 = ") != ";
  protected final String TEXT_1945 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1946 = NL + "      ";
  protected final String TEXT_1947 = "->add(";
  protected final String TEXT_1948 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1949 = ".size() != ";
  protected final String TEXT_1950 = ".size() || ";
  protected final String TEXT_1951 = ".size() < ";
  protected final String TEXT_1952 = "())" + NL + "    {";
  protected final String TEXT_1953 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1954 = NL + "    ";
  protected final String TEXT_1955 = ".clear();" + NL + "    for (int i=0; i<";
  protected final String TEXT_1956 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1957 = ".push_back(";
  protected final String TEXT_1958 = "[i]);" + NL + "\t}" + NL + "\t" + NL + "    wasSet = true;";
  protected final String TEXT_1959 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1960 = NL + "  bool equals(Object obj)" + NL + "  {" + NL + "    if (obj == NULL) { return false; }" + NL + "    if (getClass() != obj.getClass()) { return false; }" + NL;
  protected final String TEXT_1961 = NL + "    ";
  protected final String TEXT_1962 = " == (";
  protected final String TEXT_1963 = ")obj;" + NL + "  " + NL + "    return true;" + NL + "  }" + NL + "" + NL + " int hashCode()" + NL + "  {" + NL + "    if (cachedHashCode != -1)" + NL + "    {" + NL + "      return cachedHashCode;" + NL + "    }" + NL + "    cachedHashCode = 17;";
  protected final String TEXT_1964 = NL + "    ";
  protected final String TEXT_1965 = NL;
  protected final String TEXT_1966 = NL + "    ";
  protected final String TEXT_1967 = NL + "    return cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_1968 = NL + "   void ";
  protected final String TEXT_1969 = "::";
  protected final String TEXT_1970 = "()" + NL + "  {" + NL + "     try" + NL + "     {";
  protected final String TEXT_1971 = NL + "       ";
  protected final String TEXT_1972 = NL + "     }" + NL + "     catch (InterruptedException e)" + NL + "     {" + NL + " " + NL + "     }" + NL + "  }" + NL;
  protected final String TEXT_1973 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_1974 = NL + "    ";
  protected final String TEXT_1975 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_1976 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    public void run()" + NL + "    {";
  protected final String TEXT_1977 = NL + "      ";
  protected final String TEXT_1978 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1979 = NL + "  void ";
  protected final String TEXT_1980 = "();" + NL + "  void ";
  protected final String TEXT_1981 = "();" + NL + "  " + NL + NL;
  protected final String TEXT_1982 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_1983 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_1984 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    public void ";
  protected final String TEXT_1985 = "::stop()" + NL + "    {" + NL + "      timer.cancel();" + NL + "    }" + NL + "    " + NL + "    public void ";
  protected final String TEXT_1986 = "::run ()" + NL + "    {";
  protected final String TEXT_1987 = NL + "      if (\"";
  protected final String TEXT_1988 = "\" == timeoutMethodName)" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_1989 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1990 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1991 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1992 = NL + "  " + NL + "  //------------------------" + NL + "  // DESTRUCTOR" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_1993 = NL + "    ";
  protected final String TEXT_1994 = " = NULL;" + NL + "    delete ";
  protected final String TEXT_1995 = ";";
  protected final String TEXT_1996 = NL + "    ";
  protected final String TEXT_1997 = ".clear();";
  protected final String TEXT_1998 = NL + "    ";
  protected final String TEXT_1999 = " ";
  protected final String TEXT_2000 = " = ";
  protected final String TEXT_2001 = ";";
  protected final String TEXT_2002 = NL + "    ";
  protected final String TEXT_2003 = " = NULL;" + NL + "    if (";
  protected final String TEXT_2004 = " != NULL)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_2005 = ";" + NL + "    }";
  protected final String TEXT_2006 = NL + "    if (";
  protected final String TEXT_2007 = " != NULL)" + NL + "    {";
  protected final String TEXT_2008 = NL + "      ";
  protected final String TEXT_2009 = "->";
  protected final String TEXT_2010 = "(NULL);" + NL + "    }";
  protected final String TEXT_2011 = NL + "    ";
  protected final String TEXT_2012 = " ";
  protected final String TEXT_2013 = " = ";
  protected final String TEXT_2014 = ";";
  protected final String TEXT_2015 = NL + "    ";
  protected final String TEXT_2016 = " = NULL;" + NL + "    if (";
  protected final String TEXT_2017 = " != NULL)" + NL + "    {";
  protected final String TEXT_2018 = NL + "      ";
  protected final String TEXT_2019 = "->";
  protected final String TEXT_2020 = "(NULL);" + NL + "    }";
  protected final String TEXT_2021 = NL + "    ";
  protected final String TEXT_2022 = "* ";
  protected final String TEXT_2023 = " = ";
  protected final String TEXT_2024 = ";";
  protected final String TEXT_2025 = NL + "    ";
  protected final String TEXT_2026 = " = NULL;" + NL + "    if (";
  protected final String TEXT_2027 = " != NULL)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_2028 = ";" + NL + "    }";
  protected final String TEXT_2029 = NL + "    if (";
  protected final String TEXT_2030 = " != NULL)" + NL + "    {";
  protected final String TEXT_2031 = NL + "      ";
  protected final String TEXT_2032 = "* ";
  protected final String TEXT_2033 = " = ";
  protected final String TEXT_2034 = ";" + NL + "      this->";
  protected final String TEXT_2035 = " = NULL;";
  protected final String TEXT_2036 = NL + "      ";
  protected final String TEXT_2037 = "->";
  protected final String TEXT_2038 = "(this);" + NL + "    }" + NL;
  protected final String TEXT_2039 = NL + "    if (";
  protected final String TEXT_2040 = " != NULL)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_2041 = ";" + NL + "    }";
  protected final String TEXT_2042 = NL + "    if (";
  protected final String TEXT_2043 = " != NULL)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2044 = ".";
  protected final String TEXT_2045 = "() <= ";
  protected final String TEXT_2046 = ")" + NL + "      {" + NL + "        delete ";
  protected final String TEXT_2047 = ";" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2048 = NL + "        ";
  protected final String TEXT_2049 = "* ";
  protected final String TEXT_2050 = " = ";
  protected final String TEXT_2051 = ";" + NL + "        this.";
  protected final String TEXT_2052 = " = NULL;";
  protected final String TEXT_2053 = NL + "        ";
  protected final String TEXT_2054 = "->";
  protected final String TEXT_2055 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2056 = NL + "    ";
  protected final String TEXT_2057 = " ";
  protected final String TEXT_2058 = " = ";
  protected final String TEXT_2059 = ";" + NL + "    this->";
  protected final String TEXT_2060 = " = NULL;";
  protected final String TEXT_2061 = NL + "    ";
  protected final String TEXT_2062 = "->";
  protected final String TEXT_2063 = "(this);";
  protected final String TEXT_2064 = NL + "    for(i =0; sizeof(";
  protected final String TEXT_2065 = "); i++)" + NL + "    {";
  protected final String TEXT_2066 = NL + "      ";
  protected final String TEXT_2067 = "(";
  protected final String TEXT_2068 = "[i],NULL);" + NL + "    }";
  protected final String TEXT_2069 = NL + "    ";
  protected final String TEXT_2070 = ".clear();";
  protected final String TEXT_2071 = NL + "    vector<";
  protected final String TEXT_2072 = "*> ";
  protected final String TEXT_2073 = " = ";
  protected final String TEXT_2074 = ";";
  protected final String TEXT_2075 = NL + "    ";
  protected final String TEXT_2076 = ".clear();" + NL + "    for(i =0; sizeof(";
  protected final String TEXT_2077 = "); i++)" + NL + "     {" + NL + "      if (";
  protected final String TEXT_2078 = ".";
  protected final String TEXT_2079 = "() <= ";
  protected final String TEXT_2080 = "->";
  protected final String TEXT_2081 = "())" + NL + "      {" + NL + "        delete ";
  protected final String TEXT_2082 = "[i];" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2083 = NL + "        ";
  protected final String TEXT_2084 = "->";
  protected final String TEXT_2085 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2086 = NL + "    vector<";
  protected final String TEXT_2087 = "*> ";
  protected final String TEXT_2088 = " = ";
  protected final String TEXT_2089 = ";";
  protected final String TEXT_2090 = NL + "    ";
  protected final String TEXT_2091 = ".clear();" + NL + "    for(i=0;sizeof(";
  protected final String TEXT_2092 = ");i++)" + NL + "    {";
  protected final String TEXT_2093 = NL + "      ";
  protected final String TEXT_2094 = "[i]->";
  protected final String TEXT_2095 = "(this);" + NL + "    }";
  protected final String TEXT_2096 = NL + "    for(i =0; sizeof(";
  protected final String TEXT_2097 = "); i++)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_2098 = "[i];" + NL + "    }";
  protected final String TEXT_2099 = NL + "    for(i =0; sizeof(";
  protected final String TEXT_2100 = "); i++)" + NL + "    {";
  protected final String TEXT_2101 = NL + "      ";
  protected final String TEXT_2102 = "[i]->";
  protected final String TEXT_2103 = "(NULL);" + NL + "    }";
  protected final String TEXT_2104 = NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "   ";
  protected final String TEXT_2105 = NL + "  ";
  protected final String TEXT_2106 = NL + "  ";
  protected final String TEXT_2107 = NL;

  // Add a newline to the end of the input
  private void appendln(StringBuffer buffer, String input, Object... variables)
  {
    append(buffer, input + "\n", variables);
  }  

  // This method will be used to append formatted strings
  // i.e. format("Hello {0} {1}", "andrew","forward");
  private void append(StringBuffer buffer, String input, Object... variables)
  {
    buffer.append(StringFormatter.format(input,variables));
  }

  /* 
  * This method will return the generated code.
  */
  public String getCode(UmpleModel model, UmpleElement uElement)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
  UmpleClass uClass = (UmpleClass) uElement;  
  GeneratedClass gClass = uClass.getGeneratedClass();
  CppGenerator gen = new CppGenerator();
  gen.setModel(model);
  GeneratorHelper.generator = gen;
   
   String curlyBracket = (gen.translate("packageDefinition",uClass) == "")? "" : "}" ; 

  HashMap<String,String> codeInjectionMap = new HashMap<String,String>();
  for (CodeInjection inject : uClass.getCodeInjections())
  {
    String operation = StringFormatter.toUnderscore(inject.getOperation());
    String key = inject.getType() + ":" + operation;
    String newCodeToInject = "";
    String injectCode = inject.getConstraintTree()==null?inject.getCode():inject.getConstraintCode(gen);
    if (codeInjectionMap.containsKey(key))
    {
      newCodeToInject = StringFormatter.format("{0}\n    {1}",codeInjectionMap.get(key),injectCode);
    }
    else
    {
      newCodeToInject = injectCode;
    }
    codeInjectionMap.put(key,newCodeToInject);
  }

  boolean isFirst = true;


    stringBuffer.append(TEXT_2);
    
	appendln(stringBuffer, "");
	append(stringBuffer, "#include \"{0}.h\"",uClass.getName()); 
	if (uClass.hasAssociationVariables())
	for (AssociationVariable av : uClass.getAssociationVariables())
	{
	if ( uClass.getName() != av.getRelatedAssociation().getUmpleClass().getName())
	{
		appendln(stringBuffer, "");
		append(stringBuffer, "#include \"{0}.h\"",av.getRelatedAssociation().getUmpleClass().getName()); 
	}
	}
	
	if( model.getTraceType().equals("Lttng") && uClass.hasTraceDirectives() )
  {
	for (TraceDirective td : uClass.getTraceDirectives())
	    	{
	  for (AttributeTraceItem ati: td.getAttributeTraceItems())
	  {
		for (UmpleVariable att : ati.getUmpleVariables())
		{
		appendln(stringBuffer, "");
		append(stringBuffer, "#include \"{0}_tracepoint.h\";",att.getName());	
		}
	  }
	  }
  }  

    stringBuffer.append(TEXT_3);
     if (uClass.numberOfComments() > 0) { if (!uClass.getComments().get(0).getIsInline()) {append(stringBuffer, "\n{0}", Comment.format("Multiline",uClass.getComments()));} else {append(stringBuffer, "\n{0}", Comment.format("Slashes",uClass.getComments())); } } 
    stringBuffer.append(TEXT_4);
      if (uClass.getIsSingleton())
  {
    
    
appendln(stringBuffer, "  {0}* {0}::theInstance = NULL; //singleton;", uClass.getName());

    
  }
  
  
    stringBuffer.append(TEXT_5);
    
  boolean isOneToOne = false;
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssocation = av.getRelatedAssociation();
    if (av.isOnlyOne() && relatedAssocation.isOnlyOne() && av.getIsNavigable() && relatedAssocation.getIsNavigable())
    {
      isOneToOne = true;
      break;
    }
  }
  
    

  String customConstructorPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before","constructor"));
  String customConstructorPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after","constructor"));

  appendln(stringBuffer, "");

  String accessibility = uClass.getIsSingleton() ? "" : "";
  append(stringBuffer," {0}::{0}({1})",new Object[] {uClass.getName(), gClass.getLookup("constructorSignature")});

  String extraNote = null;
  
  appendln(stringBuffer, "");
  
  boolean hasBody = false;

  append(stringBuffer, "  {");
  if (!uClass.isRoot() && !"interface".equals(uClass.getExtendsClass().getModifier()))
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    {1}({0});", gClass.getParentClass().getLookup("constructorSignature_caller"),uClass.getName());
    hasBody = true;
  }
  
  if (customConstructorPrefixCode != null)
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customConstructorPrefixCode, "    "));
    hasBody = true;
  }
  
  if (uClass.getKey().isProvided())
  {
    hasBody = true;
    appendln(stringBuffer, "");
    append(stringBuffer, "    cachedHashCode = -1;");
  }
  
  for(String memberId : uClass.getKey().getMembers())
  {
    Attribute av = uClass.getAttribute(memberId);
    AssociationVariable as = uClass.getAssociationVariable(memberId);
    if (av != null && !av.isImmutable())
    {
      hasBody = true;
      appendln(stringBuffer, "");
      append(stringBuffer, "    {0} = true;", gen.translate("attributeCanSet",av));
    }
    else if (as != null)
    {
      hasBody = true;
      appendln(stringBuffer, "");
      append(stringBuffer, "    {0} = true;", gen.translate("associationCanSet",as));
    }
  }   

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique() || av.isConstant() || "theInstance".equals(gen.translate("attributeOne",av)) || av.getIsDerived())
    {
      continue;
    }
    
    if (av.getIsList())
    {
      hasBody = true;
      
    boolean hasAvMany = false;
		for (AssociationVariable av2 : uClass.getAssociationVariables())
		{
			if ( av2.isMany())
			{
				hasAvMany = true;
			}			
		}
		String cDec = (hasAvMany)? "" : "int";
		
    stringBuffer.append(TEXT_6);
    
    }
    else if ("defaulted".equals(av.getModifier()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_7);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_8);
     
    }
    else if (av.isImmutable() && av.getIsLazy())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_10);
    
    }
    else if (av.isImmutable())
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null || av.getModifier().equals("fixml") ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_11);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_15);
     
    }
    else
    {
      hasBody = true;
      if(!av.getIsLazy()){
         
    
  String parameterLookup = av.getValue() == null || av.getModifier().equals("fixml") ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_16);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_18);
    
      }
      else
      {
         
    
  String parameterLookup = null; // av.getValue() == null || av.getModifier().equals("fixml") ? "parameterOne" : "parameterValue";
  String defaultValue = null;
  
 
  if(av.getValue() == null)
  {
     // Try to assign a null value or 0 value if we recognize
     // one of Umple's built in data types. (http://cruise.site.uottawa.ca/umple/UmpleBuiltinDataTypes.html)

     if(av.getType().equals("String") || av.getType().equals("Date") || av.getType().equals("Time"))
     {
  	   defaultValue = "NULL";
     }
     else if(av.getType().equals("Double") || av.getType().equals("Integer"))
     {
       defaultValue = "0";
     }
     else if(av.getType().equals("Float"))
     {
  	   defaultValue = "0.0f";
     }
     else if(av.getType().equals("Boolean"))
     {
  	   defaultValue = "false";
     }
   else
   {
       defaultValue = gen.translate("parameterValue",av);
   }
  }
  // Only assign a value if we could find a default
  if(defaultValue != null)
  { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_21);
    } 
    
      }
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_22);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_24);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables())
  {
  	if (!av.getIsNavigable() || !av.isImmutable())
  	{
  	  continue;
  	}
    append(stringBuffer, "\n    {0} = true;", gen.translate("associationCanSet",av));
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (!av.getIsNavigable())
    {
      continue;
    }
    
    if (!relatedAssociation.getIsNavigable())
    {
      if (av.isOnlyOne())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_29);
    
      }
      else if (av.isOptionalOne() && av.isImmutable())
      {
        hasBody = true;
        
       
    append(stringBuffer, "\n    {0}({1});", gen.translate("setMethod",av), gen.translate("parameterOne",av));

    
      }
      else if (av.isMandatoryMany())
      {
        hasBody = true;
        
    
  String requiredNumber = "";
  if (av.isN())
  {
    requiredNumber += av.getMultiplicity().getLowerBound();
  }
  else if (av.isStar())
  {
    requiredNumber = StringFormatter.format("at least {0}", av.getMultiplicity().getLowerBound());
  }
  else
  {
    requiredNumber = StringFormatter.format("{0} to {1}", av.getMultiplicity().getLowerBound(), av.getMultiplicity().getUpperBound());
  }
  

    stringBuffer.append(TEXT_30);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_37);
    
      }
      else if (av.isOptionalN() && av.isImmutable())
      {
        hasBody = true;
        
     String requiredNumber = StringFormatter.format("{0}", av.getMultiplicity().getUpperBound()); 
    stringBuffer.append(TEXT_38);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_45);
    
      }
      else if (av.isMany() && av.isImmutable())
      {
      	hasBody = true;
        
    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_52);
    
      }
      else if (av.isMany())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_53);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_62);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_63);
    
    }
    else
    {
      
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  if (av.isOnlyOne())
  {
    
    stringBuffer.append(TEXT_64);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_70);
    
  }
  else if (av.isOptionalMany())
  {
    
  }
  else if (av.isMandatoryMany())
  {
    
    
  String requiredNumber = "";
  if (av.isN())
  {
    requiredNumber += av.getMultiplicity().getLowerBound();
  }
  else if (av.isStar())
  {
    requiredNumber = StringFormatter.format("at least {0}", av.getMultiplicity().getLowerBound());
  }
  else
  {
    requiredNumber = StringFormatter.format("{0} to {1}", av.getMultiplicity().getLowerBound(), av.getMultiplicity().getUpperBound());
  }
  

    stringBuffer.append(TEXT_71);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_78);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_80);
    
  }
  else
  {
    continue;
  }
  hasBody = true;

    
    }
  }
  
  for(StateMachine sm : uClass.getStateMachines())
  {
    State state = sm.getStartState();
    if (state == null)
    {
      continue;
    }
    hasBody = true;
    for (StateMachine nestedSm : sm.getNestedStateMachines())
    {
      
    stringBuffer.append(TEXT_81);
    stringBuffer.append(gen.translate("stateMachineOne",nestedSm));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(gen.translate("setMethod",nestedSm));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_84);
    
    }
    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_87);
    
  }
  
  if (customConstructorPostfixCode != null)
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customConstructorPostfixCode, "    "));
    hasBody = true;
  }

  if (hasBody)
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "  }");
  }
  else
  {
    append(stringBuffer, "}");
  }

  if (uClass.getIsSingleton())
  {
    appendln(stringBuffer, "");
    
    stringBuffer.append(TEXT_88);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_91);
    
  }

    
  if (isOneToOne)
  {
    
    
  
  String signature = gClass.getLookup("constructorSignature_mandatory");
  hasBody = false;

    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_96);
    
  if (!uClass.isRoot())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    {3}::{0}({1});", gClass.getParentClass().getLookup("constructorSignature_caller"),gClass.getParentClass().getClass().getName(),uClass.getName());
    hasBody = true;
  }
  
  if (customConstructorPrefixCode != null) 
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customConstructorPrefixCode, "    "));
    hasBody = true;
  }
  
  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique() || av.isConstant() || "theInstance".equals(gen.translate("attributeOne",av)))
    {
      continue;
    }
  
    if (av.getIsList())
    {
      hasBody = true;
      
    boolean hasAvMany = false;
		for (AssociationVariable av2 : uClass.getAssociationVariables())
		{
			if ( av2.isMany())
			{
				hasAvMany = true;
			}			
		}
		String cDec = (hasAvMany)? "" : "int";
		
    stringBuffer.append(TEXT_97);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_98);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_99);
     
    }
    else
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null || av.getModifier().equals("fixml") ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_100);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_102);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_103);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_105);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_106);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_107);
    
    }
    else
    {
      hasBody = true;
      
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  if (av.isOnlyOne())
  {
    
    stringBuffer.append(TEXT_108);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_114);
    
  }
  else if (av.isOptionalMany())
  {
    
  }
  else if (av.isMandatoryMany())
  {
    
    
  String requiredNumber = "";
  if (av.isN())
  {
    requiredNumber += av.getMultiplicity().getLowerBound();
  }
  else if (av.isStar())
  {
    requiredNumber = StringFormatter.format("at least {0}", av.getMultiplicity().getLowerBound());
  }
  else
  {
    requiredNumber = StringFormatter.format("{0} to {1}", av.getMultiplicity().getLowerBound(), av.getMultiplicity().getUpperBound());
  }
  

    stringBuffer.append(TEXT_115);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_122);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_124);
    
  }
  else
  {
    continue;
  }
  hasBody = true;

    
    }
  }
  
  if (customConstructorPostfixCode != null) 
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customConstructorPostfixCode, "    "));
    hasBody = true;
  }
  
  if (hasBody)
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "  }");
  }
  else
  {
    append(stringBuffer, "}");
  }
    // fxml attribute (create empty constructor)
  for (Attribute av : uClass.getAttributes())
  {
	  if ("fixml".equals(av.getModifier()))
	  {
		  accessibility = uClass.getIsSingleton() ? "private" : "public";
		  appendln(stringBuffer,"");
		  appendln(stringBuffer,"");
		  appendln(stringBuffer,"  {0} {1}()",new Object[] {accessibility, uClass.getName()});
		  appendln(stringBuffer,"  {");
		  for (Attribute a : uClass.getAttributes())
		  {
			  if ("fixml".equals(a.getModifier()) && a.getValue() != null )
				  append(stringBuffer, "    {0} = {1};\n", a.getName(),a.getValue());
		  }
		  for( CodeInjection ci  : uClass.getCodeInjections())
		  {
			  if( ci.getOperation().equals("emptyConstructor"))
			  {
				  appendln(stringBuffer,"    {0}",ci.getCode());
			  }
		  }
		  appendln(stringBuffer,"  }");
		  break;
	  }
  }
  

    
  }


    stringBuffer.append(TEXT_125);
     if (uClass.getAttributes() != null)
	{
		
  		
    
  
  appendln(stringBuffer, "");
  appendln(stringBuffer, "  //------------------------");
  appendln(stringBuffer, "  // COPY CONSTRUCTOR");
  appendln(stringBuffer, "  //------------------------");
  appendln(stringBuffer, "");
  append(stringBuffer," {0}::{0}(const {0} & {1})",new Object[] {uClass.getName(),uClass.getName().toLowerCase()});

  appendln(stringBuffer, "");
  append(stringBuffer, "  {");
  for (Attribute av : uClass.getAttributes())
  {
  	 appendln(stringBuffer, "");
     append(stringBuffer, "    this->{0} = {1}.{0};",av.getName(),uClass.getName().toLowerCase());  
  }
  
  if(uClass.hasAttributes())
  {
  	appendln(stringBuffer, "");
  	append(stringBuffer, "  }");
  }
  else
  {
    append(stringBuffer, "  }");
  }
  


    
  	}
    stringBuffer.append(TEXT_126);
     if (uClass.getAttributes() != null)
	{
		
  		
    
  
  appendln(stringBuffer, "");
  appendln(stringBuffer, "  //------------------------");
  appendln(stringBuffer, "  // Operator =");
  appendln(stringBuffer, "  //------------------------");
  appendln(stringBuffer, "");
  appendln(stringBuffer," {0} {0}::operator=(const {0} & {1})",new Object[] {uClass.getName(),uClass.getName().toLowerCase()});
  append(stringBuffer, "  {");
  for (Attribute av : uClass.getAttributes())
  {
  	 appendln(stringBuffer, "");
  	 append(stringBuffer, "    this->{0} = {1}.{0};",av.getName(),uClass.getName().toLowerCase());  
  }
  if(uClass.hasAttributes())
  {
  	appendln(stringBuffer, "");
  	append(stringBuffer, "  }");
  }
  else
  {
    append(stringBuffer, "  }");
  }
  


    
  	}
    stringBuffer.append(TEXT_127);
    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (Attribute av : uClass.getAttributes())
  {
    if (av.isConstant() || av.getIsAutounique() || "internal".equals(av.getModifier()) || av.getIsDerived())
    {
      continue;
    }

    gen.setParameterConstraintName(av.getName());    
    
    List<TraceItem> traceItems = av.getTraced("setMethod", uClass);
    

    String customSetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("setMethod",av)));
    String customSetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("setMethod",av)));

    String customResetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("resetMethod",av)));
    String customResetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("resetMethod",av)));

    String customAddPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("addMethod",av)));
    String customAddPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("addMethod",av)));
  
    String customRemovePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("removeMethod",av)));
    String customRemovePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("removeMethod",av)));
    
    if (av.isImmutable())
    {
      if (av.getIsLazy())
      {
        
    stringBuffer.append(TEXT_128);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_132);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_133);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_137);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_138);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_143);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_144);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_146);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_147);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_149);
     if (customResetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_150);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_152);
     if (customResetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_153);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_158);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_159);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_161);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_162);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_166);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_167);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_169);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_170);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_171);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_172);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_175);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_176);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_178);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_179);
    
    }
  }

  if(uClass.getExtendsClass()!=null)
  {
    for(Attribute av:uClass.getExtendsClass().getAttributes())
    {
      if (av.isConstant() || av.getIsAutounique() || "internal".equals(av.getModifier()) || av.getIsDerived())
      {
        continue;
      }

      List<TraceItem> traceItems = av.getTraced("setMethod", uClass);

      gen.setParameterConstraintName(av.getName());

      String customSetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("setMethod",av)));
      String customSetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("setMethod",av)));

//      String customResetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("resetMethod",av)));
//      String customResetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("resetMethod",av)));
      
      String customAddPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("addMethod",av)));
      String customAddPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("addMethod",av)));

//      String customRemovePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("removeMethod",av)));
//      String customRemovePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("removeMethod",av)));

      if(customSetPrefixCode!=null||customSetPostfixCode!=null)
      {
        if (av.getModifier().equals("defaulted"))
        {
          
    stringBuffer.append(TEXT_180);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_181);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_184);
     if (customSetPrefixCode != null) { 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_187);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
     if (customSetPostfixCode != null) { 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_188);
    
        }
        else if (av.getIsList())
        {
          
    stringBuffer.append(TEXT_189);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_190);
    stringBuffer.append( gen.translate("addMethod",av) );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_193);
     if (customAddPrefixCode != null) {
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_a", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_196);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_a", uClass):""));
     if (customAddPostfixCode != null) {
      append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customAddPostfixCode, "    "));
    } 
    stringBuffer.append(TEXT_197);
    
        }
        else if(!av.isImmutable()||av.getIsLazy())//if(customSetPrefixCode!=null&&customSetPostfixCode!=null&&customSetPrefixCode.matches("[\\s]*if.*\\n[\\s]*.*"))
        {
          
    stringBuffer.append(TEXT_198);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_199);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_202);
     if (customSetPrefixCode != null) {
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_203);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_205);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
     if (customSetPostfixCode != null) {
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_206);
    
        }
      }    
    }
  }
  gen.setParameterConstraintName("");

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (Attribute av : uClass.getAttributes()) 
  {
    if (av.getIsAutounique() || av.isConstant() || "internal".equals(av.getModifier()))
    {
      continue;
    }
    
    gen.setParameterConstraintName(av.getName());

    List<TraceItem> traceItems = av.getTraced("getMethod", uClass);
    
    String customGetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getMethod",av)));
    String customGetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getMethod",av)));

    String customGetDefaultPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getDefaultMethod",av)));
    String customGetDefaultPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getDefaultMethod",av)));

    String customGetManyPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getManyMethod",av)));
    String customGetManyPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getManyMethod",av)));

    String customNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("numberOfMethod",av)));
    String customNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("numberOfMethod",av)));

    String customHasManyPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("hasManyMethod",av)));
    String customHasManyPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("hasManyMethod",av)));

    String customIndexOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("indexOfMethod",av)));
    String customIndexOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("indexOfMethod",av)));
        
    String customHasUniquePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("hasUniqueMethod",av)));
    String customHasUniquePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("hasUniqueMethod",av)));
    
    String customGetUniquePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getUniqueMethod",av)));
    String customGetUniquePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getUniqueMethod",av)));

    if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_207);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_210);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_211);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_214);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_215);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_220);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_221);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_226);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_227);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_230);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_231);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_232);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_233);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_235);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_236);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_237);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_238);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_242);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_243);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_244);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_246);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_247);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_248);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_249);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_251);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_252);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_253);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_254);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_255);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_256);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_257);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_258);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_259);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_261);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_262);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_263);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_264);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_265);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_266);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_267);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_268);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_269);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_271);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_272);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_273);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_274);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_276);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_277);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_278);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_279);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_280);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_283);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_284);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_286);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_287);
     if (customGetDefaultPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_288);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_289);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_293);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_294);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_295);
    
      }
      
      if (av.getIsUnique())
      {
        if (customGetUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_296);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_297);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_300);
     if (customGetUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_301);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_302);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(gen.translate("uniqueMap",av));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_305);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_306);
     if (customGetUniquePostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetUniquePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_308);
    
        } 
        else 
        {
          
    stringBuffer.append(TEXT_309);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_310);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_312);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_313);
     if (customGetUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(gen.translate("uniqueMap",av));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_316);
    
        }
        if (customHasUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_317);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_320);
     if (customHasUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_321);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_324);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_325);
     if (customHasUniquePostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customHasUniquePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_326);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_327);
    
        }
        else
        {
          
    stringBuffer.append(TEXT_328);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_331);
     if (customHasUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_334);
    
        }
      }
    }
  }

  for (Attribute av : uClass.getAttributes()) 
  {
  
    if (av.getIsAutounique())
    {
      String customGetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getMethod",av)));
      String customGetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getMethod",av)));
      
      List<TraceItem> traceItems = av.getTraced("getMethod", uClass);
      
      if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_335);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_337);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_338);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_339);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_340);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_342);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_343);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_344);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_345);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_347);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_348);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_349);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_350);
    
      }
      appendln(stringBuffer, "");
    }
  }
  gen.setParameterConstraintName("");

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    
    
  StringBuilder output = new StringBuilder(); 
  List<StateMachine> allParents = new ArrayList<StateMachine>();
  allParents.add(sm);
  while (allParents.size() > 0) 
  {
    StateMachine parentSm = allParents.get(0);
    allParents.remove(0);
    for (StateMachine childSm : parentSm.getNestedStateMachines()) 
    {
      output.append(StringFormatter.format("\n    if ({0} != Null) { answer += \".\" + {2}({0}); }",gen.translate("stateMachineOne",childSm),gen.translate("type",childSm),gen.translate("getStringMethod",childSm)));
      allParents.addAll(childSm.getNestedStateMachines());
    }     
  }
  String outputAsString = output.toString();

    stringBuffer.append(TEXT_351);
    stringBuffer.append(gen.translate("typeFull",sm));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(gen.translate("getFullMethod",sm));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(gen.translate("getStringMethod",sm));
    stringBuffer.append(TEXT_355);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_356);
     if (outputAsString.length() > 0) { append(stringBuffer, "{0}",outputAsString); } 
    stringBuffer.append(TEXT_357);
     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    stringBuffer.append(TEXT_358);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_359);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_362);
    
  appendln(stringBuffer,"");
  appendln(stringBuffer,"  {");
  appendln(stringBuffer,"    return {0};", gen.translate("stateOne",sm));
  appendln(stringBuffer,"  }");
  appendln(stringBuffer,"");
  
     int i=0;
   appendln(stringBuffer,"  string {3}::{0} ({1} {2})",gen.translate("getStringMethod",sm),gen.translate("type",sm),gen.translate("stateMachineOne", sm),uClass.getName());
	appendln(stringBuffer,"  {");
	appendln(stringBuffer,"    switch ({0})  {",gen.translate("stateMachineOne", sm));
	if (!sm.getStates().equals(null))
	{
		for (State state : sm.getStates())
		{
			appendln(stringBuffer,"      case {1} : {return \"{0}\"; break;}", gen.translate("stateOne",state),i++);
		}
		appendln(stringBuffer,"      default: {return \"\"; break;}");
		appendln(stringBuffer,"    }");
		appendln(stringBuffer,"  }");
    }

    

    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for(Event e : uClass.getEvents())
  {
    
    
  StringBuffer allCases = new StringBuffer();

  for(StateMachine sm : uClass.getStateMachines(e))
  {
    allCases.append(StringFormatter.format("    switch ({0})\n",gen.translate("stateMachineOne",sm)));
    allCases.append(StringFormatter.format("    {\n"));
    
    for(State state : sm.getStates())
    {
  
      List<Transition> allT = state.getTransitionsFor(e);
  
      if (allT.size() == 0)
      {
        continue;
      }

      allCases.append(StringFormatter.format("      case {0}:\n",gen.translate("stateOne",state)));

      boolean hasExitAction = false;
      for(Action action : state.getActions())
      {
        if ("exit".equals(action.getActionType()))
        {
          hasExitAction = true;
          break;
        }
      }
  
      boolean needsBreak = true;
      for (Transition t : allT)
      {
        State nextState = t.getNextState();
        String tabSpace = t.getGuard() == null ? "        " : "          ";
        
        String condition = t.getGuard()!=null?gen.translate("Open",t.getGuard()):"if ()\n{";
        if (!"if ()\n{".equals(condition))
        {
          allCases.append(GeneratorHelper.doIndent(condition, "        ")+"\n");
        }
        if (hasExitAction)
        {
          allCases.append(StringFormatter.format("{0}{1}();\n",tabSpace,gen.translate("exitMethod",sm)));
        }
        if (t.getAction() != null)
        {
          Action a1= t.getAction();
          allCases.append(StringFormatter.format("{0}{1}\n",tabSpace,a1.getActionCode()));
        }

        allCases.append(StringFormatter.format("{0}{1}({3});\n",tabSpace,gen.translate("setMethod",nextState.getStateMachine()),gen.translate("type",nextState.getStateMachine()),gen.translate("stateOne",nextState)));
        allCases.append(StringFormatter.format("{0}wasEventProcessed = true;\n",tabSpace));
        allCases.append(StringFormatter.format("{0}break;\n",tabSpace));

        if (!"if ()\n{".equals(condition))
        {
          allCases.append(StringFormatter.format("        }\n"));
        }
        else
        {
          needsBreak = false;
          //You can only have one *no guard case*
          break;
        }
      }
  
      if (needsBreak)
      {
        allCases.append(StringFormatter.format("        break;\n"));
      }
    } 
    allCases.append(StringFormatter.format("    }\n\n"));
  }
  
  String scope = e.getIsInternal() || e.isAutoTransition() ? "" : "";
  String outputCases = allCases.toString().trim();

    stringBuffer.append(TEXT_363);
    stringBuffer.append(scope);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_366);
    stringBuffer.append( (e.getArgs()==null?"":e.getArgs()));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(TEXT_368);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_369);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (StateMachine sm : uClass.getAllStateMachines())  
  {

    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    
  StringBuffer allExitCases = new StringBuffer();
  StringBuffer allEnterCases = new StringBuffer();
  
  for(State s : sm.getStates())
  {
    boolean hasThisExit = false;
    boolean hasThisEntry = false;

    for(Action a : s.getActions())
    {
      if ("exit".equals(a.getActionType()))
      {
        if(!hasThisExit)
        {
          allExitCases.append(StringFormatter.format("    if ({0} == {1}.{2} && {3} != {1}.{2} )\n    {"
            , gen.translate("stateMachineOne",sm)
            , gen.translate("type",sm)
            , gen.translate("stateOne",s)
            , gen.translate("parameterOne",sm)
          ));
        }
        hasThisExit = true;
        allExitCases.append("\n      " + a.getActionCode());
      }
      else if ("entry".equals(a.getActionType()))
      {
        if (!hasThisEntry)
        { 
          allEnterCases.append(StringFormatter.format("    if ({0} != {1}.{2} && {3} == {1}.{2} )\n    {"
            , gen.translate("stateMachineOne",sm)
            , gen.translate("type",sm)
            , gen.translate("stateOne",s)
            , gen.translate("parameterOne",sm)
          ));
        }
        hasThisEntry = true;
        allEnterCases.append("\n      " + a.getActionCode());
      }
    }
    if (s.getHasExitAction()){
     allExitCases.append("\n    }\n");
    }
    if (s.getHasEntryAction()){
     allEnterCases.append("\n    }\n");
    }
  }
  
  String exitCasesOutput = allExitCases.toString().trim();
  String enterCasesOutput = allEnterCases.toString().trim();

    stringBuffer.append(TEXT_370);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_371);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_372);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_373);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_374);
     if (!exitCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",exitCasesOutput); } 
     if (!enterCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",enterCasesOutput); } 
    stringBuffer.append(TEXT_375);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_376);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_377);
    
    }
    else if (sm.numberOfStates() > 0)
    {
      
    
  boolean hasEntry = false;
  boolean hasExit = false;
  boolean isFirstEntry = true;
  boolean isFirstExit = true;
  State parentState = sm.getParentState();
  StateMachine parentSm = parentState != null ? parentState.getStateMachine() : null;
  String customSetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("setMethod",sm)));
  String customSetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("setMethod",sm)));
  String customExitPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("exitMethod",sm)));
  String customExitPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("exitMethod",sm)));
  
  StringBuilder entryActions = new StringBuilder();
  StringBuilder exitActions = new StringBuilder();
  StringBuilder traceRecords = new StringBuilder();
  
  for(State state : sm.getStates())
  {
    boolean hasThisEntry = false;
    boolean hasThisExit = false;
    
    for(Action action : state.getActions())
    {
      if ("entry".equals(action.getActionType()))
      {
        if (!hasThisEntry)
        {
          if (!isFirstEntry)
          {
            entryActions.append("\n      ");
          }
          entryActions.append(StringFormatter.format("case {0}:",gen.translate("stateOne",state)));
          for( TraceDirective tc : uClass.getTraceDirectives() )
      	  {
      		for( int i = 0 ; i < tc.numberOfStateMachineTraceItems() ; ++ i )
      		{
      		  StateMachineTraceItem tracedState = tc.getStateMachineTraceItem(i);
      		  StateMachine stm = tracedState.getStateMachine();
      		  if( tracedState.getEntry() )
      		    for( int j = 0 ; j < stm.numberOfStates() ; ++j )
      		    {
      		  	  State stat = stm.getState(j);
      			  //if( stat.getName().equals(gen.translate("stateOne",state)) )
          			//if( model.getTraceType().equals("Console"))
      					//entryActions.append(StringFormatter.format( "\n        " + "System.out.println(\"Tracing state {0} entry action(s)\");",gen.translate("stateOne",state)));
       				//else if( model.getTraceType().equals("File"))
       					//entryActions.append(StringFormatter.format( "\n        " + "fileTracer(\"Tracing state {0} entry action(s)\");",gen.translate("stateOne",state))); 
       		    }
      		}
      	  }
        }
        hasEntry = true;
        hasThisEntry = true;
        isFirstEntry = false;
        entryActions.append("\n        " + action.getActionCode());
      }
      else if ("exit".equals(action.getActionType()))
      {
        if (!hasThisExit)
        {
          if (!isFirstExit)
          {
            exitActions.append("\n      ");
          }
          isFirstExit = false;
          exitActions.append(StringFormatter.format("case {0}:",gen.translate("stateOne",state)));
          for( TraceDirective tc : uClass.getTraceDirectives() )
      	  {
      		for( int i = 0 ; i < tc.numberOfStateMachineTraceItems() ; ++ i )
      		{
      		  StateMachineTraceItem tracedState = tc.getStateMachineTraceItem(i);
      		  StateMachine stm = tracedState.getStateMachine();
      		  if( tracedState.getExit() )
      		    for( int j = 0 ; j < stm.numberOfStates() ; ++j )
      		    {
      		  	  State stat = stm.getState(j);
      			  //if( stat.getName().equals(gen.translate("stateOne",state)) )
          			//if( model.getTraceType().equals("Console"))
          				//exitActions.append(StringFormatter.format( "\n        " + "System.out.println(\"Tracing state {0} exit action(s)\");",gen.translate("stateOne",state)));
       				//else if( model.getTraceType().equals("File"))
       					//exitActions.append(StringFormatter.format( "\n        " + "fileTracer(\"Tracing state {0} exit action(s)\");",gen.translate("stateOne",state))); 
       		    }
      		 }
      	   }
        }
        hasExit = true;
        hasThisExit = true;
        isFirstExit = false;
        exitActions.append("\n        " + action.getActionCode());
      }
    }
  
    for( TraceDirective tc : uClass.getTraceDirectives() )
	  {
  	  TraceRecord traceRecord = tc.getTraceRecord();
	    for( int i = 0 ; i < tc.numberOfStateMachineTraceItems() ; ++ i )
	    {
	      StateMachineTraceItem tracedState = tc.getStateMachineTraceItem(i);
	      StateMachine stm = tracedState.getStateMachine();
//		    if( traceRecord != null )
//		    {
//		      for( int j = 0 ; j < stm.numberOfStates() ; ++j )
//		      {
//		  	    State stat = stm.getState(j);
//
//		  	    if( stat == state )
//		  	    {
//		  	      traceRecords.append("\n    ");
//  		        traceRecords.append("if( " + gen.translate("parameterOne",stm) + ".equals(" + gen.translate("type",stm) + "." + stat.getName() + ") )");
//  		        traceRecords.append("\n      ");
//    		      if( model.getTraceType().equals("Console"))
//    		      {
//    		        traceRecords.append(StringFormatter.format("System.out.println(\"action={0}-entry, {1}=\" + {2});",stat.getName(),traceRecord.getRecord(),traceRecord.getRecord()));
// 			        }
// 			        else if( model.getTraceType().equals("File"))
//      		    {
//      		      traceRecords.append(StringFormatter.format("fileTracer(\"action={0}-entry, {1}=\" + {2});",stat.getName(),traceRecord.getRecord(),traceRecord.getRecord()));
//      		    }
//		  	    }
// 		      }
//		    }
	    }
    }	
    for (Activity activity : state.getActivities())
    {
      if (!hasThisEntry)
      {
        if (!isFirstEntry)
        {
          entryActions.append("\n      ");
        }
        entryActions.append(StringFormatter.format("case {0}:",gen.translate("stateOne",state)));
      }
      hasEntry = true;
      hasThisEntry = true;
      isFirstEntry = false;
      entryActions.append(StringFormatter.format("\n        {1} = new DoActivityThread(this,\"{0}\");",gen.translate("doActivityMethod",activity),gen.translate("doActivityThread",activity)));
    }
    
    if (hasThisEntry)
    {
      entryActions.append("\n        break;");
    }
    
    if (hasThisExit)
    {
      exitActions.append("\n        break;");
    }
  }

     if (hasExit) { 
    stringBuffer.append(TEXT_378);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_380);
     if (customExitPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_381);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(TEXT_383);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_384);
     if (customExitPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_385);
     } 
    stringBuffer.append(TEXT_386);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_388);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_389);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_390);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_391);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_392);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_393);
     if (parentState != null) { 
    stringBuffer.append(TEXT_394);
    stringBuffer.append( gen.translate("stateMachineOne",parentSm) );
    stringBuffer.append(TEXT_395);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_396);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_397);
    stringBuffer.append( gen.translate("stateNull",sm) );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(gen.translate("setMethod",parentSm));
    stringBuffer.append(TEXT_399);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_400);
     } 
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
     if (hasEntry) { 
    stringBuffer.append(TEXT_401);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(TEXT_403);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_404);
    stringBuffer.append( traceRecords );
     } 
    stringBuffer.append(TEXT_405);
    
    }
  }
}

    
    return getAssociationCode(stringBuffer,model, gen,uClass,gClass,false);
  }
  public String getAssociationCode(StringBuffer stringBuffer, UmpleModel model, CppGenerator gen, UmpleClass uClass, GeneratedClass gClass, boolean isFirst)
  {
  
    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {

    if (!av.getIsNavigable())
    {
      continue;
    }

    gen.setParameterConstraintName(av.getName());

    List<TraceItem> traceItems = av.getTraced("getMethod", uClass);

    String customGetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getMethod",av)));
    String customGetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getMethod",av)));

    String customGetDefaultPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getDefaultMethod",av)));
    String customGetDefaultPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getDefaultMethod",av)));

    String customGetManyPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getManyMethod",av)));
    String customGetManyPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getManyMethod",av)));

    String customNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("numberOfMethod",av)));
    String customNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("numberOfMethod",av)));

    String customHasManyPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("hasManyMethod",av)));
    String customHasManyPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("hasManyMethod",av)));

    String customIndexOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("indexOfMethod",av)));
    String customIndexOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("indexOfMethod",av)));

    boolean hasCodeInjections = customGetPrefixCode != null || customGetPostfixCode != null;
  
    if (av.isOne())
    {
      
    stringBuffer.append(TEXT_406);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_409);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append(TEXT_410);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_411);
     } else { 
    stringBuffer.append(TEXT_412);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_415);
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); 
    stringBuffer.append(TEXT_416);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_417);
     } 
    stringBuffer.append(TEXT_418);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_421);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_422);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_426);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_427);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_431);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_432);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_435);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_436);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_438);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_439);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_440);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_441);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_442);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_443);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_444);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_445);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_446);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_447);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_451);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_452);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_453);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_454);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_456);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_457);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_458);
    
    }
 }
 gen.setParameterConstraintName("");

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  
  boolean sortMethodAdded = false; //To ensure that only one sort method is created per class
  for (AssociationVariable av : uClass.getAssociationVariables())
  {
  
    gen.setParameterConstraintName(av.getName());

    AssociationVariable relatedAssociation = av.getRelatedAssociation();

    if (!av.getIsNavigable())
    {
      continue;
    } 
    
    //TraceItem traceItem = av.getTraced("associationAdd", uClass);
    List<TraceItem> traceItemAssocAdds = av.getTraced("associationAdd", uClass);
    List<TraceItem> traceItemAssocRemoves = av.getTraced("associationRemove", uClass);

    String customSetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("setMethod",av)));
    String customSetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("setMethod",av)));

    String customSetManyPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("setManyMethod",av)));
    String customSetManyPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("setManyMethod",av)));

    String customAddPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("addMethod",av)));
    String customAddPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("addMethod",av)));
  
    String customRemovePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("removeMethod",av)));
    String customRemovePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("removeMethod",av)));

    String customIsNumberOfValidPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("isNumberOfValidMethod",av)));
    String customIsNumberOfValidPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("isNumberOfValidMethod",av)));
    
    String includeFileOne = null;
    String includeFileTwo = null;
    
    boolean hasIsNumberOfValidMethod = false;
    boolean hasAddManyToManyTemplateMethod = false;
    boolean hasMaximumNumberOfMethod = av.isMany() && !av.isStar();
    boolean hasMinimumNumberOfMethod = av.isMany();
    boolean hasRequiredNumberOfMethod = av.isN();
    boolean hasRemoveManyTemplateMethod = false;
    String includeFile = null;
    String includeFile2 = null;
  String includeFile3 = null;

    if (!relatedAssociation.getIsNavigable())
    {
      if (av.isOptionalOne())
      {
        includeFile = "association_SetUnidirectionalOptionalOne.jet";
      }
      else if (av.isOnlyOne())
      {
        includeFile = "association_SetUnidirectionalOne.jet";
      }
      else if (av.isMStar())
      {
        if (!av.isImmutable())
        {
          includeFile = "association_AddUnidirectionalMStar.jet";
        }
        includeFile2 = "association_SetUnidirectionalMStar.jet";
      }
      else if (av.isMN())
      {
        if (!av.isImmutable())
        {
          includeFile = "association_AddUnidirectionalMN.jet";
        }
        includeFile2 = "association_SetUnidirectionalMN.jet";
      }
      else if (av.isN())
      {
        includeFile = "association_SetUnidirectionalN.jet";
      }
      else if (av.isOptionalN())
      {
        if (!av.isImmutable())
        {
          includeFile = "association_AddUnidirectionalOptionalN.jet";
        }
        includeFile2 = "association_SetUnidirectionalOptionalN.jet";
      }
      else if (av.isImmutable() && av.isMany())
      {
        includeFile = "association_SetUnidirectionalMany.jet";
      }
      else if (av.isMany())
      {
        includeFile = "association_AddUnidirectionalMany.jet";
      }
    }
    else if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      //ignore
    }  
    else if (av.isN() && relatedAssociation.isOptionalOne())
    { 
      includeFile = "association_SetNToOptionalOne.jet";
    }
    else if (av.isMN() && relatedAssociation.isOptionalOne())
    {
      includeFile = "association_AddMNToOptionalOne.jet";
      includeFile2 = "association_SetMNToOptionalOne.jet";
    }
    else if (av.isMandatoryMany() && av.isStar() && relatedAssociation.isMany())
    {
      hasIsNumberOfValidMethod = true;
      hasAddManyToManyTemplateMethod = true;
      includeFile = "association_AddMStarToMany.jet";
      includeFile2 = "association_SetMStarToMany.jet";
    }
    else if ((av.isMN() || av.isN()) && relatedAssociation.isMandatoryMany())
    {
      hasIsNumberOfValidMethod = true;
      hasAddManyToManyTemplateMethod = true;
      hasAddManyToManyTemplateMethod = true;
      includeFile = "association_AddMNToMany.jet";
      includeFile2 = "association_SetMNToMany.jet";
    }
    else if ((av.isMN() || av.isN()) && relatedAssociation.isOptionalN())
    {
      hasIsNumberOfValidMethod = true;
      hasAddManyToManyTemplateMethod = true;
      hasAddManyToManyTemplateMethod = true;
      includeFile = "association_AddMNToMany.jet";
    }
    else if ((av.isMN() || av.isN()) && !relatedAssociation.isOne())
    {
      hasIsNumberOfValidMethod = true;
      hasAddManyToManyTemplateMethod = true;
      includeFile = "association_AddMNToMany.jet";
      includeFile2 = "association_SetMNToMany.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      includeFile = "association_SetOptionalOneToOptionalOne.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isOne())
    {
      includeFile = "association_SetOptionalOneToOne.jet";
    }
    else if (av.isOne() && relatedAssociation.isOptionalOne())
    {
      includeFile = "association_SetOneToOptionalOne.jet";
    }
    else if (av.isMandatoryMany() && av.isStar() && relatedAssociation.isOne())
    {
      hasIsNumberOfValidMethod = true;
      includeFile = "association_AddMandatoryManyToOne.jet";
    }
    else if ((av.isMN() || av.isN()) && relatedAssociation.isOnlyOne())
    {
      hasIsNumberOfValidMethod = true;
      includeFile = "association_AddMNToOnlyOne.jet";
    }
    else if (av.isOptionalN() && relatedAssociation.isOnlyOne())
    {
      includeFile = "association_AddOptionalNToOne.jet";
    }
    else if (av.isOptionalN() && (relatedAssociation.isMN() || relatedAssociation.isOptionalN()))
    {
      hasAddManyToManyTemplateMethod = true;
      if (!av.isImmutable())
      {
        hasRemoveManyTemplateMethod = true;
      }
    }
    else if (av.isOptionalN() && relatedAssociation.isOptionalMany())
    {
      hasAddManyToManyTemplateMethod = true;
      if (!av.isImmutable())
      {
        hasRemoveManyTemplateMethod = true;
      }
      includeFile = "association_SetOptionalNToMany.jet";
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      includeFile = "association_AddManyToOne.jet";
    }
    else if (av.isOptionalN() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      hasAddManyToManyTemplateMethod = true;
      if (!av.isImmutable())
      {
        hasRemoveManyTemplateMethod = true;
      }
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN() || relatedAssociation.isMany()))
    {
      hasAddManyToManyTemplateMethod = true;
      if (!av.isImmutable())
      {
        hasRemoveManyTemplateMethod = true;
      }
    }
    else if (av.isOptionalN() && relatedAssociation.isOptionalOne())
    {
      includeFile = "association_AddOptionalNToOptionalOne.jet";
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      includeFile = "association_AddManyToOptionalOne.jet";
    }
    else if (av.isOnlyOne() && relatedAssociation.isMandatoryMany() && relatedAssociation.isStar())
    {
      includeFile = "association_SetOneToMandatoryMany.jet";
    }
    else if (av.isOnlyOne() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      includeFile = "association_SetOneToAtMostN.jet";
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalN())
    {
      includeFile = "association_SetOneToAtMostN.jet";
    }
    else if (av.isOnlyOne() && relatedAssociation.isMany() && !(av.isMandatory() && !av.isOne()) && !(uClass instanceof AssociationClass))
    {
      includeFile = "association_SetOneToMany.jet";
    }
    else if (av.isOnlyOne() && relatedAssociation.isMany() && !(av.isMandatory() && !av.isOne()) && (uClass instanceof AssociationClass))
    {
      includeFile = "association_SetOneToManyAssociationClass.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalN())
    {
      includeFile = "association_SetOptionalOneToOptionalN.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      includeFile = "association_SetOptionalOneToMany.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isMandatoryMany())
    {
      // Insert code to include code here
      if (relatedAssociation.isUpperBounded())
      {
        //
        // This program cannot currently include SetOptionalOneToMandatoryMN.jet because of Issue351 where add/remove methods do not generate
        //
        // includeFile = "association_SetOptionalOneToMandatoryMN.jet";
      } 
      else
      {
        //
        // We can include association_SetOptionalOneToMandatoryMany.jet
        // 
        includeFile = "association_SetOptionalOneToMandatoryMany.jet";
      } 
    }
    else if (av.isOptionalOne() && relatedAssociation.isMandatory())
    {
      //ignore
    }

    else
    {
      
    stringBuffer.append(TEXT_459);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(relatedAssociation);
    
    }
    
    if(av.isSorted())
    {
      includeFile3 = "association_Sort.jet";
    }
    else if(av.isMany() && !av.isImmutable() && !av.isN())
    {
      includeFile3 = "association_AddIndexControlFunctions.jet";
    }

    boolean addNewLine = false;
    if (hasIsNumberOfValidMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    stringBuffer.append(TEXT_461);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_462);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_463);
     if (customIsNumberOfValidPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPrefixCode, "    ")); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_464);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_465);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_466);
     } else { 
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_468);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_469);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_470);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_471);
     } 
     if (customIsNumberOfValidPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_472);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_474);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_476);
     } else { 
    stringBuffer.append(TEXT_477);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_478);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_479);
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_480);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_481);
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_482);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_483);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_485);
     } else { 
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_488);
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_489);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_490);
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_491);
     } 
    
    }
    
    if (hasMaximumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customGetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getMethod",av)));

    String customMaximumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("maximumNumberOfMethod",av)));
    String customMaximumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("maximumNumberOfMethod",av)));

     if (customMaximumNumberOfPrefixCode == null && customMaximumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_493);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_494);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_495);
     } else { 
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_498);
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_499);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_500);
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_501);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_506);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_507);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_509);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_510);
     } 
    stringBuffer.append(TEXT_511);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_515);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_522);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_523);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_524);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_525);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_526);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_528);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_532);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_535);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_543);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_549);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_550);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_551);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_552);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_555);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_556);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_558);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_559);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_564);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_565);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_569);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_570);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_571);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_575);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_583);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "      ")); } 
    stringBuffer.append(TEXT_584);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_591);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_602);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_603);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_608);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_609);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_613);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_615);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_616);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_623);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_624);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_633);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_637);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_638);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_639);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_640);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_649);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_650);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_651);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_652);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_655);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_656);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_658);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_659);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_660);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_662);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_663);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_669);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_674);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_675);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_678);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_679);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_681);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_684);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_685);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_688);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_689);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_693);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_701);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_702);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_703);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_705);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_706);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_718);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_723);
    stringBuffer.append(TEXT_724);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_726);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_735);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_740);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_741);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_742);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_743);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_745);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_746);
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_752);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_753);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_754);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_766);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_767);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_769);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_770);
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_774);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_775);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(TEXT_780);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_785);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_786);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_791);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_793);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_794);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_796);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_799);
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_802);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_803);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_804);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_805);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_806);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_807);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_810);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_811);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_819);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_828);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_831);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_836);
    stringBuffer.append(TEXT_837);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_840);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_843);
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_846);
    stringBuffer.append(TEXT_847);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_848);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(TEXT_853);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_855);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_856);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_859);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_862);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_866);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_867);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_868);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_873);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_874);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(TEXT_877);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_878);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_879);
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_882);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_883);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_884);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_885);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_891);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_894);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_896);
    stringBuffer.append(TEXT_897);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_902);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_903);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_905);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_908);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(TEXT_911);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_914);
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_916);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_917);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_922);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_923);
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_926);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_928);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_929);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_930);
    stringBuffer.append(TEXT_931);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_932);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(TEXT_937);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_941);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(TEXT_943);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_944);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_945);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_946);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_951);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_952);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_955);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_959);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_962);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_966);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_967);
    stringBuffer.append(TEXT_968);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_970);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_977);
    stringBuffer.append(TEXT_978);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_980);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_981);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_982);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_983);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_984);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_986);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_990);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_992);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_995);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_996);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_997);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_998);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1013);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1014);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1019);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1025);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1043);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1044);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1049);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1051);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1068);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1069);
    
    }
    else if (includeFile == "association_SetOneToManyAssociationClass.jet")
    {
      
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1073);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1075);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1094);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1095);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1100);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1104);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1111);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1127);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1131);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1132);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1137);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1141);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1147);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1163);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1167);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1168);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1173);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1193);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1202);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1216);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1217);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1222);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1239);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1240);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1245);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1248);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1269);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1278);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1290);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1291);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1296);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1302);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1311);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1316);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1319);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1326);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1327);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1332);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1335);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1336);
     } 
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1345);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1359);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1368);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1384);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1385);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1390);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1400);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1403);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1405);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1411);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1417);
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1423);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1424);
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1430);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1443);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1444);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1449);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1450);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1452);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1455);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1456);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1457);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1461);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1469);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1472);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1473);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1477);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1478);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1480);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1483);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1484);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1490);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1493);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1500);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1502);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1503);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1504);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1508);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1510);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1511);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1515);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1519);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1520);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1525);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1528);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(TEXT_1530);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1533);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1534);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1535);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1536);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
    stringBuffer.append(TEXT_1537);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1538);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1539);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1541);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1543);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1544);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1545);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1546);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1547);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1549);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1550);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1551);
    stringBuffer.append(TEXT_1552);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1554);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1557);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_1558);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1561);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1562);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1564);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1565);
    
    }
    else if (includeFile == "association_SetUnidirectionalMany.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1566);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1567);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1568);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1569);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1570);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1572);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1573);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1574);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1575);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1576);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1577);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(TEXT_1579);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1581);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1582);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1583);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1584);
    stringBuffer.append(TEXT_1585);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1586);
    stringBuffer.append(TEXT_1587);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1588);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1589);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1590);
    
    }
  else if (includeFile == "association_SetOptionalOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1592);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1593);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1594);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1595);
    stringBuffer.append(TEXT_1596);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1597);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1598);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1599);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1600);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1601);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1602);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1603);
    stringBuffer.append(TEXT_1604);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1605);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1606);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1607);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1608);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1609);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1610);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1611);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1612);
    stringBuffer.append(TEXT_1613);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1614);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1615);
    stringBuffer.append(TEXT_1616);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1617);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1618);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1620);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1622);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1623);
    stringBuffer.append(TEXT_1624);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1625);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1626);
    stringBuffer.append(TEXT_1627);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1628);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1629);
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1631);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1632);
    stringBuffer.append(TEXT_1633);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1634);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1635);
    
    }
    else if (includeFile == "association_SetOptionalOneToMandatoryMN.jet")
    {
      
    stringBuffer.append(TEXT_1636);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1637);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1639);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1640);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1641);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1642);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1643);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1644);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1645);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1646);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1647);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1648);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1649);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1650);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1651);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1652);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1653);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1654);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1655);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1656);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1657);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1658);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1659);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1660);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1661);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1662);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1663);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1664);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1665);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1666);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1667);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1668);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1669);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1670);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1671);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1672);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1673);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1674);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1675);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1676);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1677);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1678);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1679);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1680);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1681);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1682);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1683);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1684);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1685);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1686);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1687);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1688);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1689);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1690);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1691);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1692);
    stringBuffer.append(TEXT_1693);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1694);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1695);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1696);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1697);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1698);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1699);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1700);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1701);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1702);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1703);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1704);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1705);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1706);
    stringBuffer.append(TEXT_1707);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1708);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1709);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1710);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1711);
    stringBuffer.append(TEXT_1712);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1713);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1714);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1715);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1716);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1717);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1718);
    stringBuffer.append(TEXT_1719);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1720);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1721);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1722);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1723);
    stringBuffer.append(TEXT_1724);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1725);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1726);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1727);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1728);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1729);
    stringBuffer.append(TEXT_1730);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1731);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1732);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1733);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1734);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1735);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1736);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1737);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1738);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1739);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1740);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1741);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1742);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1743);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1744);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1745);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1746);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1747);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1748);
    stringBuffer.append(TEXT_1749);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1750);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1751);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1752);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1753);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1754);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1755);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1756);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1757);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1758);
    stringBuffer.append(TEXT_1759);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1760);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1761);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1762);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1763);
    stringBuffer.append(TEXT_1764);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1765);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1766);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1767);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1768);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1769);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1770);
    stringBuffer.append(TEXT_1771);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1772);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1773);
    stringBuffer.append(TEXT_1774);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1775);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1776);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1777);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1778);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1779);
    stringBuffer.append(TEXT_1780);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1781);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1782);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1783);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1784);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1785);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1786);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1787);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1788);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1789);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1790);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1791);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1792);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1793);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1794);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1795);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1796);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1797);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1798);
    stringBuffer.append(TEXT_1799);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1800);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1801);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1802);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1803);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1804);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1805);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1806);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1807);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1808);
    stringBuffer.append(TEXT_1809);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1810);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1811);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1812);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1813);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1814);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_1815);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1816);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1817);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1818);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1819);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1820);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1821);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1822);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_1823);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1824);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1825);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1826);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1827);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1828);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1829);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1830);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1831);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1832);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1833);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1834);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1835);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1836);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1837);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1838);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1839);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1840);
    stringBuffer.append(TEXT_1841);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1842);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1843);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1844);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1845);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1846);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1847);
    stringBuffer.append(TEXT_1848);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1849);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1850);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1851);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1852);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1853);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1854);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1855);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "          ")); } 
    stringBuffer.append(TEXT_1856);
    stringBuffer.append(TEXT_1857);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1858);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1859);
    stringBuffer.append(TEXT_1860);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1861);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1862);
    stringBuffer.append(TEXT_1863);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1864);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1865);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1866);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1867);
    stringBuffer.append(TEXT_1868);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1869);
    stringBuffer.append(TEXT_1870);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1871);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1872);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1873);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1874);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1875);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1876);
    stringBuffer.append(TEXT_1877);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1878);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1879);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1880);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1881);
    stringBuffer.append(TEXT_1882);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1883);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1884);
    stringBuffer.append(TEXT_1885);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1886);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1887);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1888);
    stringBuffer.append(TEXT_1889);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1890);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1891);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1892);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1893);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1894);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1895);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1896);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1897);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1898);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1899);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1900);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1901);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1902);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1903);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1904);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1905);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1906);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1907);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1908);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1909);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1910);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1911);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1912);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1913);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1914);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1915);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1916);
    stringBuffer.append(TEXT_1917);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1918);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1919);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1920);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1921);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1922);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1923);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1924);
    stringBuffer.append(TEXT_1925);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1926);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1927);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1928);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1929);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1930);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1931);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1932);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1933);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1934);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1935);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1936);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1937);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1938);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1939);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1940);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1941);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1942);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1943);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1944);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1945);
    stringBuffer.append(TEXT_1946);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1947);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1948);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1949);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1950);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1951);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1952);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1953);
    stringBuffer.append(TEXT_1954);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1955);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1956);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1957);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1958);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1959);
    
    }
    else if (includeFile2 != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile2);
    }
    
    if(includeFile3 == "association_Sort.jet" && !sortMethodAdded)
    {
      
    
      sortMethodAdded = true; //after the sort method has been added, this boolean stops it from being added again
    }
    else if(includeFile3 == "association_AddIndexControlFunctions.jet")
    {
      
    
    }
  }
  gen.setParameterConstraintName("");

     if (uClass.getKey().isProvided()) { 
    

  StringBuilder checks = new StringBuilder();
  StringBuilder hash = new StringBuilder();
  StringBuilder canSet = new StringBuilder();
  
  for(String memberId : uClass.getKey().getMembers())
  {
    Attribute av = uClass.getAttribute(memberId);
    AssociationVariable as = uClass.getAssociationVariable(memberId);
    if (av != null)
    {
      canSet.append(StringFormatter.format("    {0} = false;\n",gen.translate("attributeCanSet",av)));
      if (av.getIsList())
      {
        checks.append(StringFormatter.format("    if ({0}.size() != compareTo.{0}.size())\n",gen.translate("attributeMany",av)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n\n"));
        checks.append(StringFormatter.format("    for (int i=0; i<{0}.size(); i++)\n",gen.translate("attributeMany",av)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      {0} me = {1}.get(i);\n",gen.translate("type",av),gen.translate("attributeMany",av)));
        checks.append(StringFormatter.format("      {0} them = compareTo.{1}.get(i);\n",gen.translate("type",av),gen.translate("attributeMany",av)));
        checks.append(StringFormatter.format("      if (me == null && them != null)\n"));
        checks.append(StringFormatter.format("      {\n"));
        checks.append(StringFormatter.format("       return false;\n"));
        checks.append(StringFormatter.format("      }\n"));
        checks.append(StringFormatter.format("      else if (me != null && !me.equals(them))\n"));
        checks.append(StringFormatter.format("      {\n"));
        checks.append(StringFormatter.format("        return false;\n"));
        checks.append(StringFormatter.format("      }\n"));
        checks.append(StringFormatter.format("    }\n"));
      }
      else if ("Integer".equals(av.getType()) || "Boolean".equals(av.getType()) || "Double".equals(av.getType()))
      {
        checks.append(StringFormatter.format("    if ({0} != compareTo.{0})\n",gen.translate("attributeOne",av)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
      }
      else
      {
        checks.append(StringFormatter.format("    if ({0} == null && compareTo.{0} != null)\n",gen.translate("attributeOne",av)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
        checks.append(StringFormatter.format("    else if ({0} != null && !{0}.equals(compareTo.{0}))\n",gen.translate("attributeOne",av)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
      }
      checks.append("\n");
    }
    else if (as != null)
    {
      canSet.append(StringFormatter.format("    {0} = false;\n",gen.translate("associationCanSet",as)));
      if (as.isMany())
      {
        checks.append(StringFormatter.format("    if ({0}.size() != compareTo.{0}.size())\n",gen.translate("associationMany",as)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n\n"));
        checks.append(StringFormatter.format("    for (int i=0; i<{0}.size(); i++)\n",gen.translate("attributeMany",as)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      {0} me = {1}.get(i);\n",gen.translate("type",as),gen.translate("associationMany",as)));
        checks.append(StringFormatter.format("      {0} them = compareTo.{1}.get(i);\n",gen.translate("type",as),gen.translate("associationMany",as)));
        checks.append(StringFormatter.format("      if (me == null && them != null)\n"));
        checks.append(StringFormatter.format("      {\n"));
        checks.append(StringFormatter.format("       return false;\n"));
        checks.append(StringFormatter.format("      }\n"));
        checks.append(StringFormatter.format("      else if (me != null && !me.equals(them))\n"));
        checks.append(StringFormatter.format("      {\n"));
        checks.append(StringFormatter.format("        return false;\n"));
        checks.append(StringFormatter.format("      }\n"));
        checks.append(StringFormatter.format("    }\n"));
      }
      else
      {
        checks.append(StringFormatter.format("    if ({0} == null && compareTo.{0} != null)\n",gen.translate("attributeOne",as)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
        checks.append(StringFormatter.format("    else if ({0} != null && !{0}.equals(compareTo.{0}))\n",gen.translate("attributeOne",as)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
      }
      checks.append("\n");
    }
    
    if (av != null)
    {
      if ("Integer".equals(av.getType()) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    cachedHashCode = cachedHashCode * 23 + {0};\n",gen.translate("attributeOne",av)));
      }
      else if ("Double".equals(av.getType()) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    cachedHashCode = cachedHashCode * 23 + (new Double({0})).hashCode();\n",gen.translate("attributeOne",av)));
      }
      else if ("Boolean".equals(av.getType()) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    cachedHashCode = cachedHashCode * 23 + ({0} ? 1 : 0);\n",gen.translate("attributeOne",av)));
      }
      else
      {
        String attributeType = av.getIsList() ? "attributeMany" : "attributeOne";
        hash.append(StringFormatter.format("    if ({0} != null)\n",gen.translate(attributeType,av)));
        hash.append(StringFormatter.format("    {\n"));
        hash.append(StringFormatter.format("      cachedHashCode = cachedHashCode * 23 + {0}.hashCode();\n",gen.translate(attributeType,av)));
        hash.append(StringFormatter.format("    }\n"));
        hash.append(StringFormatter.format("    else\n"));
        hash.append(StringFormatter.format("    {\n"));
        hash.append(StringFormatter.format("      cachedHashCode = cachedHashCode * 23;\n"));
        hash.append(StringFormatter.format("    }\n"));
      }
      hash.append("\n");
    }
    else if (as != null)
    {
      String attributeType = as.isOne() ? "attributeOne" : "attributeMany";
      hash.append(StringFormatter.format("    if ({0} != null)\n",gen.translate(attributeType,as)));
      hash.append(StringFormatter.format("    {\n"));
      hash.append(StringFormatter.format("      cachedHashCode = cachedHashCode * 23 + {0}.hashCode();\n",gen.translate(attributeType,as)));
      hash.append(StringFormatter.format("    }\n"));
      hash.append(StringFormatter.format("    else\n"));
      hash.append(StringFormatter.format("    {\n"));
      hash.append(StringFormatter.format("      cachedHashCode = cachedHashCode * 23;\n"));
      hash.append(StringFormatter.format("    }\n"));
    }
  }


    stringBuffer.append(TEXT_1960);
    stringBuffer.append(TEXT_1961);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1962);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1963);
    stringBuffer.append(TEXT_1964);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1965);
    stringBuffer.append(TEXT_1966);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1967);
     } 
    
{ 
  boolean hasActivities = false;
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (State state : sm.getStates())
    {
      for (Activity activity : state.getActivities())
      {
        hasActivities = true;
        
    stringBuffer.append(TEXT_1968);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1969);
    stringBuffer.append( gen.translate("doActivityMethod",activity));
    stringBuffer.append(TEXT_1970);
    stringBuffer.append(TEXT_1971);
    stringBuffer.append( activity.getActivityCode() );
    stringBuffer.append(TEXT_1972);
    
      }
    }
  } 
  if (hasActivities)
  {
    
       
  StringBuffer output = new StringBuffer();

  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (State state : sm.getStates())
    {
      for (Activity activity : state.getActivities())
      {
        if (isFirst)
        {
          output.append(StringFormatter.format("if"));
          isFirst = false;
        }
        else
        {
          output.append(StringFormatter.format("\n        else if"));
        }
        output.append(StringFormatter.format(" (\"{0}\".equals(doActivityMethodName))\n",gen.translate("doActivityMethod",activity)));
        output.append(StringFormatter.format("      {\n"));
        output.append(StringFormatter.format("        controller.{0}();\n",gen.translate("doActivityMethod",activity)));
        output.append(StringFormatter.format("      }"));
      }
    }
  }

    stringBuffer.append(TEXT_1973);
    stringBuffer.append(TEXT_1974);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1975);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1976);
    stringBuffer.append(TEXT_1977);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_1978);
    
  }
}

    
{ 
  boolean hasTimedEvents = false;
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        hasTimedEvents = true;
        
    stringBuffer.append(TEXT_1979);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1980);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1981);
    
      }
    }
  }
  if (hasTimedEvents)
  {
    
    
 


    stringBuffer.append(TEXT_1982);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1983);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1984);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1985);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1986);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        
    stringBuffer.append(TEXT_1987);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1988);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1989);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1990);
    
      }
    }
  }

    stringBuffer.append(TEXT_1991);
    
  }
}

    stringBuffer.append(TEXT_1992);
    

  appendln(stringBuffer,"");
  appendln(stringBuffer,"{0}::~{0}()",uClass.getName());
  append(stringBuffer,"  {");

  boolean hasSomethingToDelete = false;

  String customDeletePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before","delete"));
  String customDeletePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after","delete"));

  if (customDeletePrefixCode != null) 
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customDeletePrefixCode, "    "));
    hasSomethingToDelete = true;
  }

  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (!av.getIsNavigable())
    {
      continue;
    }
    
    if (!relatedAssociation.getIsNavigable())
    {
      if (av.isOne())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1993);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1994);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1995);
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1996);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1997);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1998);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1999);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2000);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2001);
    stringBuffer.append(TEXT_2002);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2003);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2004);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2005);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2006);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2007);
    stringBuffer.append(TEXT_2008);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2009);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2010);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2011);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2012);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2013);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2014);
    stringBuffer.append(TEXT_2015);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2016);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2017);
    stringBuffer.append(TEXT_2018);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2019);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2020);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_2021);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2022);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2023);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2024);
    stringBuffer.append(TEXT_2025);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2026);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2027);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2028);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_2029);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2030);
    stringBuffer.append(TEXT_2031);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2032);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2033);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2034);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2035);
    stringBuffer.append(TEXT_2036);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2037);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2038);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_2039);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2040);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2041);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_2042);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2043);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2044);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2045);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_2046);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2047);
    stringBuffer.append(TEXT_2048);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2049);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2050);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2051);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2052);
    stringBuffer.append(TEXT_2053);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2054);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2055);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_2056);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2057);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2058);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2059);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2060);
    stringBuffer.append(TEXT_2061);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2062);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2063);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2064);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2065);
    stringBuffer.append(TEXT_2066);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2067);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2068);
    stringBuffer.append(TEXT_2069);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2070);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_2071);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2072);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2073);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2074);
    stringBuffer.append(TEXT_2075);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2076);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2077);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2078);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2079);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2080);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2081);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2082);
    stringBuffer.append(TEXT_2083);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2084);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2085);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_2086);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2087);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2088);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2089);
    stringBuffer.append(TEXT_2090);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2091);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2092);
    stringBuffer.append(TEXT_2093);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2094);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2095);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_2096);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2097);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2098);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2099);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2100);
    stringBuffer.append(TEXT_2101);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2102);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2103);
    
    }
    else
    {
      continue;
    }
    hasSomethingToDelete = true;
  }
  
  if (!uClass.isRoot() && !"external".equals(uClass.getExtendsClass().getModifier()))
  {
    hasSomethingToDelete = true;
    appendln(stringBuffer,"");
    append(stringBuffer, "    super.delete();");
  }

  if (customDeletePostfixCode != null) 
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customDeletePostfixCode, "    "));
    hasSomethingToDelete = true;
  }

  if (hasSomethingToDelete)
  {
    appendln(stringBuffer, "");
    appendln(stringBuffer, "  }");
  }
  else
  {
    appendln(stringBuffer, "}");
  }


     if (uClass.hasMethods()) { 
    
   if (uClass.hasMethods())
   {
     for (Method aMethod : uClass.getMethods()) 
     {
       String methodModifier = aMethod.getModifier().equals("") ? "" : aMethod.getModifier();
       String methodName = (uClass.getName()+"::"+aMethod.getName());
       String methodType = aMethod.getType();
       String customPreconditionCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", aMethod.getName()+"Precondition"));
       String customPostconditionCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", aMethod.getName()+"Postcondition"));
       customPostconditionCode = customPostconditionCode==null?"":customPostconditionCode;
        
       String methodBody = aMethod.getIsImplemented() ? "      return " + gen.translateReturnType(methodType) + ";" : aMethod.getMethodBody().getExtraCode();
       String properMethodBody = "      " + methodBody; 
       String override =  aMethod.getIsImplemented() ? "" : "";
       String paramName="";
       String paramType="";
       String aSingleParameter="";
       String isList="";
       String finalParams = "";
       String finalParamsWithoutTypes = "";
       StringBuilder parameters = new StringBuilder();
       StringBuilder parametersWithoutTypes = new StringBuilder();
       if(aMethod.hasMethodParameters())
       {
         for (MethodParameter aMethodParam : aMethod.getMethodParameters()) 
         {
            paramName = aMethodParam.getName();
            paramType = gen.translate(aMethodParam.getType());
            isList = aMethodParam.getIsList() ? " [] " : " ";
            aSingleParameter = paramType + isList + paramName;
            parameters.append(aSingleParameter + ", ");
            parametersWithoutTypes.append(aMethodParam.getName() + ", ");
          }
          finalParams = parameters.toString().substring(0, parameters.toString().length()-2);
          finalParamsWithoutTypes = parametersWithoutTypes.toString().substring(0, parametersWithoutTypes.toString().length()-2);
        }
        else {
           appendln(stringBuffer,"");
        }
        if (aMethod.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Method Javadoc",aMethod.getComments())); }
        append(stringBuffer, "\n  {0} {1} {2}({3})", methodModifier, gen.translate(methodType), methodName, finalParams);
        if(!"".equals(customPostconditionCode))
        {
          appendln(stringBuffer, "{");
          if(!"".equals(methodType)&&!"void".equals(methodType)){
            append(stringBuffer, "    {0} result = {1}_Original({2});\n", methodType, methodName, finalParamsWithoutTypes);
          }
          else {
            append(stringBuffer, "    {0}_Original({1});\n", methodName, finalParamsWithoutTypes);
          }
          appendln(stringBuffer, GeneratorHelper.doIndent(customPostconditionCode, "    "));
          if(!"".equals(methodType)&&!"void".equals(methodType)){
            append(stringBuffer, "    return result;\n");
          }          
          appendln(stringBuffer, "  }");
          append(stringBuffer, "  {0} {1} {2}_Original({3})", methodModifier, methodType, methodName, finalParams);
        }
    	appendln(stringBuffer, "{");
    	if (customPreconditionCode != null) { append(stringBuffer, "\n{0}\n",GeneratorHelper.doIndent(customPreconditionCode, "    "));}
    	appendln(stringBuffer, properMethodBody);
    	appendln(stringBuffer, "  }");
      }
    }

     } 
     if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_2104);
    stringBuffer.append(TEXT_2105);
    stringBuffer.append(uClass.getExtraCode());
    stringBuffer.append(TEXT_2106);
     } 
    
{
  //==== Tracing Code    
  if( model.getTraceType().equals("File") && uClass.hasTraceDirectives() )
  {
    appendln(stringBuffer, "");
	appendln(stringBuffer, "  //------------------------");
	appendln(stringBuffer, "  // FILE TRACER METHOD");
	appendln(stringBuffer, "  //------------------------\n");
	appendln(stringBuffer, "  {0}::fileTracer(Object obj)",uClass.getName());
	appendln(stringBuffer, "  {");
	appendln(stringBuffer, "      // Create and Open an output stream");
	appendln(stringBuffer, "    ofstream fout;");
	appendln(stringBuffer, "    time_t rawTime; // for timestamp");
	appendln(stringBuffer, "    try");
	appendln(stringBuffer, "    {");
	appendln(stringBuffer, "      // Create and Open an output stream");
	appendln(stringBuffer, "      fout.open(\"TraceLog.txt\")");
	appendln(stringBuffer, "    }");
	appendln(stringBuffer, "    catch (exception& e)");
	appendln(stringBuffer, "    {");
	appendln(stringBuffer, "      cout<<\"Unable to write to file due to:\"<<e.what()<<endl;");
	appendln(stringBuffer, "    }");
	appendln(stringBuffer, "    // Write traced Item information");
	appendln(stringBuffer, "    fout<<obj;");
	appendln(stringBuffer, "    try");
	appendln(stringBuffer, "    {");
	appendln(stringBuffer, "      // Close output stream");
	appendln(stringBuffer, "      fout.close();");
	appendln(stringBuffer, "    }");
	appendln(stringBuffer, "    catch (exception& e)");
	appendln(stringBuffer, "    {");
	appendln(stringBuffer, "      fout<<e.what()<<endl;");
	appendln(stringBuffer, "    }");
	appendln(stringBuffer, "  }");
  }
  
  
}

    stringBuffer.append(TEXT_2107);
    return stringBuffer.toString();
  }
}