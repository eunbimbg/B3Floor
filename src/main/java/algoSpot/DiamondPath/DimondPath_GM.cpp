#include <cstdio>
#include <algorithm>
using namespace std;
int C, N, arr[200][100], d[200][100], ans;
int f(int y, int x)
{
	if (y == 2 * N - 1 || arr[y][x] == 0) return 0;
	int &ret = d[y][x];
	if (d[y][x] != -1) return ret;
	ret = arr[y][x];
	ret += max(f(y + 1, x), f(y + 1, x + 1));
	return ret;
}
int main()
{
	scanf("%d", &C);
	while (C--)
	{
		for (int i = 0; i < 2 * N - 1; i++)
			for (int j = 0; j < N; j++)
				arr[i][j] = 0;
		scanf("%d", &N);
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				scanf("%d", &arr[i][j]);
				d[i][j] = -1; 
			}
		}
		for (int i = N; i < 2 * N - 1; i++)
		{
			for (int j = i - N + 1; j < N; j++)
			{
				scanf("%d", &arr[i][j]);
				d[i][j] = -1;
			}
		}
		printf("%d\n", f(0, 0));
	}
}