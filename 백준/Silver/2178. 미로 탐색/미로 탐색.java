
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색
public class Main {
    static int w;
    static int h;
    static int map[][];
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1}; // 상좌하우
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        System.out.println(map[h - 1][w - 1]);
    }

    private static void bfs() {
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] temps = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newH = temps[0] + dy[i];
                int newW = temps[1] + dx[i];
                if (newH >= 0 && newW >= 0 && newH < h && newW < w) {
                    if (!visited[newH][newW] && map[newH][newW] == 1) {
                        queue.add(new int[]{newH, newW});
                        map[newH][newW] = map[temps[0]][temps[1]] + 1;
                        visited[newH][newW] = true;
                    }
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }
}
