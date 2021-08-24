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
const int MAXN = 1001;
const int MAXM = 30001;

int diff[MAXN][MAXM];
int M;
int N;
int K;
int x;
int y;
int r;
int b;
int dy;
int ans;
int freq;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> M >> N >> K;
    while (K--) {
        cin >> x >> y >> r >> b;
        int strt = max(1, x - r);
        int end = min(N, x + r);
        for (int j = strt; j <= end; j++) {
            dy = (int)sqrt(r * r - (j - x) * (j - x));
            int lo = y - dy;
            int hi = y + dy + 1;
            int z1 = max(1, lo);
            int z2 = min(hi, M + 1);
            diff[j][z1] += b;
            diff[j][z2] -= b;
        }
    }

    ans = freq = 0;
    for (int j = 1; j <= N; ++j)
        for (int i = 1, sum = 0; i <= M; ++i) {
            sum += diff[j][i];
            if (sum >= ans) {
                if (sum == ans) freq++;
                else { freq = 1; ans = sum; }
            }
        }
    cout << ans << endl;
    cout << freq << endl;
    return 0;
}
