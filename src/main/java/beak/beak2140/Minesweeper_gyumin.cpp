#include <cstdio>
struct P {
	int y, x;
};
char a[100][101];
bool visit[100][100];
int N, f, r, ans;
int dx[8] = { -1,-1,-1,0,0,1,1,1 };
int dy[8] = { -1,0,1,-1,1,-1,0,1 };
P q[99999];
void change(int y, int x, int n)
{
	for (int i = 0; i < 8; i++)
	{
		int ny = y + dy[i], nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
		if (a[ny][nx] == '#')
		{
			if (n == 0) a[ny][nx] = 'x'; // 지뢰 X
			else a[ny][nx] = '*';     // 지뢰 O
		}
	}
}
int num(int y, int x)
{
	int ret = 0, dut = 0;
	for (int i = 0; i < 8; i++)
	{
		int ny = y + dy[i], nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
		if (a[ny][nx] == '#')
			ret++;
		else if (a[ny][nx] == '*')
			dut++;
		if (dut == a[y][x] - '0')
		{
			ret = 0;
			break;
		}
	}
	return ret;
}
int main()
{
	f = 0, r = -1;
	scanf("%d", &N);
	for (int i = 0; i < N; i++)
		scanf("%s", &a[i]);
	q[++r].y = 0, q[r].x = 0;
	q[++r].y = 0, q[r].x = N - 1;
	q[++r].y = N - 1, q[r].x = 0;
	q[++r].y = N - 1, q[r].x = N - 1;
	visit[0][0] = visit[0][N - 1] = visit[N - 1][0] = visit[N - 1][N - 1] = true;

	while (f <= r)
	{
		int y = q[f].y, x = q[f++].x;
		if (a[y][x] == '0')
			change(y, x, 0);
		else
		{
			int cnt = num(y, x);
			change(y, x, cnt);
		}
		for (int i = 0; i < 8; i++)
		{
			int ny = y + dy[i], nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) continue;
			if (a[ny][nx] >= '0'&&a[ny][nx] <= '9')
			{
				q[++r].y = ny, q[r].x = nx;
				visit[ny][nx] = true;
			}
		}
	}

	for (int i = 1; i < N - 1; i++)
		for (int j = 1; j < N - 1; j++)
			if (a[i][j] == '*' || a[i][j] == '#')
				ans++;

	printf("%d", ans);
}