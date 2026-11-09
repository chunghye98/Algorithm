import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // 1. Map에 포켓몬을 번호와 개수로 넣는다.
        Map<Integer, Integer> poketmons = new HashMap<>();
        for(int n : nums) {
            poketmons.put(n, poketmons.getOrDefault(n, 0) + 1);
        }
        
        // 2. 포켓몬 총 몇 마리인지 구한다.
        int total = nums.length;
        
        // 3. map의 크기 < 총 포켓몬 개수 / 2 이면 map의 크기를 return 한다. 아니면 총 개수 return
        if(poketmons.size() < total / 2) {
            answer = poketmons.size();
        } else {
            answer = total / 2;
        }
                
        return answer;
    }
}