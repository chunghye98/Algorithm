import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static int[][] map;
    static int result;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        output();
    }

    private static void init() throws IOException {
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        K = Integer.parseInt(br.readLine());
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    count++;
                }
            }

            int sameRowcnt = 0;
            if (count <= K && count % 2 == K % 2) {
                for (int j = 0; j < N; j++) {
                    if(Arrays.equals(map[i], map[j])) {
                        sameRowcnt++;
                    }
                }
            }
            result = Math.max(sameRowcnt, result);
        }
    }

    private static void output() {
        System.out.println(result);
    }
}