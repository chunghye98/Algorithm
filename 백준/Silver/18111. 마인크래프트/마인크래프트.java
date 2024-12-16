import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, B;
	static int start;
	static int[][] map;
	static int minTime;
	static int maxHeight;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		B = Integer.parseInt(inputs[2]);

		start = Integer.MIN_VALUE;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
				start = Math.max(start, map[i][j]);
			}
		}

		maxHeight = Integer.MIN_VALUE;
		minTime = Integer.MAX_VALUE;
	}

	private static void solve() {
		for (int k = start; k >= 0; k--) {
			int blocks = B;
			int time = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int value = map[i][j];

					if(value > k) {
						time += (value - k) * 2;
						blocks += value - k;
					}else {
						time += k - value;
						blocks -= k - value;
					}
				}
			}
			
			if(blocks < 0) continue;

			if (time < minTime || (time == minTime && k > maxHeight)) {
				minTime = time;
				maxHeight = k;
			}
		}
	}

	private static void output() {
		System.out.println(minTime + " " + maxHeight);
	}
}