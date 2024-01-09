import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Node>> list;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시 수
        int m = Integer.parseInt(st.nextToken()); // 도로 수
        int k = Integer.parseInt(st.nextToken()); // 거리 정보
        int start = Integer.parseInt(st.nextToken()); // 출발 도시

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        list = new ArrayList<>(); // 연결 리스트 생성
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(new Node(v, 1));
        }

        bfs(start);

        boolean flag = false;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }

        if (!flag) {
            System.out.println(-1);
        }
    }

    private static void bfs(final int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node parent = queue.poll();

            for (Node child : list.get(parent.index)) {
                if (dist[child.index] > parent.distance + child.distance) {
                    dist[child.index] = parent.distance + child.distance;
                    queue.add(new Node(child.index, dist[child.index]));
                }
            }
        }
    }
}

class Node {
    int index;
    int distance;

    public Node(final int index, final int distance) {
        this.index = index;
        this.distance = distance;
    }
}