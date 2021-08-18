import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int K = readInt();
		int N = readInt();
		int M = readInt();
		
		List <Edge> adj[] = new ArrayList[N+1];
		for (int k = 0; k < N+1; k++) adj[k] = new ArrayList();
		for (int k = 0; k < M; k++) {
			int a = readInt(), b = readInt(), w = readInt(), h = readInt();
			adj[a].add(new Edge(b,w,h)); adj[b].add(new Edge(a,w,h));
		}
		int start = readInt();
		int end = readInt();
		
		PriorityQueue <Edge> q = new PriorityQueue<Edge>();
		int dis[][] = new int [N+1][K+1];
		for (int[] row: dis) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		dis[start][0] = 0; q.add(new Edge(start,0,0));
		
		while(!q.isEmpty()) {
			Edge curr = q.poll();
			if (curr.w > dis[curr.v][curr.x]) continue;
			for (Edge e: adj[curr.v]) {
				if (e.x + curr.x < K && dis[e.v][e.x + curr.x] > dis[curr.v][curr.x] + e.w) {
					dis[e.v][e.x + curr.x] = dis[curr.v][curr.x] + e.w;
					q.add(new Edge(e.v,dis[e.v][e.x + curr.x], curr.x + e.x));
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int k = 0; k < K; k++) {
			min = Math.min(min, dis[end][k]);
		}
		System.out.println(min != Integer.MAX_VALUE? min : -1);
		
	}
	static class Edge implements Comparable<Edge>{
		int v, w, x;
		Edge(int v0, int w0, int x0) {v = v0; w = w0; x = x0;}
		public int compareTo(Edge x) {return Integer.compare(w, x.w);}
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
