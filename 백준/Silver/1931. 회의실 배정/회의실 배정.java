/*
1. end 시간을 기준으로 정렬, end가 같으면 start 시간으로 정렬한다.
2. 정렬된 리스트를 반복문으로 돌면서 이전 end 시간보다 현재의 시작 시간이 같거나 크면 count + 1을 하고 이전 end 시간을 갱신한다.
3. count를 출력한다.
*/

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
