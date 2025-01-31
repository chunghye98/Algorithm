import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] board;
    static boolean[] visited;
    static Map<Integer, Integer> map;
    static int d[] = {1, 2, 3, 4, 5, 6};
    
    public static void main(String[] args) throws Exception {
        init();
        solve(1);
        output();
    }
    
    public static void init() throws Exception {
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        
        map = new HashMap<>();
        board = new int[101];
        visited = new boolean[101];
        
        for(int i=0; i<N+M; i++) {
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            
            map.put(start, end);
        }
    }
    
    public static void solve(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int i=0; i<d.length; i++) {
                int next = cur + d[i];
                
                if(next > 100) break;
                // 뱀이나 사다리가 없는 경우 방문 체크
                if(visited[next]) continue;
                
                if(map.containsKey(next)) {
                    next = map.get(next);
                }
                // 뱀이나 사다리가 있다면 이동 후 방문 체크
                if(visited[next]) continue;
                
                queue.add(next);
                visited[next] = true;
                board[next] = board[cur] + 1;
            }
        }
    }
    
    public static void output() {
        System.out.println(board[100]);
    }
}