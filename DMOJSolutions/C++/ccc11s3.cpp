#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <queue>
#include <unordered_map>
#include <unordered_set>
#include <math.h>
using namespace std;
#define PB push_back

typedef long long int ll;
typedef unsigned long long int ull;
typedef pair<int, int> pii;
typedef vector<int> vi;

const int INF = 0x3f3f3f3f;
int T;
int m;
int x;
int y;
int grid[5][5] = {
    {0, 1, 1, 1, 0},
    {0, 2, 1, 2, 0},
    {0, 0, 2, 0, 0},
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0}
};

bool fun(int mag, int xpos, int ypos) {
    int z = pow(5, mag-1);
    int xrel = xpos / z;
    int yrel = ypos / z;
    if (grid[yrel][xrel] == 1) {
        return true;
    }
    else if (grid[yrel][xrel] == 0) {
        return false;
    }
    else {
        if (mag != 1) {
            int xnew = xpos % z;
            int ynew = ypos % z;
            return fun(mag - 1, xnew, ynew);
        }
        return false;
    }

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> T;
    for (int t = 0; t < T; t++) {
        cin >> m >> x >> y;
        bool ans = fun(m, x, y);
        if (ans == true) {
            cout << "crystal" << endl;
        }
        else {
            cout << "empty" << endl;
        }
    }
	

    
}
