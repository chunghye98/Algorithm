import java.util.*;

class Solution {
    
    private long calc(int[] diffs, int[] times, int level) {
        long time = 0;
        for(int i=0; i<diffs.length; i++) {
            if(diffs[i] <= level) {
                time += times[i];    
            } else {
                int fail = diffs[i] - level;
                time += fail * (times[i-1] + times[i]) + times[i];
            }
        }
        return time;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int lo = 1;
        int hi = 100000;
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(calc(diffs, times, mid) <= limit) hi = mid; 
            else lo = mid + 1;
        }
        
        return lo;
    }
}