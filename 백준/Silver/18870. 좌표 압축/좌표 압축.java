import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] numbers;
	static int N;
	static int[] compactNumbers;
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		init();
		solve();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		compactNumbers = new int[N];
		numbers = new int[N];
		map = new HashMap<>();
		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(inputs[i]);
			numbers[i] = value;
			compactNumbers[i] = value;
		}
	}

	private static void solve() {
		Arrays.sort(compactNumbers);

		int index = 0;
		for (int value : compactNumbers) {
			if (!map.containsKey(value)) {
				map.put(value, index++);
			}
		}

		for (int value : numbers) {
			sb.append(map.get(value)).append(" ");
		}

		System.out.println(sb);
	}
}