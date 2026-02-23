import java.util.*;

class Solution {
    
    private int n;
    private int[] numberArr;
    private boolean[] visited;
    private Set<Integer> primeSet = new HashSet<>();
    
    public int solution(String numbers) {
        n = numbers.length();
        numberArr = new int[n];
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            numberArr[i] = numbers.charAt(i) - '0';
        }
        
        permutation(numberArr, visited, 0, "");
        
        return primeSet.size();
    }
    
    public void permutation(int[] numberArr, boolean[] visited, int depth, String current) {
        if(depth >= 1) {
            int number = Integer.parseInt(current);
            if(isPrime(number)) {
                primeSet.add(number);
            }
        }

        if(depth == n) {
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            permutation(numberArr, visited, depth + 1, current + numberArr[i]);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int number) {
        if(number < 2) return false;
        for(int i=2; i<=Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}