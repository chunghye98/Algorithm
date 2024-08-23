import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int time;
	static int BCCount;
	static int[] moveA;
	static int[] moveB;
	static BC[] bcs;
	static int maxSum;
	static int[][] dxy = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};  // {정지, 상, 우, 하, 좌}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			init();
			solve();
			output(i);
		}
		System.out.println(sb);
	}

	public static void output(int t) {
		sb.append("#").append(t).append(" ").append(maxSum).append("\n");
	}

	public static void solve() {
		Person A = new Person(1, 1);
		Person B = new Person(10, 10);

		maxSum = 0;
		// 초기 상태도 확인
		for (int i = 0; i <= time; i++) {
			A.x += dxy[moveA[i]][0];
			A.y += dxy[moveA[i]][1];
			B.x += dxy[moveB[i]][0];
			B.y += dxy[moveB[i]][1];

			maxSum += getMaxSum(A, B);
		}
	}

	public static int getMaxSum(Person A, Person B) {
		int max = 0;
		for (int a = 0; a < bcs.length; a++) {
			for (int b = 0; b < bcs.length; b++) {
				int sum = 0;
				int chargeA = findCharge(a, A.x, A.y);
				int chargeB = findCharge(b, B.x, B.y);

				if (a != b) {
					sum = chargeA + chargeB;
				} else {
					sum = Math.max(chargeA, chargeB);
				}

				if (max < sum) {
					max = sum;
				}
			}
		}
		return max;
	}

	private static int findCharge(int bc, int x, int y) {
		if (Math.abs(bcs[bc].x - x) + Math.abs(bcs[bc].y - y) <= bcs[bc].charge) {
			return bcs[bc].power;
		}
		return 0;
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		time = Integer.parseInt(inputs[0]);
		BCCount = Integer.parseInt(inputs[1]);

		// 처음 값을 계산하기 위함
		moveA = new int[time + 1];
		moveB = new int[time + 1];

		String[] inputsA = br.readLine().split(" ");
		String[] inputsB = br.readLine().split(" ");

		// 초기위치는 이동 x
		// moveA[0] = 0 <- default
		for (int i = 1; i <= time; i++) {
			moveA[i] = Integer.parseInt(inputsA[i - 1]);
			moveB[i] = Integer.parseInt(inputsB[i - 1]);
		}

		bcs = new BC[BCCount];
		for (int i = 0; i < BCCount; i++) {
			inputs = br.readLine().split(" ");
			int x = Integer.parseInt(inputs[0]);  // x 좌표
			int y = Integer.parseInt(inputs[1]);  // y 좌표
			int charge = Integer.parseInt(inputs[2]);
			int power = Integer.parseInt(inputs[3]);

			bcs[i] = new BC(x, y, charge, power);
		}
	}

	static class BC {
		int x;
		int y;
		int charge;
		int power;

		BC(int x, int y, int charge, int power) {
			this.x = x;
			this.y = y;
			this.charge = charge;
			this.power = power;
		}
	}

	static class Person {
		int x;
		int y;

		Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}