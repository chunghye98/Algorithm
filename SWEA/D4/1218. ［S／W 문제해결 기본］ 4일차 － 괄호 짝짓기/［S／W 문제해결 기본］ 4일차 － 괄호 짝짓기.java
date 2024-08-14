import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Stack<Character> stack;
	static char[] inputs;
	static int n;
	static int result;

	public static void main(String[] args) throws Exception {
		for (int testCase = 1; testCase <= 10; testCase++) {
			init();
			solve();
			output(testCase);
		}
		System.out.println(sb);
	}
	
	public static void output(int testCase) {
		sb.append("#").append(testCase).append(" ").append(result).append("\n");
	}
	
	public static void solve() {
		result = checkPair();
	}
	
	public static int checkPair() {
		try {
			boolean flag = false;
			for(char c : inputs) {
				switch(c) {
				case ')' :
					if(stack.peek() == '(') {
						stack.pop();
					}else {
						flag = true;
					}
					break;
				case ']' :
					if(stack.peek() == '[') {
						stack.pop();
					}else {
						flag = true;
					}
					break;
				case '}' : 
					if(stack.peek() == '{') {
						stack.pop();
					}else {
						flag = true;
					}
					break;
				case '>' :
					if(stack.peek() == '<') {
						stack.pop();
					}else {
						flag = true;
					}
					break;
				case '(' :
				case '[' :
				case '{' :
				case '<' :
					stack.push(c);
				default :
					if(flag) {
						return 0;
					}
				}
			}
			
			// 여는 괄호가 더 많은 경우
			if(stack.size() > 0) {
				return 0;
			}
			
		// 닫는 괄호가 더 많은 경우
		}catch(Exception e) {
			return 0;
		}
		
		return 1;
	}

	public static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		inputs = br.readLine().toCharArray();
		stack = new Stack<>();
	}

}