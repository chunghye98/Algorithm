import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static Map<String, String> map;
	static String[] findSites;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	private static void init() throws IOException {
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			map.put(inputs[0], inputs[1]);
		}

		findSites = new String[M];
		for (int i = 0; i < M; i++) {
			findSites[i] = br.readLine();
		}
	}

	private static void solve() {
		for (String site : findSites) {
			sb.append(map.get(site)).append("\n");
		}
	}

	private static void output() {
		System.out.println(sb);
	}
}