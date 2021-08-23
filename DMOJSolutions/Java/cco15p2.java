import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int dp[][], w[][];
	public static void main(String[] args) throws IOException {
		N = readInt();
		int M = readInt();
		
		w = new int [N][N];
		dp = new int [N][1 << N];
		
		for (int i = 1; i <= M; i++) {
			int s = readInt(), d = readInt(), l = readInt();
			w[s][d] = l;
		}
		
		System.out.println(bitmask((1 << 0), 0));
		
	}
	static int bitmask(int mask ,int u) {
		if (u == N-1) return dp[u][mask];
		
		if (dp[u][mask] > 0) return dp[u][mask];
		
		dp[u][mask] = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			if (w[u][i] >= 1 && (mask & (1 << i)) == 0) {
				dp[u][mask] = Math.max(dp[u][mask], w[u][i] + bitmask((mask | (1 << i)), i));
			}
		}
		return dp[u][mask];
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}	
}
