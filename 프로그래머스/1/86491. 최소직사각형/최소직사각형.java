class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        //1. 가로에 더 큰 값을 두도록 swap 한다
        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        
        //2. 가로, 세로 배열에서 각각 max 값을 추출한다
        int maxX = -1;
        int maxY = -1;
        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0] > maxX) {
                maxX = sizes[i][0];
            }
            if(sizes[i][1] > maxY) {
                maxY = sizes[i][1];
            }
        }
        
        //3. 지갑의 크기를 구한다.
        answer  = maxX * maxY;
        
        return answer;
    }
}