import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> dq = new ArrayDeque<>();
	static int N;

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			switch (input[0]) {
				case "push_back" :
					dq.addLast(Integer.parseInt(input[1]));
					break;
				case "push_front" :
					dq.addFirst(Integer.parseInt(input[1]));
					break;
				case "front" :
					if(dq.isEmpty()) {
						sb.append(-1).append("\n");
					}else {
						sb.append(dq.peekFirst()).append("\n");
					}
					break;
				case "back" :
					if(dq.isEmpty()) {
						sb.append(-1).append("\n");
					}else {
						sb.append(dq.peekLast()).append("\n");
					}
					break;
				case "empty" :
					if(dq.isEmpty()) {
						sb.append(1).append("\n");
					}else {
						sb.append(0).append("\n");
					}
					break;
				case "pop_front":
					if(dq.isEmpty()) {
						sb.append(-1).append("\n");
					}else {
						sb.append(dq.pollFirst()).append("\n");
					}
					break;
				case "pop_back":
					if(dq.isEmpty()) {
						sb.append(-1).append("\n");
					}else {
						sb.append(dq.pollLast()).append("\n");
					}
					break;
				case "size" :
					sb.append(dq.size()).append("\n");
			}
		}
		System.out.println(sb);
	}
}
