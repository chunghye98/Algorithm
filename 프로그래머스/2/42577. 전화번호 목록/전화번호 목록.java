import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {        
        // 1. 번호 set 생성
        Set<String> set = new HashSet<>();
        for(String phone : phone_book) {
            set.add(phone);
        }
        
        // 2. 내 번호가 set에 있는지 확인
        for(String phone : phone_book) {
            for(int i=1; i<phone.length(); i++) {
                if(set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}