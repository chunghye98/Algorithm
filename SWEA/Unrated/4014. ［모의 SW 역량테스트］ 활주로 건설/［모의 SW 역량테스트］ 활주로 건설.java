import java.io.*;

/**
 * 경사로 설치 가능 경우
 * 높이가 1 차이 나면서도 경사로의 길이 x만큼 연속된 구간이 있어야 한다.
 *
 */
public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int X;
	static int[][] map;
	static int result;

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			init();
			solve();
			output(t);
		}
		System.out.println(sb);
	}

	private static void output(int t) {
		sb.append("#").append(t).append(" ").append(result).append("\n");
	}

	private static void solve() {
		// 행 별로 검사
		for (int i = 0; i < N; i++) {
			result += countCanSlope(map[i]);
		}

		// 열 별로 검사
		for (int i = 0; i < N; i++) {
			int[] temp = new int[N];
			for (int j = 0; j < N; j++) {
				temp[j] = map[j][i];
			}
			result += countCanSlope(temp);
		}
	}

	// 경사로를 놓을 수 있는지 확인
	private static int countCanSlope(int[] arr) {
		// 같은 높이가 몇 개 연속으로 나왔는지 카운팅
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			// 이전 높이가 지금 높이와 같은 경우
			if (arr[i - 1] == arr[i]) {
				cnt++;
			}
			// 높이가 1증가할 때 경사로를 놓을 수 있는 경우
			else if (arr[i - 1] + 1 == arr[i] && cnt >= X) {
				cnt = 1;
			}
			// 높이가 1 감소할 때 경사로를 놓을 수 있는 경우
			else if (arr[i - 1] == arr[i] + 1 && cnt >= 0) {
				// 앞으로 최소한 x만큼 연속된 구간이 필요
				cnt = 1 - X;
			}
			// 경사로를 놓을 수 없는 경우(높이 차이가 1 초과인 경우, 경사로를 놓을 충분한 연속된 구간이 없는 경우)
			else {
				return 0;
			}
		}

		// 배열의 마지막까지 경사로를 설치할 수 있다면
		if (cnt >= 0) {
			return 1;
		}
		return 0;
	}

	private static void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		X = Integer.parseInt(inputs[1]);

		map = new int[N][N];
		result = 0;

		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
	}
}