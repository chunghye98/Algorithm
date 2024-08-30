import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static List<List<Integer>> friends;
	static int count;
	static int result;
	static boolean[] visit;

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
			dfs(i, 0);
			if (result == 1)
				break;
		}
	}

	public static void dfs(int node, int cnt) {
		if (cnt == 4 || result == 1) {
			result = 1;
			return;
		}

		visit[node] = true;

		for (int v : friends.get(node)) {
			if (visit[v]) {
				continue;
			}
			count++;
			dfs(v, cnt + 1);
		}
		visit[node] = false;
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		visit = new boolean[N];
		friends = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			friends.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			inputs = br.readLine().split(" ");
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);

			friends.get(a).add(b);
			friends.get(b).add(a);
		}

		result = 0;
	}
}