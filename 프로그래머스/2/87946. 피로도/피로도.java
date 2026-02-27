import java.util.*;

class Solution {
    
    private int n;
    private boolean[] visited;
    private int max = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        // 1. 변수 정의
        n = dungeons.length;
        visited = new boolean[n];
    
        // 2. 부분 순열
        permutation(dungeons, visited, k, 0);
        
        return max;
    }
    
    public void permutation(int[][] dungeons, boolean[] visited, int pirodo, int count) {
        max = Math.max(max, count);
        
        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            if(pirodo < dungeons[i][0]) continue;
            visited[i] = true;
            pirodo -= dungeons[i][1];
            permutation(dungeons, visited, pirodo, count+1);
            visited[i] = false;
            pirodo += dungeons[i][1];
        }
    }
    
    
}