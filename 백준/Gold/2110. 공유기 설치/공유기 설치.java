
import java.io.*;
import java.util.*;

/*
 * 답안 참고: https://st-lab.tistory.com/277
 */
public class Main {

	static int[] house;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		house = new int[n];
		for (int i = 0; i < n; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(house);

		System.out.println(binarySearch(c) - 1);
	}

	private static int binarySearch(int c) {
		int start = 1; // 최소 거리가 가질 수 있는 최솟값
		int end = house[n - 1] - house[0] + 1; // 최소 거리가 가질 수 있는 최댓값

		while (start < end) {
			int mid = (start + end) / 2;

			/*
			 * mid 거리에 대해 설치 가능한 공유기 개수가 M 개수에 못미치면
			 * 거리를 좁혀야 하기 때문에 end 를 줄인다.
			 */
			if (isInstall(mid) < c) {
				end = mid;
			} else {
				/*
				 * 설치 가능한 공유기 개수가 c 개수보다 크거나 같으면
				 * 거리를 벌리면서 최소거리가 가질 수 있는 최대 거리를
				 * 찾아낸다.
				 */
				start = mid + 1;
			}
		}
		return start;
	}

	// distance에 대해 설치 가능한 공유기 개수를 찾는 메소드
	private static int isInstall(int distance) {
		// 첫 번째 집은 무조건 설치
		int count = 1;
		int lastLocate = house[0];

		for (int i = 1; i < house.length; i++) {
			int locate = house[i];

			/*
			 * 현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가
			 * 최소 거리(distance)보다 크거나 같을 때 공유기 설치 개수를 늘려주고
			 * 마지막 설치 위치를 갱신
			 */
			if (locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		return count;
	}
}
