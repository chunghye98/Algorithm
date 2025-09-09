import java.util.*;
import java.io.*;

class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[][] board;
    private static boolean[][] visited;
    private static int n;
    private static int m;
    private static int[][] dyx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //상,우,하,좌
    private static int maxValue = 0;
    private static int cntValue = 0;
    
    public static void main(String[] args) throws Exception {
        init();
        solve();
        output();
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        board = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            inputs = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }
    }

    public static void solve() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(visited[i][j] || board[i][j] == 0) {
                    continue;
                }
                cntValue++;
                bfs(i, j);
            }
        }
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[y][x] = true;
        queue.add(new int[]{y, x});
        int count = 1;

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
                count++;
            }
        }
        maxValue = Math.max(maxValue, count);
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }

    public static void output() {
        System.out.println(cntValue);
        System.out.println(maxValue);
    }
}