import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        char[] inputs = s.toCharArray();
        for(char input : inputs) {
            if(stack.isEmpty()) {
                stack.push(input);
                continue;
            }
            if(stack.peek() == input) {
                stack.pop();
            } else {
                stack.push(input);
            }
        }
        
        if(stack.isEmpty()) {
            return 1;
        } 
        return 0;
    }
}