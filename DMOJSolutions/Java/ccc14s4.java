import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), T = readInt();
		ArrayList<E> event = new ArrayList();
		ArrayList<Integer> yCoords = new ArrayList();
		Map<Integer,Integer> compY = new HashMap();
		int fac[] = new int [2*N+1];
		
		for (int i = 0; i < N; i++) {
			int xl = readInt(), yt = readInt(), xr = readInt(), yb = readInt(), t = readInt();
			event.add(new E(xl, yt, yb, t));
			event.add(new E(xr, yt, yb, -t));
			if (!yCoords.contains(yt)) {
				yCoords.add(yt);
			}
			if (!yCoords.contains(yb)) {
				yCoords.add(yb);
			}
		}
		Collections.sort(event);
		Collections.sort(yCoords);
		
		for (int i = 0; i < yCoords.size(); i++) {
			compY.put(yCoords.get(i),i);
		}
		
		long ans = 0;
		
		for (int i = 0; i < event.size(); i++) {
			E cur = event.get(i);
			
			for (int j = compY.get(cur.y1); j < compY.get(cur.y2); j++) {
				fac[j] += cur.t;
			}
			
			for (int j = 0; j < yCoords.size(); j++) {
				if (fac[j] >= T) {
					ans += (long)(event.get(i+1).x - event.get(i).x) * (yCoords.get(j+1) - yCoords.get(j));
				}
			}
		}
		
		System.out.println(ans);
		
	}
	static class E implements Comparable<E>{
		int x, y1, y2, t;
		E(int x0, int y10, int y20, int t0) {x = x0; y1 = y10; y2 = y20; t = t0; }
		
		public int compareTo(E c) {
			if (Integer.compare(x, c.x) == 0) {
				return Integer.compare(t,c.t);
			}
			return Integer.compare(x,  c.x);
		}
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
