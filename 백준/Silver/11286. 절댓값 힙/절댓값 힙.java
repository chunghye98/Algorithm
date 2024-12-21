import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static PriorityQueue<Number> pq = new PriorityQueue<>();

	static class Number implements Comparable<Number> {
		int x;

		Number(int x) {
			this.x = x;
		}

		@Override
		public int compareTo(Number o) {
			if(Math.abs(this.x) == Math.abs(o.x)) {
				return Integer.compare(this.x, o.x);
			}
			return Integer.compare(Math.abs(this.x), Math.abs(o.x));
		}
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				pq.add(new Number(x));
			}else {
				if (!pq.isEmpty()) {
					sb.append(pq.poll().x).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}