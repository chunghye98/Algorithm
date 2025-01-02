import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, K;
	static char[] hamburgerAndPerson;
	static int count;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		K = Integer.parseInt(inputs[1]);

		hamburgerAndPerson = br.readLine().toCharArray();
		count = 0;
		visit = new boolean[N];
	}

	private static void solve() {
		for (int i = 0; i < hamburgerAndPerson.length; i++) {
			if(hamburgerAndPerson[i] == 'P') {
				for (int j = Math.max(0, i - K); j < Math.min(i + K + 1, N); j++) {
					if (hamburgerAndPerson[j] == 'H' && !visit[j]) {
						visit[j] = true;
						count++;
						break;
					}
				}
			}
		}
	}

	private static void output() {
		System.out.println(count);
	}
}