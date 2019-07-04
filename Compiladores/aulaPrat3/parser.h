/* A Bison parser, made by GNU Bison 3.0.2.  */

/* Bison interface for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2013 Free Software Foundation, Inc.

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
typedef union YYSTYPE YYSTYPE;
union YYSTYPE
{
#line 11 "yalang.y" /* yacc.c:1909  */

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

#line 172 "parser.h" /* yacc.c:1909  */
};
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_PARSER_H_INCLUDED  */
