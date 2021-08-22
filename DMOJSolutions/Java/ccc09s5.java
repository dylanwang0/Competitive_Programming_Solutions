import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int M = readInt(), N = readInt(), K = readInt();
		int diff[][] = new int [M+2][N+2];
		for (int i = 0; i < K; i++) {
			int x = readInt(), y = readInt(), r = readInt(), b = readInt();
			for (int j = Math.max(x-r,1); j <= Math.min(x+r,N+1); j++) {
				int dy = (int)Math.sqrt(r*r - ((x-j)*(x-j)));
				int lo = y - dy;
				int hi = y + dy + 1;
				diff[Math.max(lo,1)][j] += b;
				diff[Math.min(hi,M+1)][j] -= b;
			}
		}
		int max = 0;
		int freq = 0;
		for (int j = 1; j <= N; j++) {
			for (int i = 1; i <= M; i++) {
				diff[i][j] = diff[i-1][j] + diff[i][j];
				if (diff[i][j] > max) {
					max = diff[i][j];
					freq = 1;
				}
				else if (diff[i][j] == max) {
					freq++;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(freq);
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
