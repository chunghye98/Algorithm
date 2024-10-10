import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] dist;
    static int result;

    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            init();
            solve();
            output(t);
        }
        System.out.println(sb);
    }

    private static void output(int t) {
        result = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == Integer.MIN_VALUE) {
                    continue;
                }
                sum += dist[i][j];
            }
            result = Math.min(sum, result);
        }
        sb.append("#").append(t).append(" ").append(result).append("\n");
    }

    private static void solve() {
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    if (dist[a][k] == Integer.MAX_VALUE || dist[k][b] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dist[a][b] = Math.min(dist[a][k] + dist[k][b], dist[a][b]);
                }
            }
        }
    }

    private static void init() throws IOException {
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);

        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        int index = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(inputs[index++]);
                if (value != 0) {
                    dist[i][j] = value;
                }
            }
        }
    }
}
