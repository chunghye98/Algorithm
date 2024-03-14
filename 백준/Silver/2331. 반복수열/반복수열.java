
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		list.add(n);
		int index = 0;
		int startRepeat = -1;
		while(true) {
			Integer before = list.get(index);
			int current = getBeforeSum(before, p);

			if(list.contains(current)) {
				startRepeat = current;
				break;
			}

			list.add(current);
			index++;
		}

		int count = 0;
		for(int value : list) {
			if(value == startRepeat) {
				break;
			}
			count++;
		}
		System.out.println(count);
	}

	private static int getBeforeSum(Integer before, int p) {
		int sum = 0;
		while(before > 0) {
			sum += Math.pow(before % 10, p);
			before /= 10;
		}
		return sum;
	}
}
