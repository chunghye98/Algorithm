import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] dp;
    static int[][] costs;
    static int result;

    public static void main(String[] args) throws Exception {
        init();
        solve();
        output();
    }

    private static void output() {
        result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            result = Math.min(dp[N][i], result);
        }
        System.out.println(result);
    }

    private static void solve() {
        dp[1][0] = costs[1][0];
        dp[1][1] = costs[1][1];
        dp[1][2] = costs[1][2];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
    }

    public static void init() throws Exception {
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][3];
        costs = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            String[] inputs = br.readLine().split(" ");
            costs[i][0] = Integer.parseInt(inputs[0]);
            costs[i][1] = Integer.parseInt(inputs[1]);
            costs[i][2] = Integer.parseInt(inputs[2]);
        }
    }
}