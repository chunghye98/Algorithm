import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int target = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] dp = new int[target + 101]; // target명 이상 가능, 한 번에 얻을 수 있는 고객의 수는 100보다 작거나 같다.
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());

			for (int j = customer; j < target + 101; j++) {
				if (dp[j - customer] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], cost + dp[j - customer]);
				}
			}
		}

		// target명 이상 중에 최솟값 탐색
		int result = Integer.MAX_VALUE;
		for (int i = target; i < target + 101; i++) {
			result = Math.min(result, dp[i]);
		}
		System.out.println(result);
	}
}