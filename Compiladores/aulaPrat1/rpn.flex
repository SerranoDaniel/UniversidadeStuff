%option noyywrap

%{
	
#include<stdio.h>

int result;

int pop();

int stack[20];

int sp=0;

void push(int val);


%}

NUM [0-9]+


%%


{NUM} {push(atoi(yytext));}
"+" {result=pop()+pop(); push(result);}
"-" {result=pop()-pop(); push(result);}
"*" {result=pop()*pop(); push(result);}
"/" {result=pop()/pop(); push(result);}
[\n\t ]+ {/* ignore withespace , tab's \n e espaço */ }

"show" {printf("(%d)\n",pop());}
.     {printf("Syntax error.\n");}

%%


int main (int argc , char *argv[]){
	
	while(1){

		yylex();
	}
}


int pop()
{
	if(sp==0){


		printf("Empty STACK!\n");
		return 0;
	}
	return stack[--sp];
}

void push(int val)
{
	stack[sp++]=val;
}