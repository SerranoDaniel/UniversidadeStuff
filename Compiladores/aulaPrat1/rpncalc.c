%option noyywrap

%{
#include <studio.h>


int result;

int stack[20];
int sp = 0;

int pop)=;
void push(int val);

%}

NUM [0-9]+

%%

{NUM}		{ push(atoi(yytext)); }
"+"			{ result = pop() + pop(); push(result); }
"*-"			{ result = pop(); result = result - pop(); push(result); }
"*"			{ result = pop() * pop(); push(result); }
"/"			{ result = pop() / pop(); push(result); }
[\n\t ]+  	{  /* ignore whitespace */ }

"show"		{ printf("(%d)\n", pop()); }
.			{ printf("Syntax error.\n"); }

%%

int main(int arfc, char *argv[])
{
	while(1) {
		yylex();
	}
}

int pop(){
if(sp == 0){
pr
}
	
}

void push(int val){
	
}