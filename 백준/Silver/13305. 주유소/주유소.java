
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] distance = new int[n - 1];
		int totalDistance = 0;
		for (int i = 0; i < n - 1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
			totalDistance += distance[i];
		}

		st = new StringTokenizer(br.readLine());
		int[] price = new int[n];
		for (int i = 0; i < n; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		int minPrice = solve(totalDistance, distance, price);

		System.out.println(minPrice);
	}

	private static int solve(int totalDistance, int[] distance, int[] price) {
		int minPrice = 0;

		for (int i = 0; i < price.length - 1; i++) {
			if (price[i] > price[i + 1]) {
				minPrice += price[i] * distance[i];
				totalDistance -= distance[i];
			} else {
				minPrice += price[i] * totalDistance;
				break;
			}
		}

		return minPrice;
	}
}
