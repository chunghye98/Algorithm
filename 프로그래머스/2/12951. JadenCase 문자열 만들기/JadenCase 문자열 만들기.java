import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] input = s.split("");
        int jump = 1;
        for(int i = 0; i < s.length(); i += jump) {
            jump = 1;
            if(input[i].equals(" ")) {
                answer += " ";
                continue;
            }
            System.out.println(i);
            String word = "";
            for(int j = i; j < s.length(); j++) {
                if(input[j].equals(" ")) {
                    break;
                }
                
                if(j == i) {
                    word += input[j].toUpperCase();
                }else {
                    word += input[j].toLowerCase();
                }
            }
            jump = word.length();
            answer += word;
        }
        
        return answer;
    }
}