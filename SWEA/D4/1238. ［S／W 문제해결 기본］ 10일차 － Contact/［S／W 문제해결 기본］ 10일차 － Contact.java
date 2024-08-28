import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T = 10;
	static int N;
	static int start;
	static List<List<Node>> nodes;
	static boolean[] visit;
	static int result;


	public static void main(String[] args) throws Exception {
		for (int i = 1; i <= T; i++) {
			init();
			solve(start);
			output(i);
		}
		System.out.println(sb);
	}

	public static void output(int t) {
		sb.append("#").append(t).append(" ").append(result).append("\n");
	}

	public static void solve(int start) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(start, 0));
		visit[start] = true;

		int before = 0;
		while(!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.depth > before) {
				before = cur.depth;
				result = cur.number; // 깊이가 바뀔 때 새로운 깊이에서의 시작 노드를 저장
			} else if (cur.depth == before) {
				result = Math.max(result, cur.number); // 동일 깊이에서 최대값 갱신
			}

			for(Node next : nodes.get(cur.number)) {
				if(visit[next.number]) {
					continue;
				}

				visit[next.number] = true;
				queue.add(new Node(next.number, cur.depth + 1));
			}
		}
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		start = Integer.parseInt(inputs[1]);
		result = Integer.MIN_VALUE;
		nodes = new ArrayList<>();

		visit = new boolean[101];
		for (int i = 0; i <= 100; i++) {
			nodes.add(new ArrayList<>());
		}

		inputs = br.readLine().split(" ");
		for (int i = 0; i < N; i += 2) {
			int from = Integer.parseInt(inputs[i]);
			int to = Integer.parseInt(inputs[i + 1]);
			nodes.get(from).add(new Node(to, -1));
		}
	}
}

class Node {
	int number;
	int depth;

	Node(int number, int depth) {
		this.number = number;
		this.depth = depth;
	}
}