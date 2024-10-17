import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int Target;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        output();
    }

    private static void output() {
        if (dp[Target] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[Target]);
    }

    private static void solve() {
        Arrays.fill(dp, Integer.MAX_VALUE);  // 최댓값으로 초기화
        dp[0] = 0;  // 0원을 만드는 데 필요한 동전 개수는 0

        for (int coin : coins) {
            for (int i = coin; i <= Target; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
    }

    private static void init() throws IOException {
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        Target = Integer.parseInt(inputs[1]);

        coins = new int[N];
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            coins[i] = temp;
        }

        dp = new int[Target + 1];
    }
}