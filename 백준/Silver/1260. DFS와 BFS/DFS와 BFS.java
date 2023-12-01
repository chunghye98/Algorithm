/* DFS와 BFS
- 시간 제한: 2초
- DFS: 보통 stack이나 재귀 사용
- BFS: 보통 queue 사용

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        boolean[] visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        System.out.println(dfs(map, v, visited, sb));

        visited = new boolean[n + 1];
        sb = new StringBuilder();
        System.out.println(bfs(map, v, visited, sb));

    }

    private static String bfs(int[][] map, int index, boolean[] visited, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");
            for (int i = 1; i < map.length; i++) {
                if (map[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return sb.toString();
    }
    private static String dfs(int[][] map, int index, boolean[] visited, StringBuilder sb) {
        visited[index] = true;
        sb.append(index);
        for (int i = 1; i < map.length; i++) {
            if (map[index][i] == 1 && !visited[i]) {
                sb.append(" ");
                dfs(map, i, visited, sb);
            }
        }
        return sb.toString();
    }
}
