import java.util.*;

class Solution {
    
    private int toSec(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int len = toSec(video_len);
        int cur = toSec(pos);
        int start = toSec(op_start);
        int end = toSec(op_end);
        
        if(start <= cur && cur <= end) cur = end;
        
        for(String command : commands) {
            if("next".equals(command)) {
                cur = Math.min(cur + 10, len);
            } else {
                cur = Math.max(cur - 10, 0);
            }
            
            if(start <= cur && cur <= end) cur = end;
        }
        
        return String.format("%02d:%02d", cur/60, cur%60);
    }
}