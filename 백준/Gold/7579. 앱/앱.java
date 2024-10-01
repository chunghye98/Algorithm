import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N; // 앱의 개수
	static int M; // 필요한 메모리
	static int[] bytes; // 앱이 사용하고 있는 메모리
	static int[] costs; // 해당 앱을 비활성화 할 경우의 비용
	static int sumCosts;
	static int[] dp; // i만큼의 비용으로 확보할 수 있는 최대 메모리 크기

	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}

	public static void output() {
		// 필요한 메모리를 확보하기 위한 최소 비용을 찾는다.
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}

	private static void solve() {
		for (int i = 1; i <= N; i++) {
			for (int j = sumCosts; j >= costs[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - costs[i]] + bytes[i]);
			}
		}
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		bytes = new int[N + 1];
		costs = new int[N + 1];

		String[] byteInputs = br.readLine().split(" ");
		String[] costInputs = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			bytes[i] = Integer.parseInt(byteInputs[i - 1]);
			costs[i] = Integer.parseInt(costInputs[i - 1]);
			sumCosts += costs[i];
		}

		dp = new int[sumCosts + 1];
	}
}