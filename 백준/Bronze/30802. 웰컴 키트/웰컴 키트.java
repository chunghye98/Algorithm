import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] sizes;
	static int T;
	static int P;

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

	public static void solve() {
		int orderT = calculateTOrder();
		int[] orderP = calculatePOrder();

		System.out.println(orderT);
		System.out.println(orderP[0] + " " + orderP[1]);
	}

	private static int[] calculatePOrder() {
		int order = N / P;
		int one = N % P;
		return new int[]{order, one};
	}

	private static int calculateTOrder() {
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			if(sizes[i] % T == 0){
				sum += sizes[i] / T;
			}else {
				sum += sizes[i] / T + 1;
			}
		}
		return sum;
	}

	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		sizes = new int[6];
		for (int i = 0; i < 6; i++) {
			sizes[i] = Integer.parseInt(inputs[i]);
		}

		inputs = br.readLine().split(" ");
		T = Integer.parseInt(inputs[0]);
		P = Integer.parseInt(inputs[1]);

	}
}