%{
/* headers and function calls */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "symbol.h"

void yyerror(char *s);
int yyparse(void);
int yylex(void);

%}
/* declaring tokens */
%union {double value; char name[25];}
%start statement
%token ADD SUB MUL DIV ABS ASSIGNOP LPAREN RPAREN EOL
%token <value> NUMBER
%token <name> ID
%type  <value> statement exp factor term


%%
statement: exp ';' EOL {printf("%lf \n", $1);}
|ID ASSIGNOP exp ';' EOL {set_value($1 , $3);symbolList();}
|statement exp ';' EOL {printf("%lf\n", $2);}
|statement ID ASSIGNOP exp ';' EOL  {set_value($2 , $4);symbolList();}
;


exp: factor {$$ = $1;}
| exp ADD factor {$$ = $1 + $3;}
| exp SUB factor {$$ = $1 - $3;}
;

factor: term {$$ = $1;}
| factor MUL term {$$ = $1 * $3;}
| factor DIV term {$$ = $1 / $3;}
;

term: NUMBER {$$ = $1;}
|ID {
  if(get_value($1) == 0){
    printf("%s not found . value set to 0 instead!\n", $1);
    $$ = 0;
  } else {
    $$ = get_value($1);
  }
}
|SUB ID {$$ = -(get_value($2));}
|SUB NUMBER {$$ = -$2;}
|LPAREN exp RPAREN {$$ = $2;}
|SUB LPAREN exp RPAREN {$$ = -$3;}
|ABS exp ABS {$$ = ($2 >= 0 ? $2 : -$2);}
;
%%

int main(int argc,char *argv[])
{
	return yyparse();
}
void yyerror(char* s)
{
fprintf(stderr,"%s\n",s);
}
