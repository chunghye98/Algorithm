import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static List<Integer> numbers = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			String[] command = br.readLine().split(" ");

			int value = -1;
			switch(command[0]) {
				case "add" :
					value = Integer.parseInt(command[1]);
					add(value);
					break;
				case "remove" :
					value = Integer.parseInt(command[1]);
					remove(value);
					break;
				case "check" :
					value = Integer.parseInt(command[1]);
					sb.append(check(value)).append("\n");
					break;
				case "toggle" :
					value = Integer.parseInt(command[1]);
					toggle(value);
					break;
				case "all" :
					all();
					break;
				case "empty" :
					empty();
					break;
			}
		}
		System.out.println(sb);
	}

	private static void add(int value) {
		if (!numbers.contains(value)) {
			numbers.add(value);
		}
	}

	private static void remove(int value) {
		if (numbers.contains(value)) {
			numbers.remove((Integer)value);
		}
	}

	private static int check(int value) {
		if (numbers.contains(value)) {
			return 1;
		}
		return 0;
	}

	private static void toggle(int value) {
		if (numbers.contains(value)) {
			remove(value);
		}else {
			add(value);
		}
	}

	private static void all() {
		numbers = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			numbers.add(i);
		}
	}

	private static void empty() {
		numbers.clear();
	}
}