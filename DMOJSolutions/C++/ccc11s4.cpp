#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <unordered_map>
#include <unordered_set>
using namespace std;
#define PB push_back

typedef long long int ll;
typedef unsigned long long int ull;
typedef pair<int, int> pii;
typedef vector<int> vi;

const int INF = 0x3f3f3f3f;

int blood[8];
int patients[8];

int calc(int n, int m) {
	int ans = min(blood[n], patients[m]);
	blood[n] -= ans;
	patients[m] -= ans;
	return ans;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

	for (int k = 0; k < 8; k++) {
		cin >> blood[k];
	}
	for (int k = 0; k < 8; k++) {
		cin >> patients[k];
	}

	int total = 0;
	total += calc(0, 0);
	total += calc(1, 1) + calc(0, 1);
	total += calc(2, 2) + calc(0, 2);
	total += calc(4, 4) + calc(0, 4);
	total += calc(3, 3) + calc(2, 3) + calc(1, 3) + calc(0, 3);
	total += calc(5, 5) + calc(4, 5) + calc(1, 5) + calc(0, 5);
	total += calc(6, 6) + calc(4, 6) + calc(2, 6) + calc(0, 6);
	total += calc(7, 7) + calc(6, 7) + calc(5, 7) + calc(4, 7) + calc(3, 7) + calc(2, 7) + calc(1, 7) + calc(0, 7);

	cout << total << endl;
    
}
