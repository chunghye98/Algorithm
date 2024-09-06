import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int N;
	static int M;
	static List<List<Integer>> graph;
	static List<List<Integer>> reverseGraph;
	static boolean[] visit;

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
		for (int i = 1; i <= N; i++) {
			int frontCount = bfs(i, reverseGraph);
			visit = new boolean[N + 1];
			int backCount = bfs(i, graph);
			visit = new boolean[N + 1];

			if (frontCount + backCount == N - 1) {
				result++;
			}
		}
	}

	public static int bfs(int start, List<List<Integer>> graph) {
		Queue<Integer> queue = new ArrayDeque<>();
		visit[start] = true;
		queue.add(start);

		int count = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int next : graph.get(cur)) {
				if (visit[next])
					continue;
				count++;
				visit[next] = true;
				queue.add(next);
			}
		}
		return count;
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		reverseGraph = new ArrayList<>();
		visit = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
			reverseGraph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			String[] inputs = br.readLine().split(" ");
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);

			graph.get(a).add(b);
			reverseGraph.get(b).add(a);
		}

		result = 0;
	}

}