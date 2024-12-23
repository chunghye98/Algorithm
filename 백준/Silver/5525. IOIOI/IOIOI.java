import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static String target;
	static int count;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		target = br.readLine();
	}

	private static void solve() {
		int patternLength = 0;
		count = 0;

		for (int i = 1; i < M - 1; i++) {
			if (target.charAt(i - 1) == 'I' && target.charAt(i) == 'O' && target.charAt(i + 1) == 'I') {
				patternLength++;
				if (patternLength == N) {
					patternLength--;
					count++;
				}
				i++;
			}else {
				patternLength = 0;
			}
		}
	}

	private static void output() {
		System.out.println(count);
	}
}