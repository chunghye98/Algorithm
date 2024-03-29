import java.util.Arrays;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i < puddles.length; i++) {
			int x = puddles[i][0];
			int y = puddles[i][1];

			dp[y][x] = -1;
		}

		dp[1][1] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(dp[i][j] == -1) continue;

				if (dp[i - 1][j] > 0) {
					dp[i][j] += dp[i - 1][j] % 1_000_000_007;
				}
				if (dp[i][j - 1] > 0) {
					dp[i][j] += dp[i][j - 1] % 1_000_000_007;
				}
			}
		}
		return dp[n][m] % 1_000_000_007;
    }
}