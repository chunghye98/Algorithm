import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 1. HashMap에 참가자들의 이름을 넣는다. 값은 1 이상
        Map<String, Integer> marathon = new HashMap<>();
        for(String person : participant) {
            marathon.put(person, marathon.getOrDefault(person, 0) + 1);
        }
        
        // 2. HashMap에 완주한 선수들의 이름이 있으면 값을 -- 한다.
        for(String person : completion) {
            if(marathon.containsKey(person)) {
                marathon.put(person, marathon.get(person) - 1);
            }
        }
        
        // 3. 값이 1 이상인 선수의 이름을 return 한다.
        for(Map.Entry<String, Integer> entry : marathon.entrySet()) {
            if(entry.getValue() > 0) {
                answer = entry.getKey();
            }
        }
        
        return answer;
    }
}