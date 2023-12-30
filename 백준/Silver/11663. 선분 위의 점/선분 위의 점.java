
import java.io.*;
import java.util.*;

public class Main {

	private static long[] points;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int pointN = Integer.parseInt(st.nextToken());
		int edgeN = Integer.parseInt(st.nextToken());

		points = new long[pointN];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < pointN; i++) {
			points[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(points);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < edgeN; i++) {
			st = new StringTokenizer(br.readLine());

			long first = Long.parseLong(st.nextToken());
			long second = Long.parseLong(st.nextToken());

			sb.append(binarySearch(first, second));
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static int binarySearch(long first, long second) {
		int start = 0;
		int end = points.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (first <= points[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		int startIndex = start;

		start = 0;
		end = points.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (second < points[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		int endIndex = end + 1;

		return endIndex - startIndex;
	}
}
