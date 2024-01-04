/**
dp[n] = dp[n-1]+dp[n-2];
**/
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];

		if (n > 0) {
			dp[1] = 1;
		}
		if (n > 1) {
			dp[2] = 2;
		}
		if (n > 2) {
			dp[3] = 3;
		}

		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] % 10007 + dp[i - 2] % 10007;
		}

		System.out.println(dp[n] % 10007);
	}
}
