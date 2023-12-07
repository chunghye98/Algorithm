
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<Integer> tips = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			tips.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(tips, Collections.reverseOrder());

		long result = 0;
		for (int i = 0; i < n; i++) {
			long value = tips.get(i) - i;

			if (value < 0) {
				break;
			}

			result += value;
		}

		System.out.println(result);
	}
}
