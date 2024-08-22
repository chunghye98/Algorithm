import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int roomNum;
	static int max;
	
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
		sb.append("#").append(t).append(" ").append(roomNum).append(" ").append(max).append("\n");
	}

	public static void solve() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visit = new boolean[n][n];
				int count = bfs(i, j);
				
				if(count > max) {
					max = count;
					roomNum = map[i][j];
				}else if(count == max) {
					if(map[i][j] < roomNum) {
						roomNum = map[i][j];
					}
				}

			}
		}
	}
	
	public static int bfs(int y, int x) {
		Queue<MyPoint> queue = new ArrayDeque<>();
		queue.add(new MyPoint(y, x));
		visit[y][x] = true;
		int count = 1;
		
		while(!queue.isEmpty()) {
			MyPoint cur = queue.poll();
			int cy = cur.y;
			int cx = cur.x;
			
			for(int i=0; i<4; i++) {
				int ny = cy + dxy[i][0];
				int nx = cx + dxy[i][1];
				
				if(!canGo(ny, nx, cy, cx)) {
					continue;
				}
				
				visit[ny][nx] = true;
				queue.add(new MyPoint(ny, nx));
				count++;
			}
		}
		return count;
	}

	public static boolean canGo(int ny, int nx, int cy, int cx ) {
		return isRange(ny, nx) && !visit[ny][nx] && map[ny][nx] == map[cy][cx] + 1;
	}

	public static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < n && x < n;
	}

	public static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		max = Integer.MIN_VALUE;
		roomNum = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
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