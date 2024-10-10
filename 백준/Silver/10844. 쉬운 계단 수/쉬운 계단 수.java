import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[][] dp;
    static long result;

    public static void main(String[] args) throws Exception {
        init();
        solve();
        output();
    }

    private static void output() {
        result = 0;
        for (int i = 0; i < dp[0].length; i++) {
            result = (result + dp[N][i]) % 1_000_000_000; 
        }
        System.out.println(result);
    }

    private static void solve() {
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] % 1_000_000_000;
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
            }
            dp[i][9] = dp[i - 1][8] % 1_000_000_000;
        }
    }

    public static void init() throws Exception {
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10];
    }
}