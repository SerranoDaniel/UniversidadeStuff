/* A Bison parser, made by GNU Bison 3.0.4.  */

/* Bison implementation for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2015 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* C LALR(1) parser skeleton written by Richard Stallman, by
   simplifying the original so-called "semantic" parser.  */

/* All symbols defined below should begin with yy or YY, to avoid
   infringing on user name space.  This should be done even for local
   variables, as they might otherwise be expanded by user macros.
   There are some unavoidable exceptions within include files to
   define necessary library symbols; they are noted "INFRINGES ON
   USER NAME SPACE" below.  */

/* Identify Bison output.  */
#define YYBISON 1

/* Bison version.  */
#define YYBISON_VERSION "3.0.4"

/* Skeleton name.  */
#define YYSKELETON_NAME "yacc.c"

/* Pure parsers.  */
#define YYPURE 0

/* Push parsers.  */
#define YYPUSH 0

/* Pull parsers.  */
#define YYPULL 1




/* Copy the first part of user declarations.  */
#line 1 "yah.y" /* yacc.c:339  */

#include <stdio.h>
#include "yahh.h"

int yylex (void);
void yyerror (char const *);

#line 74 "parser.c" /* yacc.c:339  */

# ifndef YY_NULLPTR
#  if defined __cplusplus && 201103L <= __cplusplus
#   define YY_NULLPTR nullptr
#  else
#   define YY_NULLPTR 0
#  endif
# endif

/* Enabling verbose error messages.  */
#ifdef YYERROR_VERBOSE
# undef YYERROR_VERBOSE
# define YYERROR_VERBOSE 1
#else
# define YYERROR_VERBOSE 0
#endif

/* In a future release of Bison, this section will be replaced
   by #include "parser.h".  */
#ifndef YY_YY_PARSER_H_INCLUDED
# define YY_YY_PARSER_H_INCLUDED
/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 0
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Token type.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    NUM = 258,
    ID = 259,
    PRINT = 260,
    THEN = 261,
    DEFINE = 262,
    DO = 263,
    IF = 264,
    ELSE = 265,
    RETURN = 266,
    WHILE = 267,
    INPUT = 268,
    COMMA = 269,
    COLON = 270,
    SEMI = 271,
    LCBRACE = 272,
    RCBRACE = 273,
    LBRACKET = 274,
    RBRACKET = 275,
    LPAR = 276,
    RPAR = 277,
    BIGGERTHAN = 278,
    LESSTHAN = 279,
    ASSIGN = 280,
    AND = 281,
    OR = 282,
    NOT = 283,
    SUB = 284,
    DIV = 285,
    MUL = 286,
    POWEROF = 287,
    MOD = 288,
    ADD = 289,
    T_STRING = 290,
    T_INT = 291,
    T_FLOAT = 292,
    T_BOOL = 293,
    VOID = 294
  };
#endif
/* Tokens.  */
#define NUM 258
#define ID 259
#define PRINT 260
#define THEN 261
#define DEFINE 262
#define DO 263
#define IF 264
#define ELSE 265
#define RETURN 266
#define WHILE 267
#define INPUT 268
#define COMMA 269
#define COLON 270
#define SEMI 271
#define LCBRACE 272
#define RCBRACE 273
#define LBRACKET 274
#define RBRACKET 275
#define LPAR 276
#define RPAR 277
#define BIGGERTHAN 278
#define LESSTHAN 279
#define ASSIGN 280
#define AND 281
#define OR 282
#define NOT 283
#define SUB 284
#define DIV 285
#define MUL 286
#define POWEROF 287
#define MOD 288
#define ADD 289
#define T_STRING 290
#define T_INT 291
#define T_FLOAT 292
#define T_BOOL 293
#define VOID 294

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED

union YYSTYPE
{
#line 9 "yah.y" /* yacc.c:355  */

    double val;
    char *id;

    decls_t decls;
    decl_t decl;
    ids_t ids;
    typee_t typee;
    exp_t exp;
    argdefs_t argdefs;
    argdef_t argdef;
    stm_t stm;
    stms_t stms;
    args_t args;
    boolexp_t boolexp;


#line 210 "parser.c" /* yacc.c:355  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_PARSER_H_INCLUDED  */

/* Copy the second part of user declarations.  */

#line 227 "parser.c" /* yacc.c:358  */

#ifdef short
# undef short
#endif

#ifdef YYTYPE_UINT8
typedef YYTYPE_UINT8 yytype_uint8;
#else
typedef unsigned char yytype_uint8;
#endif

#ifdef YYTYPE_INT8
typedef YYTYPE_INT8 yytype_int8;
#else
typedef signed char yytype_int8;
#endif

#ifdef YYTYPE_UINT16
typedef YYTYPE_UINT16 yytype_uint16;
#else
typedef unsigned short int yytype_uint16;
#endif

#ifdef YYTYPE_INT16
typedef YYTYPE_INT16 yytype_int16;
#else
typedef short int yytype_int16;
#endif

#ifndef YYSIZE_T
# ifdef __SIZE_TYPE__
#  define YYSIZE_T __SIZE_TYPE__
# elif defined size_t
#  define YYSIZE_T size_t
# elif ! defined YYSIZE_T
#  include <stddef.h> /* INFRINGES ON USER NAME SPACE */
#  define YYSIZE_T size_t
# else
#  define YYSIZE_T unsigned int
# endif
#endif

#define YYSIZE_MAXIMUM ((YYSIZE_T) -1)

#ifndef YY_
# if defined YYENABLE_NLS && YYENABLE_NLS
#  if ENABLE_NLS
#   include <libintl.h> /* INFRINGES ON USER NAME SPACE */
#   define YY_(Msgid) dgettext ("bison-runtime", Msgid)
#  endif
# endif
# ifndef YY_
#  define YY_(Msgid) Msgid
# endif
#endif

#ifndef YY_ATTRIBUTE
# if (defined __GNUC__                                               \
      && (2 < __GNUC__ || (__GNUC__ == 2 && 96 <= __GNUC_MINOR__)))  \
     || defined __SUNPRO_C && 0x5110 <= __SUNPRO_C
#  define YY_ATTRIBUTE(Spec) __attribute__(Spec)
# else
#  define YY_ATTRIBUTE(Spec) /* empty */
# endif
#endif

#ifndef YY_ATTRIBUTE_PURE
# define YY_ATTRIBUTE_PURE   YY_ATTRIBUTE ((__pure__))
#endif

#ifndef YY_ATTRIBUTE_UNUSED
# define YY_ATTRIBUTE_UNUSED YY_ATTRIBUTE ((__unused__))
#endif

#if !defined _Noreturn \
     && (!defined __STDC_VERSION__ || __STDC_VERSION__ < 201112)
# if defined _MSC_VER && 1200 <= _MSC_VER
#  define _Noreturn __declspec (noreturn)
# else
#  define _Noreturn YY_ATTRIBUTE ((__noreturn__))
# endif
#endif

/* Suppress unused-variable warnings by "using" E.  */
#if ! defined lint || defined __GNUC__
# define YYUSE(E) ((void) (E))
#else
# define YYUSE(E) /* empty */
#endif

#if defined __GNUC__ && 407 <= __GNUC__ * 100 + __GNUC_MINOR__
/* Suppress an incorrect diagnostic about yylval being uninitialized.  */
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN \
    _Pragma ("GCC diagnostic push") \
    _Pragma ("GCC diagnostic ignored \"-Wuninitialized\"")\
    _Pragma ("GCC diagnostic ignored \"-Wmaybe-uninitialized\"")
# define YY_IGNORE_MAYBE_UNINITIALIZED_END \
    _Pragma ("GCC diagnostic pop")
#else
# define YY_INITIAL_VALUE(Value) Value
#endif
#ifndef YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_END
#endif
#ifndef YY_INITIAL_VALUE
# define YY_INITIAL_VALUE(Value) /* Nothing. */
#endif


#if ! defined yyoverflow || YYERROR_VERBOSE

/* The parser invokes alloca or malloc; define the necessary symbols.  */

