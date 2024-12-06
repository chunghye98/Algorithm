import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] people;
	static int result;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(br.readLine());
		}
	}

	private static void solve() {
		Arrays.sort(people);

		int halfJump = (int)Math.round(N * 0.3 / 2);
		double sum = 0;
		int count = 0;
		for (int i = halfJump; i < N - halfJump; i++) {
			sum += people[i];
			count++;
		}

		result = (int)Math.round(sum / count);
	}

	private static void output() {
		System.out.println(result);
	}
}