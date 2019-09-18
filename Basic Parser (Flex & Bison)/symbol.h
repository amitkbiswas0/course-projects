#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX 5

struct Symbol {
  char name[50];
  double value;
  struct Symbol* next;
};
typedef struct Symbol Symbol;

/* symbol table for storing (value,id) pair */
Symbol* symbolTable[MAX];



int gethashkey(char *name)
{
  int index;
  index = strlen(name)%MAX;
  return index;
}

int lookup(char *name)
{
  Symbol* temp;
  int i;
  for (i=0; i<MAX; i++){
    temp = symbolTable[i];
    while (temp != NULL){
      if(strcmp(name , temp->name) == 0){
        return 1;
      }
      temp = temp->next;
    }
  }
  return 0;
}

void insert_value(char *name, double value)
{
  int index, j;
  Symbol* newSymbol = (Symbol*) malloc(sizeof(Symbol));
  
  newSymbol->value = value;
  strcpy(newSymbol->name , name);
  newSymbol->next = NULL;
  
  index = gethashkey(name);
  Symbol* temp = symbolTable[index];
  
  if(temp == NULL){
    symbolTable[index] = newSymbol;
    printf("Inserted at : (%d , 0)\n", index);
  } else {
    j = 1;
    while(temp->next != NULL){
      temp = temp->next;
      j++;
    }
    temp->next = newSymbol;
    printf("Inserted at : (%d , %d)\n", index, j);
  }
}

void update_value(char *name , double nvalue)
{
  Symbol* temp;
  int i;
  for (i=0; i<MAX; i++){
    temp = symbolTable[i];
    while (temp != NULL){
      if(strcmp(name , temp->name) == 0){
        temp->value = nvalue;
        return;
      }
      temp = temp->next;
    }
  }
}

void set_value(char *name, double value)
{
  if(lookup(name) == 1) update_value(name , value);
  else insert_value(name , value);
}

double get_value(char* name)
{
  Symbol* temp;
  int i;
  for (i=0; i<MAX; i++){
    temp = symbolTable[i];
    while (temp != NULL){
      if(strcmp(name , temp->name) == 0){
        return temp->value;
      }
      temp = temp->next;
    }
  }
  return 0;
}

void symbolList() {
    Symbol* temp;
    int i;
    for(i=0; i<MAX; i++){
        temp = symbolTable[i];
        printf("%d : ", i);
        while(temp != NULL)
        {
            printf(" <%s , %lf> ",temp->name,temp->value);
            temp = temp->next;
        }
        printf("\n");
    }
}





















