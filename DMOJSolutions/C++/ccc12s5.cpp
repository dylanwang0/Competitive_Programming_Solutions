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
int rows;
int cols;
int cats;
int arr[26][26];
bool cat[26][26];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

	cin >> rows >> cols >> cats;
	for (int k = 0; k < cats; k++) {
		int x, y;
		cin >> y >> x;
		cat[y][x] = true;
	}
	arr[1][1] = 1;
	for (int r = 1; r < rows + 1; r++) {
		for (int c = 1; c < cols + 1; c++) {
			if ((r != 1 || c != 1) && cat[r][c] == false) {
				if (cat[r - 1][c] && cat[r][c - 1]) arr[r][c] = 0;
				else if (cat[r - 1][c]) arr[r][c] = arr[r][c - 1];
				else if (cat[r][c - 1]) arr[r][c] = arr[r - 1][c];
				else arr[r][c] = arr[r - 1][c] + arr[r][c - 1];
			}
		}
	}
	cout << arr[rows][cols] << endl;
}
