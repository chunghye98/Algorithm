
import java.io.*;
import java.util.*;

public class Main {

	static int[] realCards;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		realCards = new int[n];
		for (int i = 0; i < n; i++) {
			realCards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(realCards);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] determineCards = new int[m];
		for (int i = 0; i < m; i++) {
			determineCards[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			sb.append(binarySearch(determineCards[i]) + " ");
		}

		System.out.println(sb);
	}

	private static int binarySearch(int determineCard) {
		int start = 0;
		int end = realCards.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (determineCard < realCards[mid]) {
				end = mid - 1;
			} else if (determineCard > realCards[mid]) {
				start = mid + 1;
			} else {
				return 1;
			}
		}
		return 0;
	}

}
