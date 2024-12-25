import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int maxLength;
	static int N;
	static String word;
	static Map<Character, Integer> map;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		word = br.readLine();
		maxLength = Integer.MIN_VALUE;
		map = new HashMap<>();
	}

	private static void solve() {
		int start = 0;
		int end = 0;
		int length = 0;

		while (start < word.length() && end < word.length()) {
			// System.out.printf("start: %d, end: %d\n", start, end);
			char endLetter = word.charAt(end);
			map.put(endLetter, map.getOrDefault(endLetter, 0) + 1);
			length++;

			if (map.size() > N) {
				char startLetter = word.charAt(start);
				if (map.get(startLetter) > 1) {
					map.put(startLetter, map.get(startLetter) - 1);
				} else {
					map.remove(startLetter);
				}
				start++;
				length--;
			}

			maxLength = Math.max(length, maxLength);
			end++;
		}
	}

	private static void output() {
		System.out.println(maxLength);
	}
}