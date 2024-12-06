import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String[] inputs;
	static String result;
	static boolean isEnd;
	static Map<String, String> map;

	public static void main(String[] args) throws Exception {

		while (true) {
			init();
			solve();
			if (isEnd) {
				break;
			}
			output();
		}
		System.out.println(sb);
	}

	private static void init() throws Exception {
		inputs = br.readLine().split("");
		// 종료조건 확인
		if (inputs.length == 1 && inputs[0].equals(".")) {
			isEnd = true;
			return;
		}

		map = new HashMap<>();
		map.put("(", ")");
		map.put("[", "]");
	}

	public static void solve() {
		Stack<String> stack = new Stack<>();
		boolean isWrong = false;
		for (String input : inputs) {
			if (input.equals("(") || input.equals("[")) {
				stack.push(input);
			}

			if (input.equals(")") || input.equals("]")) {
				if (stack.isEmpty() || !map.get(stack.peek()).equals(input)) {
					isWrong = true;
					break;
				}

				stack.pop();
			}
		}

		if (isWrong || !stack.isEmpty()) {
			result = "no";
		}else {
			result = "yes";
		}
	}

	private static void output() {
		sb.append(result).append("\n");
	}
}