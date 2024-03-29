
import java.io.*;
import java.util.*;

/*
1. n, m 입력
2. n만큼 points 입력받음, 정렬
3. m만큼 반복해서 선분 입력
	1. 선분의 첫번째와 끝을 입력받음
	2. 선분의 첫번째를 포함하는 points 인덱스 찾기
	3. 선분의 끝을 포함하는 points 인덱스 찾기 -> end + 1
	4. 끝인덱스 - 첫인덱스 => 선분 위의 모든 점
 */
public class Main {

	static int[] points;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int pointN = Integer.parseInt(st.nextToken());
		int lineN = Integer.parseInt(st.nextToken());

		points = new int[pointN];

		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < pointN; i++) {
			points[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(points);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lineN; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			sb.append(binarySearch(s, e));
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int binarySearch(int s, int e) {
		int start = 0;
		int end = points.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (s <= points[mid]) {
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

			if (e >= points[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		int endIndex = end + 1; // 끝점도 포함하기 위함

		return endIndex - startIndex;
	}
}

