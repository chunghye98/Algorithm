import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int result;

	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}

	public static void output() {
		System.out.println(result);
	}

	public static void solve() {
		while(n > 0) {
			if(n % 5 == 0) {
				result += n / 5;
				break;
			}else if(n < 5 && n % 3 != 0) {
				result = -1;
				break;
			}
			n -= 3;
			result++;
		}
	}

	public static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		result = 0;
	}
}