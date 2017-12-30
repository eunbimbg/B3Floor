#include <cstdio>
#include <cstring>
#include <vector>
#include <functional>
#include <queue>
using namespace std;
typedef pair<int, double>P;
typedef pair<double, int>DI;
int T, N, M;
bool visit[10001];
double d[10001];
int main()
{
	scanf("%d", &T);
	while (T--)
	{
		vector<P>v[10001];
		priority_queue<DI, vector<DI>, greater<DI>>q;
		memset(visit, 0, sizeof(visit));
		memset(d, 0, sizeof(d));
		scanf("%d %d", &N, &M);
		for (int i = 0; i < M; i++)
		{
			int a, b;
			double c;
			scanf("%d %d %lf", &a, &b, &c);
			v[a].push_back({ b,c });
			v[b].push_back({ a,c });
		}
		q.push({ 1,0 });
		while (!q.empty())
		{
			int now = q.top().second;
			double noise = q.top().first;
			q.pop();
			if (d[now] > 0 && d[now] < noise)continue;
			visit[now] = true;
			d[now] = noise;
			int size = v[now].size();
			for (int i = 0; i < size; i++)
			{
				int next = v[now][i].first;
				double n_noise = noise * v[now][i].second;
				if (visit[next]) continue;
				q.push({ n_noise,next });
			}
		}
		printf("%.10lf\n", d[N-1]);
	}
}