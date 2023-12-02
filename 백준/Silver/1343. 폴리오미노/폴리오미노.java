
import java.io.*;
import java.util.*;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");

		int xCount = 0;
		int dotCount = 0;

		for (int i = 0; i < input.length; i++) {
			if (input[i].equals("X")) {
				if (xCount == 0) {
					sb.append(".".repeat(dotCount));
					dotCount = 0;
				}
				xCount++;
			} else {
				if (dotCount == 0) {
					if (!findResult(xCount))
						return;
					xCount = 0;
				}
				dotCount++;
			}
		}
		if (input[input.length - 1].equals(".")) {
			sb.append(".".repeat(dotCount));
		} else {
			if (!findResult(xCount))
				return;
		}

		System.out.println(sb);
	}

	private static boolean findResult(int xCount) {
		while (xCount > 0) {
			if (xCount < 2 || xCount % 2 != 0) {
				System.out.println(-1);
				return false;
			}else if (xCount >= 4) {
				sb.append("AAAA");
				xCount -= 4;
			} else {
				sb.append("BB");
				xCount -= 2;
			}
		}
		return true;
	}
}
