#include <iostream>
#include <algorithm> 
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

struct Edge {
	int v, w;
	Edge() : v(0) , w(0) {}
	Edge(int v0, int w0) : v(v0), w(w0) {}

	friend bool operator<(Edge a, Edge b) {
		return a.w < b.w;
	}
};

const int MAX = 5005;
int N, M;
vector<Edge> adj[MAX];
priority_queue<Edge> q;
int dis[MAX][2];

int main()
{
	cin >> N >> M;
	for (int i = 1; i <= M; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back(Edge(b,c));
		adj[b].push_back(Edge(a,c));
	}

	for (int i = 0; i < MAX; i++) {
		memset(dis[i], 0x3f, sizeof(dis[i]));
	}
	dis[1][0] = 0;
	q.push(Edge(1, 0));

	while (!q.empty()) {
		Edge cur = q.top();
		q.pop();
		for (Edge e : adj[cur.v]) {
			if (dis[e.v][0] > dis[cur.v][0] + e.w) {
				dis[e.v][1] = dis[e.v][0];
				dis[e.v][0] = dis[cur.v][0] + e.w;
				q.push(Edge(e.v, dis[e.v][0]));
			}
			else if (dis[e.v][1] > dis[cur.v][0] + e.w && dis[e.v][0] < dis[cur.v][0] + e.w) {
				dis[e.v][1] = dis[cur.v][0] + e.w;
				q.push(Edge(e.v, dis[e.v][1]));
			}
			else if (dis[e.v][1] > dis[cur.v][1] + e.w && dis[e.v][0] < dis[cur.v][1] + e.w) {
				dis[e.v][1] = dis[cur.v][1] + e.w;
				q.push(Edge(e.v, dis[e.v][1]));
			}
			
		}
	}
	cout << dis[N][1] << endl;;
	
}
