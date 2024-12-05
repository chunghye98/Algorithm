import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] word = br.readLine().toCharArray();

        int result = 0;
        for(int i = 0; i < word.length; i++){
            result += (word[i] - ('a' - 1)) * Math.pow(31, i);
        }
        System.out.println(result);
    }
}