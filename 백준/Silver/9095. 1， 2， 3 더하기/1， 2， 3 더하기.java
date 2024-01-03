import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < test; i++) {
			int n = Integer.parseInt(br.readLine());

			int[] dp = new int[n + 1];

			if (n > 0) {
				dp[1] = 1;
			}
			if (n > 1) {
				dp[2] = 2;
			}
			if (n > 2) {
				dp[3] = 4;
			}
			for (int j = 4; j <= n; j++) {
				dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
			}
			sb.append(dp[n]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
