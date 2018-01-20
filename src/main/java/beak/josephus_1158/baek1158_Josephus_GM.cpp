#include <cstdio>
int N, M, a[5000], p, c;
bool b[5000];
int main()
{
	scanf("%d %d", &N, &M);
	printf("<");
	c = N;
	while (c)
	{
		int t = M - 1;
		while (b[p])
			p = (p + 1) % N;
		while (t)
		{
			p = (p + 1) % N;
			if (!b[p % N])
				t--;
		}
		if (c == 1) printf("%d>", p + 1);
		else printf("%d, ", p + 1);
		b[p] = true;
		p = (p + 1) % N;
		c--;
	}
}