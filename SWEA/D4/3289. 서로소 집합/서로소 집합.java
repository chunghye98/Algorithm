import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int N;
	static int M;
	static int[] parents;
	static String result;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			init();
			makeOutput(t);
			solve();
		}
		System.out.println(sb);
	}

	public static void makeOutput(int t) {
		sb.append("#").append(t).append(" ");
	}

	public static void solve() throws Exception {
		for (int i = 0; i < M; i++) {
			String[] inputs = br.readLine().split(" ");
			int command = Integer.parseInt(inputs[0]);
			int a = Integer.parseInt(inputs[1]);
			int b = Integer.parseInt(inputs[2]);

			switch (command) {
			case 0:
				union(a, b);
				break;
			case 1:
				if (findSet(a) == findSet(b)) {
					sb.append("1");
				} else {
					sb.append("0");
				}
			}
		}
		sb.append("\n");
	}

	public static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	public static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {
			return;
		}
		
		parents[bRoot] = aRoot;
	}
	
	public static int findSet(int x) {
		if(parents[x] == x) {
			return x;
		}
		
		return parents[x] = findSet(parents[x]);
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		parents = new int[N + 1];
		make();
	}

}