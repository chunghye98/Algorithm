import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static boolean[][] nemo;
    static int result;

    public static void main(String[] args) throws IOException {
        init();
        backtracking(0);
        output();
    }

    private static void init() throws IOException {
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        nemo = new boolean[N][M];
        result = 0;
    }

    private static void backtracking(int depth) {
        if (depth == N * M) {
            // 2x2 형태가 아닌 배치라면 count++
            if(!canBomb()) {
                result++;
            }
            return;
        }

        int y = depth / M;
        int x = depth % M;

        // 현재 위치를 선택한 경우
        nemo[y][x] = true;
        backtracking(depth + 1);

        // 현재 위치를 선택하지 않은 경우
        nemo[y][x] = false;
        backtracking(depth + 1);
    }

    // 2 x 2 사각형을 이루면 넴모를 없앤다.
    private static boolean canBomb() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (nemo[i][j] && nemo[i + 1][j] && nemo[i][j + 1] && nemo[i + 1][j + 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void output() {
        System.out.println(result);
    }
}