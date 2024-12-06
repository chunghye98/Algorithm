import java.io.*;

// 에라토스테네스의 체
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int M, N;
	static boolean[] numbers;
	static boolean isOne;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		M = Integer.parseInt(inputs[0]);
		N = Integer.parseInt(inputs[1]);

		numbers = new boolean[N + 1];
	}

	private static void solve() {
		for (int i = 2; i <= N; i++) {
			if (numbers[i]) {
				continue;
			}

			for (int j = i * 2; j <= N; j += i) {
				numbers[j] = true;
			}
		}

		for (int i = M; i <= N; i++) {
			if (i == 1) {
				continue;
			}
			if (numbers[i]) {
				continue;
			}
			sb.append(i).append("\n");
		}
	}

	private static void output() {
		System.out.println(sb);
	}
}