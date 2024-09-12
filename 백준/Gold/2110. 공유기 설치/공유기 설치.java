import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int C;
    static int[] homes;

    static int result;

    public static void main(String[] args) throws Exception {
        init();
        solve();
        output();
    }

    public static void output() {
        System.out.println(result);
    }

    public static void solve() {
        int start = 1; // 최소 범위
        int end = homes[homes.length - 1] - homes[0]; // 최대 범위

        while(start <= end) { // <= 을 사용하는 이유: start와 end가 같을 때까지, 그 값도 확인하기 위함이다.
            int mid = (start + end) / 2;

            // mid로 공유기 설치가 가능하거나 더 넓은 범위로도 설치가 가능한 경우
            if(getCount(mid) >= C) {
                result = mid; // 두 공유기 사이의 거리가 최대여야 하므로 계속 갱신
                start = mid + 1; // 더 넓은 범위에서 설치가 가능한지 확인
            }else {
                end = mid - 1; // 더 작은 범위에서 설치가 가능한지 확인
            }
        }
    }

    public static int getCount(int mid) {
        int count = 1; // 첫번째 집에 무조건 공유기 설치
        int before = homes[0];

        for (int i = 1; i < N; i++) {
            // 인덱스가 3일 때 집의 좌표는 8이다. 8-1 >= 3 이므로 공유기를 하나 더 설치해야 한다.
            if(homes[i] - before >= mid) {
                count++;
                before = homes[i];
            }
        }
        return count;
    }

    public static void init() throws Exception {
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);

        homes = new int[N];
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);
    }
}