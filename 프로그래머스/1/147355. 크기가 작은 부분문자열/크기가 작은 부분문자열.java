import java.util.*;

class Solution {
    public int solution(String t, String p) {
        // 1. p의 length 구하기
        int pLen = p.length();
        // 2. t를 돌면서 p보다 작은 값 count
        int count = 0;
        for(int i=0; i<t.length()-pLen+1; i++) {
            if(Long.parseLong(t.substring(i, i + pLen)) <= Long.parseLong(p)) {
                count++;
            }
        }
        return count;
    }
}