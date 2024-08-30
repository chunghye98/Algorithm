import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int N;
	static int M;
	static int[] parents;
	static int result;

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

	public static void solve() {
		// 그룹의 개수 세기
		// 자기 자신이 부모인 것의 개수 == 그룹의 개수
		for (int i = 1; i <= N; i++) {
			if (parents[i] == i) {
				result++;
			}
		}
	}

	public static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	public static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return;
		}
		parents[bRoot] = aRoot;
	}

	public static int findSet(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		result = 0;

		parents = new int[N + 1];
		make();

		for (int i = 0; i < M; i++) {
			inputs = br.readLine().split(" ");
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);

			union(a, b);
		}
	}
}