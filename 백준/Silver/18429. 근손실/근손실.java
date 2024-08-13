import java.io.BufferedReader;
import java.io.InputStreamReader;

/**

@author hyeseon
@since 2024. 8. 13.
@link https://www.acmicpc.net/problem/18429
@timecomplex
@performance
@category #순열
@note 
중량 증가량을 배열로 만들고(values) 이 배열의 인덱스를 순열로 만든 후
해당 순열을 돌며 중량이 500이 넘지 않으면 출력하지 않는다.
*/

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int k;
	static boolean[] visit;
	static int[] values;
	static int[] choosed;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}

	public static void output() {
		System.out.println(count);
	}

	public static void solve() {
		makePermutation(0);
	}

	public static void makePermutation(int cnt) {
		if (cnt == n) {
			checkWeight();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visit[i]) {
				continue;
			}

			visit[i] = true;
			choosed[cnt] = i + 1;
			makePermutation(cnt + 1);
			visit[i] = false;
		}
	}
	
	public static void checkWeight() {
		int weight = 500;
		for(int i=0; i<choosed.length; i++) {
			weight += values[choosed[i]-1] - k;
			if(weight < 500) {
				return;
			}
		}
		count++;
	}

	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		k = Integer.parseInt(inputs[1]);

		visit = new boolean[n];
		values = new int[n];
		choosed = new int[n];

		inputs = br.readLine().split(" ");
		for (int i = 0; i < inputs.length; i++) {
			values[i] = Integer.parseInt(inputs[i]);
		}
	}
}