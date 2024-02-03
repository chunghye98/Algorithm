import java.io.*;
import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
            queue.add((int)Math.ceil((100.0-progresses[i]) / speeds[i] ));
        }
        
        while(!queue.isEmpty()) {
            int minday = queue.poll();
            
            int count = 1;
            
            while(!queue.isEmpty() && queue.peek() <= minday) {
                count++;
                queue.poll();
            }
            
            result.add(count);
        }
        return result;
        
        
        
    }
}