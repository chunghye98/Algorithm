
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] graph = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int now = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			if (graph[now][next] <= time) {
				sb.append("Enjoy other party");
			} else {
				sb.append("Stay here");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);

	}
}
