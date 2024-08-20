import java.util.Scanner;

public class Solution {

	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int result;
	static int T;
	static int n;
	static int[] mountains;

	public static void main(String[] args) throws Exception {
		T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			init();
			solve();
			output(i);
		}
		System.out.println(sb);
	}

	public static void output(int t) {
		sb.append("#").append(t).append(" ").append(result).append("\n");
	}

	public static void solve() {
		int up = 0;
		int down = 0;
		for(int i=1; i<n; i++) {
			
			if(mountains[i-1] < mountains[i]) {
				if(down == 0) {
					up++;
				}else {
					result += up * down;
					up = 1;
					down = 0;
				}
			}else if(mountains[i-1] > mountains[i]) {
				down++;
			}
		}
		result += up * down;
	}

	public static void init() throws Exception {
		n = sc.nextInt();
		mountains = new int[n];
		result = 0;

		for (int i = 0; i < n; i++) {
			mountains[i] = sc.nextInt();
		}
	}
}