
import java.io.*;
import java.util.*;

public class Main {

	static int[][] graph;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1}; // 상,우,하,좌
	static int[] dy = {-1, 0, 1, 0};
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		visit = new boolean[n][n];
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split("");
			for (int j = 0; j < inputs.length; j++) {
				graph[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		List<Integer> counts = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 0 || visit[i][j]) {
					continue;
				}
				counts.add(bfs(i, j));
			}
		}

		Collections.sort(counts);
		System.out.println(counts.size());
		for (int count : counts) {
			System.out.println(count);
		}
	}

	private static int bfs(int row, int col) {
		Queue<MyPoint1> queue = new LinkedList<>();
		queue.add(new MyPoint1(row, col));
		visit[row][col] = true;
		int count = 1;

		while (!queue.isEmpty()) {
			MyPoint1 current = queue.poll();
			int curRow = current.row;
			int curCol = current.col;

			for (int i = 0; i < 4; i++) {
				int nextRow = curRow + dy[i];
				int nextCol = curCol + dx[i];

				if (isRange(nextRow, nextCol)) {
					if (!visit[nextRow][nextCol] && graph[nextRow][nextCol] == 1) {
						queue.add(new MyPoint1(nextRow, nextCol));
						visit[nextRow][nextCol] = true;
						count++;
					}
				}
			}
		}
		return count;
	}

	private static boolean isRange(int nextRow, int nextCol) {
		if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n) {
			return false;
		}
		return true;
	}
}

class MyPoint1 {
	int row;
	int col;

	MyPoint1(int row, int col) {
		this.row = row;
		this.col = col;
	}
}