# ifdef YYSTACK_USE_ALLOCA
#  if YYSTACK_USE_ALLOCA
#   ifdef __GNUC__
#    define YYSTACK_ALLOC __builtin_alloca
#   elif defined __BUILTIN_VA_ARG_INCR
#    include <alloca.h> /* INFRINGES ON USER NAME SPACE */
#   elif defined _AIX
#    define YYSTACK_ALLOC __alloca
#   elif defined _MSC_VER
#    include <malloc.h> /* INFRINGES ON USER NAME SPACE */
#    define alloca _alloca
#   else
#    define YYSTACK_ALLOC alloca
#    if ! defined _ALLOCA_H && ! defined EXIT_SUCCESS
#     include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
      /* Use EXIT_SUCCESS as a witness for stdlib.h.  */
#     ifndef EXIT_SUCCESS
#      define EXIT_SUCCESS 0
#     endif
#    endif
#   endif
#  endif
# endif

# ifdef YYSTACK_ALLOC
   /* Pacify GCC's 'empty if-body' warning.  */
#  define YYSTACK_FREE(Ptr) do { /* empty */; } while (0)
#  ifndef YYSTACK_ALLOC_MAXIMUM
    /* The OS might guarantee only one guard page at the bottom of the stack,
       and a page size can be as small as 4096 bytes.  So we cannot safely
       invoke alloca (N) if N exceeds 4096.  Use a slightly smaller number
       to allow for a few compiler-allocated temporary stack slots.  */
#   define YYSTACK_ALLOC_MAXIMUM 4032 /* reasonable circa 2006 */
#  endif
# else
#  define YYSTACK_ALLOC YYMALLOC
#  define YYSTACK_FREE YYFREE
#  ifndef YYSTACK_ALLOC_MAXIMUM
#   define YYSTACK_ALLOC_MAXIMUM YYSIZE_MAXIMUM
#  endif
#  if (defined __cplusplus && ! defined EXIT_SUCCESS \
       && ! ((defined YYMALLOC || defined malloc) \
             && (defined YYFREE || defined free)))
#   include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
#   ifndef EXIT_SUCCESS
#    define EXIT_SUCCESS 0
#   endif
#  endif
#  ifndef YYMALLOC
#   define YYMALLOC malloc
#   if ! defined malloc && ! defined EXIT_SUCCESS
void *malloc (YYSIZE_T); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
#  ifndef YYFREE
#   define YYFREE free
#   if ! defined free && ! defined EXIT_SUCCESS
void free (void *); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
# endif
#endif /* ! defined yyoverflow || YYERROR_VERBOSE */


#if (! defined yyoverflow \
     && (! defined __cplusplus \
         || (defined YYSTYPE_IS_TRIVIAL && YYSTYPE_IS_TRIVIAL)))

/* A type that is properly aligned for any stack member.  */
union yyalloc
{
  yytype_int16 yyss_alloc;
  YYSTYPE yyvs_alloc;
};

/* The size of the maximum gap between one aligned stack and the next.  */
# define YYSTACK_GAP_MAXIMUM (sizeof (union yyalloc) - 1)

/* The size of an array large to enough to hold all stacks, each with
   N elements.  */
# define YYSTACK_BYTES(N) \
     ((N) * (sizeof (yytype_int16) + sizeof (YYSTYPE)) \
      + YYSTACK_GAP_MAXIMUM)

# define YYCOPY_NEEDED 1

/* Relocate STACK from its old location to the new one.  The
   local variables YYSIZE and YYSTACKSIZE give the old and new number of
   elements in the stack, and YYPTR gives the new location of the
   stack.  Advance YYPTR to a properly aligned location for the next
   stack.  */
# define YYSTACK_RELOCATE(Stack_alloc, Stack)                           \
    do                                                                  \
      {                                                                 \
        YYSIZE_T yynewbytes;                                            \
        YYCOPY (&yyptr->Stack_alloc, Stack, yysize);                    \
        Stack = &yyptr->Stack_alloc;                                    \
        yynewbytes = yystacksize * sizeof (*Stack) + YYSTACK_GAP_MAXIMUM; \
        yyptr += yynewbytes / sizeof (*yyptr);                          \
      }                                                                 \
    while (0)

#endif

#if defined YYCOPY_NEEDED && YYCOPY_NEEDED
/* Copy COUNT objects from SRC to DST.  The source and destination do
   not overlap.  */
# ifndef YYCOPY
#  if defined __GNUC__ && 1 < __GNUC__
#   define YYCOPY(Dst, Src, Count) \
      __builtin_memcpy (Dst, Src, (Count) * sizeof (*(Src)))
#  else
#   define YYCOPY(Dst, Src, Count)              \
      do                                        \
        {                                       \
          YYSIZE_T yyi;                         \
          for (yyi = 0; yyi < (Count); yyi++)   \
            (Dst)[yyi] = (Src)[yyi];            \
        }                                       \
      while (0)
#  endif
# endif
#endif /* !YYCOPY_NEEDED */

/* YYFINAL -- State number of the termination state.  */
#define YYFINAL  9
/* YYLAST -- Last index in YYTABLE.  */
#define YYLAST   180

/* YYNTOKENS -- Number of terminals.  */
#define YYNTOKENS  40
/* YYNNTS -- Number of nonterminals.  */
#define YYNNTS  13
/* YYNRULES -- Number of rules.  */
#define YYNRULES  52
/* YYNSTATES -- Number of states.  */
#define YYNSTATES  127

/* YYTRANSLATE[YYX] -- Symbol number corresponding to YYX as returned
   by yylex, with out-of-bounds checking.  */
#define YYUNDEFTOK  2
#define YYMAXUTOK   294

#define YYTRANSLATE(YYX)                                                \
  ((unsigned int) (YYX) <= YYMAXUTOK ? yytranslate[YYX] : YYUNDEFTOK)

/* YYTRANSLATE[TOKEN-NUM] -- Symbol number corresponding to TOKEN-NUM
   as returned by yylex, without out-of-bounds checking.  */
static const yytype_uint8 yytranslate[] =
{
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39
};

#if YYDEBUG
  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
static const yytype_uint8 yyrline[] =
{
       0,   101,   101,   113,   114,   117,   118,   119,   120,   121,
     124,   125,   128,   132,   133,   136,   137,   138,   139,   140,
     142,   143,   146,   147,   148,   149,   150,   151,   152,   157,
     158,   162,   163,   164,   165,   166,   167,   168,   169,   170,
     171,   172,   173,   176,   177,   178,   179,   180,   181,   182,
     183,   184,   185
};
#endif

#if YYDEBUG || YYERROR_VERBOSE || 0
/* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
   First, the terminals, then, starting at YYNTOKENS, nonterminals.  */
static const char *const yytname[] =
{
  "$end", "error", "$undefined", "NUM", "ID", "PRINT", "THEN", "DEFINE",
  "DO", "IF", "ELSE", "RETURN", "WHILE", "INPUT", "COMMA", "COLON", "SEMI",
  "LCBRACE", "RCBRACE", "LBRACKET", "RBRACKET", "LPAR", "RPAR",
  "BIGGERTHAN", "LESSTHAN", "ASSIGN", "AND", "OR", "NOT", "SUB", "DIV",
  "MUL", "POWEROF", "MOD", "ADD", "T_STRING", "T_INT", "T_FLOAT", "T_BOOL",
  "VOID", "$accept", "prog", "decls", "decl", "argdefs", "argdef", "ids",
  "typee", "stms", "stm", "args", "exp", "boolexp", YY_NULLPTR
};
#endif

# ifdef YYPRINT
/* YYTOKNUM[NUM] -- (External) token number corresponding to the
   (internal) symbol number NUM (which must be that of a token).  */
static const yytype_uint16 yytoknum[] =
{
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,   276,   277,   278,   279,   280,   281,   282,   283,   284,
     285,   286,   287,   288,   289,   290,   291,   292,   293,   294
};
# endif

#define YYPACT_NINF -70

#define yypact_value_is_default(Yystate) \
  (!!((Yystate) == (-70)))

#define YYTABLE_NINF -14

