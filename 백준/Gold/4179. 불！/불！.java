import java.util.*;
import java.io.*;

class Main {
    private static int n;
    private static int m;
    private static char[][] board;
    private static int[][] fireDist;
    private static int[][] jihunDist;
    private static int[][] dyx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //상우하좌
    private static String result;
    private static Queue<int[]> fireQueue = new ArrayDeque<>(); // 불이 여러군데서 발생할 수 있다.
    private static Queue<int[]> jihunQueue = new ArrayDeque<>();
    
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

        board = new char[n][m];
        fireDist = new int[n][m];
        jihunDist = new int[n][m];

        for(int i=0; i<n; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j=0; j<m; j++) {
                board[i][j] = input[j];
                fireDist[i][j] = -1;
                jihunDist[i][j] = -1;
                if(board[i][j] == 'F') {
                    fireQueue.add(new int[]{i, j});
                    fireDist[i][j] = 0;
                }
                if(board[i][j] == 'J') {
                    jihunQueue.add(new int[]{i, j});
                    jihunDist[i][j] = 0;
                } 
            }
        }
    }

    public static void solve() {
        bfsFire();
        bfsJihun();
    }

    public static void bfsFire() {
        while(!fireQueue.isEmpty()) {
            int[] parent = fireQueue.poll();
            int cy = parent[0];
            int cx = parent[1];

            for(int i=0; i<dyx.length; i++) {
                int ny = cy + dyx[i][0];
                int nx = cx + dyx[i][1];
                
                if(!isRange(ny, nx) || board[ny][nx] == '#' || fireDist[ny][nx] >= 0) continue;
                fireDist[ny][nx] = fireDist[cy][cx] + 1;
               
                fireQueue.add(new int[]{ny, nx});
            }
        }
    }

    public static void bfsJihun() {
        while(!jihunQueue.isEmpty()) {
            int[] parent = jihunQueue.poll();
            int cy = parent[0];
            int cx = parent[1];

            for(int i=0; i<dyx.length; i++) {
                int ny = cy + dyx[i][0];
                int nx = cx + dyx[i][1];
                
                if(!isRange(ny, nx)) {
                    result = String.valueOf(jihunDist[cy][cx] + 1);
                    return;
                }
                
                if(board[ny][nx] == '#' || jihunDist[ny][nx] >= 0) continue;
                // 불이 안 붙은 경우 통과, 불이 붙은 시간보다 지훈이가 이동하는 시간이 작으면 통과
                if(fireDist[ny][nx] != -1 && jihunDist[cy][cx] + 1 >= fireDist[ny][nx]) continue;
                
                jihunDist[ny][nx] = jihunDist[cy][cx] + 1;
                jihunQueue.add(new int[]{ny, nx});
            }
        }
        result = "IMPOSSIBLE";
    }

    public static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }

    public static void output() {
        System.out.println(result);
    }
}