
import java.io.*;
import java.util.*;

public class Main{

	private static int n;
	private static int[] prices;
	private static int total;
	private static int target;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		prices = new int[n];
		total = 0;
		for (int i = 0; i < n; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
			total += prices[i];
		}

		target = Integer.parseInt(br.readLine());

		Arrays.sort(prices);

		if (total <= target) {
			System.out.println(prices[n - 1]);
			return;
		}

		int max = binarySearch();
		System.out.println(max);
	}

	private static int binarySearch() {
		int start = 0;
		int end = prices[n - 1];

		while (start < end - 1) {
			int mid = (start + end) / 2;

			int calculateSum = calculate(mid);

			if (calculateSum > target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return start;
	}

	private static int calculate(int mid) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Math.min(mid, prices[i]);
		}
		return sum;
	}
}