import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int n;
	static int target;
	static List<Integer> heights;
	static boolean[] visit;
	static int min;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			init();
			solve();
			output(i);
		}
		System.out.println(sb);
	}
	
	public static void output(int t) {
		sb.append("#").append(t).append(" ").append(min).append("\n");
	}

	public static void solve() {
		Collections.reverse(heights);

		makeSubSet(0);
	}

	public static void makeSubSet(int cnt) {
		if (cnt == n) {
			int sum = calculate();
			
			if(sum < target) {
				return;
			}
			
			min = Math.min(min, Math.abs(sum - target));
			return;
		}

		visit[cnt] = true;
		makeSubSet(cnt + 1);
		visit[cnt] = false;
		makeSubSet(cnt + 1);
	}

	public static int calculate() {
		int sum = 0;
		for (int i = 0; i < visit.length; i++) {
			sum += visit[i] ? heights.get(i) : 0;
		}
		return sum;
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		target = Integer.parseInt(inputs[1]);
		visit = new boolean[n];
		min = Integer.MAX_VALUE;

		heights = new ArrayList<>();
		inputs = br.readLine().split(" ");
		for (int i = 0; i < inputs.length; i++) {
			heights.add(Integer.parseInt(inputs[i]));
		}
	}
}