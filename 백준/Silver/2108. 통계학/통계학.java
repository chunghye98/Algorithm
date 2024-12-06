import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] numbers;
	static Map<Integer, Integer> map;
	static int avg;
	static int mid;
	static int frequent;
	static int range;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		map = new HashMap<>();
		numbers = new int[N];

		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			numbers[i] = number;
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
	}

	private static void solve() {
		Arrays.sort(numbers);
		int sum = 0;
		for (int n : numbers) {
			sum += n;
		}
		avg = (int)Math.round((double)sum / numbers.length);
		mid = numbers[numbers.length / 2];
		range = numbers[numbers.length - 1] - numbers[0];

		PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(
			(a, b) -> {
				int valueCompare = b.getValue().compareTo(a.getValue());
				if (valueCompare == 0) {
					return a.getKey().compareTo(b.getKey());
				}
				return valueCompare;
			}
		);
		pq.addAll(map.entrySet());

		Entry<Integer, Integer> first = pq.poll();
		if (pq.isEmpty()) {
			frequent = first.getKey();
			return;
		}
		Map.Entry<Integer, Integer> second = pq.poll();
		if (first.getValue() == second.getValue()) {
			frequent = second.getKey();
		}else {
			frequent = first.getKey();
		}
	}

	private static void output() {
		StringBuilder sb = new StringBuilder();
		sb.append(avg).append("\n");
		sb.append(mid).append("\n");
		sb.append(frequent).append("\n");
		sb.append(range).append("\n");
		System.out.println(sb);
	}
}