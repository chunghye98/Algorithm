
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] graph = new int[n + 1][n + 1];

		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b++) {
					// 단순히 갈 수 있는 경로가 있는지만 체크
					if (graph[a][k] == 1 && graph[k][b] == 1) {
						graph[a][b] = 1;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (graph[i][j] > 0) {
					sb.append("1");
				} else {
					sb.append("0");
				}
				sb.append(" ");
			}
			sb.delete(sb.length()-1, sb.length());
			sb.append("\n");
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb);
	}
}
