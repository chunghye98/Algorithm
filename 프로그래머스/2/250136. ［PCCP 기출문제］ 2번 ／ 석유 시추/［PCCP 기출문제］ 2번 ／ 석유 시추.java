import java.util.*;

class Solution {
    private int n, m;
    private int[][] dyx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;
    private int[] colSum;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        colSum = new int[m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(land[i][j] == 0 || visited[i][j]) continue;
                bfs(i, j, land);
            }
        }
        
        int answer = 0;
        for(int sum : colSum) {
            answer = Math.max(sum, answer);
        }
        return answer;
    }
    
    private void bfs(int y, int x, int[][] land) {
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.offer(new int[]{y, x});
        Set<Integer> set = new HashSet<>();
        int size = 0;
        
        while(!queue.isEmpty()) {
            int[] parent = queue.poll();
            size++;
            int curY = parent[0];
            int curX = parent[1];
            set.add(curX);
            for(int i=0; i<4; i++) {
                int nextY = curY + dyx[i][0];
                int nextX = curX + dyx[i][1];
                if(!isBound(nextY, nextX)) continue;
                if(land[nextY][nextX] == 0 || visited[nextY][nextX]) continue;
                visited[nextY][nextX] = true;
                queue.offer(new int[]{nextY, nextX});
            }
        }
        
        for(int c : set) {
            colSum[c] += size;
        }
    }
    
    private boolean isBound(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}