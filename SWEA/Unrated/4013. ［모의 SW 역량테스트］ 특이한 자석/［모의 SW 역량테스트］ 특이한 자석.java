import java.io.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int K;
	static int[][] magnetics;
	static int[][] commands;

	static int result;

	public static void main(String[] args) throws Exception {
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
		findDirectorsAndRotate();
		calculate();
	}

	private static void calculate() {
		for (int i = 1; i < magnetics.length; i++) {
			if (magnetics[i][0] == 1) {
				result += (int) Math.pow(2, i - 1);
			}
		}
	}

	private static void rotate(int[] directors) {
		for (int i = 1; i < directors.length; i++) {
			if(directors[i] == 1) {
				rotateRight(i);
			} else if (directors[i] == -1) {
				rotateLeft(i);
			}
		}
	}

	private static void rotateLeft(int num) {
		int[] mag = magnetics[num];

		int temp = mag[0];
		for (int i = 1; i <= 7; i++) {
			mag[i - 1] = mag[i];
		}
		mag[7] = temp;
	}

	private static void rotateRight(int num) {
		int[] mag = magnetics[num];

		int temp = mag[7];
		for (int i = 7; i > 0; i--) {
			mag[i] = mag[i - 1];
		}
		mag[0] = temp;
	}

	private static void findDirectorsAndRotate() {
		for (int[] command : commands) {
			int[] directors = new int[5];
			int number = command[0];
			int dir = command[1];

			directors[number] = dir;

			// 왼쪽 탐색
			for (int i = number; i > 1; i--) {
				if (canRotate(i - 1, i)) {
					directors[i - 1] = directors[i] * -1;
				}
			}

			// 오른쪽 탐색
			for (int i = number; i < 4; i++) {
				if (canRotate(i, i + 1)) {
					directors[i + 1] = directors[i] * -1;
				}
			}

			rotate(directors);
		}
	}

	private static boolean canRotate(int left, int right) {
		return magnetics[left][2] != magnetics[right][6];
	}

	private static void init() throws IOException {
		K = Integer.parseInt(br.readLine());

		magnetics = new int[5][8];
		for (int i = 1; i <= 4; i++) {
			String[] inputs = br.readLine().split(" ");

			for (int j = 0; j < 8; j++) {
				magnetics[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		commands = new int[K][2];
		for (int i = 0; i < K; i++) {
			String[] inputs = br.readLine().split(" ");

			for (int j = 0; j < 2; j++) {
				commands[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		result = 0;
	}
}