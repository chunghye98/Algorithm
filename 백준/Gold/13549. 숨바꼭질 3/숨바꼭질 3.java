import java.io.*;
import java.util.*;

/* 13549, 숨바꼭질3
- 시간 제한: 2초
- 다익스트라 문제
< 접근 방법 >


 */
public class Main {
    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(final int index, final int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(final Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100_000 + 1];
        int result = Integer.MAX_VALUE;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            visited[curNode.index] = true;

            if (curNode.index == end) {
                result = curNode.cost;
                break;
            }

            if (curNode.index * 2 < 100_001 && !visited[curNode.index * 2]) {
                queue.add(new Node(curNode.index * 2, curNode.cost));
            }

            if (curNode.index + 1 < 100_001 && !visited[curNode.index + 1]) {
                queue.add(new Node(curNode.index + 1, curNode.cost + 1));
            }

            if (curNode.index - 1 >= 0 && !visited[curNode.index - 1]) {
                queue.add(new Node(curNode.index - 1, curNode.cost + 1));
            }
        }
        System.out.println(result);
    }
}
