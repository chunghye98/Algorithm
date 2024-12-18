import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<Integer> results;

	static int N, M;
	static int[][] distance;
	static Map<Integer, List<Integer>> map;


	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		map = new HashMap<>();
		distance = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					distance[i][j] = 0;
				}else {
					distance[i][j] = 100_000;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			inputs = br.readLine().split(" ");

			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);

			distance[a][b] = 1;
			distance[b][a] = 1;
		}
	}

	private static void solve() {
		makeDistance();
		findKBNumber();
	}

	private static void makeDistance() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
	}

	private static void findKBNumber() {
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += distance[i][j];
			}

			List<Integer> numbers = map.getOrDefault(sum, new ArrayList<>());
			numbers.add(i);
			map.put(sum, numbers);
		}

		int min = Integer.MAX_VALUE;
		for (int key : map.keySet()) {
			min = Math.min(key, min);
		}

		results = map.get(min);
		Collections.sort(results);
	}

	private static void output() {
		System.out.println(results.get(0));
	}
}