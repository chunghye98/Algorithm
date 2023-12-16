import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String ps = br.readLine();
            System.out.println(solve(ps));
        }
    }

    private static String solve(String ps) {
        Stack<Boolean> stack = new Stack<>();
        String[] split = ps.split("");
        try {
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("(")) {
                    stack.push(true);
                    continue;
                }
                if (split[i].equals(")")) {
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) {
                return "NO";
            }
            return "YES";
        } catch (Exception e) {
            return "NO";
        }
    }
}
