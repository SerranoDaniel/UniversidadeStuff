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
#line 1 "yalang.y" /* yacc.c:339  */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "yalang.h"

int yylex (void);	
void yyerror (char const *);

#line 76 "parser.c" /* yacc.c:339  */

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
    ID = 258,
    INTLIT = 259,
    FLOATLIT = 260,
    STRINGLIT = 261,
    BOOLLIT = 262,
    T_INT = 263,
    T_FLOAT = 264,
    T_STRING = 265,
    T_BOOL = 266,
    VOID = 267,
    DEFINE = 268,
    RETURN = 269,
    STRUCT = 270,
    WHILE = 271,
    IF = 272,
    THEN = 273,
    DO = 274,
    PRINT = 275,
    INPUT = 276,
    ELSE = 277,
    BREAK = 278,
    NEXT = 279,
    COLON = 280,
    ASSIGN = 281,
    COMMA = 282,
    SEMI = 283,
    INV_COMMA = 284,
    OR = 285,
    AND = 286,
    NOT = 287,
    MOD = 288,
    EQ_OP = 289,
    NE_OP = 290,
    GET_OP = 291,
    LET_OP = 292,
    GT_OP = 293,
    LT_OP = 294,
    SUB = 295,
    ADD = 296,
    MUL = 297,
    DIV = 298,
    POW = 299,
    LCPAR = 300,
    RCPAR = 301,
    LRPAR = 302,
    RRPAR = 303,
    LPAR = 304,
    RPAR = 305
  };
#endif
/* Tokens.  */
#define ID 258
#define INTLIT 259
#define FLOATLIT 260
#define STRINGLIT 261
#define BOOLLIT 262
#define T_INT 263
#define T_FLOAT 264
#define T_STRING 265
#define T_BOOL 266
#define VOID 267
#define DEFINE 268
#define RETURN 269
#define STRUCT 270
#define WHILE 271
#define IF 272
#define THEN 273
#define DO 274
#define PRINT 275
#define INPUT 276
#define ELSE 277
#define BREAK 278
#define NEXT 279
#define COLON 280
#define ASSIGN 281
#define COMMA 282
#define SEMI 283
#define INV_COMMA 284
#define OR 285
#define AND 286
#define NOT 287
#define MOD 288
#define EQ_OP 289
#define NE_OP 290
#define GET_OP 291
#define LET_OP 292
#define GT_OP 293
#define LT_OP 294
#define SUB 295
#define ADD 296
#define MUL 297
#define DIV 298
#define POW 299
#define LCPAR 300
#define RCPAR 301
#define LRPAR 302
#define RRPAR 303
#define LPAR 304
#define RPAR 305

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED

union YYSTYPE
{
#line 11 "yalang.y" /* yacc.c:355  */

	int ival;
    float fval;
    char *id;
    char *sval;
    int bval;

struct ya_t_decls_ 		*ya_t_decls;
struct ya_t_decl_ 		*ya_t_decl;
struct ya_t_argdefs_ 	*ya_t_argdefs;
struct ya_t_argdef_ 	*ya_t_argdef;
struct ya_t_stmts_ 		*ya_t_stmts;
struct ya_t_stmt_ 		*ya_t_stmt;
struct ya_t_ids_ 		*ya_t_ids;
struct ya_t_type_ 		*ya_t_type;
struct ya_t_exp_ 		*ya_t_exp;

#line 234 "parser.c" /* yacc.c:355  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_PARSER_H_INCLUDED  */

/* Copy the second part of user declarations.  */

#line 251 "parser.c" /* yacc.c:358  */

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
#define YYFINAL  10
/* YYLAST -- Last index in YYTABLE.  */
#define YYLAST   248

/* YYNTOKENS -- Number of terminals.  */
#define YYNTOKENS  51
/* YYNNTS -- Number of nonterminals.  */
#define YYNNTS  11
/* YYNRULES -- Number of rules.  */
#define YYNRULES  47
/* YYNSTATES -- Number of states.  */
#define YYNSTATES  118

/* YYTRANSLATE[YYX] -- Symbol number corresponding to YYX as returned
   by yylex, with out-of-bounds checking.  */
#define YYUNDEFTOK  2
#define YYMAXUTOK   305

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
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,    48,    49,    50
};

