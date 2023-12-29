
import java.io.*;
import java.util.*;

public class Main {
	private static List<Grade> grades;
	private static int[] powers;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int gradeN = Integer.parseInt(st.nextToken());
		int powerN = Integer.parseInt(st.nextToken());

		grades = new ArrayList<>();
		for (int i = 0; i < gradeN; i++) {
			st = new StringTokenizer(br.readLine());
			grades.add(new Grade(st.nextToken(), Integer.parseInt(st.nextToken())));
		}

		StringBuilder sb = new StringBuilder();
		powers = new int[powerN];
		for (int i = 0; i < powerN; i++) {
			sb.append(binarySearch(Integer.parseInt(br.readLine())));
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static String binarySearch(int power) {
		int start = 0;
		int end = grades.size() - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (power <= grades.get(mid).power) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return grades.get(start).name;
	}
}

class Grade {
	String name;
	int power;

	public Grade(String name, int power) {
		this.name = name;
		this.power = power;
	}
}