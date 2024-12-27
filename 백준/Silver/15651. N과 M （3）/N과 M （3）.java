import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static List<Integer> answer;

	public static void main(String[] args) throws Exception {
		init();
		solve(0);
		output();
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		answer = new ArrayList<>();
	}

	public static void solve(int cnt) {
		if (cnt == M) {
			for(int value : answer) {
				sb.append(value).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			answer.add(i);
			solve(cnt + 1);
			answer.remove(answer.size() - 1);
		}
	}

	public static void output() {
		System.out.println(sb);
	}
}