import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int total;
	static int[] recommends;
	static List<Person> persons;

	public static void main(String[] args) throws Exception {
		init();
		solve();
		output();
	}

	static class Person implements Comparable<Person>{
		int index;
		int time;
		int count;

		public Person(int index, int time) {
			this.index = index;
			this.time = time;
			this.count = 1;
		}

		@Override
		public int compareTo(Person o) {
			if (this.count == o.count) {
				return Integer.compare(this.time, o.time);
			}
			return Integer.compare(this.count, o.count);
		}

		public void updateCount() {
			this.count++;
		}
	}

	public static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		total = Integer.parseInt(br.readLine());

		recommends = new int[total];
		persons = new ArrayList<>();
		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < total; i++) {
			recommends[i] = Integer.parseInt(inputs[i]);
		}
	}

	private static void solve() {
		int currentTime = 0;
		for (int index : recommends) {
			Person person = findExist(index);
			if (person != null) {
				person.updateCount();
				continue;
			}

			if (isFull()) {
				Collections.sort(persons);
				persons.remove(0);
			}

			persons.add(new Person(index, currentTime++));
		}
	}

	private static Person findExist(int recommend) {
		for (Person person : persons) {
			if (person.index == recommend) {
				return person;
			}
		}
		return null;
	}

	private static boolean isFull() {
		return persons.size() == N;
	}

	private static void output() {
		int[] results = new int[persons.size()];

		for (int i = 0; i < results.length; i++) {
			results[i] = persons.get(i).index;
		}

		Arrays.sort(results);
		for(int result : results) {
			sb.append(result).append(" ");
		}
		System.out.println(sb);
	}
}