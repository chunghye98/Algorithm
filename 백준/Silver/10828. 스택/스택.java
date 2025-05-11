import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer> stack = new Stack<>();
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
					stack.push(Integer.parseInt(input[1]));
					break;
				case "top" :
					if(stack.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(stack.peek()).append("\n");
					}
					break;
				case "size" :
					sb.append(stack.size()).append("\n");
					break;
				case "empty" :
					if (stack.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "pop" :
					if (stack.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(stack.pop()).append("\n");
					}
					break;
			}
		}
		System.out.println(sb);
	}
}
