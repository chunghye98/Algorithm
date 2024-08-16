import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] liquid;
	static int[] result;

	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}

	public static void output() {
		for (int v : result) {
			sb.append(v).append(" ");
		}
		sb.append("\n");
		System.out.println(sb);
	}

	public static void solve() {
		Arrays.sort(liquid);

		int left = 0;
		int right = liquid.length - 1;
		int absMin = Integer.MAX_VALUE;

		while (left < right) {
			int sum = liquid[left] + liquid[right];
			if (Math.abs(sum) < absMin) {
				absMin = Math.abs(sum);
				result = new int[] {liquid[left], liquid[right]};
			}

			if(sum > 0) {
				right--;
			}else {
				left++;
			}
		}
	}

	public static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		liquid = new int[n];
		result = new int[2];

		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			liquid[i] = Integer.parseInt(inputs[i]);
		}
	}
}