#define yytable_value_is_error(Yytable_value) \
  0

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
static const yytype_int16 yypact[] =
{
       7,    -2,    21,    36,   -70,     7,    62,    43,   131,   -70,
     -70,   131,    38,   -70,   -70,   -70,   -70,   -70,   -70,    58,
      28,    44,    55,    29,    65,   -70,   -70,    54,   131,   131,
      80,    93,   -70,    88,    54,    74,   -70,   100,   131,   -70,
      51,   110,   -70,    54,    54,    54,    54,    54,    54,    89,
     102,    63,   -70,   104,    57,   -70,   130,   130,   130,   130,
     130,   130,    97,   106,     1,    54,     1,   113,   -70,   118,
      89,    91,    89,   -70,   -70,    54,   133,    54,   122,    35,
      99,    40,   134,   127,   -70,   -70,   139,   -70,   126,   130,
       5,    24,    31,   124,   141,     1,     1,   -70,   146,   143,
     -70,   155,   156,    54,   130,    54,   130,    54,    54,    89,
      87,    87,    89,   157,   -70,   -70,   130,   130,   130,   130,
     158,   159,   -70,   162,   163,   -70,   -70
};

  /* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
     Performed when YYTABLE does not specify something else to do.  Zero
     means the default is an error.  */
static const yytype_uint8 yydefact[] =
{
       0,    13,     0,     0,     2,     3,     0,     0,     0,     1,
       4,     0,     0,    14,    17,    15,    16,    18,    19,     0,
       0,     0,     0,     0,    10,     8,     5,     0,     0,     0,
       0,     0,    31,    32,     0,     0,    12,     0,     0,    11,
       0,     0,     7,     0,     0,     0,     0,     0,     0,     0,
       0,    32,    41,     0,    29,    39,    38,    34,    36,    35,
      37,    33,    32,     0,     0,     0,     0,     0,    22,     0,
      20,     0,     0,    40,    42,     0,     0,     0,    43,     0,
       0,     0,     0,     0,    21,    23,     0,    30,     0,    50,
       0,     0,     0,     0,     0,     0,     0,    26,     0,     0,
       6,     0,     0,     0,    44,     0,    45,     0,     0,     0,
      51,    52,     0,     0,     9,    24,    46,    47,    48,    49,
       0,     0,    25,     0,     0,    27,    28
};

  /* YYPGOTO[NTERM-NUM].  */
static const yytype_int16 yypgoto[] =
{
     -70,   -70,    10,   -70,   144,   -70,   167,    -5,   -69,   -70,
     105,   -27,   -64
};

  /* YYDEFGOTO[NTERM-NUM].  */
static const yytype_int8 yydefgoto[] =
{
      -1,     3,    68,     5,    23,    24,     6,    19,    69,    70,
      53,    71,    79
};

  /* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule whose
     number is the opposite.  If YYTABLE_NINF, syntax error.  */
static const yytype_int8 yytable[] =
{
      35,    84,    81,    86,    32,    33,    20,    41,    32,    33,
       4,     1,     7,    54,     2,    10,    56,    57,    58,    59,
      60,    61,    34,    36,    37,     8,    34,    32,    33,    77,
     103,   110,   111,    50,    32,    33,     9,    78,    80,    78,
     120,    94,    21,   121,    26,    34,    98,     1,    54,   105,
      89,    30,    34,    27,    32,    51,   107,    32,    33,    28,
      22,    95,    96,   104,   106,    56,    95,    96,    78,    78,
      29,    75,    34,    52,    25,    34,   116,    11,   117,    31,
     118,   119,    43,    12,    40,    73,    44,    45,    46,    47,
      42,    48,    32,    62,    63,    38,     2,    21,    64,    43,
      65,    66,    67,    44,    45,    46,    47,    85,    48,    40,
      34,     7,   -13,    95,    96,    97,    43,    49,    40,    72,
      44,    45,    46,    47,    43,    48,    74,    76,    44,    45,
      46,    47,    55,    48,    82,    43,    83,    88,    99,    44,
      45,    46,    47,   100,    48,    90,    91,    92,   102,   108,
      93,    44,    45,    46,    47,    43,    48,   101,   109,    44,
      45,    46,    47,   112,    48,   113,    14,    15,    16,    17,
      18,   114,   115,   122,    13,    39,   123,   124,   125,   126,
      87
};

static const yytype_uint8 yycheck[] =
{
      27,    70,    66,    72,     3,     4,    11,    34,     3,     4,
       0,     4,    14,    40,     7,     5,    43,    44,    45,    46,
      47,    48,    21,    28,    29,     4,    21,     3,     4,    28,
      25,    95,    96,    38,     3,     4,     0,    64,    65,    66,
     109,     6,     4,   112,    16,    21,     6,     4,    75,    25,
      77,    22,    21,    25,     3,     4,    25,     3,     4,    15,
      22,    26,    27,    90,    91,    92,    26,    27,    95,    96,
      15,    14,    21,    22,    16,    21,   103,    15,   105,    14,
     107,   108,    25,    21,    21,    22,    29,    30,    31,    32,
      16,    34,     3,     4,     5,    15,     7,     4,     9,    25,
      11,    12,    13,    29,    30,    31,    32,    16,    34,    21,
      21,    14,    15,    26,    27,    16,    25,    17,    21,    17,
      29,    30,    31,    32,    25,    34,    22,    21,    29,    30,
      31,    32,    22,    34,    21,    25,    18,     4,     4,    29,
      30,    31,    32,    16,    34,    23,    24,    25,    22,    25,
      28,    29,    30,    31,    32,    25,    34,    18,    17,    29,
      30,    31,    32,    17,    34,    22,    35,    36,    37,    38,
      39,    16,    16,    16,     7,    31,    18,    18,    16,    16,
      75
};

  /* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
static const yytype_uint8 yystos[] =
{
       0,     4,     7,    41,    42,    43,    46,    14,     4,     0,
      42,    15,    21,    46,    35,    36,    37,    38,    39,    47,
      47,     4,    22,    44,    45,    16,    16,    25,    15,    15,
      22,    14,     3,     4,    21,    51,    47,    47,    15,    44,
      21,    51,    16,    25,    29,    30,    31,    32,    34,    17,
      47,     4,    22,    50,    51,    22,    51,    51,    51,    51,
      51,    51,     4,     5,     9,    11,    12,    13,    42,    48,
      49,    51,    17,    22,    22,    14,    21,    28,    51,    52,
      51,    52,    21,    18,    48,    16,    48,    50,     4,    51,
      23,    24,    25,    28,     6,    26,    27,    16,     6,     4,
      16,    18,    22,    25,    51,    25,    51,    25,    25,    17,
      52,    52,    17,    22,    16,    16,    51,    51,    51,    51,
      48,    48,    16,    18,    18,    16,    16
};

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
static const yytype_uint8 yyr1[] =
{
       0,    40,    41,    42,    42,    43,    43,    43,    43,    43,
      44,    44,    45,    46,    46,    47,    47,    47,    47,    47,
      48,    48,    49,    49,    49,    49,    49,    49,    49,    50,
      50,    51,    51,    51,    51,    51,    51,    51,    51,    51,
      51,    51,    51,    52,    52,    52,    52,    52,    52,    52,
      52,    52,    52
};

  /* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
static const yytype_uint8 yyr2[] =
{
       0,     2,     1,     1,     2,     4,     9,     6,     4,    10,
       1,     3,     3,     1,     3,     1,     1,     1,     1,     1,
       1,     2,     1,     2,     5,     5,     3,     7,     7,     1,
       3,     1,     1,     3,     3,     3,     3,     3,     3,     3,
       4,     3,     4,     1,     3,     3,     4,     4,     4,     4,
       2,     3,     3
};


#define yyerrok         (yyerrstatus = 0)
#define yyclearin       (yychar = YYEMPTY)
#define YYEMPTY         (-2)
#define YYEOF           0

#define YYACCEPT        goto yyacceptlab
#define YYABORT         goto yyabortlab
#define YYERROR         goto yyerrorlab


#define YYRECOVERING()  (!!yyerrstatus)

#define YYBACKUP(Token, Value)                                  \
do                                                              \
  if (yychar == YYEMPTY)                                        \
    {                                                           \
      yychar = (Token);                                         \
      yylval = (Value);                                         \
      YYPOPSTACK (yylen);                                       \
      yystate = *yyssp;                                         \
      goto yybackup;                                            \
    }                                                           \
  else                                                          \
    {                                                           \
      yyerror (YY_("syntax error: cannot back up")); \
      YYERROR;                                                  \
    }                                                           \
while (0)

/* Error token number */
#define YYTERROR        1
#define YYERRCODE       256



