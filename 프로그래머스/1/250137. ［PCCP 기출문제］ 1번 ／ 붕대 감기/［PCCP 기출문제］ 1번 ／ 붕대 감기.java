import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        int cur = health;
        int streak = 0;
        int lastTime = attacks[attacks.length-1][0];
        int idx = 0;
        
        for(int i=1; i<=lastTime; i++) {
            if(attacks[idx][0] == i) {
                cur -= attacks[idx][1];
                streak = 0;
                idx++;
                if(cur <= 0) return -1;
            } else {
                cur += x;
                streak++;
                if(streak == t) {
                    streak = 0;
                    cur += y;
                }
                cur = Math.min(cur, health);
            }
        }
        
        return cur;
    }
}