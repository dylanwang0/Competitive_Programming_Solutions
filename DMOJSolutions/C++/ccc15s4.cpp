#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <queue>
#include <unordered_map>
#include <unordered_set>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
using namespace std;
#define PB push_back

typedef long long int ll;
typedef unsigned long long int ull;
typedef pair<int, int> pii;
typedef vector<int> vi;

const int INF = 0x3f3f3f3f;

const int MAXM = 2003;

struct Edge {
    int v, w, h;
    bool operator < (const Edge& x) const { return w > x.w; }
};
int K, N, M;
int A, B;
int dis[MAXM][202]; 
vector<Edge> adj[MAXM];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> K >> N >> M;
    for (int i = 1; i <= M; i++) {
        int a, b, t, h;
        cin >> a >> b >> t >> h;
        adj[a].PB(Edge{ b, t, h }); 
        adj[b].PB(Edge{ a, t, h });
    }
    cin >> A >> B;
    priority_queue<Edge> q;
    memset(dis, 0x3f, sizeof(dis)); 
    dis[A][0] = 0; 
    q.push({ A, 0, 0 });

    while (!q.empty()) {
        Edge t = q.top(); 
        q.pop();
        if (dis[t.v][t.h] < t.w) continue;
        for (Edge& e : adj[t.v]) {
            int sumh = e.h + t.h;
            if (sumh >= K || dis[e.v][sumh] <= t.w + e.w) continue;
            dis[e.v][sumh] = t.w + e.w; 
            q.push({ e.v, dis[e.v][sumh], sumh });
        }
    }

    int ans = INF;
    for (int k = 0; k < K; k++) {
        ans = min(ans, dis[B][k]);
    }
    if (ans == INF) {
        cout << -1 << endl;
    }
    else cout << ans << endl;
}