/* Enable debugging if requested.  */
#if YYDEBUG

# ifndef YYFPRINTF
#  include <stdio.h> /* INFRINGES ON USER NAME SPACE */
#  define YYFPRINTF fprintf
# endif

# define YYDPRINTF(Args)                        \
do {                                            \
  if (yydebug)                                  \
    YYFPRINTF Args;                             \
} while (0)

/* This macro is provided for backward compatibility. */
#ifndef YY_LOCATION_PRINT
# define YY_LOCATION_PRINT(File, Loc) ((void) 0)
#endif


# define YY_SYMBOL_PRINT(Title, Type, Value, Location)                    \
do {                                                                      \
  if (yydebug)                                                            \
    {                                                                     \
      YYFPRINTF (stderr, "%s ", Title);                                   \
      yy_symbol_print (stderr,                                            \
                  Type, Value); \
      YYFPRINTF (stderr, "\n");                                           \
    }                                                                     \
} while (0)


/*----------------------------------------.
| Print this symbol's value on YYOUTPUT.  |
`----------------------------------------*/

static void
yy_symbol_value_print (FILE *yyoutput, int yytype, YYSTYPE const * const yyvaluep)
{
  FILE *yyo = yyoutput;
  YYUSE (yyo);
  if (!yyvaluep)
    return;
# ifdef YYPRINT
  if (yytype < YYNTOKENS)
    YYPRINT (yyoutput, yytoknum[yytype], *yyvaluep);
# endif
  YYUSE (yytype);
}


/*--------------------------------.
| Print this symbol on YYOUTPUT.  |
`--------------------------------*/

static void
yy_symbol_print (FILE *yyoutput, int yytype, YYSTYPE const * const yyvaluep)
{
  YYFPRINTF (yyoutput, "%s %s (",
             yytype < YYNTOKENS ? "token" : "nterm", yytname[yytype]);

  yy_symbol_value_print (yyoutput, yytype, yyvaluep);
  YYFPRINTF (yyoutput, ")");
}

/*------------------------------------------------------------------.
| yy_stack_print -- Print the state stack from its BOTTOM up to its |
| TOP (included).                                                   |
`------------------------------------------------------------------*/

static void
yy_stack_print (yytype_int16 *yybottom, yytype_int16 *yytop)
{
  YYFPRINTF (stderr, "Stack now");
  for (; yybottom <= yytop; yybottom++)
    {
      int yybot = *yybottom;
      YYFPRINTF (stderr, " %d", yybot);
    }
  YYFPRINTF (stderr, "\n");
}

# define YY_STACK_PRINT(Bottom, Top)                            \
do {                                                            \
  if (yydebug)                                                  \
    yy_stack_print ((Bottom), (Top));                           \
} while (0)


/*------------------------------------------------.
| Report that the YYRULE is going to be reduced.  |
`------------------------------------------------*/

static void
yy_reduce_print (yytype_int16 *yyssp, YYSTYPE *yyvsp, int yyrule)
{
  unsigned long int yylno = yyrline[yyrule];
  int yynrhs = yyr2[yyrule];
  int yyi;
  YYFPRINTF (stderr, "Reducing stack by rule %d (line %lu):\n",
             yyrule - 1, yylno);
  /* The symbols being reduced.  */
  for (yyi = 0; yyi < yynrhs; yyi++)
    {
      YYFPRINTF (stderr, "   $%d = ", yyi + 1);
      yy_symbol_print (stderr,
                       yystos[yyssp[yyi + 1 - yynrhs]],
                       &(yyvsp[(yyi + 1) - (yynrhs)])
                                              );
      YYFPRINTF (stderr, "\n");
    }
}

# define YY_REDUCE_PRINT(Rule)          \
do {                                    \
  if (yydebug)                          \
    yy_reduce_print (yyssp, yyvsp, Rule); \
} while (0)

/* Nonzero means print parse trace.  It is left uninitialized so that
   multiple parsers can coexist.  */
int yydebug;
#else /* !YYDEBUG */
# define YYDPRINTF(Args)
# define YY_SYMBOL_PRINT(Title, Type, Value, Location)
# define YY_STACK_PRINT(Bottom, Top)
# define YY_REDUCE_PRINT(Rule)
#endif /* !YYDEBUG */


/* YYINITDEPTH -- initial size of the parser's stacks.  */
#ifndef YYINITDEPTH
# define YYINITDEPTH 200
#endif

/* YYMAXDEPTH -- maximum size the stacks can grow to (effective only
   if the built-in stack extension method is used).

   Do not make this value too large; the results are undefined if
   YYSTACK_ALLOC_MAXIMUM < YYSTACK_BYTES (YYMAXDEPTH)
   evaluated with infinite-precision integer arithmetic.  */

#ifndef YYMAXDEPTH
# define YYMAXDEPTH 10000
#endif


#if YYERROR_VERBOSE

# ifndef yystrlen
#  if defined __GLIBC__ && defined _STRING_H
#   define yystrlen strlen
#  else
/* Return the length of YYSTR.  */
static YYSIZE_T
yystrlen (const char *yystr)
{
  YYSIZE_T yylen;
  for (yylen = 0; yystr[yylen]; yylen++)
    continue;
  return yylen;
}
#  endif
# endif

# ifndef yystpcpy
#  if defined __GLIBC__ && defined _STRING_H && defined _GNU_SOURCE
#   define yystpcpy stpcpy
#  else
/* Copy YYSRC to YYDEST, returning the address of the terminating '\0' in
   YYDEST.  */
static char *
yystpcpy (char *yydest, const char *yysrc)
{
  char *yyd = yydest;
  const char *yys = yysrc;

  while ((*yyd++ = *yys++) != '\0')
    continue;

  return yyd - 1;
}
#  endif
# endif

# ifndef yytnamerr
/* Copy to YYRES the contents of YYSTR after stripping away unnecessary
   quotes and backslashes, so that it's suitable for yyerror.  The
   heuristic is that double-quoting is unnecessary unless the string
   contains an apostrophe, a comma, or backslash (other than
   backslash-backslash).  YYSTR is taken from yytname.  If YYRES is
   null, do not copy; instead, return the length of what the result
   would have been.  */
static YYSIZE_T
yytnamerr (char *yyres, const char *yystr)
{
  if (*yystr == '"')
    {
      YYSIZE_T yyn = 0;
      char const *yyp = yystr;

      for (;;)
        switch (*++yyp)
          {
          case '\'':
          case ',':
            goto do_not_strip_quotes;

          case '\\':
            if (*++yyp != '\\')
              goto do_not_strip_quotes;
            /* Fall through.  */
          default:
            if (yyres)
              yyres[yyn] = *yyp;
            yyn++;
            break;

          case '"':
            if (yyres)
              yyres[yyn] = '\0';
            return yyn;
          }
    do_not_strip_quotes: ;
    }

  if (! yyres)
    return yystrlen (yystr);

  return yystpcpy (yyres, yystr) - yyres;
}
# endif

/* Copy into *YYMSG, which is of size *YYMSG_ALLOC, an error message
   about the unexpected token YYTOKEN for the state stack whose top is
   YYSSP.

   Return 0 if *YYMSG was successfully written.  Return 1 if *YYMSG is
   not large enough to hold the message.  In that case, also set
   *YYMSG_ALLOC to the required number of bytes.  Return 2 if the
   required number of bytes is too large to store.  */
