import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int k = 0; k < T; k++) {
		    int N = readInt();
			Stack <Integer> top = new Stack<Integer>();
			Stack <Integer> branch = new Stack<Integer>();
			for (int x = 0; x < N; x++) {
				int num = readInt();
				top.push(num);
			}
			
            int order = 1;
            
            while(order <= N) {
            	
                if(!top.isEmpty() && order == top.peek()) {
                    top.pop();
                    order++; 
                } 
                else if(!branch.isEmpty() && branch.peek() == order) {
                    branch.pop();
                    order++;
                } 
                else if (!top.isEmpty()) {
                    branch.push(top.pop());
                    
                } 
                else {
                    if (order != N){
                        System.out.println("N");
                        break;
                    }
                }
            }
            if (order > N) {
            	System.out.println("Y");
            }
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
