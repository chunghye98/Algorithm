import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dxy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] students;
    static int result;
    static int[] selected;
    static boolean[][] visit;
    
    public static void main(String[] args) throws Exception {
        init();
        solve(0,0,0);
        output();
    }
    
    public static void init() throws Exception {
        students = new char[5][5];
        for(int i=0; i<5; i++) {
            students[i] = br.readLine().toCharArray();
        }
        
        selected = new int[7];
    }
    
    public static void solve(int cnt, int start, int numY) {
        if(numY >= 4) {
            return;
        }
        
        if(cnt == 7) {
            visit = new boolean[5][5];
            boolean isDasom = bfs();
            if(isDasom) {
                result++;
            }
            return;
        }
        
        for(int i=start; i<25; i++) {
            selected[cnt] = i;
            if(students[i/5][i%5] == 'Y') {
                solve(cnt+1, i+1, numY+1);
            }else {
                solve(cnt+1, i+1, numY);
            }
        }
    }
    
    public static boolean bfs() {
        int startY = selected[0]/5;
        int startX = selected[0]%5;
        
        Queue<int[]> queue = new ArrayDeque<>();
        visit[startY][startX] = true;
        queue.add(new int[]{startY, startX});
        int count = 1;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            
            for(int i=0; i<4; i++) {
                int ny = cy + dxy[i][0];
                int nx = cx + dxy[i][1];
                
                if(!isRange(ny, nx) || visit[ny][nx] || !isNear(ny, nx)) {
                    continue;
                }
                
                visit[ny][nx] = true;
                queue.add(new int[]{ny, nx});
                count++;
            }
        }
        
        return count == 7;
    }
    
    public static boolean isNear(int y, int x) {
        for(int select : selected) {
            if(select/5 == y && select%5 == x) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isRange(int y, int x) {
        return y >= 0 && y < 5 && x >= 0 && x < 5;
    }
    
    public static void output() {
        System.out.println(result);
    }
}