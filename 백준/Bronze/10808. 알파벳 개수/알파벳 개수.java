import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray();
        
        int[] alphabet = new int[26];
        
        for(int i=0; i<input.length; i++) {
            alphabet[input[i]-'a']++;
        }
        
        for(int value : alphabet) {
            sb.append(value).append(" ");
        }
        System.out.println(sb);
    }
}
