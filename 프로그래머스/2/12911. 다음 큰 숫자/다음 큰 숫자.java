class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String binaryN = Integer.toBinaryString(n);
        int count = countOne(binaryN);
        
        while(true) {
            n++;
            String binaryNext = Integer.toBinaryString(n);
            if(count == countOne(binaryNext)) {
                answer = n;
                break;
            }
        }
        
        return answer;
    }
    
    public int countOne(String binary) {
        int count = 0;
        for(int i=0;i<binary.length(); i++) {
            if(binary.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}