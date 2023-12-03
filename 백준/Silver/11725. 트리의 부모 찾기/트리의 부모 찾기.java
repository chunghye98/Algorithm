
import java.io.*;
import java.util.*;

// 트리의 부모 찾기, 11725
public class Main {
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int n;
    static int[] result;

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        output();
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 2; i < result.length; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(1);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int i : tree.get(parent)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    result[i] = parent;
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        visited = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 0; i <= n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
    }
}
