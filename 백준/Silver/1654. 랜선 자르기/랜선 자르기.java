import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int K;
	static int target;
	static int[] lans;
	static int maxLan;
	static long result;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		K = Integer.parseInt(inputs[0]);
		target = Integer.parseInt(inputs[1]);
		lans = new int[K];

		maxLan = Integer.MIN_VALUE;
		for (int i = 0; i < K; i++) {
			lans[i] = Integer.parseInt(br.readLine());
			maxLan = Math.max(maxLan, lans[i]);
		}
	}

	private static void solve() {
		long start = 1;
		long end = maxLan;

		while (start <= end) {
			long mid = (start + end) / 2;

			if (countLanLength(mid) >= target) {
				result = mid;
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
	}

	private static int countLanLength(long mid) {
		int count = 0;
		for (int lan : lans) {
			count += lan / mid;
		}
		return count;
	}

	private static void output() {
		System.out.println(result);
	}
}