
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cityN = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] paths = new long[cityN - 1];
		for (int i = 0; i < cityN - 1; i++) {
			paths[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		long[] costs = new long[cityN];
		for (int i = 0; i < cityN; i++) {
			costs[i] = Long.parseLong(st.nextToken());
		}

		long min = costs[0];
		long sum = costs[0] * paths[0];
		for (int i = 1; i < cityN - 1; i++) {
			min = Math.min(min, costs[i]);
			sum += min * paths[i];
		}
		System.out.println(sum);
	}
}
