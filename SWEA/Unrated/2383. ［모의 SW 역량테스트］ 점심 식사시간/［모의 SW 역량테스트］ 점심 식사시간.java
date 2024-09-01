import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int N;
	static int[][] map;
	static StairSystem s1, s2;
	static List<Person> persons;
	static int result;

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
		makeSubSet(0, new boolean[persons.size()]);
	}

	public static void makeSubSet(int cnt, boolean[] check) {
		if(cnt == check.length) {
			move(check);
			return;
		}

		check[cnt] = true;
		makeSubSet(cnt + 1, check);

		check[cnt] = false;
		makeSubSet(cnt + 1, check);
	}

	public static void move(boolean[] check) {
		for (int i = 0; i < check.length; i++) {
			if (check[i]) {
				s1.allocate(persons.get(i));
			} else {
				s2.allocate(persons.get(i));
			}
		}

		int moveTime1 = s1.move();
		int moveTime2 = s2.move();

		result = Math.min(result, Math.max(moveTime1, moveTime2));
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		s1 = null;
		s2 = null;
		persons = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);

				if(map[i][j] == 1) {
					persons.add(new Person(i, j));
				}else if(map[i][j] > 1){
					if(s1 == null) {
						s1 = new StairSystem(i, j, map[i][j]);
					}else {
						s2 = new StairSystem(i, j, map[i][j]);
					}
				}
			}
		}
		result = Integer.MAX_VALUE;
	}

	static class Person {
		int y;
		int x;
		int time;

		Person(int y, int x) {
			this.y = y;
			this.x = x;
			this.time = 0;
		}

		void updateTime(StairSystem s) {
			this.time = Math.abs(this.y - s.y) + Math.abs(this.x - s.x);
		}
	}

	static class StairSystem {
		int y;
		int x;
		int height;
		List<Person> allocatedPersons = new ArrayList<>();
		List<Person> onStairPersons = new ArrayList<>();

		StairSystem(int y, int x, int height) {
			this.y = y;
			this.x = x;
			this.height = height;
		}

		void allocate(Person p) {
			p.updateTime(this);
			allocatedPersons.add(p);
		}

		int move() {
			int time = 0;
			while(!allocatedPersons.isEmpty() || !onStairPersons.isEmpty()) {
				moveOnStairPersons();
				moveAllocatedPersons();
				time++;
			}

			return time;
		}

		void moveOnStairPersons() {
			for (int i = 0; i < Math.min(3, onStairPersons.size()); i++) {
				Person p = onStairPersons.get(i);
				p.time--;

				if (p.time == 0) {
					onStairPersons.remove(i--);
				}
			}
		}

		void moveAllocatedPersons() {
			for (int i = 0; i < allocatedPersons.size(); i++) {
				Person p = allocatedPersons.get(i);
				p.time--;
				if (p.time == 0) {
					allocatedPersons.remove(i--);
					p.time = this.height + 1;
					onStairPersons.add(p);
				}
			}
		}
	}
}