
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine()); // N! 끝자리에 있는 0의 개수

		int result = binarySearch(m);

		if (findFiveCount(result) != m) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	private static int binarySearch(int m) {
		int start = 0;
		int end = m * 5; // m개의 0을 만들기 위해 적어도 m개의 5가 필요함
		int result = -1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int count = findFiveCount(mid);

			if (count < m) {
				start = mid + 1;
			} else {
				end = mid - 1;
				result = mid;
			}
		}
		return result;
	}

	// 주어진 정수 mid 까지의 수 중 5의 배수의 개수를 찾아내는 함수
	private static int findFiveCount(int mid) {
		int count = 0;
		for (int i = 5; i <= mid; i *= 5) {
			count += (mid / i);
		}
		return count;
	}
}
