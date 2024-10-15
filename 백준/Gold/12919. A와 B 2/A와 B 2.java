import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String first;
    static String target;

    static int result;

    public static void main(String[] args) throws IOException {
        init();
        solve(target.length(), target);
        output();
    }

    private static void output() {
        System.out.println(result);
    }

    private static void solve(int length, String word) {
        if (length == first.length()) {
            if (first.contentEquals(word)) {
                result = 1;
                return;
            }
            return;
        }

        if (word.charAt(word.length() - 1) == 'A') {
            solve(length - 1, word.substring(0, word.length() - 1));
        }

        if (word.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder();
            word = word.substring(1);
            for (int i = word.length() - 1; i >= 0; i--) {
                sb.append(word.charAt(i));
            }

            solve(length - 1, sb.toString());
        }
    }

    private static void init() throws IOException {
        first = br.readLine();
        target = br.readLine();
    }
}