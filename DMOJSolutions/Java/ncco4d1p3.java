import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		List <Edge> adj[] = new ArrayList[N+1];
		for (int k = 0; k < N+1; k++) adj[k] = new ArrayList();
		for (int k = 0; k < M; k++) {
			int x = readInt();
			int y = readInt();
			int w = readInt();
			adj[x].add(new Edge(y,w)); adj[y].add(new Edge(x,w));
		}
		PriorityQueue <Edge> q = new PriorityQueue<Edge>();
		int dis[][] = new int [N+1][2];
		for (int i = 0; i < dis.length; i++) {
			Arrays.fill(dis[i], (int)1e9);
		}
		dis[1][0] = 0; q.add(new Edge(1,0));
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			for (Edge e: adj[cur.v]) {
				if (dis[e.v][0] > dis[cur.v][0] + e.w) {
				    dis[e.v][1] = dis[e.v][0];
				    dis[e.v][0] = dis[cur.v][0] + e.w;
				    q.add(new Edge(e.v,dis[e.v][0]));
				}
				else if (dis[e.v][1] > dis[cur.v][0] + e.w && dis[e.v][0] != dis[cur.v][0] + e.w) {
					dis[e.v][1] = dis[cur.v][0] + e.w;
					q.add(new Edge(e.v, dis[e.v][1]));
				}
				else if (dis[e.v][1] > dis[cur.v][1] + e.w && dis[e.v][0] != dis[cur.v][1] + e.w){
				    dis[e.v][1] = dis[cur.v][1] + e.w;
				    q.add(new Edge(e.v, dis[e.v][1]));
				}
				
			}
		}
		System.out.println(dis[N][1]);
	}
	static class Edge implements Comparable<Edge>{
		int v, w;
		Edge(int v0, int w0) {v = v0; w = w0;}
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
