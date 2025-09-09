import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int col;
    private static int row;
    private static int[][] boxes;

    private static int[] dx = {0, 1, 0, -1}; // 상,우,하,좌
    private static int[] dy = {-1, 0, 1, 0};

    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        boxes = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                boxes[i][j] = Integer.parseInt(st.nextToken());
                if (boxes[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

//        for (int y = 0; y < row; y++) {
//            for (int x = 0; x < col; x++) {
//                if (boxes[y][x] == 1) {
//                    bfs(y, x);
//                }
//            }
//        }

        bfs();

        if (isZero()) {
            System.out.println(-1);
        } else {
            findMax();
        }
    }

    private static void findMax() {
        int max = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (max < boxes[i][j]) {
                    max = boxes[i][j];
                }
            }
        }
        System.out.println(max - 1);
    }

    private static boolean isZero() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (boxes[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int curY = point[0];
            int curX = point[1];

            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if (nextY < 0 || nextY >= row || nextX < 0 || nextX >= col) {
                    continue;
                }

                if (boxes[nextY][nextX] == 0) {
                    boxes[nextY][nextX] = boxes[curY][curX] + 1;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }

    }
}
