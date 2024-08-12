import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] dp;
    static int n;
    static int total;
    static int twoCount = 0;
    static int oneCount = 0;


    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }

    private static void output() {
        System.out.println(sb);
    }

    private static void solve() {
        dp(n);

        findFirstAndSecond();
    }

    private static void findFirstAndSecond() {
        for (int i = 1; i < 100_000; i++) {
            for (int j = i; j < 100_000; j++) {
                if((i * oneCount + j * twoCount) == total) {
                    sb.append(i).append("\n");
                    sb.append(j).append("\n");
                    return;
                }
            }
        }
    }

    private static void dp(int n) {
        if(n == 2) {
            twoCount++;
            return;
        }
        if(n == 1) {
            oneCount++;
            return;
        }

        dp(n - 1);
        dp(n - 2);
    }

    private static void input() throws Exception {
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        total = Integer.parseInt(inputs[1]);

        dp = new int[n + 1];
    }
}