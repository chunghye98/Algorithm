import java.io.*;
import java.util.*;

public class Main {

	static final int BEER = 20;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static MyPoint start;
	static MyPoint end;
	static MyPoint[] marts;
	static boolean[] visit;
	static String result;

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testcase; i++) {
			init();
			solve();
			output();
		}
		System.out.println(sb);
	}

	private static void output() {
		sb.append(result).append("\n");
	}

	private static void solve() {
		Queue<MyPoint> queue = new ArrayDeque<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			MyPoint cur = queue.poll();

			if (canGo(cur, end)) {
				result = "happy";
				return;
			}

			for (int i = 0; i < N; i++) {
				if (!visit[i] && canGo(cur, marts[i])) {
					visit[i] = true; // 편의점 방문 처리
					queue.add(marts[i]);
				}
			}
		}

		result = "sad";
	}

	private static boolean canGo(MyPoint cur, MyPoint target) {
		return Math.abs(cur.y - target.y) + Math.abs(cur.x - target.x) <= 50 * BEER;
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N];

		String[] inputs = br.readLine().split(" ");
		start = new MyPoint(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));

		marts = new MyPoint[N];
		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			marts[i] = new MyPoint(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
		}

		inputs = br.readLine().split(" ");
		end = new MyPoint(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
	}

	static class MyPoint {
		int y;
		int x;

		public MyPoint(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}