#if YYDEBUG
  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
static const yytype_uint8 yyrline[] =
{
       0,    77,    77,    80,    81,    84,    85,    86,    87,    88,
      91,    92,    95,    98,    99,   102,   103,   104,   105,   106,
     107,   108,   109,   110,   114,   115,   118,   119,   120,   121,
     122,   125,   126,   127,   128,   129,   131,   132,   133,   134,
     136,   137,   138,   139,   140,   141,   143,   144
};
#endif

#if YYDEBUG || YYERROR_VERBOSE || 0
/* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
   First, the terminals, then, starting at YYNTOKENS, nonterminals.  */
static const char *const yytname[] =
{
  "$end", "error", "$undefined", "ID", "INTLIT", "FLOATLIT", "STRINGLIT",
  "BOOLLIT", "T_INT", "T_FLOAT", "T_STRING", "T_BOOL", "VOID", "DEFINE",
  "RETURN", "STRUCT", "WHILE", "IF", "THEN", "DO", "PRINT", "INPUT",
  "ELSE", "BREAK", "NEXT", "COLON", "ASSIGN", "COMMA", "SEMI", "INV_COMMA",
  "OR", "AND", "NOT", "MOD", "EQ_OP", "NE_OP", "GET_OP", "LET_OP", "GT_OP",
  "LT_OP", "SUB", "ADD", "MUL", "DIV", "POW", "LCPAR", "RCPAR", "LRPAR",
  "RRPAR", "LPAR", "RPAR", "$accept", "program", "decls", "decl",
  "argdefs", "argdef", "stmts", "stmt", "ids", "type", "exp", YY_NULLPTR
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
     285,   286,   287,   288,   289,   290,   291,   292,   293,   294,
     295,   296,   297,   298,   299,   300,   301,   302,   303,   304,
     305
};
# endif

#define YYPACT_NINF -62

#define yypact_value_is_default(Yystate) \
  (!!((Yystate) == (-62)))

#define YYTABLE_NINF -1

#define yytable_value_is_error(Yytable_value) \
  (!!((Yytable_value) == (-1)))

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
static const yytype_int16 yypact[] =
{
      38,   -10,     6,    60,   -62,    38,    17,    69,     5,    67,
     -62,   -62,    67,    70,   -62,    73,    74,    50,    75,   -62,
     -62,   -62,   -62,   -62,    76,    55,    67,    67,    78,   102,
     -62,     7,   -62,   -62,    56,    67,   -62,    59,   -62,   -62,
     -62,   -62,     7,   115,    93,    66,     7,    81,   -62,     7,
       7,     7,     7,     7,     7,     7,     7,     7,     7,    31,
       7,     7,     7,     7,     7,   -62,    79,    93,    93,    98,
     -62,   205,   205,   205,   205,   205,   205,    42,    42,   -62,
     -62,     7,    -2,   131,   147,    52,    27,   163,   179,    84,
     -62,    80,   -62,   195,    -9,   -62,   -62,    82,    83,   -62,
     -62,   -62,   101,   -62,    93,    93,   -62,    96,    99,   116,
      24,   -62,    85,   -62,    93,   100,   119,   -62
};

  /* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
     Performed when YYTABLE does not specify something else to do.  Zero
     means the default is an error.  */
static const yytype_uint8 yydefact[] =
{
       0,    24,     0,     0,     2,     3,     0,     0,     0,     0,
       1,     4,     0,    24,    25,     0,     0,     0,    10,    26,
      27,    28,    29,    30,     0,     0,     0,     0,     0,     0,
       9,     0,     5,    12,     0,     0,    11,    35,    31,    33,
      32,    34,     0,     0,     0,     0,     0,     0,     6,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,    24,
       0,     0,     0,     0,     0,    15,     0,    13,     0,     0,
      46,    40,    45,    44,    43,    42,    41,    37,    36,    38,
      39,     0,     0,     0,     0,     0,     0,     0,     0,     0,
      14,     0,    47,     0,    35,    16,    21,     0,     0,    22,
      23,     7,     0,    17,     0,     0,     8,     0,     0,     0,
       0,    20,     0,    18,     0,     0,     0,    19
};

  /* YYPGOTO[NTERM-NUM].  */
