import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        output();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
    }

    private static void solve() {
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            int sqrt = (int) Math.sqrt(i);
            if(Math.pow(sqrt, 2) == i) {
                dp[i] = 1;
                continue;
            }

            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
    }

    private static void output() {
        System.out.println(dp[N]);
    }
}