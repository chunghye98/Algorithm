import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] inputs;
	static String result;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		inputs = new String[4];

		for (int i = 1; i <= 3; i++) {
			inputs[i] = br.readLine();
		}
	}

	private static void solve() {
		for (int i = 3; i >= 1; i--) {
			if (inputs[i].equals("Fizz") || inputs[i].equals("Buzz") || inputs[i].equals("FizzBuzz")) {
				continue;
			}

			int value = Integer.parseInt(inputs[i]);
			value += (4 - i);

			if (value % 3 == 0 && value % 5 == 0) {
				result = "FizzBuzz";
			} else if (value % 3 == 0) {
				result = "Fizz";
			} else if (value % 5 == 0) {
				result = "Buzz";
			}else {
				result = String.valueOf(value);
			}

			break;
		}
	}

	private static void output() {
		System.out.println(result);
	}
}