static const yytype_int16 yypgoto[] =
{
     -62,   -62,   155,    49,   132,   -62,   -61,   -62,   156,    47,
     -31
};

  /* YYDEFGOTO[NTERM-NUM].  */
static const yytype_int8 yydefgoto[] =
{
      -1,     3,     4,    65,    17,    18,    66,    67,     6,    24,
      47
};

  /* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule whose
     number is the opposite.  If YYTABLE_NINF, syntax error.  */
static const yytype_int8 yytable[] =
{
      43,    94,    38,    39,    40,    41,    90,    91,    15,     9,
      37,    38,    39,    40,    41,    69,    26,     7,    71,    72,
      73,    74,    75,    76,    77,    78,    79,    80,    83,    84,
      85,    86,    87,    88,    37,    38,    39,    40,    41,     8,
      46,     1,    12,   107,   108,    98,   112,    42,    16,     5,
      93,     2,   113,   115,     5,    16,    42,    81,     7,    25,
      10,    49,    50,    51,    52,    53,    54,    55,    56,    57,
      58,    97,    13,    33,    34,    19,    20,    21,    22,    23,
      82,    31,    45,    32,    57,    58,    49,    50,    51,    52,
      53,    54,    55,    56,    57,    58,    59,     7,    26,    27,
      28,    44,    29,    35,    30,    15,     2,    60,    46,    61,
      62,    68,   101,    63,    64,    49,    50,    51,    52,    53,
      54,    55,    56,    57,    58,    89,   102,   104,   105,   106,
     114,    70,    49,    50,    51,    52,    53,    54,    55,    56,
      57,    58,   109,    48,   111,   110,   116,   117,    92,    49,
      50,    51,    52,    53,    54,    55,    56,    57,    58,    95,
      11,    36,     0,    14,     0,    49,    50,    51,    52,    53,
      54,    55,    56,    57,    58,    96,     0,     0,     0,     0,
       0,    49,    50,    51,    52,    53,    54,    55,    56,    57,
      58,    99,     0,     0,     0,     0,     0,    49,    50,    51,
      52,    53,    54,    55,    56,    57,    58,   100,     0,     0,
       0,     0,     0,    49,    50,    51,    52,    53,    54,    55,
      56,    57,    58,   103,     0,     0,     0,     0,     0,    49,
      50,    51,    52,    53,    54,    55,    56,    57,    58,    -1,
      -1,    -1,    -1,    -1,    -1,    55,    56,    57,    58
};