static int
yysyntax_error (YYSIZE_T *yymsg_alloc, char **yymsg,
                yytype_int16 *yyssp, int yytoken)
{
  YYSIZE_T yysize0 = yytnamerr (YY_NULLPTR, yytname[yytoken]);
  YYSIZE_T yysize = yysize0;
  enum { YYERROR_VERBOSE_ARGS_MAXIMUM = 5 };
  /* Internationalized format string. */
  const char *yyformat = YY_NULLPTR;
  /* Arguments of yyformat. */
  char const *yyarg[YYERROR_VERBOSE_ARGS_MAXIMUM];
  /* Number of reported tokens (one for the "unexpected", one per
     "expected"). */
  int yycount = 0;

  /* There are many possibilities here to consider:
     - If this state is a consistent state with a default action, then
       the only way this function was invoked is if the default action
       is an error action.  In that case, don't check for expected
       tokens because there are none.
     - The only way there can be no lookahead present (in yychar) is if
       this state is a consistent state with a default action.  Thus,
       detecting the absence of a lookahead is sufficient to determine
       that there is no unexpected or expected token to report.  In that
       case, just report a simple "syntax error".
     - Don't assume there isn't a lookahead just because this state is a
       consistent state with a default action.  There might have been a
       previous inconsistent state, consistent state with a non-default
       action, or user semantic action that manipulated yychar.
     - Of course, the expected token list depends on states to have
       correct lookahead information, and it depends on the parser not
       to perform extra reductions after fetching a lookahead from the
       scanner and before detecting a syntax error.  Thus, state merging
       (from LALR or IELR) and default reductions corrupt the expected
       token list.  However, the list is correct for canonical LR with
       one exception: it will still contain any token that will not be
       accepted due to an error action in a later state.
  */
  if (yytoken != YYEMPTY)
    {
      int yyn = yypact[*yyssp];
      yyarg[yycount++] = yytname[yytoken];
      if (!yypact_value_is_default (yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative indexes in
             YYCHECK.  In other words, skip the first -YYN actions for
             this state because they are default actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST - yyn + 1;
          int yyxend = yychecklim < YYNTOKENS ? yychecklim : YYNTOKENS;
          int yyx;

          for (yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck[yyx + yyn] == yyx && yyx != YYTERROR
                && !yytable_value_is_error (yytable[yyx + yyn]))
              {
                if (yycount == YYERROR_VERBOSE_ARGS_MAXIMUM)
                  {
                    yycount = 1;
                    yysize = yysize0;
                    break;
                  }
                yyarg[yycount++] = yytname[yyx];
                {
                  YYSIZE_T yysize1 = yysize + yytnamerr (YY_NULLPTR, yytname[yyx]);
                  if (! (yysize <= yysize1
                         && yysize1 <= YYSTACK_ALLOC_MAXIMUM))
                    return 2;
                  yysize = yysize1;
                }
              }
        }
    }

  switch (yycount)
    {
# define YYCASE_(N, S)                      \
      case N:                               \
        yyformat = S;                       \
      break
      YYCASE_(0, YY_("syntax error"));
      YYCASE_(1, YY_("syntax error, unexpected %s"));
      YYCASE_(2, YY_("syntax error, unexpected %s, expecting %s"));
      YYCASE_(3, YY_("syntax error, unexpected %s, expecting %s or %s"));
      YYCASE_(4, YY_("syntax error, unexpected %s, expecting %s or %s or %s"));
      YYCASE_(5, YY_("syntax error, unexpected %s, expecting %s or %s or %s or %s"));
# undef YYCASE_
    }

  {
    YYSIZE_T yysize1 = yysize + yystrlen (yyformat);
    if (! (yysize <= yysize1 && yysize1 <= YYSTACK_ALLOC_MAXIMUM))
      return 2;
    yysize = yysize1;
  }

  if (*yymsg_alloc < yysize)
    {
      *yymsg_alloc = 2 * yysize;
      if (! (yysize <= *yymsg_alloc
             && *yymsg_alloc <= YYSTACK_ALLOC_MAXIMUM))
        *yymsg_alloc = YYSTACK_ALLOC_MAXIMUM;
      return 1;
    }

  /* Avoid sprintf, as that infringes on the user's name space.
     Don't have undefined behavior even if the translation
     produced a string with the wrong number of "%s"s.  */
  {
    char *yyp = *yymsg;
    int yyi = 0;
    while ((*yyp = *yyformat) != '\0')
      if (*yyp == '%' && yyformat[1] == 's' && yyi < yycount)
        {
          yyp += yytnamerr (yyp, yyarg[yyi++]);
          yyformat += 2;
        }
      else
        {
          yyp++;
          yyformat++;
        }
  }
  return 0;
}
#endif /* YYERROR_VERBOSE */

/*-----------------------------------------------.
| Release the memory associated to this symbol.  |
`-----------------------------------------------*/

static void
yydestruct (const char *yymsg, int yytype, YYSTYPE *yyvaluep)
{
  YYUSE (yyvaluep);
  if (!yymsg)
    yymsg = "Deleting";
  YY_SYMBOL_PRINT (yymsg, yytype, yyvaluep, yylocationp);

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  YYUSE (yytype);
  YY_IGNORE_MAYBE_UNINITIALIZED_END
}




/* The lookahead symbol.  */
int yychar;

/* The semantic value of the lookahead symbol.  */
YYSTYPE yylval;
/* Number of syntax errors so far.  */
int yynerrs;


/*----------.
| yyparse.  |
`----------*/

int
yyparse (void)
{
    int yystate;
    /* Number of tokens to shift before error messages enabled.  */
    int yyerrstatus;

    /* The stacks and their tools:
       'yyss': related to states.
       'yyvs': related to semantic values.

       Refer to the stacks through separate pointers, to allow yyoverflow
       to reallocate them elsewhere.  */

    /* The state stack.  */
    yytype_int16 yyssa[YYINITDEPTH];
    yytype_int16 *yyss;
    yytype_int16 *yyssp;

    /* The semantic value stack.  */
    YYSTYPE yyvsa[YYINITDEPTH];
    YYSTYPE *yyvs;
    YYSTYPE *yyvsp;

    YYSIZE_T yystacksize;

  int yyn;
  int yyresult;
  /* Lookahead token as an internal (translated) token number.  */
  int yytoken = 0;
  /* The variables used to return semantic value and location from the
     action routines.  */
  YYSTYPE yyval;

#if YYERROR_VERBOSE
  /* Buffer for error messages, and its allocated size.  */
  char yymsgbuf[128];
  char *yymsg = yymsgbuf;
  YYSIZE_T yymsg_alloc = sizeof yymsgbuf;
#endif

#define YYPOPSTACK(N)   (yyvsp -= (N), yyssp -= (N))

  /* The number of symbols on the RHS of the reduced rule.
     Keep to zero when no symbol should be popped.  */
  int yylen = 0;

  yyssp = yyss = yyssa;
  yyvsp = yyvs = yyvsa;
  yystacksize = YYINITDEPTH;

  YYDPRINTF ((stderr, "Starting parse\n"));

  yystate = 0;
  yyerrstatus = 0;
  yynerrs = 0;
  yychar = YYEMPTY; /* Cause a token to be read.  */
  goto yysetstate;

/*------------------------------------------------------------.
| yynewstate -- Push a new state, which is found in yystate.  |
`------------------------------------------------------------*/
 yynewstate:
  /* In all cases, when you get here, the value and location stacks
     have just been pushed.  So pushing a state here evens the stacks.  */
  yyssp++;

 yysetstate:
  *yyssp = yystate;

  if (yyss + yystacksize - 1 <= yyssp)
    {
      /* Get the current used size of the three stacks, in elements.  */
      YYSIZE_T yysize = yyssp - yyss + 1;

#ifdef yyoverflow
      {
        /* Give user a chance to reallocate the stack.  Use copies of
           these so that the &'s don't force the real ones into
           memory.  */
        YYSTYPE *yyvs1 = yyvs;
        yytype_int16 *yyss1 = yyss;

        /* Each stack pointer address is followed by the size of the
           data in use in that stack, in bytes.  This used to be a
           conditional around just the two extra args, but that might
           be undefined if yyoverflow is a macro.  */
        yyoverflow (YY_("memory exhausted"),
                    &yyss1, yysize * sizeof (*yyssp),
                    &yyvs1, yysize * sizeof (*yyvsp),
                    &yystacksize);

        yyss = yyss1;
        yyvs = yyvs1;
      }
#else /* no yyoverflow */
# ifndef YYSTACK_RELOCATE
      goto yyexhaustedlab;
# else
      /* Extend the stack our own way.  */
      if (YYMAXDEPTH <= yystacksize)
        goto yyexhaustedlab;
      yystacksize *= 2;
      if (YYMAXDEPTH < yystacksize)
        yystacksize = YYMAXDEPTH;

      {
        yytype_int16 *yyss1 = yyss;
        union yyalloc *yyptr =
          (union yyalloc *) YYSTACK_ALLOC (YYSTACK_BYTES (yystacksize));
        if (! yyptr)
          goto yyexhaustedlab;
        YYSTACK_RELOCATE (yyss_alloc, yyss);
        YYSTACK_RELOCATE (yyvs_alloc, yyvs);
#  undef YYSTACK_RELOCATE
        if (yyss1 != yyssa)
          YYSTACK_FREE (yyss1);
      }
# endif
#endif /* no yyoverflow */

      yyssp = yyss + yysize - 1;
      yyvsp = yyvs + yysize - 1;

      YYDPRINTF ((stderr, "Stack size increased to %lu\n",
                  (unsigned long int) yystacksize));

      if (yyss + yystacksize - 1 <= yyssp)
        YYABORT;
    }

  YYDPRINTF ((stderr, "Entering state %d\n", yystate));

  if (yystate == YYFINAL)
    YYACCEPT;

  goto yybackup;

/*-----------.
| yybackup.  |
`-----------*/
yybackup:

  /* Do appropriate processing given the current state.  Read a
     lookahead token if we need one and don't already have one.  */

  /* First try to decide what to do without reference to lookahead token.  */
  yyn = yypact[yystate];
  if (yypact_value_is_default (yyn))
    goto yydefault;

  /* Not known => get a lookahead token if don't already have one.  */

  /* YYCHAR is either YYEMPTY or YYEOF or a valid lookahead symbol.  */
  if (yychar == YYEMPTY)
    {
      YYDPRINTF ((stderr, "Reading a token: "));
      yychar = yylex ();
    }

  if (yychar <= YYEOF)
    {
      yychar = yytoken = YYEOF;
      YYDPRINTF ((stderr, "Now at end of input.\n"));
    }
  else
    {
      yytoken = YYTRANSLATE (yychar);
      YY_SYMBOL_PRINT ("Next token is", yytoken, &yylval, &yylloc);
    }

  /* If the proper action on seeing token YYTOKEN is to reduce or to
     detect an error, take that action.  */
  yyn += yytoken;
  if (yyn < 0 || YYLAST < yyn || yycheck[yyn] != yytoken)
    goto yydefault;
  yyn = yytable[yyn];
  if (yyn <= 0)
    {
      if (yytable_value_is_error (yyn))
        goto yyerrlab;
      yyn = -yyn;
      goto yyreduce;
    }

  /* Count tokens shifted since error; after three, turn off error
     status.  */
  if (yyerrstatus)
    yyerrstatus--;

  /* Shift the lookahead token.  */
  YY_SYMBOL_PRINT ("Shifting", yytoken, &yylval, &yylloc);

  /* Discard the shifted token.  */
  yychar = YYEMPTY;

  yystate = yyn;
  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END

  goto yynewstate;


/*-----------------------------------------------------------.
| yydefault -- do the default action for the current state.  |
`-----------------------------------------------------------*/
yydefault:
  yyn = yydefact[yystate];
  if (yyn == 0)
    goto yyerrlab;
  goto yyreduce;


/*-----------------------------.
| yyreduce -- Do a reduction.  |
`-----------------------------*/
yyreduce:
  /* yyn is the number of a rule to reduce with.  */
  yylen = yyr2[yyn];

  /* If YYLEN is nonzero, implement the default value of the action:
     '$$ = $1'.

     Otherwise, the following line sets YYVAL to garbage.
     This behavior is undocumented and Bison
     users should not rely upon it.  Assigning to YYVAL
     unconditionally makes the parser a bit smaller, and it avoids a
     GCC warning that YYVAL may be used uninitialized.  */
  yyval = yyvsp[1-yylen];


  YY_REDUCE_PRINT (yyn);
  switch (yyn)
    {
        case 2:
#line 101 "yah.y" /* yacc.c:1646  */
    { 

			printf("SYMBOL TABLE\n");
			struct node *l= list_new();
			decls_list((yyvsp[0].decls),l);
			printf("\n\n\n");
			printf("Codigo em C do programa original\n");
			printf("#include <stdlib.h>\n#include <stdio.h>\n#include <string.h>\n");
			decls_print((yyvsp[0].decls));
			}
#line 1402 "parser.c" /* yacc.c:1646  */
    break;

  case 3:
#line 113 "yah.y" /* yacc.c:1646  */
    { (yyval.decls) = 	decls_solo((yyvsp[0].decl)); }
#line 1408 "parser.c" /* yacc.c:1646  */
    break;

  case 4:
#line 114 "yah.y" /* yacc.c:1646  */
    {  (yyval.decls) = decls_recursive((yyvsp[-1].decl),(yyvsp[0].decls)); }
#line 1414 "parser.c" /* yacc.c:1646  */
    break;

  case 5:
#line 117 "yah.y" /* yacc.c:1646  */
    {(yyval.decl) = decl_id((yyvsp[-3].ids),(yyvsp[-1].typee));}
#line 1420 "parser.c" /* yacc.c:1646  */
    break;

  case 6:
#line 118 "yah.y" /* yacc.c:1646  */
    { (yyval.decl) = decl_function((yyvsp[-8].ids),(yyvsp[-4].typee),(yyvsp[-2].stms)); }
#line 1426 "parser.c" /* yacc.c:1646  */
    break;

  case 7:
#line 119 "yah.y" /* yacc.c:1646  */
    { (yyval.decl) = decl_assign((yyvsp[-5].ids),(yyvsp[-3].typee),(yyvsp[-1].exp));}
#line 1432 "parser.c" /* yacc.c:1646  */
    break;

  case 8:
#line 120 "yah.y" /* yacc.c:1646  */
    { (yyval.decl) = decl_define((yyvsp[-2].id),(yyvsp[-1].typee));}
#line 1438 "parser.c" /* yacc.c:1646  */
    break;

  case 9:
#line 121 "yah.y" /* yacc.c:1646  */
    { (yyval.decl) = decl_argdef((yyvsp[-9].ids),(yyvsp[-7].argdefs),(yyvsp[-4].typee),(yyvsp[-2].stms));}
#line 1444 "parser.c" /* yacc.c:1646  */
    break;

  case 10:
#line 124 "yah.y" /* yacc.c:1646  */
    { (yyval.argdefs) = argdefs_unico((yyvsp[0].argdef));}
#line 1450 "parser.c" /* yacc.c:1646  */
    break;

  case 11:
#line 125 "yah.y" /* yacc.c:1646  */
    { (yyval.argdefs) = argdefs_double((yyvsp[-2].argdef),(yyvsp[0].argdefs));}
#line 1456 "parser.c" /* yacc.c:1646  */
    break;

  case 12:
#line 128 "yah.y" /* yacc.c:1646  */
    { (yyval.argdef) = argdef_unique((yyvsp[-2].id),(yyvsp[0].typee));}
#line 1462 "parser.c" /* yacc.c:1646  */
    break;

  case 13:
#line 132 "yah.y" /* yacc.c:1646  */
    { (yyval.ids) = ids_solo((yyvsp[0].id));}
#line 1468 "parser.c" /* yacc.c:1646  */
    break;

  case 14:
#line 133 "yah.y" /* yacc.c:1646  */
    { (yyval.ids) = ids_recursive((yyvsp[-2].id),(yyvsp[0].ids));}
#line 1474 "parser.c" /* yacc.c:1646  */
    break;

  case 15:
#line 136 "yah.y" /* yacc.c:1646  */
    { (yyval.typee) = type_int();}
#line 1480 "parser.c" /* yacc.c:1646  */
    break;

  case 16:
#line 137 "yah.y" /* yacc.c:1646  */
    { (yyval.typee) = type_float();}
#line 1486 "parser.c" /* yacc.c:1646  */
    break;

  case 17:
#line 138 "yah.y" /* yacc.c:1646  */
    { (yyval.typee) = type_string();}
#line 1492 "parser.c" /* yacc.c:1646  */
    break;

  case 18:
#line 139 "yah.y" /* yacc.c:1646  */
    { (yyval.typee) = type_bool();}
#line 1498 "parser.c" /* yacc.c:1646  */
    break;

  case 19:
#line 140 "yah.y" /* yacc.c:1646  */
    { (yyval.typee) = type_void();}
#line 1504 "parser.c" /* yacc.c:1646  */
    break;

  case 20:
#line 142 "yah.y" /* yacc.c:1646  */
    { (yyval.stms) = stms_unique((yyvsp[0].stm));}
#line 1510 "parser.c" /* yacc.c:1646  */
    break;

  case 21:
#line 143 "yah.y" /* yacc.c:1646  */
    { (yyval.stms) = stms_doublee((yyvsp[-1].stm),(yyvsp[0].stms));}
#line 1516 "parser.c" /* yacc.c:1646  */
    break;

  case 22:
#line 146 "yah.y" /* yacc.c:1646  */
    { (yyval.stm) = stm_decls((yyvsp[0].decls));}
#line 1522 "parser.c" /* yacc.c:1646  */
    break;

  case 23:
#line 147 "yah.y" /* yacc.c:1646  */
    { (yyval.stm) = stm_exp((yyvsp[-1].exp));}
#line 1528 "parser.c" /* yacc.c:1646  */
    break;

  case 24:
#line 148 "yah.y" /* yacc.c:1646  */
    { (yyval.stm) = stm_printa((yyvsp[-2].id));}
#line 1534 "parser.c" /* yacc.c:1646  */
    break;

  case 25:
#line 149 "yah.y" /* yacc.c:1646  */
    { (yyval.stm) = stm_input((yyvsp[-2].id));}
#line 1540 "parser.c" /* yacc.c:1646  */
    break;

  case 26:
#line 150 "yah.y" /* yacc.c:1646  */
    { (yyval.stm) = stm_return((yyvsp[-1].exp));}
#line 1546 "parser.c" /* yacc.c:1646  */
    break;

  case 27:
#line 151 "yah.y" /* yacc.c:1646  */
    { (yyval.stm) = stm_if((yyvsp[-5].boolexp),(yyvsp[-2].stms));}
#line 1552 "parser.c" /* yacc.c:1646  */
    break;

  case 28:
#line 152 "yah.y" /* yacc.c:1646  */
    { (yyval.stm) = stm_while((yyvsp[-5].boolexp),(yyvsp[-2].stms));}
#line 1558 "parser.c" /* yacc.c:1646  */
    break;

  case 29:
#line 157 "yah.y" /* yacc.c:1646  */
    { (yyval.args) = args_unique((yyvsp[0].exp));}
#line 1564 "parser.c" /* yacc.c:1646  */
    break;

  case 30:
#line 158 "yah.y" /* yacc.c:1646  */
    { (yyval.args) = args_doublee((yyvsp[-2].exp),(yyvsp[0].args));}
#line 1570 "parser.c" /* yacc.c:1646  */
    break;

  case 31:
#line 162 "yah.y" /* yacc.c:1646  */
    { (yyval.exp) = exp_num((yyvsp[0].val));}
#line 1576 "parser.c" /* yacc.c:1646  */
    break;

  case 32:
#line 163 "yah.y" /* yacc.c:1646  */
    { (yyval.exp) = exp_id((yyvsp[0].id));}
#line 1582 "parser.c" /* yacc.c:1646  */
    break;

  case 33:
#line 164 "yah.y" /* yacc.c:1646  */
    { (yyval.exp) = exp_binop("+",(yyvsp[-2].exp),(yyvsp[0].exp));}
#line 1588 "parser.c" /* yacc.c:1646  */
    break;

  case 34:
#line 165 "yah.y" /* yacc.c:1646  */
    { (yyval.exp) = exp_binop("-",(yyvsp[-2].exp),(yyvsp[0].exp));}
#line 1594 "parser.c" /* yacc.c:1646  */
    break;

  case 35:
#line 166 "yah.y" /* yacc.c:1646  */
    { (yyval.exp) = exp_binop("*",(yyvsp[-2].exp),(yyvsp[0].exp));}
#line 1600 "parser.c" /* yacc.c:1646  */
    break;

  case 36:
#line 167 "yah.y" /* yacc.c:1646  */
    { (yyval.exp) = exp_binop("/",(yyvsp[-2].exp),(yyvsp[0].exp));}
#line 1606 "parser.c" /* yacc.c:1646  */
    break;

  case 37:
#line 168 "yah.y" /* yacc.c:1646  */
    { (yyval.exp) = exp_binop("^",(yyvsp[-2].exp),(yyvsp[0].exp));}
#line 1612 "parser.c" /* yacc.c:1646  */
    break;

  case 38:
#line 169 "yah.y" /* yacc.c:1646  */
    { (yyval.exp) = exp_binop("=",(yyvsp[-2].exp),(yyvsp[0].exp));}
#line 1618 "parser.c" /* yacc.c:1646  */
    break;

  case 39:
#line 170 "yah.y" /* yacc.c:1646  */
    { (yyval.exp) = exp_expe((yyvsp[-1].exp));}
#line 1624 "parser.c" /* yacc.c:1646  */
    break;

  case 40:
#line 171 "yah.y" /* yacc.c:1646  */
    { (yyval.exp) = exp_funcao((yyvsp[-3].id),(yyvsp[-1].id));}
#line 1630 "parser.c" /* yacc.c:1646  */
    break;

  case 41:
#line 172 "yah.y" /* yacc.c:1646  */
    { (yyval.exp) = exp_name((yyvsp[-2].id));}
#line 1636 "parser.c" /* yacc.c:1646  */
    break;

  case 42:
#line 173 "yah.y" /* yacc.c:1646  */
    { (yyval.exp) = exp_args((yyvsp[-3].id),(yyvsp[-1].args));}
#line 1642 "parser.c" /* yacc.c:1646  */
    break;

  case 43:
#line 176 "yah.y" /* yacc.c:1646  */
    { (yyval.boolexp) = boolexp_unique((yyvsp[0].exp));}
#line 1648 "parser.c" /* yacc.c:1646  */
    break;

  case 44:
#line 177 "yah.y" /* yacc.c:1646  */
    { (yyval.boolexp) = boolexp_binop(">",(yyvsp[-2].exp),(yyvsp[0].exp));}
#line 1654 "parser.c" /* yacc.c:1646  */
    break;

  case 45:
#line 178 "yah.y" /* yacc.c:1646  */
    { (yyval.boolexp) = boolexp_binop("<",(yyvsp[-2].exp),(yyvsp[0].exp));}
#line 1660 "parser.c" /* yacc.c:1646  */
    break;

  case 46:
#line 179 "yah.y" /* yacc.c:1646  */
    { (yyval.boolexp) = boolexp_duplo(">","=",(yyvsp[-3].exp),(yyvsp[0].exp));}
#line 1666 "parser.c" /* yacc.c:1646  */
    break;

  case 47:
#line 180 "yah.y" /* yacc.c:1646  */
    { (yyval.boolexp) = boolexp_duplo("<","=",(yyvsp[-3].exp),(yyvsp[0].exp));}
#line 1672 "parser.c" /* yacc.c:1646  */
    break;

  case 48:
#line 181 "yah.y" /* yacc.c:1646  */
    { (yyval.boolexp) = boolexp_duplo("=","=",(yyvsp[-3].exp),(yyvsp[0].exp));}
#line 1678 "parser.c" /* yacc.c:1646  */
    break;

  case 49:
#line 182 "yah.y" /* yacc.c:1646  */
    { (yyval.boolexp) = boolexp_duplo("!","=",(yyvsp[-3].exp),(yyvsp[0].exp));}
#line 1684 "parser.c" /* yacc.c:1646  */
    break;

  case 50:
#line 183 "yah.y" /* yacc.c:1646  */
    { (yyval.boolexp) = boolexp_unop("-",(yyvsp[0].exp));}
#line 1690 "parser.c" /* yacc.c:1646  */
    break;

  case 51:
#line 184 "yah.y" /* yacc.c:1646  */
    { (yyval.boolexp) = boolexp_boolexp_and((yyvsp[-2].boolexp),(yyvsp[0].boolexp));}
#line 1696 "parser.c" /* yacc.c:1646  */
    break;

  case 52:
#line 185 "yah.y" /* yacc.c:1646  */
    { (yyval.boolexp) = boolexp_boolexp_or((yyvsp[-2].boolexp),(yyvsp[0].boolexp));}
#line 1702 "parser.c" /* yacc.c:1646  */
    break;


#line 1706 "parser.c" /* yacc.c:1646  */
      default: break;
    }
  /* User semantic actions sometimes alter yychar, and that requires
     that yytoken be updated with the new translation.  We take the
     approach of translating immediately before every use of yytoken.
     One alternative is translating here after every semantic action,
     but that translation would be missed if the semantic action invokes
     YYABORT, YYACCEPT, or YYERROR immediately after altering yychar or
     if it invokes YYBACKUP.  In the case of YYABORT or YYACCEPT, an
     incorrect destructor might then be invoked immediately.  In the
     case of YYERROR or YYBACKUP, subsequent parser actions might lead
     to an incorrect destructor call or verbose syntax error message
     before the lookahead is translated.  */
  YY_SYMBOL_PRINT ("-> $$ =", yyr1[yyn], &yyval, &yyloc);

  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);

  *++yyvsp = yyval;

  /* Now 'shift' the result of the reduction.  Determine what state
     that goes to, based on the state we popped back to and the rule
     number reduced by.  */

  yyn = yyr1[yyn];

  yystate = yypgoto[yyn - YYNTOKENS] + *yyssp;
  if (0 <= yystate && yystate <= YYLAST && yycheck[yystate] == *yyssp)
    yystate = yytable[yystate];
  else
    yystate = yydefgoto[yyn - YYNTOKENS];

  goto yynewstate;


/*--------------------------------------.
| yyerrlab -- here on detecting error.  |
`--------------------------------------*/
yyerrlab:
  /* Make sure we have latest lookahead translation.  See comments at
     user semantic actions for why this is necessary.  */
  yytoken = yychar == YYEMPTY ? YYEMPTY : YYTRANSLATE (yychar);

  /* If not already recovering from an error, report this error.  */
  if (!yyerrstatus)
    {
      ++yynerrs;
#if ! YYERROR_VERBOSE
      yyerror (YY_("syntax error"));
#else
# define YYSYNTAX_ERROR yysyntax_error (&yymsg_alloc, &yymsg, \
                                        yyssp, yytoken)
      {
        char const *yymsgp = YY_("syntax error");
        int yysyntax_error_status;
        yysyntax_error_status = YYSYNTAX_ERROR;
        if (yysyntax_error_status == 0)
          yymsgp = yymsg;
        else if (yysyntax_error_status == 1)
          {
            if (yymsg != yymsgbuf)
              YYSTACK_FREE (yymsg);
            yymsg = (char *) YYSTACK_ALLOC (yymsg_alloc);
            if (!yymsg)
              {
                yymsg = yymsgbuf;
                yymsg_alloc = sizeof yymsgbuf;
                yysyntax_error_status = 2;
              }
            else
              {
                yysyntax_error_status = YYSYNTAX_ERROR;
                yymsgp = yymsg;
              }
          }
        yyerror (yymsgp);
        if (yysyntax_error_status == 2)
          goto yyexhaustedlab;
      }
# undef YYSYNTAX_ERROR
#endif
    }



  if (yyerrstatus == 3)
    {
      /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

      if (yychar <= YYEOF)
        {
          /* Return failure if at end of input.  */
          if (yychar == YYEOF)
            YYABORT;
        }
      else
        {
          yydestruct ("Error: discarding",
                      yytoken, &yylval);
          yychar = YYEMPTY;
        }
    }

  /* Else will try to reuse lookahead token after shifting the error
     token.  */
  goto yyerrlab1;


