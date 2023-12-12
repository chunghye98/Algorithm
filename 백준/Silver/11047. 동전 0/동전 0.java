
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 동전 0
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(br.readLine()));
        }
        Collections.sort(list, Collections.reverseOrder());

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += k / list.get(i);
            k = k % list.get(i);
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
