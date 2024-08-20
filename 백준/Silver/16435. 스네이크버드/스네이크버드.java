import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int snake;
	static int[] trees;
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}
	
	public static void output() {
		System.out.println(snake);
	}
	
	public static void solve() {
		Arrays.sort(trees);
		
		for(int i=0; i<n; i++) {
			if(trees[i] <= snake) {
				snake++;
			}
		}
	}
	
	public static void init() throws Exception {
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		snake = Integer.parseInt(inputs[1]);
		
		trees = new int[n];
		inputs = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			trees[i] = Integer.parseInt(inputs[i]);
		}
	}
}