import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        for(int a : arr) {
            boolean flag = false;
            for(int d : delete_list) {
                if(a == d) {
                    flag = true;
                }
            }
            if(!flag) {
                list.add(a);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}