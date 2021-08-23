import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int blood[];
	static int patients[];
	public static void main(String[] args) throws IOException {
		blood = new int [8];
		patients = new int [8];
		for (int k = 0; k < 8; k++) {
			blood[k] = readInt();
		}
		for (int k = 0; k < 8; k++) {
			patients[k] = readInt();
		}
		int total = 0;
		total += calc(0,0);
		total += calc(1,1) + calc(0,1);
		total += calc(2,2) + calc(0,2);
		total += calc(4,4) + calc(0,4);
		total += calc(3,3) + calc(2,3) + calc(1,3) + calc(0,3);
		total += calc(5,5) + calc(4,5) + calc(1,5) + calc(0,5);
		total += calc(6,6) + calc(4,6) + calc(2,6) + calc(0,6);
		total += calc(7,7) + calc(6,7) + calc(5,7) + calc(4,7) + calc(3,7) + calc(2,7) + calc(1,7) + calc(0,7);
		
		System.out.println(total);
	}
	static int calc(int n,int m) {
		int min = Math.min(blood[n], patients[m]);
		blood[n] -= min;
		patients[m] -= min;
		return min;
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
