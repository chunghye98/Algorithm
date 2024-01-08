import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 계단 오르기
- 제한 시간: 1초
- dp문제
- 1이나 2는 연속으로 3번 이상 점프할 수 없다.
- 1점프했을 때와 2점프했을 때 중 최댓값을 찾아 dp에 넣는 방식
- 점화식: Math.max(dp[i-3]+stairs[i-1], dp[i-2])+stairs[i]
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairsN = Integer.parseInt(br.readLine());
        int[] stairs = new int[stairsN + 1];
        for (int i = 1; i <= stairsN; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[stairsN + 1];

        System.out.println(solve(dp, stairs, stairsN));
    }

    private static int solve(int[] dp, int[] stairs, int stairsN) {
        dp[1] = stairs[1];
        if (stairsN > 1) {
            dp[2] = dp[1] + stairs[2];
        }
        if (stairsN > 2) {
            dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
        }

        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
        }

        return dp[stairsN];
    }
}
