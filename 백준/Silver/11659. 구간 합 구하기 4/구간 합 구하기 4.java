import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		dp = new int[N + 1];
		inputs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			dp[i + 1] = dp[i] + Integer.parseInt(inputs[i]);
		}

		for (int i = 0; i < M; i++) {
			inputs = br.readLine().split(" ");
			int s = Integer.parseInt(inputs[0]);
			int e = Integer.parseInt(inputs[1]);

			sb.append(dp[e] - dp[s - 1]).append("\n");
		}

		System.out.println(sb);
	}
}