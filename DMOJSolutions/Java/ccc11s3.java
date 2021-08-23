import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int grid[][] = {{0,1,1,1,0},{0,2,1,2,0},{0,0,2,0,0},{0,0,0,0,0},{0,0,0,0,0}};
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int i = 1; i <= T; i++) {
			int m = readInt(), x = readInt(), y = readInt();
			boolean check = rec(m,x,y);
			if (check) System.out.println("crystal");
			else System.out.println("empty");
		}
		
		
	}
	static boolean rec(int mag, int x, int y) {
		int z = (int)Math.pow(5, mag-1);
		
		int zx = x / z;
		int zy = y / z;
		
		if (grid[zy][zx] == 1) return true;
		else if (grid[zy][zx] == 0) return false;
		else if (grid[zy][zx] == 2 && mag != 1) {
			int nx = x % z;
			int ny = y % z;
			return rec(mag-1, nx, ny);
		}
		return false;
		
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
