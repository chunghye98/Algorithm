
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] inputs = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(inputs);

		int temp = 0;
		int result = 0;
		for (int value : inputs) {
			temp += value;
			result += temp;
		}

		System.out.println(result);
	}
}
