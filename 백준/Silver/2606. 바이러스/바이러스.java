
import java.io.*;
import java.util.*;

/*
바이러스
- 시간 제한: 1초
- 메모리 제한: 128MB
 */
public class Main {
	private static List<List<Integer>> graph;
	private static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int edge = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수

		graph = new ArrayList<>();
		visit = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		StringTokenizer st;
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		int count = bfs(1);

		System.out.println(count);
	}

	private static int bfs(int node) {
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		visit[node] = true;
		queue.add(node);

		while (!queue.isEmpty()) {
			int parent = queue.poll();
			for (int child : graph.get(parent)) {
				if (!visit[child]) {
					queue.add(child);
					visit[child] = true;
					count++;
				}
			}
		}

		return count;
	}
}
