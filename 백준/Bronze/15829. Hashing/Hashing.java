import java.io.*;

public class Main {
	static final int MOD = 1234567891;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] str;
	static long result;

	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		str = new int[N];
		char[] inputs = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) {
			str[i] = inputs[i] - 'a' + 1;
		}
	}

	private static void solve() {
		result = 0;
		long power = 1;
		for (int value : str) {
			result = (result + value * power) % MOD;
			power = (power * 31) % MOD;
		}
	}

	private static void output() {
		System.out.println(result);
	}
}