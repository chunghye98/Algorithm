import java.io.*;
import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<Node1>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            int u = road[i][0];
            int v = road[i][1];
            int c = road[i][2];

            graph.get(u).add(new Node1(v, c));
            graph.get(v).add(new Node1(u, c));
        }

        int[] dist = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node1> pq = new PriorityQueue<>();
        pq.add(new Node1(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            int nowIndex = pq.poll().index;

            if (visit[nowIndex])
                continue;
            visit[nowIndex] = true;

            for (Node1 next : graph.get(nowIndex)) {
                if (dist[next.index] > dist[nowIndex] + next.cost) {
                    dist[next.index] = dist[nowIndex] + next.cost;
                    pq.add(new Node1(next.index, dist[next.index]));
                }
            }
        }

        int count = 0;
        for (int value : dist) {
            if (value <= K) {
                count++;
            }
        }
        return count;
    }
}

class Node1 implements Comparable<Node1> {
	int index;
	int cost;

	Node1(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node1 o) {
		return this.cost - o.cost;
	}
}