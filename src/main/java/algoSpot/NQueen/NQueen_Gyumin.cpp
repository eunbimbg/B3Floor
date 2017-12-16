#include <cstdio>
int N; // 1 <= N <= 12
int C, dif, ans;
bool asc[24], dsc[24], row[12], col[12];

void solve(int n)
{
	if (n == N)
	{
		ans++;
		return;
	}
	for (int i = 0; i < N; i++)
	{
		if (asc[n + i] || dsc[(i - n) + dif] || col[i])
			continue;
		asc[n + i] = dsc[(i - n) + dif] = col[i] = true;
		solve(n + 1);
		asc[n + i] = dsc[(i - n) + dif] = col[i] = false;
	}
}

int main()
{
	scanf("%d", &C);
	while (C--)
	{
		ans = 0;
		scanf("%d", &N);
		dif = (N % 2) ? N / 2 + 1 : N / 2;
		solve(0);
		printf("%d\n", ans);
	}
	return 0;
}