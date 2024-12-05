import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int A, B, V;
	static int time;

	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		A = Integer.parseInt(inputs[0]);
		B = Integer.parseInt(inputs[1]);
		V = Integer.parseInt(inputs[2]);
	}

	private static void solve() {
		time = (int)Math.ceil((double)(V - B) / (A - B)); // V - B: 마지막 날 미끄러지지 않는 거리
	}

	private static void output() {
		System.out.println(time);
	}
}