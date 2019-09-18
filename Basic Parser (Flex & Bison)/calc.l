%option noyywrap

%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "calc.tab.h"
%}

%%
[0-9]*\.?[0-9] {
  yylval.value = atof(yytext);
  return NUMBER;
}
[a-zA-Z0-9_]+ {
  /* not valid variable if first char is digit */
  if(!isdigit(yytext[0])){
    strcpy(yylval.name , yytext);
    return ID;
  }
}
"+"   { return ADD;}
"-"   { return SUB;}
"*"   { return MUL;}
"/"   { return DIV;}
"|"   { return ABS;}
"="   { return ASSIGNOP;}
"("   { return LPAREN;}
")"   { return RPAREN;}
"\n"  { return EOL;}
";"   { return yytext[0];}
[ \t] { /* ignore whitespace */}
.     { printf("Syntax error found : %s\n", yytext);}
%%
