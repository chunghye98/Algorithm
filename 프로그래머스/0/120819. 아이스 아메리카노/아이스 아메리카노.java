class Solution {
    public int[] solution(int money) {
        int n = money / 5500;
        int remain = money % 5500;
        int[] answer = new int[]{n, remain};
        return answer;
    }
}