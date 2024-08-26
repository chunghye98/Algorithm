import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int target;
    static int[] numbers;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        init();
        makeSubset(0, new boolean[n]);
        output();
    }

    private static void output() {
        System.out.println(result);
    }

    public static void makeSubset(int cnt, boolean[] isSelected) {
        if (cnt == numbers.length) {
            int sum = 0;
            boolean flag = false;
            for (int i = 0; i < isSelected.length; i++) {
                sum += isSelected[i] ? numbers[i] : 0;
                if(isSelected[i]) {
                    flag = true;
                }
            }

            // 공집합은 건너뛴다.
            if(!flag) {
                return;
            }

            if(sum == target) {
                result++;
            }
            return;
        }

        isSelected[cnt] = true;
        makeSubset(cnt + 1, isSelected);

        isSelected[cnt] = false;
        makeSubset(cnt + 1, isSelected);
    }

    public static void init() throws Exception {
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        target = Integer.parseInt(inputs[1]);

        numbers = new int[n];
        inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
    }
}