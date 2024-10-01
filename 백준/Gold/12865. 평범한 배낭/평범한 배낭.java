import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int K;
	static int[] w;
	static int[] v;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}

	public static void output() {
		System.out.println(dp[N][K]);
	}

	public static void solve() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				// 지금 물건의 무게 > 배낭에 담을 수 있는 남은 무게
				if (w[i] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				// 지금 물건의 무게 <= 배낭에 담을 수 있는 남은 무게
				// 지금 물건을 넣지 않는 경우와 넣는 경우의 가치 중 더 큰 값을 넣는다.
				// dp[i-1][j - w[i]]: 이전 상태에서 남은 용량으로 얻을 수 있는 최대 가치
				else {
					dp[i][j] = Math.max(dp[i - 1][j], v[i] + dp[i - 1][j - w[i]]);
				}
			}
		}
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		K = Integer.parseInt(inputs[1]);

		w = new int[N + 1];
		v = new int[N + 1];
		dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			inputs = br.readLine().split(" ");

			w[i] = Integer.parseInt(inputs[0]);
			v[i] = Integer.parseInt(inputs[1]);
		}
	}
}