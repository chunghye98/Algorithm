import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int T;
	static int N;
	static int honeyN;
	static int limit;
	static int[][] map;
	static Person p1, p2;

	static int result;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			init();
			solve(0);
			output(t);
		}
		System.out.println(sb);
	}

	public static void output(int t) {
		sb.append("#").append(t).append(" ").append(result).append("\n");
	}

	public static void solve(int cnt) {
		// 두 사람이 벌통을 선택했을 때
		if (cnt == 2) {
			// 겹치면 안 된다
			if (p1.isDuplicated(p2)) {
				return;
			}

			p1.maxValue = 0;
			p2.maxValue = 0;
			// 가장 많은 꿀을 채취한다.
			p1.select(0, 0);
			p2.select(0, 0);

			int sum = p1.maxValue + p2.maxValue;
			// 벌통 조합의 최대값의 합을 갱신한다
			result = Math.max(sum, result);

			return;
		}

		// 두 사람이 벌통은 선택하는 조합을 모두 만든다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - honeyN + 1; j++) {
				// 첫번째 사람이 벌통의 시작 지점을 선택한다.
				if (cnt == 0) { 
					p1.setLocation(i, j);
				}
				// 두번째 사람이 벌통의 시작 지점을 선택한다.
				if (cnt == 1) {
					p2.setLocation(i, j);
				}
				solve(cnt + 1);
			}
		}
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		honeyN = Integer.parseInt(inputs[1]);
		limit = Integer.parseInt(inputs[2]);

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		result = Integer.MIN_VALUE;
		p1 = new Person(honeyN);
		p2 = new Person(honeyN);
	}

	static class Person {
		int r;
		int c;
		int[] value; // 선택한 벌통에 담긴 꿀들
		int length; // 벌통의 크기
		int maxValue; // 선택한 벌통에 담긴 꿀들의 최대값

		public Person(int honeyN) {
			this.length = honeyN;
			this.value = new int[length];
		}

		public void setLocation(int r, int c) {
			this.r = r;
			this.c = c;
		}

		// 두 사람의 벌통이 겹치면 true
		public boolean isDuplicated(Person o) {
			// 행이 다르면 완전히 겹치지 않음
			if (this.r != o.r) {
				return false;
			}

			// 두 열의 차가 벌통의 길이보다 크면 맞대있거나 떨어져있다. 
			// 겹치지 않는다.
			if (Math.abs(this.c - o.c) >= length) {
				return false;
			}

			return true;
		}

		// 선택한 벌통에서 고를 수 있는 최대 값을 고른다. 
		// 부분집합
		public void select(int depth, int sum) {
			if (sum > limit) {
				return;
			}

			if (depth == length) {
				int profit = calculateProfit();
				this.maxValue = Math.max(this.maxValue, profit);
				return;
			}

			int honey = map[this.r][this.c + depth];
			this.value[depth] = honey;
			select(depth + 1, sum + honey);
			this.value[depth] = 0;
			select(depth + 1, sum);
		}

		public int calculateProfit() {
			int sum = 0;
			for (int v : value) {
				sum += Math.pow(v, 2);
			}
			return sum;
		}
	}
}