static const yytype_int8 yycheck[] =
{
      31,     3,     4,     5,     6,     7,    67,    68,     3,     3,
       3,     4,     5,     6,     7,    46,    25,    27,    49,    50,
      51,    52,    53,    54,    55,    56,    57,    58,    59,    60,
      61,    62,    63,    64,     3,     4,     5,     6,     7,    49,
      49,     3,    25,   104,   105,    18,    22,    49,    50,     0,
      81,    13,    28,   114,     5,    50,    49,    26,    27,    12,
       0,    34,    35,    36,    37,    38,    39,    40,    41,    42,
      43,    19,     3,    26,    27,     8,     9,    10,    11,    12,
      49,    26,    35,    28,    42,    43,    34,    35,    36,    37,
      38,    39,    40,    41,    42,    43,     3,    27,    25,    25,
      50,    45,    27,    25,    28,     3,    13,    14,    49,    16,
      17,    45,    28,    20,    21,    34,    35,    36,    37,    38,
      39,    40,    41,    42,    43,    46,    46,    45,    45,    28,
      45,    50,    34,    35,    36,    37,    38,    39,    40,    41,
      42,    43,    46,    28,    28,    46,    46,    28,    50,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    28,
       5,    29,    -1,     7,    -1,    34,    35,    36,    37,    38,
      39,    40,    41,    42,    43,    28,    -1,    -1,    -1,    -1,
      -1,    34,    35,    36,    37,    38,    39,    40,    41,    42,
      43,    28,    -1,    -1,    -1,    -1,    -1,    34,    35,    36,
      37,    38,    39,    40,    41,    42,    43,    28,    -1,    -1,
      -1,    -1,    -1,    34,    35,    36,    37,    38,    39,    40,
      41,    42,    43,    28,    -1,    -1,    -1,    -1,    -1,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43
};

  /* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
static const yytype_uint8 yystos[] =
{
       0,     3,    13,    52,    53,    54,    59,    27,    49,     3,
       0,    53,    25,     3,    59,     3,    50,    55,    56,     8,
       9,    10,    11,    12,    60,    60,    25,    25,    50,    27,
      28,    26,    28,    60,    60,    25,    55,     3,     4,     5,
       6,     7,    49,    61,    45,    60,    49,    61,    28,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,     3,
      14,    16,    17,    20,    21,    54,    57,    58,    45,    61,
      50,    61,    61,    61,    61,    61,    61,    61,    61,    61,
      61,    26,    49,    61,    61,    61,    61,    61,    61,    46,
      57,    57,    50,    61,     3,    28,    28,    19,    18,    28,
      28,    28,    46,    28,    45,    45,    28,    57,    57,    46,
      46,    28,    22,    28,    45,    57,    46,    28
};

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
static const yytype_uint8 yyr1[] =
{
       0,    51,    52,    53,    53,    54,    54,    54,    54,    54,
      55,    55,    56,    57,    57,    58,    58,    58,    58,    58,
      58,    58,    58,    58,    59,    59,    60,    60,    60,    60,
      60,    61,    61,    61,    61,    61,    61,    61,    61,    61,
      61,    61,    61,    61,    61,    61,    61,    61
};

  /* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
static const yytype_uint8 yyr2[] =
{
       0,     2,     1,     1,     2,     4,     6,     9,    10,     4,
       1,     3,     3,     1,     2,     1,     3,     4,     7,    11,
       7,     3,     3,     3,     1,     3,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     3,     3,     3,     3,
       3,     3,     3,     3,     3,     3,     3,     4
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
        case 3:
#line 80 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_decls) = ya_decls_one((yyvsp[0].ya_t_decl));}
#line 1427 "parser.c" /* yacc.c:1646  */
    break;

  case 4:
#line 81 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_decls) = ya_decls_more((yyvsp[-1].ya_t_decl), (yyvsp[0].ya_t_decls));}
#line 1433 "parser.c" /* yacc.c:1646  */
    break;

  case 5:
#line 84 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_decl) = ya_decl_idtype((yyvsp[-3].ya_t_ids), (yyvsp[-1].ya_t_type));}
#line 1439 "parser.c" /* yacc.c:1646  */
    break;

  case 6:
#line 85 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_decl) = ya_decl_assign((yyvsp[-5].ya_t_ids), (yyvsp[-3].ya_t_type), (yyvsp[-1].ya_t_exp));}
#line 1445 "parser.c" /* yacc.c:1646  */
    break;

  case 7:
#line 86 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_decl) = ya_decl_function((yyvsp[-8].id), (yyvsp[-4].ya_t_type), (yyvsp[-2].ya_t_stmts));}
#line 1451 "parser.c" /* yacc.c:1646  */
    break;

  case 8:
#line 87 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_decl) = ya_decl_argdefs((yyvsp[-9].id), (yyvsp[-7].ya_t_argdefs), (yyvsp[-4].ya_t_type), (yyvsp[-2].ya_t_stmts));}
#line 1457 "parser.c" /* yacc.c:1646  */
    break;

  case 9:
