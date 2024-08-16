import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int testCase;
	static int n;
	static int limit;
	static Component[] components;
	static boolean[] visit;
	static int max;

	public static void main(String[] args) throws Exception {
		testCase = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCase; i++) {
			init();
			makeSubset(0, 0, 0);
			output(i);
		}
		System.out.println(sb);
	}
	
	public static void output(int testCase) {
		sb.append("#").append(testCase).append(" ").append(max).append("\n");
	}
	
	public static void makeSubset(int cnt, int score, int calorie) {
		if(cnt == n) {
			
			if(calorie > limit) {
				return;
			}
			
			max = Math.max(score, max);
			
			return;
		}
		
		visit[cnt] = true;
		makeSubset(cnt + 1, score + components[cnt].score, calorie + components[cnt].calorie);
		visit[cnt] = false;
		makeSubset(cnt + 1, score, calorie);
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		limit = Integer.parseInt(inputs[1]);
		components = new Component[n];
		visit = new boolean[n];
		max = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			inputs = br.readLine().split(" ");
			int score = Integer.parseInt(inputs[0]);
			int calorie = Integer.parseInt(inputs[1]);
			components[i] = new Component(score, calorie);
		}
	}
}

class Component {
	int score;
	int calorie;

	Component(int score, int calorie) {
		this.score = score;
		this.calorie = calorie;
	}
}