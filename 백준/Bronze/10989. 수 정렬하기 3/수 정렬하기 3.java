import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
	}

	private static void solve() {
		Arrays.sort(numbers);
	}

	private static void output() {
		StringBuilder sb = new StringBuilder();
		for (int value : numbers) {
			sb.append(value).append("\n");
		}
		System.out.println(sb);
	}
}