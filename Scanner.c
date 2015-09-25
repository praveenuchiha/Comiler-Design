  /*Authors:praveen kumar kommireddy(pkk236) and shreyas tiwari(st2352) [group project]
Description:
This scanner implements Lexical analysis */


#include <stdio.h>
#include <ctype.h>

#define TEXT 21
#define OPERATOR 10
#define DIGIT 25

char A;
char Grammer;
char lex[100];
int leximlen;
int token;
int token1;
int fetchToken();
void addChar();
void fetchChar();
void getNonBlank();


FILE *in_fp, *fopen();

int main()
{
    /* Open the file and read its contents*/
    if ((in_fp = fopen("input.txt", "r")) == NULL)
        printf("ERROR - cannot open file");
    else
   {
        fetchChar();
        do
        {
	fetchToken();

         } while (token1 != EOF);
    }
	return 0;
}

void fetchChar()
{
    if ((A = getc(in_fp)) != EOF)
   {
        if (isalpha(A))
    	{
            Grammer = TEXT;
        }
        else if (isdigit(A))
        {
        	Grammer = DIGIT;
        }
        else
		{
		Grammer = OPERATOR ;
		}
    }
else
        Grammer = EOF;
}
void getNonBlank()
{
    while (isspace(A)) fetchChar();
}
void addChar()
{

    if (leximlen <= 98)
    {
        lex[leximlen++] = A;
        lex[leximlen] = 0;
    } else
        printf("Error - leximlen exceeded  \n");
}

int fetchToken()
{
    leximlen = 0;
    getNonBlank();
    switch (Grammer)
    {
/*checks if the argument is text  */
    case TEXT:

       addChar();
        fetchChar();
        while (Grammer == TEXT)
       {

        addChar();
        fetchChar();

        }
      printf("%s", lex);
	  printf("tokword \n"); /*print the token */
      break;
/*checks if the argument is digit  */
    case DIGIT:

        addChar();
        fetchChar();
        while (Grammer == DIGIT)
        {

        addChar();
        fetchChar();
        }
        printf("%s", lex);
        printf("toknumber \n");
        break;
        /*checks if the argument is operator  */
    case OPERATOR:
    	addChar();
        fetchChar();
		printf(" %s ", lex);
        printf("tokop \n");
        break;

    }

    return token1;

/*Ignore comment lines*/
    while(Grammer=='{')
{
while(Grammer!='}')
{
if(Grammer==EOF)
break;
Grammer=getc(in_fp);
}
Grammer=getc(in_fp);
}
if(Grammer==' '|| Grammer=='\n' )
{
Grammer=getc(in_fp);
}
}



