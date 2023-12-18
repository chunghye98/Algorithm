
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cardsIHave = new int[n];
		for (int i = 0; i < n; i++) {
			cardsIHave[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] cardsToIdentify = new int[m];
		for (int i = 0; i < m; i++) {
			cardsToIdentify[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cardsIHave);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			sb.append(binarySearch(cardsIHave, cardsToIdentify[i], 0, n - 1) + " ");
		}

		System.out.println(sb);
	}

	private static int binarySearch(int[] cardsIHave, int target, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;

			if (cardsIHave[mid] == target) {
				return 1;
			} else if (cardsIHave[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return 0;
	}
}
