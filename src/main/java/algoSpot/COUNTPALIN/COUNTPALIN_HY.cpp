#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int A[2000004];
long long Manacher(string str)
{
	int r=0,p=0; 
	long long result=0;
	int len=str.length();
	
	for(int i=0;i<len;i++)
	{
		if(i<r)
			A[i]=min(A[2*p-i],r-i);
		else
			A[i]=0;
	
		while(	
			i-A[i]-1>=0
			&&i+A[i]+1<len
			&&str[i-A[i]-1]==str[i+A[i]+1]	
			)
		A[i]++;
	
	
		if(r<i+A[i])
		{
			r=i+A[i];
			p=i;
		}
		result+=A[i]/2;
	}
	return result;
}

int main(void)
{
	int T;
	int N;
	string editedS;
	string originS;

	cin>>T;
	while(T--)
	{
		cin>>N;
		cin>>originS;
		editedS='#';
		for(int i=1;i<=N*2;i++)
		{		
			if(i%2==0)
				editedS+='#';
			else	
				editedS+=originS[i/2];	
		}
			cout<<Manacher(editedS)<<endl;	
	}
	return 0;
}
