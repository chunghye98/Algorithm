import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long n;
	static long target;
	static long[] trees;
	static long result;
	static long maxHeight = -1;

	public static void main(String[] args) throws Exception {
		init();
		binarySearch();
		output();
	}

	public static void output() {
		System.out.println(result);
	}

	public static void binarySearch() {
		long start = 0;
		long end = maxHeight;

		while (start < end) {
			long mid = (start + end) / 2;
			long sum = calculate(mid);

			if (sum < target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		result = start - 1;
	}

	public static long calculate(long mid) {
		long sum = 0;
		for (long v : trees) {
			if (v > mid) {
				sum += v - mid;
			}
		}
		return sum;
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		n = Long.parseLong(inputs[0]);
		target = Long.parseLong(inputs[1]);

		trees = new long[(int) n];
		inputs = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(inputs[i]);
			maxHeight = Math.max(trees[i], maxHeight);
		}
	}
}