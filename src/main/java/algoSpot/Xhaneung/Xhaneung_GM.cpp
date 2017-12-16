//XHAE
#include <cstdio>
#include <cstring>
#include <iostream>
#include <string>
using namespace std;
string num[11] = { "zero","one","two","three","four","five","six","seven","eight","nine","ten" };
string S, A, OP, B, C;
int N, a, b, c, check[29];
void Parse()
{
	int cnt = 0;
	string tmp = "";
	for (int i = 0; i < S.size(); i++)
	{
		if (S[i] != ' ')
			tmp += S[i];
		else
		{
			if (cnt == 0) A = tmp;
			else if (cnt == 1) OP = tmp;
			else if (cnt == 2) B = tmp;
			else C = tmp;
			cnt++;
			tmp = "";
		}
	}
}

bool Solve()
{
	bool ret = true;

	if (OP == "+") c = a + b;
	else if (OP == "-") c = a - b;
	else c = a*b;

	if (c < 0 || c>10) ret = false;
	else
	{
		string tmp = num[c];
		for (int i = 0; i < tmp.size(); i++)
		{
			char t = tmp[i];
			check[t - 'a']--;
		}
		for (int i = 0; i < 29; i++)
		{
			if (check[i] != 0)
			{
				ret = false;
				break;
			}
		}
	}

	return ret;
}

int main()
{
	scanf("%d\n", &N);
	while (N--)
	{
		memset(check, 0, sizeof(check));
		S = "";
		getline(cin, S);
		S += " ";
		Parse();

		for (int i = 0; i < 11; i++)
		{
			if (A==num[i])
			{
				a = i;
				break;
			}
		}

		for (int i = 0; i < 11; i++)
		{
			if (B==num[i])
			{
				b = i;
				break;
			}
		}

		for (int i = 0; i < C.size(); i++)
		{
			char tmp = C[i];
			check[tmp - 'a']++;
		}

		if (Solve())
			printf("Yes\n");
		else
			printf("No\n");
	}
}