/*---------------------------------------------------.
| yyerrorlab -- error raised explicitly by YYERROR.  |
`---------------------------------------------------*/
yyerrorlab:

  /* Pacify compilers like GCC when the user code never invokes
     YYERROR and the label yyerrorlab therefore never appears in user
     code.  */
  if (/*CONSTCOND*/ 0)
     goto yyerrorlab;

  /* Do not reclaim the symbols of the rule whose action triggered
     this YYERROR.  */
  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);
  yystate = *yyssp;
  goto yyerrlab1;


/*-------------------------------------------------------------.
| yyerrlab1 -- common code for both syntax error and YYERROR.  |
`-------------------------------------------------------------*/
yyerrlab1:
  yyerrstatus = 3;      /* Each real token shifted decrements this.  */

  for (;;)
    {
      yyn = yypact[yystate];
      if (!yypact_value_is_default (yyn))
        {
          yyn += YYTERROR;
          if (0 <= yyn && yyn <= YYLAST && yycheck[yyn] == YYTERROR)
            {
              yyn = yytable[yyn];
              if (0 < yyn)
                break;
            }
        }

      /* Pop the current state because it cannot handle the error token.  */
      if (yyssp == yyss)
        YYABORT;


      yydestruct ("Error: popping",
                  yystos[yystate], yyvsp);
      YYPOPSTACK (1);
      yystate = *yyssp;
      YY_STACK_PRINT (yyss, yyssp);
    }

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END


  /* Shift the error token.  */
  YY_SYMBOL_PRINT ("Shifting", yystos[yyn], yyvsp, yylsp);

  yystate = yyn;
  goto yynewstate;


