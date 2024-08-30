import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int V;
	static int E;
	static MyEdge[] edges;
	static int[] parents;
	static long result;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			init();
			solve();
			output(t);
		}
		System.out.println(sb);
	}
	
	public static void output(int t) {
		sb.append("#").append(t).append(" ").append(result).append("\n");
	}

	public static void solve() throws Exception {
		for (int i = 0; i < E; i++) {
			String[] inputs = br.readLine().split(" ");
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);
			int w = Integer.parseInt(inputs[2]);

			edges[i] = new MyEdge(a, b, w);
		}

		Arrays.sort(edges);

		int cnt = 0;
		result = 0;
		for (MyEdge e : edges) {
			if (union(e.a, e.b)) {
				result += e.weight;

				if (++cnt == V - 1)
					break;
			}
		}
	}

	public static void make() {
		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}

	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return false;
		}

		parents[bRoot] = aRoot;
		return true;
	}

	public static int findSet(int x) {
		if (parents[x] == x) {
			return x;
		}

		return parents[x] = findSet(parents[x]);
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		V = Integer.parseInt(inputs[0]);
		E = Integer.parseInt(inputs[1]);

		edges = new MyEdge[E];
		make();
	}
}

class MyEdge implements Comparable<MyEdge> {
	int a;
	int b;
	long weight;

	public MyEdge(int a, int b, long weight) {
		this.a = a;
		this.b = b;
		this.weight = weight;
	}

	@Override
	public int compareTo(MyEdge o) {
		return Long.compare(this.weight, o.weight);
	}
}