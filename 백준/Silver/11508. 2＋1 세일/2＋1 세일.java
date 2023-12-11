
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<Integer> prices = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			prices.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(prices, Collections.reverseOrder());

		int result = 0;
		for (int i = 0; i < n; i++) {
			if ((i + 1) % 3 == 0) {
				continue;
			}
			result += prices.get(i);
		}
		System.out.println(result);
	}
}