/*-------------------------------------.
| yyacceptlab -- YYACCEPT comes here.  |
`-------------------------------------*/
yyacceptlab:
  yyresult = 0;
  goto yyreturn;

/*-----------------------------------.
| yyabortlab -- YYABORT comes here.  |
`-----------------------------------*/
yyabortlab:
  yyresult = 1;
  goto yyreturn;

#if !defined yyoverflow || YYERROR_VERBOSE
/*-------------------------------------------------.
| yyexhaustedlab -- memory exhaustion comes here.  |
`-------------------------------------------------*/
yyexhaustedlab:
  yyerror (YY_("memory exhausted"));
  yyresult = 2;
  /* Fall through.  */
#endif

yyreturn:
  if (yychar != YYEMPTY)
    {
      /* Make sure we have latest lookahead translation.  See comments at
         user semantic actions for why this is necessary.  */
      yytoken = YYTRANSLATE (yychar);
      yydestruct ("Cleanup: discarding lookahead",
                  yytoken, &yylval);
    }
  /* Do not reclaim the symbols of the rule whose action triggered
     this YYABORT or YYACCEPT.  */
  YYPOPSTACK (yylen);
  YY_STACK_PRINT (yyss, yyssp);
  while (yyssp != yyss)
    {
      yydestruct ("Cleanup: popping",
                  yystos[*yyssp], yyvsp);
      YYPOPSTACK (1);
    }
#ifndef yyoverflow
  if (yyss != yyssa)
    YYSTACK_FREE (yyss);
#endif
#if YYERROR_VERBOSE
  if (yymsg != yymsgbuf)
    YYSTACK_FREE (yymsg);
#endif
  return yyresult;
}
#line 188 "yah.y" /* yacc.c:1906  */

	
/* Called by yyparse on error.  */
void yyerror (char const *s)
	{
	    fprintf (stderr, "%s\n", s);
	}

int main (void)
{
    return yyparse();
}
