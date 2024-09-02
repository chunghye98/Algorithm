import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] costs;
	static boolean[] visit;
	static int result;

	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}

	public static void output() {
		System.out.println(result);
	}

	public static void solve() {
		for (int i = 0; i < N; i++) {
			dfs(i, 1, 0, i);
		}
	}

	public static void dfs(int node, int cnt, int sum, int start) {
		if(cnt == N) {

			// 순회가 되지 않는다면 패스
			if(costs[node][start] == 0) {
				return;
			}

			result = Math.min(result, sum + costs[node][start]);
			return;
		}

		visit[node] = true;

		for (int i = 0; i < costs[node].length; i++) {
			if (visit[i] || costs[node][i] == 0) {
				continue;
			}

			dfs(i, cnt + 1, sum + costs[node][i], start);
		}
		visit[node] = false;
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());

		costs = new int[N][N];
		visit = new boolean[N];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				costs[i][j] = Integer.parseInt(inputs[j]);
			}
		}
	}
}