
import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	private static int[] prices;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		prices = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
			sum += prices[i];
		}

		int target = Integer.parseInt(br.readLine());

		Arrays.sort(prices);

		if (sum <= target) {
			System.out.println(prices[n - 1]);
			return;
		}

		int result = binarySearch(prices, target);
		System.out.println(result);
	}

	private static int binarySearch(int[] prices, int target) {
		int low = 0;
		int high = prices[n - 1];

		while (low < high - 1) {
			int mid = (low + high) / 2;

			if (calculatePrices(mid) > target) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return low;
	}

	private static int calculatePrices(int mid) {
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += Math.min(prices[i], mid);
		}
		return total;
	}
}
