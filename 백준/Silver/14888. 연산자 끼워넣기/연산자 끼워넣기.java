
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연산자 끼워넣기
public class Main {
    static int n;
    static int[] arr;
    static int[] operator;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        solve(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void solve(int value, int depth) {
        if (depth == n) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        solve(value + arr[depth], depth + 1);
                        break;
                    case 1:
                        solve(value - arr[depth], depth + 1);
                        break;
                    case 2:
                        solve(value * arr[depth], depth + 1);
                        break;
                    case 3:
                        solve(value / arr[depth], depth + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}
