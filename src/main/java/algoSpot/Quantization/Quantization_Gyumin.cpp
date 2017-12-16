#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;
#define MAX 1e9;
int C, N, S, arr[101], dp[101][101];

int avg(int start, int end)
{
	int a = 0, ret = 0, n = end - start;
	for (int i = start; i < end; i++)
		a += arr[i];
	if (a%n > n / 2)
		a = a / n + 1;
	else
		a /= n;
	for (int i = start; i < end; i++)
		ret += (a - arr[i])*(a - arr[i]);
	return ret;
}

void Sort()
{
	for (int i = 0; i<N; i++)
		for (int j = i; j < N; j++)
		{
			if (arr[i] > arr[j])
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
}

int f(int s, int n)
{
	if (s == N) return 0;
	if (n == 0) return MAX;
	int &ret = dp[s][n];
	if (ret != -1) return ret;
	ret = MAX;
	for (int i = s + 1; i <= N; i++)
		ret = min(ret, avg(s, i) + f(i, n - 1));
	return ret;
}

int main()
{
	scanf("%d", &C);
	while (C--)
	{
		memset(dp, -1, sizeof(dp));
		scanf("%d %d", &N, &S);
		for (int i = 0; i < N; i++)
			scanf("%d", &arr[i]);
		Sort();
		printf("%d\n", f(0, S));
	}
}