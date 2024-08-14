import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}

	public static void output() {
		System.out.println(sb);
	}

	public static void solve() {
		comb(0, 0, new int[m]);
	}

	public static void comb(int cnt, int start, int[] save) {
		if (cnt == m) {
			makeOutput(save);
			return;
		}

		for (int i = start; i < n; i++) {
			save[cnt] = i + 1;
			comb(cnt + 1, i + 1, save);
		}
	}

	public static void makeOutput(int[] save) {
		for (int v : save) {
			sb.append(v).append(" ");
		}
		sb.append("\n");
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
	}
}