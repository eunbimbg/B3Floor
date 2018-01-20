#include <cstdio>
typedef long long ll;
const int MAX = 1000001;
int N, M, K;
ll arr[MAX], tree[2 * MAX + 99999];

ll make_tree(int s, int e, int n)
{
	if (s == e) return tree[n] = arr[s];
	int m = (s + e) / 2;
	return tree[n] = make_tree(s, m, 2 * n) + make_tree(m + 1, e, 2 * n + 1);
}

void one(int s, int e, int ds ,ll de, int n) // ds를 de로 바꾼다
{
	if (ds<s || ds>e) return;
	tree[n] += de;
	if (s == e) return;
	int m = (s + e) / 2;
	one(s, m, ds, de, 2 * n);
	one(m + 1, e, ds, de, 2 * n + 1);
}

ll two(int s, int e, int ds, int de, int n) // ds부터 de까지의 합을 구해서 출력한다
{
	if (e<ds || s>de) return 0;
	if (s >= ds && e<=de) return tree[n];
	int m = (s + e) / 2;
	return two(s, m, ds, de, 2 * n) + two(m + 1, e, ds, de, 2 * n + 1);
}

int main()
{
	scanf("%d %d %d", &N, &M, &K);
	for (int i = 0; i < N; i++) scanf("%lld", &arr[i]);
	make_tree(0, N - 1, 1);
	for (int i = 0; i < M + K; i++)
	{
		int a;
		scanf("%d", &a);
		if (a == 1) 
		{
			int b; ll c;
			scanf("%d %lld", &b, &c);
			ll dif = c - arr[--b];
			arr[b] = c;
			one(0, N-1, b, dif, 1);
		}
		else
		{
			int b, c;
			scanf("%d %d", &b, &c);
			printf("%lld\n", two(0, N-1, b-1, c-1, 1));
		}
	}
}