import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int testCase;
	static int n; // 재료의 수
	static int m; // 궁합 안 좋은 재료쌍의 수
	static boolean[][] notGood;
	static int result;
	static boolean[] visit;
	static int[] input;
	
	public static void main(String[] args) throws Exception {
		testCase = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCase; i++) {
			init();
			makeSubset(0);
			output(i);
		}
		System.out.println(sb);
	}

	public static void output(int num) {
		sb.append("#").append(num).append(" ").append(result).append("\n");
	}

	public static void makeSubset(int cnt) {
		if (cnt == n) {
			if (!isGood(visit)) {
				return;
			}
			
			result++;
			return;
		}

		visit[cnt] = true;
		makeSubset(cnt + 1);
		visit[cnt] = false;
		makeSubset(cnt + 1);
	}

	public static boolean isGood(boolean[] visit) {
		for (int i = 0; i < visit.length - 1; i++) {
			for (int j = i + 1; j < visit.length; j++) {
				boolean a = visit[i];
				boolean b = visit[j];
				if (!a || !b) {
					continue;
				}
				if (notGood[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		notGood = new boolean[20][20];
		visit = new boolean[n];
		input = new int[n];
		result = 0;
		
		for(int i=0; i<n; i++) {
			input[i] = i;
		}

		for (int i = 0; i < m; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				int a = Integer.parseInt(inputs[0]) - 1;
				int b = Integer.parseInt(inputs[1]) - 1;

				notGood[a][b] = true;
				notGood[b][a] = true;
			}
		}
	}

}