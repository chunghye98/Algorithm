
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<Meeting> meetings = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			meetings.add(new Meeting(s, e));
		}

		Collections.sort(meetings);

		int count = 0;
		int beforeTime = 0;
		for (int i = 0; i < n; i++) {
			if (meetings.get(i).start >= beforeTime) {
				count++;
				beforeTime = meetings.get(i).end;
			}
		}
		System.out.println(count);
	}
}
class Meeting implements Comparable<Meeting> {
	int start;
	int end;

	Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		if (this.end == o.end) {
			return this.start - o.start;
		}
		return this.end - o.end;
	}

}
