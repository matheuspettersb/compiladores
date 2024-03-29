public interface ParserConstants
{
    int START_SYMBOL = 44;

    int FIRST_NON_TERMINAL    = 44;
    int FIRST_SEMANTIC_ACTION = 83;

    int[][] PARSER_TABLE =
    {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  2,  2,  2,  2, -1, -1, -1, -1, -1, -1, -1, -1,  2,  2, -1, -1, -1, -1, -1,  2, -1, -1, -1, -1,  2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  1, -1 },
        { -1, -1,  3,  3,  3,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  4,  5,  6,  7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 10, -1, -1 },
        { -1, -1, 12, 12, 12, 12, -1, -1, -1, -1, -1, -1, -1, -1, 12, 12, -1, -1, -1, -1, -1, 12, -1, -1, -1, -1, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 13, 13, 13, 13, -1, -1, -1, -1, -1, -1, -1, -1, 16, 14, -1, -1, -1, -1, -1, 15, -1, -1, -1, -1, 17, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 20, 20, 20, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 24, 24, 24, 24, -1, -1, -1, -1, 24, 24, -1, 24, 24, 24, 24, -1, -1, -1, -1, 24, -1, -1, -1, -1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 28, 28, 28, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1 },
        { -1, -1, 29, 30, 31, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 38, 38, 38, 38, 38, 38, 38, -1, -1, -1, 38, -1, -1, -1, -1, -1, 38, 38, -1, -1, 38, -1, 38, 38, -1, -1, -1, 38, -1, -1, -1, -1, -1, 38, 38, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 47, 47, 47, 47, 47, 47, 47, -1, -1, -1, 47, -1, -1, -1, -1, -1, 47, 47, -1, -1, 47, -1, 47, 47, -1, -1, -1, 47, -1, -1, -1, -1, -1, 47, 47, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22 },
        { -1, -1, 19, 19, 19, 19, -1, -1, -1, -1, 18, 18, -1, 18, 19, 19, 18, -1, -1, -1, -1, 19, -1, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  8,  9, -1, -1 },
        { -1, -1, 27, 27, 27, 27, -1, -1, 26, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, -1, -1, -1, -1, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 46, 45, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 51, 51, 51, 51, 51, 51, 51, -1, -1, -1, 53, -1, -1, -1, -1, -1, 51, 54, -1, -1, 51, -1, 51, 52, -1, -1, -1, 51, -1, -1, -1, -1, -1, 51, 51, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 48, 48, 48, 48, -1, -1, -1, 49, 48, 48, -1, 48, 48, 48, 48, 48, -1, -1, 50, 48, -1, -1, -1, -1, 48, -1, 48, -1, 48, -1, -1, -1, -1, -1, -1, -1, -1, 48, -1, 48, -1 },
        { -1, -1, 55, 55, 55, 55, 55, 55, 55, -1, -1, -1, -1, -1, -1, -1, -1, -1, 55, -1, -1, -1, 55, -1, 55, -1, -1, -1, -1, 55, -1, -1, -1, -1, -1, 55, 55, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 56, 56, 56, 56, -1, -1, -1, 56, 56, 56, -1, 56, 56, 56, 56, 56, -1, -1, 56, 56, -1, -1, -1, -1, 56, -1, 56, -1, 56, 57, 57, 57, 57, -1, -1, -1, -1, 56, -1, 56, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 62, 62, 62, 62, 62, 62, 62, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 62, -1, 62, -1, -1, -1, -1, 62, -1, -1, -1, -1, -1, 62, 62, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 63, 63, 63, 63, -1, -1, -1, 63, 63, 63, -1, 63, 63, 63, 63, 63, -1, -1, 63, 63, -1, -1, -1, -1, 63, -1, 63, -1, 63, 63, 63, 63, 63, 64, 65, -1, -1, 63, -1, 63, -1 },
        { -1, -1, 66, 66, 66, 66, 66, 66, 66, -1, -1, -1, -1, -1, -1, -1, -1, -1, 66, -1, -1, -1, 66, -1, 66, -1, -1, -1, -1, 66, -1, -1, -1, -1, -1, 66, 66, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 67, 67, 67, 67, -1, -1, -1, 67, 67, 67, -1, 67, 67, 67, 67, 67, -1, -1, 67, 67, -1, -1, -1, -1, 67, -1, 67, -1, 67, 67, 67, 67, 67, 67, 67, 68, 69, 67, -1, 67, -1 },
        { -1, -1, 70, 70, 70, 70, 71, 72, 73, -1, -1, -1, -1, -1, -1, -1, -1, -1, 74, -1, -1, -1, 75, -1, 76, -1, -1, -1, -1, 77, -1, -1, -1, -1, -1, 78, 79, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 80, 80, 80, 80, -1, -1, -1, 80, 80, 80, -1, 80, 80, 80, 80, 80, -1, -1, 80, 80, -1, -1, -1, -1, 80, 81, 80, -1, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, -1, 80, -1 },
        { -1, -1, 82, 83, 84, 85, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };

    int[][] PRODUCTIONS = 
        {
        	{  98,  24,  45,  49,  14,  99 },
            {  42,  46, 106,  41 },
            {   0 },
            {  47,  64 },
            {   3, 107,  48 },
            {   4, 107,  48 },
            {   5, 107,  48 },
            {   6, 107,  48 },
            {  40,  46 },
            {   0 },
            {   0 },
            {  28,   7,  29 },
            {  50,  63 },
            {  51 },
            {  53 },
            {  57 },
            {  59 },
            {  60 },
            {   0 },
            {  49 },
            {  56, 107,  62 },
            {  28,  61,  29,  43,  61,  52, 108 },
            {  43,  61,  52, 108 },
            {  42,  15,  61, 109 },
            {   0 },
            {  16,  30,  65 },
            {   9, 100,  97,  40,  54, 110,  31 },
            {  54, 110,  31 },
            {  56, 107,  55,  66 },
            {   3 },
            {   4 },
            {   5 },
            {   6 },
            {  40,  54 },
            {   0 },
            {   0 },
            {  28,  61,  29 },
            {  22,  30,  58,  31 },
            {  61,  97,  68 },
            {   0 },
            {  40,  58 },
            {  15,  61, 111,  18,  49,  69 },
            {  17, 113,  49,  11, 112 },
            {  11, 112 },
            {  27, 114,  61,  70 },
            {  18, 115,  49,  12, 116 },
            {  17, 115,  49,  12, 116 },
            {  71,  72 },
            {   0 },
            {  10,  71, 104,  72 },
            {  21,  71, 105,  72 },
            {  73 },
            {  26,  94 },
            {  13,  95 },
            {  20,  71,  96 },
            {  76,  74 },
            {   0 },
            {  75,  92,  76,  93 },
            {  32 },
            {  33 },
            {  34 },
            {  35 },
            {  78,  77 },
            {   0 },
            {  36,  78,  84,  77 },
            {  37,  78,  85,  77 },
            {  80,  79 },
            {   0 },
            {  38,  80,  86,  79 },
            {  39,  80,  87,  79 },
            {  82, 117,  81 },
            {   7,  88 },
            {   8,  89 },
            {   9, 100 },
            {  19, 101 },
            {  23, 102 },
            {  25, 103 },
            {  30,  61,  31 },
            {  36,  80,  90 },
            {  37,  80,  91 },
            {   0 },
            {  28,  61,  29 },
            {   3 },
            {   4 },
            {   5 },
            {   6 }
        };

    String[] PARSER_ERROR =
    {
        "",
        "esperado EOF",
        "esperado palavra_reservada",
        "esperado identificador",
        "esperado identificador",
        "esperado identificador",
        "esperado identificador",
        "esperado constante int",
        "esperado constante float",
        "esperado constante string",
        "esperado and",
        "esperado endIf",
        "esperado endWhile",
        "esperado false",
        "esperado finish",
        "esperado if",
        "esperado in",
        "esperado isFalseDo",
        "esperado isTrueDo",
        "esperado newLine",
        "esperado not",
        "esperado or",
        "esperado out",
        "esperado space",
        "esperado start",
        "esperado tab",
        "esperado true",
        "esperado while",
        "esperado \"[\"",
        "esperado \"]\"",
        "esperado \"(\"",
        "esperado \")\"",
        "esperado \"==\"",
        "esperado \"<>\"",
        "esperado \"<\"",
        "esperado \">\"",
        "esperado \"+\"",
        "esperado \"-\"",
        "esperado \"*\"",
        "esperado \"/\"",
        "esperado \",\"",
        "esperado \";\"",
        "esperado \":\"",
        "esperado \"=\"",
        "esperado start",										//"<programa> inv�lido",
        "esperado identificador if in out while :",				//"<declaracao_de_variaveis> inv�lido",
        "esperado identificador",								//"<lista_de_identificadores> inv�lido",
        "esperado identificador",								//"<identificador> inv�lido",
        "esperado [ ,",											//"<identificador_array> inv�lido",
        "esperado identificador if in out while",				//"<lista_de_comandos> inv�lido",
        "esperado identificador if in out while",				//"<comando> inv�lido",
        "esperado identificador",								//"<com_atribuicao> inv�lido",
        "esperado identificador endIf endWhile finish if in isFalseDo out while :",		//"<sufixo> inv�lido",
        "esperado in",											//"<com_entrada> inv�lido",
        "esperado identificador",								//"<lista_de_variaveis> inv�lido",
        "esperado [ ) ,",										//"<identificador_expressao> inv�lido",
        "esperado identificador",								//"<outro_identificador> inv�lido",
        "esperado out",											//<com_saida> inv�lido",
        "esperado express�o",									//"<lista_de_expressoes> inv�lido",
        "esperado if",											//"<com_selecao> inv�lido",
        "esperado while",										//"<com_repeticao> inv�lido",
        "esperado express�o",									//"<expressao> inv�lido",
        "esperado [ = ",										//"<resto_expressao> inv�lido",
        "esperado identificador endIf endWhile finish if in isFalseDo out while",		//"<comando1> inv�lido",
        "esperado , ;",											//"<identificador1> inv�lido",
        "esperado identificador constante string",				//"<com_entrada1> inv�lido",
        "esperado ) ,",											//"<outro_identificador1> inv�lido",
        "",//sem referencia ??									//"<identificador_expressao1> inv�lido",
        "esperado ) ,",											//"<lista_de_expressoes1> inv�lido",
        "esperado endIf isFalseDo ",							//"<com_selecao1> inv�lido",
        "esperado isFalseDo isTrueDo",							//"<com_repeticao1> inv�lido",
        "esperado express�o",									//"<elemento> inv�lido",
        "esperado express�o",									//"<expressao_> inv�lido",
        "esperado express�o",									// "<relacional> inv�lido",
        "esperado express�o",									//"<relacional_> inv�lido",
        "esperado == <> < > ",									//<operador_relacional> inv�lido",
        "esperado express�o",									//"<aritmetica> inv�lido",
        "esperado express�o",									//"<aritmetica_> inv�lido",
        "esperado express�o",									//"<termo> inv�lido",
        "esperado express�o",									//"<termo_> inv�lido",
        "esperado express�o",									//"<fator> inv�lido",
        "esperado express�o",									//"<fator_> inv�lido",
        "esperado identificadorz",								//<identificador_fator> inv�lido"
    };
}
