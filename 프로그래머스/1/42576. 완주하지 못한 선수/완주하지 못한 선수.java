import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 1. Map에 선수 이름을 넣는다. 1부터 시작, 동명이인이 있으면 ++
        Map<String, Integer> marathon = new HashMap<>();
        for(String person : participant) {
            marathon.put(person, marathon.getOrDefault(person, 0) + 1);
        }
        
        // 2. Map에 있는 선수이름이 completion에도 있으면 --
        for(String person : completion) {
            if(marathon.containsKey(person)) {
                marathon.put(person, marathon.get(person)-1);
            }
        }
        
        // 3. Map에 있는 값이 1이상인 선수 이름을 return
        for(Map.Entry<String, Integer> entry : marathon.entrySet()) {
            if(entry.getValue() > 0) {
                answer = entry.getKey();
            }
        }
        
        return answer;
    }
}