import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 1_000_000;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] numbers;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		numbers = new int[N + 1];
		dp = new int[N + 1];
		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			numbers[i + 1] = Integer.parseInt(inputs[i]);
		}
		Arrays.fill(dp, MAX);
	}

	private static void solve() {
		dp[1] = 0;

		for (int i = 1; i <= N; i++) {
			int range = numbers[i];
			for (int j = i; j <= i + range; j++) {
				if (j > N) {
					break;
				}
				dp[j] = Math.min(dp[j], dp[i] + 1);
			}
		}
	}

	private static void output() {
		if (dp[N] == MAX) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}
	}
}