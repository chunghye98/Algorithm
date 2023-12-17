
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] distance = new long[n - 1];
		for (int i = 0; i < n - 1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		long[] price = new long[n];
		for (int i = 0; i < n; i++) {
			price[i] = Long.parseLong(st.nextToken());
		}

		long minPrice = solve(distance, price);

		System.out.println(minPrice);
	}

	private static long solve(long[] distance, long[] price) {
		long sum = 0;
		long min = price[0];

		for(int i=0; i<distance.length; i++) {
			if(price[i] < min) {
				min = price[i];
			}
			sum += min * distance[i];
		}
		return sum;
	}
}
