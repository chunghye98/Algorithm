import java.util.*;

public class Solution {
    public Stack<Integer> solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int value : arr) {
            if(stack.isEmpty()) {
                stack.push(value);
            } else {
                if(stack.peek() == value) {
                    continue;
                } else {
                    stack.push(value);
                }
            }
        }
        return stack;
    }
}