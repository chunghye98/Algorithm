import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int resultIndex = 0;
        
        for(int[] command : commands) {
            int start = command[0];
            int end = command[1];
            int target = command[2];
            
            int[] arr = new int[end-start+1];
            int index = 0;
            for(int i = start-1; i < end; i++) {
                arr[index] = array[i];
                index++;
            }
            
            Arrays.sort(arr);
            result[resultIndex] = arr[target-1];
            resultIndex++;
        }
        return result;
    }
    
}