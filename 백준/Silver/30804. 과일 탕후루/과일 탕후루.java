import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] numbers;
	static int max;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		numbers = new int[N];
		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(inputs[i]);
		}

		max = Integer.MIN_VALUE;
	}

	private static void solve() {
		int start = 0;
		int end = 0;

		Map<Integer, Integer> countMap = new HashMap<>();

		while (end < N) {
			countMap.put(numbers[end], countMap.getOrDefault(numbers[end], 0) + 1);

			while (countMap.size() > 2) {
				countMap.put(numbers[start], countMap.get(numbers[start]) - 1);

				if (countMap.get(numbers[start]) == 0) {
					countMap.remove(numbers[start]);
				}

				start++;
			}

			max = Math.max(max, end - start + 1);

			end++;
		}
	}

	private static void output() {
		System.out.println(max);
	}
}