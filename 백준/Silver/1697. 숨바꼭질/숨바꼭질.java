import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 100001;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int result;
	
	static int[] visit = new int[MAX]; // 방문 시간 저장
	static int N, K;

	public static void main(String[] args) throws IOException {
		init();
		solveBFS(N, K);
		output();
	}

	private static void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		K = Integer.parseInt(inputs[1]);
	}

	private static void solveBFS(int start, int target) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visit[start] = 0; // 0초부터 시작

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (cur == target) {
				result = visit[cur];
				return;
			}

			int[] nextX = {cur - 1, cur + 1, cur * 2};
			for (int next : nextX) {
				if (isRange(next) && visit[next] == 0) {
					queue.add(next);
					visit[next] = visit[cur] + 1;
				}
			}
		}
	}

	private static boolean isRange(int next) {
		return next >= 0 && next < MAX;
	}

	private static void output() {
		System.out.println(result);
	}
}