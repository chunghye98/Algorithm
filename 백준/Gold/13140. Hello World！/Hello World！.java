import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int first;
	static int second;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	private static void solve() {
		for (int i = 10_000; i <= N - 10_000; i++) {
			String strFirst = String.valueOf(i);
			String strSecond = String.valueOf(N - i);

			if (strFirst.length() != 5 || strSecond.length() != 5)
				continue;

			if (!(strFirst.charAt(2) == strFirst.charAt(3) && strFirst.charAt(3) == strSecond.charAt(3))) {
				continue;
			}

			if (strFirst.charAt(4) != strSecond.charAt(1)) {
				continue;
			}

			Set<Character> usedDigits = new HashSet<>();
			boolean isFail = false;
			for (int j = 0; j < 5; j++) {
				if (j == 3) {
					continue;
				} else if (j == 4) {
					if (!usedDigits.add(strSecond.charAt(j))) {
						isFail = true;
						break;
					}
				} else if (!usedDigits.add(strFirst.charAt(j)) || !usedDigits.add(strSecond.charAt(j))) {
					isFail = true;
					break;
				}
			}

			if (!isFail) {
				first = i;
				second = N - i;
				break;
			}
		}
	}

	private static void output() {
		if (first == 0 && second == 0) {
			sb.append("No Answer");
		} else {
			sb.append("  ").append(first).append("\n");
			sb.append("+ ").append(second).append("\n");
			sb.append("-------\n");
			if (String.valueOf(N).length() > 5) {
				sb.append(" ").append(N);
			} else {
				sb.append("  ").append(N);
			}
		}
		System.out.println(sb);
	}
}