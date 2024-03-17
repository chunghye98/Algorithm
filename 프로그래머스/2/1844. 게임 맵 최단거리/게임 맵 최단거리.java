import java.io.*;
import java.util.*;

class Solution {
    
    boolean[][] visit;
	int[] dx = {0, 1, 0, -1}; // 상우하좌
	int[] dy = {-1, 0, 1, 0};
	int n;
    int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
		visit = new boolean[n][m];

		Queue<MyPoint2> queue = new LinkedList<>();
		queue.add(new MyPoint2(0, 0));
		visit[0][0] = true;

		while (!queue.isEmpty()) {
			MyPoint2 current = queue.poll();
			int curY = current.y;
			int curX = current.x;

			for (int i = 0; i < 4; i++) {
				int nextY = curY + dy[i];
				int nextX = curX + dx[i];

				if(isRange(nextY, nextX)) {
					if (!visit[nextY][nextX] && maps[nextY][nextX] == 1) {
						visit[nextY][nextX] = true;
						maps[nextY][nextX] = maps[curY][curX] + 1;
						queue.add(new MyPoint2(nextY, nextX));
					}
				}

			}
		}

		int result = maps[n - 1][m - 1];
		if(result == 1) {
			return -1;
		}
		return result;
    }
    
    private boolean isRange(int nextY, int nextX) {
		if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) {
			return false;
		}
		return true;
	}
}

class MyPoint2 {
	int y;
	int x;

	MyPoint2(int y, int x) {
		this.y = y;
		this.x = x;
	}
}