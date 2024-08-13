import java.io.BufferedReader;
import java.io.InputStreamReader;

/**

@author 혜선
@since 2024. 8. 13.
@link https://www.acmicpc.net/problem/15649
@timecomplex
@performance
@category #순열
@note 
1부터 N까지 자연수 중에서 길이가 M인 수열을 찾는 문제
visit의 크기는 n만큼 만들어줘야 해당 숫자의 중복 검사가 가능하다. 
*/
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] choosed;
	static int n;
	static int m;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}
	
	public static void output() {
		System.out.println(sb);
	}
	
	public static void solve() {
		makePermutation(0);
	}
	
	public static void makePermutation(int cnt) {
		if(cnt == m) {
			for(int v : choosed) {
				sb.append(v).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visit[i]) {
				continue;
			}
			visit[i] = true;
			choosed[cnt] = i+1;
			makePermutation(cnt+1);
			visit[i] = false;
		}
	}
	
	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		
		choosed = new int[m];
		visit = new boolean[n];
	}
}