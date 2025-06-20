class Solution {
    static int zeroNum = 0;
    static int transNum = 0;
    
    public int[] solution(String s) {        
        while(!s.equals("1")) {
            s = checkZero(s);
            int length = s.length();
            s = makeBinary(length, "");
            transNum++;
        }
        
        return new int[]{transNum, zeroNum};
    }
    
    public String checkZero(String s) {
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') {
                zeroNum++;
            }
        }
        return s.replaceAll("0", "");
    }
    
    public String makeBinary(int n, String binary) {
        if(n == 1) {
            return "1" + binary;
        }
        
        binary = String.valueOf(n % 2) + binary;
        return makeBinary(n/2, binary);
    }
}