
import java.io.*;
import java.util.*;

public class Maiin {

	static List<List<MyNode>> graph = new ArrayList<>();
	static int[] dist;
	static boolean[] visited;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(new MyNode(v, 1));
		}

		visited = new boolean[n + 1];
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dijkstra(x);

		List<Integer> result = new ArrayList<>();
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == k) {
				result.add(i);
			}
		}

		if (result.isEmpty()) {
			System.out.println(-1);
			return;
		}

		Collections.sort(result);
		for (Integer value : result) {
			System.out.println(value);
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<MyNode> queue = new PriorityQueue<>();
		queue.add(new MyNode(start, 0));
		dist[start] = 0;

		while (!queue.isEmpty()) {
			int nowIndex = queue.poll().index;

			if (visited[nowIndex]) continue;  // 이미 방문한 노드는 스킵
			visited[nowIndex] = true;

			for(MyNode next : graph.get(nowIndex)) {
				if (dist[next.index] > dist[nowIndex] + next.cost) {
					dist[next.index] = dist[nowIndex] + next.cost;

					queue.add(new MyNode(next.index, dist[next.index]));
				}
			}
		}
	}
}

class MyNode implements Comparable<MyNode>{
	int index;
	int cost;

	MyNode(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(MyNode o) {
		return this.cost - o.cost;
	}

}
