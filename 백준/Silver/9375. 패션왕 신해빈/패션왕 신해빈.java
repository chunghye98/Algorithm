import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static Map<String, Integer> map;
	static int result;

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
		n = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			map.put(inputs[1], map.getOrDefault(inputs[1], 0) + 1);
		}
	}

	private static void solve() {
		result = 1;
		for (int value : map.values()) {
			result *= value + 1; // 사용 안 하는 경우 추가
		}
		result--; // 알몸은 안 된다.
	}

	private static void output() {
		sb.append(result).append("\n");
	}
}