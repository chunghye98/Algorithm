
import java.io.*;
import java.util.*;

public class Main {

	private static int[][] graph;
	private static boolean[][] visited;
	private static int[] dy = {-1, 0, 1, 0}; // 상우하좌
	private static int[] dx = {0, 1, 0, -1}; // 상우하좌
	private static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		graph = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(temp[j]);
			}
		}

		int count = 0;
		List<Integer> results = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 0 || visited[i][j]) {
					continue;
				}

				int size = bfs(i, j);
				if (size > 0) {
					count++;
					results.add(size);
				}
			}
		}

		Collections.sort(results);

		StringBuilder sb = new StringBuilder();
		sb.append(count + "\n");
		for (int value : results) {
			sb.append(value + "\n");
		}
		sb.delete(sb.length() - 1, sb.length());
		System.out.println(sb);
	}

	private static int bfs(int y, int x) {
		Queue<MyPoint1> queue = new LinkedList<>();
		queue.add(new MyPoint1(y, x));
		visited[y][x] = true;
		int size = 1;

		while (!queue.isEmpty()) {
			MyPoint1 now = queue.poll();
			int nowY = now.y;
			int nowX = now.x;

			for (int i = 0; i < 4; i++) {
				int nextY = nowY + dy[i];
				int nextX = nowX + dx[i];

				if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
					continue;
				}

				if (visited[nextY][nextX] || graph[nextY][nextX] == 0) {
					continue;
				}

				visited[nextY][nextX] = true;
				size++;
				queue.add(new MyPoint1(nextY, nextX));
			}
		}

		return size;
	}
}

class MyPoint1 {
	int y;
	int x;

	public MyPoint1(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
