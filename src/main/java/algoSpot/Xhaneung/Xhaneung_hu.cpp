#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char Arr[5][20];
char Str[10];
void SameCheck(char* _str1,char* _str2)
{
int Check[10]={0};
int findCharCount=0;
if(strlen(_str1)==strlen(_str2))
{
	for(int i=0;i<strlen(_str1);i++)
	{
		for(int j=0;j<strlen(_str2);j++)
		{
			if(_str1[i]==_str2[j]&&Check[j]==0)			
			{
				Check[j]=1;
				findCharCount++;
				break;	
			}
		}			
	}
	
	if(findCharCount==strlen(_str1))
		printf("Yes\n");
	else
		printf("No\n");
}

else
		printf("No\n");
}

char* IToS(int _int)
{
	memset(Str,0,sizeof(Str));

	switch(_int)
	{
		case 0:	strcpy(Str,"zero");
		return Str;
			
		case 1:	strcpy(Str,"one");
		return Str;
			
		case 2:	strcpy(Str,"two");
		return Str;
			
		case 3:strcpy(Str,"three");
		return Str;
			
		case 4:strcpy(Str,"four");
		return Str;
			
		case 5:	strcpy(Str,"five");
		return Str;
			
		case 6:	strcpy(Str,"six");
		return Str;
			
		case 7:	strcpy(Str,"seven");
		return Str;
			
		case 8:	strcpy(Str,"eight");
		return Str;
			
		case 9:	strcpy(Str,"nine");
		return Str;
			
		case 10:	strcpy(Str,"ten");
		return Str;
	}
}

int SToI(char* _string)
{
	if(strcmp("zero",_string)==0)
		return 0;
	if(strcmp("one",_string)==0)
		return 1;
	if(strcmp("two",_string)==0)
		return 2;
	if(strcmp("three",_string)==0)
		return 3;
	if(strcmp("four",_string)==0)
			return 4;
	if(strcmp("five",_string)==0)
		return 5;
	if(strcmp("six",_string)==0)
		return 6;
	if(strcmp("seven",_string)==0)
		return 7;
	if(strcmp("eight",_string)==0)
		return 8;
	if(strcmp("nine",_string)==0)
		return 9;									
	if(strcmp("ten",_string)==0)
		return 10;
}


void XHAENEUNG()
{
	char op=Arr[1][0];
	int result=0;
	switch(op)
	{
		case '+':
			result=SToI(Arr[0])+SToI(Arr[2]);	
		if(result>=0&&result<=10)
			SameCheck(IToS(result),Arr[4]);
		else 
		printf("No\n");
		
		break;
		case '-':
			result=SToI(Arr[0])-SToI(Arr[2]);
		if(result>=0&&result<=10)
			SameCheck(IToS(result),Arr[4]);
		else 
		printf("No\n");
		
				break;

		case '*':
			result=SToI(Arr[0])*SToI(Arr[2]);
		if(result>=0&&result<=10)
			SameCheck(IToS(result),Arr[4]);
			else 
		printf("No\n");
				break;

	}
}

int main()
{
	int C;
	scanf("%d",&C);
	while(C--)
	{
		memset(Arr,0,sizeof(100));
		scanf("%s %s %s %s %s",&Arr[0],&Arr[1],&Arr[2],&Arr[3],&Arr[4]);
		XHAENEUNG();
	}	
		
}
