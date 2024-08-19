import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int n;
	static int[] numbers;
	static List<Character> signs;
	static int max;
	static int min;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			init();
			solve();
			output(i);
		}
		System.out.println(sb);
	}

	public static void output(int t) {
		sb.append("#").append(t).append(" ").append(max - min).append("\n");
	}

	public static void solve() {
		char[] selected = new char[signs.size()];
		for(int i=0; i<signs.size(); i++) {
			selected[i] = signs.get(i);
		}
		
		Arrays.sort(selected);
		calculate(selected);
		
		while(np(selected)) {
			calculate(selected);
		}
	}
	
	public static boolean np(char[] selected) {
		int length = selected.length;
		
		// step1) 꼭대기 찾기
		int i = length - 1;
		while(i > 0 && selected[i-1] >= selected[i]) {
			--i;
		}
		
		// 다음 순열이 없는 경우
		if( i==0) {
			return false;
		}
		
		// step2) 꼭대기 앞 교환 위치에 교환할 값 자리 찾기
		int j = length - 1;
		while(selected[i-1] >= selected[j]) {
			--j;
		}
		
		// step3) 두 위치의 수 교환
		swap(selected, i-1, j);
		
		// step4) 꼭대기부터 맨 뒤까지 오름차순 형태로 만듦
		int k = length-1;
		while(i < k) {
			swap(selected, i++, k--);
		}
		
		return true;
	}
	
	public static void swap(char[] selected, int i, int j) {
		char temp = selected[i];
		selected[i] = selected[j];
		selected[j] = temp;
	}

	public static void calculate(char[] selected) {
		int result = numbers[0];
		for (int i = 0; i < selected.length; i++) {
			int b = numbers[i + 1];

			switch (selected[i]) {
			case '+':
				result += b;
				break;
			case '-':
				result -= b;
				break;
			case '*':
				result *= b;
				break;
			case '/':
				result /= b;
				break;
			}
		}
		max = Math.max(max, result);
		min = Math.min(min, result);
	}

	public static void init() throws Exception {
		n = Integer.parseInt(br.readLine());

		int[] temp = new int[4];
		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < 4; i++) {
			temp[i] = Integer.parseInt(inputs[i]);
		}

		signs = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			switch (i) {
			case 0:
				for (int j = 0; j < temp[i]; j++) {
					signs.add('+');
				}
				break;
			case 1:
				for (int j = 0; j < temp[i]; j++) {
					signs.add('-');
				}
				break;
			case 2:
				for (int j = 0; j < temp[i]; j++) {
					signs.add('*');
				}
				break;
			case 3:
				for (int j = 0; j < temp[i]; j++) {
					signs.add('/');
				}
				break;
			}
		}

		visit = new boolean[signs.size()];
		numbers = new int[n];
		inputs = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(inputs[i]);
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}
}