import java.io.*;
import java.util.*;

public class Main {

	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visitDFS;
	static boolean[] visitBFS;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodeN = Integer.parseInt(st.nextToken());
		int edgeN = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		visitBFS = new boolean[nodeN + 1];
		visitDFS = new boolean[nodeN + 1];
		for (int i = 0; i <= nodeN; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < edgeN; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

        // 연결 된 노드가 다양할 경우 작은 노드부터 처리하기 위해 정렬
		for (int i = 1; i <= nodeN; i++) {
			Collections.sort(graph.get(i));
		}

		System.out.println(dfs(start));
		sb = new StringBuilder();
		System.out.println(bfs(start));
	}

	private static String bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visitBFS[start] = true;
		sb.append(start + " ");

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : graph.get(current)) {
				if (!visitBFS[next]) {
					sb.append(next + " ");
					visitBFS[next] = true;
					queue.add(next);
				}
			}
		}
		return sb.toString();
	}

	private static String dfs(int start) {
		visitDFS[start] = true;
		sb.append(start + " ");

		for (int next : graph.get(start)) {
			if (!visitDFS[next]) {
				dfs(next);
			}
		}

		return sb.toString();
	}
}
