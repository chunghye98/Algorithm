import java.io.*;
import java.util.*;


public class Main {

	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nodeN = Integer.parseInt(br.readLine());
		int edgeN = Integer.parseInt(br.readLine());

		for(int i=0; i<=nodeN; i++) {
			list.add(new ArrayList<>());
		}

		visited = new boolean[nodeN+1];

		StringTokenizer st;
		for(int i=0; i<edgeN; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list.get(u).add(v);
			list.get(v).add(u);
		}

		System.out.println(bfs(1));
	}

	private static int bfs(int start) {
		int count = 0;
		visited[start] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : list.get(current)) {
				if (!visited[next]) {
					count++;
					visited[next] = true;
					queue.add(next);
				}
			}
		}
		return count;
	}
}
