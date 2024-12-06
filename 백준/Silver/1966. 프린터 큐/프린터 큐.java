import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static Queue<Paper> papers;
	static int result;

	static class Paper{
		int index;
		int priority;

		Paper(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			init();
			solve();
			output();
		}
		System.out.println(sb);
	}

	private static void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		papers = new LinkedList<>();
		inputs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int priority = Integer.parseInt(inputs[i]);
			papers.add(new Paper(i, priority));
		}
	}

	private static void solve() {
		int count = 0;
		while (!papers.isEmpty()) {
			Paper current = papers.poll();

			boolean hasHigher = false;
			for (Paper p : papers) {
				if(current.priority < p.priority) {
					hasHigher = true;
					break;
				}
			}

			if(hasHigher) {
				papers.add(current);
			}else {
				count++;
				if (current.index == M) {
					result = count;
					return;
				}
			}
		}
	}

	private static void output() {
		sb.append(result).append("\n");
	}
}