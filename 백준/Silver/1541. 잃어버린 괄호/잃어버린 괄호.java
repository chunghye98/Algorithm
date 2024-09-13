import java.io.BufferedReader;
import java.io.InputStreamReader;

/** 1541. 잃어버린 괄호
 * 메모리
 * 시간
 *
 *
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splitMinus = br.readLine().split("-");

        int result = 0;
        try {
            result = Integer.parseInt(splitMinus[0]);
        } catch (NumberFormatException e) {
            String[] splitPlus = splitMinus[0].split("\\+");
            for(String p : splitPlus) {
                result += Integer.parseInt(p);
            }
        }

        for (int i = 1; i < splitMinus.length; i++) {
            int num = 0;
            try {
                num = Integer.parseInt(splitMinus[i]);
            } catch (NumberFormatException e) {
                String[] splitPlus = splitMinus[i].split("\\+");
                for(String p : splitPlus) {
                    num += Integer.parseInt(p);
                }
            }
            result -= num;
        }

        System.out.println(result);
    }
}