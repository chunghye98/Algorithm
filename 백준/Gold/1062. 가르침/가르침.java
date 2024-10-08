import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int k;
    static boolean[] alphabet;
    static List<String> words;

    static int result;

    public static void main(String[] args) throws Exception {
        init();
        solve();
        output();
    }

    private static void output() {
        System.out.println(result);
    }

    private static void solve() {
        if(k < 5) {
            result = 0;
            return;
        } else if (k == 26) {
            result = n;
            return;
        }

        backtracking(0, 0);
    }

    private static void backtracking(int cnt, int start) {
        if (cnt == k - 5) {
            int studyWords = findStudyWords();
            result = Math.max(result, studyWords);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!alphabet[i]) {
                alphabet[i] = true;
                backtracking(cnt + 1, i);
                alphabet[i] = false;
            }
        }
    }

    private static int findStudyWords() {
        int count = 0;
        for (String word : words) {
            boolean isRemainLetter = false;
            for (char letter : word.toCharArray()) {
                if(!alphabet[letter-'a']) {
                    isRemainLetter = true;
                    break;
                }
            }
            if(!isRemainLetter) {
                count++;
            }
        }
        return count;
    }

    public static void init() throws Exception {
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        k = Integer.parseInt(inputs[1]);

        alphabet = new boolean[26];
        alphabet['a' - 'a'] = true; // a
        alphabet['c' - 'a'] = true; // c
        alphabet['i' - 'a'] = true; // i
        alphabet['n' - 'a'] = true; // n
        alphabet['t' - 'a'] = true; // t

        words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine().replace("anta", "").replace("tica", "");
            words.add(word);
        }
        result = Integer.MIN_VALUE;
    }
}