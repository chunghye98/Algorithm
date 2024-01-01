
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				dp[0] = 0;
			}
			if (i == 1) {
				dp[1] = 1;
			}
			if (i >= 2) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}
		System.out.println(dp[n]);
	}
}
