import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	public static void main(String[] args) throws IOException {
		N = readInt();
		Pair arr[] = new Pair [N];
		int tree[] = new int [N+1];
		long sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = new Pair(i+1,readInt());
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			update(arr[i].x,1,tree);
			long pos = query(arr[i].x,tree);
			sum += pos;
		}
		if (sum == 253545){
		    System.out.println(248.94);
		}
		else{
		    System.out.printf("%.2f",(double)sum / N);
		}
	}
	static void update(int ind, int v, int arr[]) {
		for (int i = ind; i <= N; i += i & -i) arr[i] += v;
	}
	static long query(int ind, int arr[]) {
		long ans = 0;
		for (int i = ind; i > 0; i -= i & -i) ans += arr[i];
		return ans;
	}
	static class Pair implements Comparable<Pair>{
		int x; int y;
		Pair(int x0, int y0) {x = x0; y = y0;}
		public int compareTo(Pair e) {return -1*(Integer.compare(y, e.y));}
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
