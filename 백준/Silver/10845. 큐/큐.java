import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> queue = new ArrayDeque<>();
	static int N;

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			switch(input[0]) {
				case "push" :
					queue.add(Integer.parseInt(input[1]));
					break;
				case "front" :
					if(queue.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.peekFirst()).append("\n");
					}
					break;
				case "back" :
					if(queue.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.peekLast()).append("\n");
					}
					break;
				case "size" :
					sb.append(queue.size()).append("\n");
					break;
				case "empty" :
					if (queue.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "pop" :
					if (queue.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.poll()).append("\n");
					}
					break;
			}
		}
		System.out.println(sb);
	}
}
