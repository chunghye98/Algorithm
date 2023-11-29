import java.io.*;
import java.util.*;

/*
14916, 거스름돈
- 시간 제한: 2초
- 메모리 제한: 512MB
- 그리디
<접근 방법>
1. 5로 나누어 떨어지면 5로만 나누는 것이 최소다.
2. 5로 나누어 떨어지지 않으면 n이 5로 나누어 떨어질 때까지 n -= 2를 한다.
3. n이 0보다 작아지면 거슬러 줄 수 없는 돈이므로 -1을 출력한다.
 */

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());


		int count = 0;

		while (true) {
			if (n % 5 == 0) {
				count += n / 5;
				break;
			} else {
				n -= 2;
				count++;
			}

			if (n < 0) {
				count = -1;
				break;
			}
		}

		System.out.println(count);
	}
}