#line 88 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_decl) = ya_decl_define((yyvsp[-2].id), (yyvsp[-1].ya_t_type));}
#line 1463 "parser.c" /* yacc.c:1646  */
    break;

  case 10:
#line 91 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_argdefs) = ya_argdefs_one((yyvsp[0].ya_t_argdef));}
#line 1469 "parser.c" /* yacc.c:1646  */
    break;

  case 11:
#line 92 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_argdefs) = ya_argdefs_more((yyvsp[-2].ya_t_argdef), (yyvsp[0].ya_t_argdefs));}
#line 1475 "parser.c" /* yacc.c:1646  */
    break;

  case 12:
#line 95 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_argdef) = ya_argdef_id((yyvsp[-2].id), (yyvsp[0].ya_t_type));}
#line 1481 "parser.c" /* yacc.c:1646  */
    break;

  case 13:
#line 98 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_stmts) = ya_stmts_one((yyvsp[0].ya_t_stmt));}
#line 1487 "parser.c" /* yacc.c:1646  */
    break;

  case 14:
#line 99 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_stmts) = ya_stmts_more((yyvsp[-1].ya_t_stmt), (yyvsp[0].ya_t_stmts));}
#line 1493 "parser.c" /* yacc.c:1646  */
    break;

  case 15:
#line 102 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_stmt) = ya_stmt_decl((yyvsp[0].ya_t_decl));}
#line 1499 "parser.c" /* yacc.c:1646  */
    break;

  case 16:
#line 103 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_stmt) = ya_stmt_exp((yyvsp[-2].id), (yyvsp[-1].ya_t_exp));}
#line 1505 "parser.c" /* yacc.c:1646  */
    break;

  case 17:
#line 104 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_stmt) = ya_stmt_assign((yyvsp[-3].id), (yyvsp[-1].ya_t_exp));}
#line 1511 "parser.c" /* yacc.c:1646  */
    break;

  case 18:
#line 105 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_stmt) = ya_stmt_if((yyvsp[-5].ya_t_exp), (yyvsp[-2].ya_t_stmts));}
#line 1517 "parser.c" /* yacc.c:1646  */
    break;

  case 19:
#line 106 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_stmt) = ya_stmt_ifelse((yyvsp[-9].ya_t_exp), (yyvsp[-6].ya_t_stmts), (yyvsp[-2].ya_t_stmts));}
#line 1523 "parser.c" /* yacc.c:1646  */
    break;

  case 20:
#line 107 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_stmt) = ya_stmt_while((yyvsp[-5].ya_t_exp), (yyvsp[-2].ya_t_stmts));}
#line 1529 "parser.c" /* yacc.c:1646  */
    break;

  case 21:
#line 108 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_stmt) = ya_stmt_return((yyvsp[-1].ya_t_exp));}
#line 1535 "parser.c" /* yacc.c:1646  */
    break;

  case 22:
#line 109 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_stmt) = ya_stmt_print((yyvsp[-1].ya_t_exp));}
#line 1541 "parser.c" /* yacc.c:1646  */
    break;

  case 23:
#line 110 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_stmt) = ya_stmt_input((yyvsp[-1].ya_t_exp));}
#line 1547 "parser.c" /* yacc.c:1646  */
    break;

  case 24:
#line 114 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_ids) = ya_ids_one((yyvsp[0].id));}
#line 1553 "parser.c" /* yacc.c:1646  */
    break;

  case 25:
#line 115 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_ids) = ya_ids_more((yyvsp[-2].id), (yyvsp[0].ya_t_ids));}
#line 1559 "parser.c" /* yacc.c:1646  */
    break;

  case 26:
#line 118 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_type) = ya_type_int();}
#line 1565 "parser.c" /* yacc.c:1646  */
    break;

  case 27:
#line 119 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_type) = ya_type_float();}
#line 1571 "parser.c" /* yacc.c:1646  */
    break;

  case 28:
#line 120 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_type) = ya_type_string();}
#line 1577 "parser.c" /* yacc.c:1646  */
    break;

  case 29:
