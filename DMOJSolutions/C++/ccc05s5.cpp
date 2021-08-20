#include <iostream>
#include <algorithm> 
using namespace std;

const int MAX = 100005;
int t;
int bit[MAX];

struct Pair {
    int pos;
    int score;
    Pair() : pos(0), score(0) {}
    Pair(int pos0, int score0) : pos(pos0), score(score0) {}
    friend bool operator<(Pair a, Pair b) {
        if (a.score == b.score) {
            return a.pos > b.pos;
        }
        else {
            return a.score > b.score;
        }
    }
};

void update(int ind, int val) {
    for (int i = ind; i <= t; i += i & -i) {
        bit[i] += val;
    }
}

long query(int ind) {
    long ans = 0;
    for (int i = ind; i > 0; i -= i & -i) {
        ans += bit[i];
    }
    return ans;
}

int main()
{
    cin >> t;
    Pair arr[MAX];

    long ans = 0;
    
    for (int i = 1; i <= t; i++) {
        int score;
        cin >> score;
        arr[i] = Pair(i,score);
    }
    sort(arr+1, arr+t+1);
    for (int i = 1; i <= t; i++) {
        update(arr[i].pos, 1);
        ans += query(arr[i].pos);
    }
    printf("%.2f\n", (double)ans / t);
}
