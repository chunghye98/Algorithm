import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static int r;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		init();
		rotate(0, 0, n, m);
		output();
	}

	public static void output() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void rotate(int startY, int startX, int endY, int endX) {
		if (endY - startY == 0 || endX - startX == 0) {
			return;
		}

		Queue<Integer> queue = makeQueue(startY, startX, endY, endX);
		// int rotateNumber = r % 12;

		for (int i = 0; i < r; i++) {
			int value = queue.poll();
			queue.add(value);
		}

		makeArrays(queue, startY, startX, endY, endX);

		rotate(startY + 1, startX + 1, endY - 1, endX - 1);
	}

	public static void makeArrays(Queue<Integer> queue, int startY, int startX, int endY, int endX) {
		for (int x = startX; x < endX; x++) {
			map[startY][x] = queue.poll();
			queue.add(map[startY][x]);
		}
		for (int y = startY + 1; y < endY; y++) {
			map[y][endX - 1] = queue.poll();
		}
		for (int x = endX - 2; x >= startX; x--) {
			map[endY - 1][x] = queue.poll();
		}
		for (int y = endY - 2; y >= startY + 1; y--) {
			map[y][startX] = queue.poll();
		}
	}

	public static Queue<Integer> makeQueue(int startY, int startX, int endY, int endX) {
		Queue<Integer> queue = new ArrayDeque<>();
		for (int x = startX; x < endX; x++) {
			queue.add(map[startY][x]);
		}
		for (int y = startY + 1; y < endY; y++) {
			queue.add(map[y][endX - 1]);
		}
		for (int x = endX - 2; x >= startX; x--) {
			queue.add(map[endY - 1][x]);
		}
		for (int y = endY - 2; y >= startY + 1; y--) {
			queue.add(map[y][startX]);
		}
		return queue;
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		r = Integer.parseInt(inputs[2]);

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
	}
}