#line 121 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_type) = ya_type_bool();}
#line 1583 "parser.c" /* yacc.c:1646  */
    break;

  case 30:
#line 122 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_type) = ya_type_void();}
#line 1589 "parser.c" /* yacc.c:1646  */
    break;

  case 31:
#line 125 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_intlit((yyvsp[0].ival));}
#line 1595 "parser.c" /* yacc.c:1646  */
    break;

  case 32:
#line 126 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_stringlit((yyvsp[0].sval));}
#line 1601 "parser.c" /* yacc.c:1646  */
    break;

  case 33:
#line 127 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_floatlit((yyvsp[0].fval));}
#line 1607 "parser.c" /* yacc.c:1646  */
    break;

  case 34:
#line 128 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_boollit((yyvsp[0].bval));}
#line 1613 "parser.c" /* yacc.c:1646  */
    break;

  case 35:
#line 129 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_id((yyvsp[0].id));}
#line 1619 "parser.c" /* yacc.c:1646  */
    break;

  case 36:
#line 131 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_binop((yyvsp[-2].ya_t_exp), "+", (yyvsp[0].ya_t_exp));}
#line 1625 "parser.c" /* yacc.c:1646  */
    break;

  case 37:
#line 132 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_binop((yyvsp[-2].ya_t_exp), "-", (yyvsp[0].ya_t_exp));}
#line 1631 "parser.c" /* yacc.c:1646  */
    break;

  case 38:
#line 133 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_binop((yyvsp[-2].ya_t_exp), "*", (yyvsp[0].ya_t_exp));}
#line 1637 "parser.c" /* yacc.c:1646  */
    break;

  case 39:
#line 134 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_binop((yyvsp[-2].ya_t_exp), "/", (yyvsp[0].ya_t_exp));}
#line 1643 "parser.c" /* yacc.c:1646  */
    break;

  case 40:
#line 136 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_binop((yyvsp[-2].ya_t_exp), "==", (yyvsp[0].ya_t_exp));}
#line 1649 "parser.c" /* yacc.c:1646  */
    break;

  case 41:
#line 137 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_binop((yyvsp[-2].ya_t_exp), "<", (yyvsp[0].ya_t_exp));}
#line 1655 "parser.c" /* yacc.c:1646  */
    break;

  case 42:
#line 138 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_binop((yyvsp[-2].ya_t_exp), ">", (yyvsp[0].ya_t_exp));}
#line 1661 "parser.c" /* yacc.c:1646  */
    break;

  case 43:
#line 139 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_binop((yyvsp[-2].ya_t_exp), "<=", (yyvsp[0].ya_t_exp));}
#line 1667 "parser.c" /* yacc.c:1646  */
    break;

  case 44:
#line 140 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_binop((yyvsp[-2].ya_t_exp), ">=", (yyvsp[0].ya_t_exp));}
#line 1673 "parser.c" /* yacc.c:1646  */
    break;

  case 45:
#line 141 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_binop((yyvsp[-2].ya_t_exp), "!=", (yyvsp[0].ya_t_exp));}
#line 1679 "parser.c" /* yacc.c:1646  */
    break;

  case 46:
#line 143 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_par((yyvsp[-1].ya_t_exp));}
#line 1685 "parser.c" /* yacc.c:1646  */
    break;

  case 47:
#line 144 "yalang.y" /* yacc.c:1646  */
    {(yyval.ya_t_exp) = ya_exp_assign((yyvsp[-3].id), (yyvsp[-1].ya_t_exp));}
#line 1691 "parser.c" /* yacc.c:1646  */
    break;


#line 1695 "parser.c" /* yacc.c:1646  */
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
#line 148 "yalang.y" /* yacc.c:1906  */


void yyerror(const char *msg)
{
	extern int yylineno;
	extern int line;
	extern int column;
	fprintf(stderr, "Error: %s\n", msg);
	fprintf(stderr, "ERRO NA LINHA: %d   \n\tCOLUNA:%d\n", yylineno,column);
}
int main (void)
{
	return yyparse();
}
