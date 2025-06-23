class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int start = 1;
        int end = 1;
        while(start <= n) {
            int sum = 0;
            for(int j=start; j<=end; j++) {
                sum += j;
            }
            
            if(sum == n) {
                answer++;
                start++;
                end = start;
            }else if(sum > n) {
                start++;
                end = start;
            }else {
                end++;
            }
        }
        return answer;
    }
}