#include <cstdio>
struct P {
	int y, x, n;
};
int N, M, f, r;
int dy[4] = { -1,1,0,0 }, dx[4] = { 0,0,-1,1 };
char a[100][101];
bool visit[100][100];
P q[10001];
int main()
{
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) scanf("%s", a[i]);
	q[0].y = q[0].x = 0;
	while (f <= r)
	{
		int y = q[f].y, x = q[f].x, n = q[f++].n;
		if (y == N - 1 && x == M - 1)
		{
			printf("%d", n + 1);
			return 0;
		}
		for (int i = 0; i < 4; i++)
		{
			int ny = y + dy[i], nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= N || nx >= M || a[ny][nx] == '0' || visit[ny][nx]) continue;
			visit[ny][nx] = true;
			q[++r].y = ny, q[r].x = nx, q[r].n = n + 1;
		}
	}
}