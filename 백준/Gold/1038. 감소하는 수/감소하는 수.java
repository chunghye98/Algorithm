import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static List<Long> decreaseNumbers;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		decreaseNumbers = new ArrayList<>();
	}

	private static void solve() {
		for (int i = 0; i < 10; i++) {
			makeDecreaseNumber(i, 1);
		}

		Collections.sort(decreaseNumbers);
	}

	// 재귀적으로 감소하는 수 생성 / num: 현재 생성 중인 숫자, value: 현재 숫자의 자릿수
	private static void makeDecreaseNumber(long num, int value) {
		// 감소하는 수는 최대 10자리
		if (value > 10) {
			return;
		}

		decreaseNumbers.add(num);

		for (int i = 0; i < num % 10; i++) {
			makeDecreaseNumber((num * 10) + i, value + 1);
		}
	}

	// N번째 감소하는 수가 있으면 출력, 없으면 -1 출력
	private static void output() {
		if (N >= decreaseNumbers.size()) {
			System.out.println(-1);
		}else {
			System.out.println(decreaseNumbers.get(N));
		}
	}
}