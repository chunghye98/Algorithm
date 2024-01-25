import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                }       
            }
        }
        
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++){
                
                if(lost[i] == reserve[j] + 1
                  || lost[i] == reserve[j] - 1) {
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }
        
        for(int i : lost) {
            if(i == -1) continue;
            n--;
        }
        
        return n;
    }
}