class Solution {
    public int solution(String num_str) {
        int answer = 0;
        for(char num : num_str.toCharArray()) {
            answer += num - '0';
        }
        return answer;
    }
}