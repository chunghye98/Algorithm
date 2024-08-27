import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int N;
	static int[][] cheeze;
	static boolean[][] visit;
	static int result;
	static int[][] dxy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상우하좌
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			init();
			solve();
			output(t);
		}
		System.out.println(sb);
	}
	
	public static void output(int t) {
		sb.append("#").append(t).append(" ").append(result).append("\n");
	}

	public static void solve() {
		for (int day = 0; day <= 100; day++) {
			int count = 0;
			visit = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (canGo(i, j, day)) {
						continue;
					}
					
					bfs(i, j, day);
					count++;
				}
			}
			result = Math.max(result, count);
		}
	}
	
	public static boolean canGo(int y, int x, int day) {
		return !isRange(y, x) || visit[y][x] || cheeze[y][x] <= day;
	}
	
	public static void bfs(int y, int x, int day) {
		Queue<MyPoint> queue = new ArrayDeque<>();
		visit[y][x] = true;
		queue.add(new MyPoint(y, x));
		
		while(!queue.isEmpty()) {
			MyPoint cur = queue.poll();
			int cy = cur.y;
			int cx = cur.x;
			
			for(int i=0; i<4; i++) {
				int ny = dxy[i][0] + cy;
				int nx = dxy[i][1] + cx;
				
				if(canGo(ny, nx, day)) {
					continue;
				}
				
				visit[ny][nx] = true;
				queue.add(new MyPoint(ny, nx));
			}
		}
	}

	public static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < N;
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());

		cheeze = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				cheeze[i][j] = Integer.parseInt(inputs[j]);
			}
		}
		
		result = 0;
	}
}

class MyPoint {
	int y;
	int x;
	
	MyPoint(int y, int x) {
		this.y = y;
		this.x = x;
	}
}