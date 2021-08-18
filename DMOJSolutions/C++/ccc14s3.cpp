#include <iostream>
#include <stack>
using namespace std;

int main()
{
    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {
        int N;
        cin >> N;
        stack<int> top;
        stack<int> branch;
        for (int j = 1; j <= N; j++) {
            int num;
            cin >> num;
            top.push(num);
        }
        int exp = 1;
        while (exp <= N) {
            if (!top.empty() && top.top() == exp) {
                top.pop();
                exp++;
            }
            else if (!branch.empty() && branch.top() == exp) {
                branch.pop();
                exp++;
            }
            else if (!top.empty()){
                branch.push(top.top());
                top.pop();
            }
            else {
                if (exp != N) {
                    cout << "N" << endl;
                    break;
                }
            }
        }
        if (exp > N) cout << "Y" << endl;
    }
}
