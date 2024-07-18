import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] map;
    static boolean[][] visitFirst;
    static boolean[][] visitSecond;
    static int[][] d = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 중, 상, 우, 하, 좌

    public static void main(String[] args) throws Exception {
        input();

        int min = bruteforce();
        System.out.println(min);
        br.close();
    }

    public static int bruteforce() {
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            int sum = 0;

            for(int j=0; j<n; j++) {
                visitFirst = new boolean[n][n];
                visitSecond = new boolean[n][n];

                int firstFlower = getFlowerFirst(i, j);
                if(firstFlower == -1) {
                    visitFirst = new boolean[n][n];
                    continue;
                }

                for(int k=0; k<n; k++) {
                    for(int l=0; l<n; l++) {
                        int secondFlower = getFlowerSecond(k, l);
                        if(secondFlower == -1) {
                            visitSecond = new boolean[n][n];
                            continue;
                        }

                        for(int m=0; m<n; m++) {
                            for(int o=0; o<n; o++) {
                                int thirdFlower = getFlowerThird(m, o);
                                if(thirdFlower == -1) {
                                    continue;
                                }
                                sum = firstFlower + secondFlower + thirdFlower;
                                min = Math.min(sum, min);
                            }
                        }
                    }
                }
            }
        }
        return min;
    }

    public static int getFlowerFirst(int y, int x) {
        int price = 0;
        for(int i=0; i<5; i++) {
            int curY = d[i][0] + y;
            int curX = d[i][1] + x;

            if(isRange(curY, curX)) {
                return -1;
            }

            price += map[curY][curX];
            visitFirst[curY][curX] = true;
        }
        return price;
    }

    public static int getFlowerSecond(int y, int x) {
        int price = 0;
        for(int i=0; i<5; i++) {
            int curY = d[i][0] + y;
            int curX = d[i][1] + x;

            if(isRange(curY, curX) || visitFirst[curY][curX]) {
                return -1;
            }

            price += map[curY][curX];
            visitSecond[curY][curX] = true;
        }
        return price;
    }

    public static int getFlowerThird(int y, int x) {
        int price = 0;
        for(int i=0; i<5; i++) {
            int curY = d[i][0] + y;
            int curX = d[i][1] + x;

            if(isRange(curY, curX) || visitFirst[curY][curX] || visitSecond[curY][curX]) {
                return -1;
            }

            price += map[curY][curX];
        }
        return price;
    }

    public static boolean isRange(int y, int x) {
        return y < 0 || y >= n || x < 0 || x >= n;
    }

    public static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}