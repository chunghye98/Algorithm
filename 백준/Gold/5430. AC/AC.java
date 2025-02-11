import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static Deque<Integer> dq;
	static String[] commands;
	static boolean isReversed;
	static String result;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			init();
			solve();
			output();
		}
		System.out.println(sb);
	}

	private static void init() throws Exception {
		commands = br.readLine().split("");
		int N = Integer.parseInt(br.readLine());
		dq = new ArrayDeque<>();
		result = "";
		isReversed = false;

		String[] inputs = br.readLine().replaceAll("\\[|\\]", "").split(",");
		for (int i = 0; i < N; i++) {
			dq.add(Integer.parseInt(inputs[i]));
		}
	}

	private static void solve() {
		for (String command : commands) {
			switch(command) {
				case "R" :
					reverse();
					break;
				case "D" :
					if (dq.isEmpty()) {
						result = "error";
						return;
					}
					removeFirst();
					break;
			}
		}
	}

	private static void reverse() {
		isReversed = !isReversed;
	}

	private static void removeFirst() {
		if (isReversed) {
			dq.removeLast();
		} else {
			dq.removeFirst();
		}
	}

	private static void output() {
		if (result.equals("error")) {
			sb.append(result);
		} else {
			sb.append("[");
			while (!dq.isEmpty()) {
				sb.append(isReversed ? dq.pollLast() : dq.pollFirst());
				if (!dq.isEmpty()) sb.append(","); 
			}
			sb.append("]");
		}
		sb.append("\n");
	}
}