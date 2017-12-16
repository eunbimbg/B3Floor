#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int result;
int* rowArr;
bool Check(int cur)
{
	for(int i=0;i<cur;i++)
	{
	if(rowArr[i]==rowArr[cur]||cur-i==abs(rowArr[cur]-rowArr[i]))
		{
			return false;
		}		
	}	
		return true;
}

void NQueenRecursive(int cur,int __N)
{
	static int N=0;
	if(cur==__N-1)
	{
		result++;
		return;
	}
	for(int i=0;i<__N;i++)
	{
		rowArr[cur+1]=i;
		if(Check(cur+1))
		{
			NQueenRecursive(cur+1,__N);
		}
	}
}

int NQueen(int _N)
{
	rowArr=(int*)malloc(sizeof(int)*_N);
	result=0;
	NQueenRecursive(-1,_N);
	return result;
}
int main()
{
	int C,N;
	scanf("%d",&C);
	while(C--)
	{
		scanf("%d",&N);
		printf("%d\n",NQueen(N));
	}
	return 0;
}
