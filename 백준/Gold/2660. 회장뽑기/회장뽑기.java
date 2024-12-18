import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] distance;

	static Map<Integer, List<Integer>> map;
	static int min;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		distance = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					distance[i][j] = 0;
				}else {
					distance[i][j] = 100_001;
				}
			}
		}

		while (true) {
			String[] inputs = br.readLine().split(" ");
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);

			if (a == -1 && b == -1) {
				break;
			}

			distance[a][b] = 1;
			distance[b][a] = 1;
		}
	}

	private static void solve() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}

		map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			Arrays.sort(distance[i]);
			int max = distance[i][distance[i].length - 1];
			List<Integer> list = map.getOrDefault(max, new ArrayList<>());
			list.add(i);
			map.put(max, list);
		}

		min = Integer.MAX_VALUE;
		for (int key : map.keySet()) {
			min = Math.min(key, min);
		}

		List<Integer> results = map.get(min);
		Collections.sort(results);
	}

	private static void output() {
		sb.append(min).append(" ").append(map.get(min).size()).append("\n");
		for (int v : map.get(min)) {
			sb.append(v).append(" ");
		}
		System.out.println(sb);
	}
}