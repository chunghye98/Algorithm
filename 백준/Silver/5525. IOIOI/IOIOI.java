import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static String target;
	static String condition;
	static int count;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		target = br.readLine();
	}

	private static void solve() {
		makeCondition(1, sb.append("I"), "I");
		findCount();
	}

	private static void makeCondition(int count, StringBuilder sb, String before) {
		if (count == 2 * N + 1) {
			condition = sb.toString();
			return;
		}

		if (before.equals("I")) {
			sb.append("O");
			makeCondition(count + 1, sb, "O");
		}else {
			sb.append("I");
			makeCondition(count + 1, sb, "I");
		}
	}

	private static void findCount() {
		for (int i = 0; i <= target.length() - condition.length(); i++) {
			if (target.substring(i, i + condition.length()).equals(condition)) {
				count++;
			}
		}
	}

	private static void output() {
		System.out.println(count);
	}
}