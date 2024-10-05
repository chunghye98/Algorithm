import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] numbers;
	static int[] dp;
	static int result;

	public static void main(String[] args) throws Exception {
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			init();
			solve();
			output(t);
		}
		System.out.println(sb);
	}

	private static void output(int t) {
		sb.append("#").append(t).append(" ").append(result).append("\n");
	}

	private static void solve() {
		Arrays.fill(dp, 1);

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] < numbers[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		for (int v : dp) {
			result = Math.max(v, result);
		}
	}

	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());

		numbers = new int[N];
		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < inputs.length; i++) {
			numbers[i] = Integer.parseInt(inputs[i]);
		}

		dp = new int[N];
		result = 0;
	}
}