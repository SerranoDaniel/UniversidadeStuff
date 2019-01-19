/* A Bison parser, made by GNU Bison 3.0.4.  */

/* Bison interface for Yacc-like parsers in C

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
#line 9 "yah.y" /* yacc.c:1909  */

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


#line 150 "parser.h" /* yacc.c:1909  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_PARSER_H_INCLUDED  */
