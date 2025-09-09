import java.util.*;
import java.io.*;

class Main {
    private static int n;
    private static int m;
    private static int[][] board;
    private static boolean[][] visited;
    private static int[][] dyx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //상우하좌
    
    public static void main(String[] args) throws Exception {
        init();
        solve();
        output();
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        board = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            input = br.readLine().split("");
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    public static void solve() {
        bfs(0, 0);
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            int[] parent = queue.poll();
            int cy = parent[0];
            int cx = parent[1];

            for(int i=0; i<dyx.length; i++) {
                int ny = cy + dyx[i][0];
                int nx = cx + dyx[i][1];

                if(!isRange(ny, nx) || visited[ny][nx] || board[ny][nx] == 0) continue;
                
                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx});
                board[ny][nx] = board[cy][cx] + board[ny][nx];
            }
        }
    }

    public static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }

    public static void output() {
        System.out.println(board[n-1][m-1]);
    }
}