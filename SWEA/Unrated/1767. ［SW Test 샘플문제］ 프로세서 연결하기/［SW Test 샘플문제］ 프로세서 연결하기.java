import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int T;
	static int N;
	static int[][] map;
	static List<Point> cores;
	static int[][] dxy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //상우하좌
	static int coreMax;

	static int result;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			init();
			solve(0, 0, 0);
			output(t);
		}
		System.out.println(sb);
	}

	public static void output(int t) {
		sb.append("#").append(t).append(" ").append(result).append("\n");
	}

	public static void solve(int cnt, int coreCount, int wireLength) {
		if(cnt == cores.size()) {
			if(coreCount > coreMax || (coreCount == coreMax && wireLength < result)) {
				coreMax = coreCount;
				result = wireLength;
			}
			return;
		}

		Point core = cores.get(cnt);

		if(isOutLine(core.y, core.x)) {
			solve(cnt + 1, coreCount + 1, wireLength);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int len = canAllocateWire(core, i);

			if(len == -1) {
				continue;
			}

			placeWire(core, i, len, 2); // 전선 설치
			solve(cnt + 1, coreCount + 1, wireLength + len);
			placeWire(core, i, len, 0); // 전선 제거
		}
		solve(cnt + 1, coreCount, wireLength); // 현재 코어를 연결하지 않는 경우
	}

	public static int canAllocateWire(Point core, int d) {
		int ny = core.y;
		int nx = core.x;
		int length = 0;

		while (true) {
			ny += dxy[d][0];
			nx += dxy[d][1];
			if (!isRange(ny, nx)) {
				break;
			}
			if (map[ny][nx] != 0) {
				return -1; // 다른 코어나 전선이 있는 경우
			}
			length++;
		}
		return length;
	}

	public static void placeWire(Point core, int d, int length, int value) {
		int ny = core.y;
		int nx = core.x;

		for (int i = 0; i < length; i++) {
			ny += dxy[d][0];
			nx += dxy[d][1];
			map[ny][nx] = value;
		}
	}

	public static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < N;
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		result = Integer.MAX_VALUE;
		coreMax = 0;
		map = new int[N][N];
		cores = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);

				if(map[i][j] == 1){
					cores.add(new Point(i, j));
				}
			}
		}
	}

	public static boolean isOutLine(int y, int x) {
		return y == 0 || x == 0 || y == N - 1 || x == N - 1;
	}

	static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}