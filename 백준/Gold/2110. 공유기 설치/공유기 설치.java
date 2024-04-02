
import java.io.*;
import java.util.*;

/*
 * 답안 참고: https://st-lab.tistory.com/277
 */
public class Main {

	static int[] house;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		house = new int[n];
		for (int i = 0; i < n; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(house);

		System.out.println(binarySearch(c));
	}

	private static int binarySearch(int c) {
		// 공유기 간의 최대 거리를 찾는데 사용
		int start = 1;
		int end = house[house.length - 1] - house[0];

		while (start <= end) {
			int mid = (start + end) / 2;

			// mid까지 설치된 공유기의 대수가 원하는 값보다 작으면 거리를 늘린다.
			if (isInstall(mid) < c) {
				end = mid - 1;
			}
			// mid까지 설치된 공유기의 대수가 원하는 값보다 크면 같은 경우 거리를 늘린다.
			else {
				start = mid + 1;
			}
		}
		return start - 1; // 공유기 간의 최대 간격, start: 공유기를 설치할 수 없는 거리의 최솟값
	}

	private static int isInstall(int mid) {
		// 첫번째 집은 무조건 설치
		int count = 1;
		int lastLocated = house[0];

		for (int i = 1; i < house.length; i++) {
			int locate = house[i];

			if (locate - lastLocated >= mid) {
				count++;
				lastLocated = locate;
			}
		}
		return count;
	}

}
