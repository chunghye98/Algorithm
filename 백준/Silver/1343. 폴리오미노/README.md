# [Silver V] 폴리오미노 - 1343 

[문제 링크](https://www.acmicpc.net/problem/1343) 

### 성능 요약

메모리: 14416 KB, 시간: 124 ms

### 분류

그리디 알고리즘, 구현

### 제출 일자

2023년 12월 2일 19:29:18

### 문제 설명

<p>민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB</p>

<p>이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다.</p>

<p>폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 보드판이 주어진다. 보드판의 크기는 최대 50이다.</p>

### 출력 

 <p>첫째 줄에 사전순으로 가장 앞서는 답을 출력한다. 만약 덮을 수 없으면 -1을 출력한다.</p>

---

### 풀이
n의 크기가 50보다 작으므로 구현만 하면 되는 문제이다.
1. input 배열을 돌면서 `X`를 만나면 이전에 쌓아 놓은 `.`을 출력하고 dotCount = 0으로 초기화한다.
2. input 배열을 돌면서 `.`을 만나면 이전에 쌓아 놓은 'X'를 출력하고 xCount = 0으로 초기화한다.
    1. xCount가 2보다 작거나 홀수라면 `-1`을 출력하고 끝낸다.
    2. xCount가 0이 될때까지 xCount가 4보다 크면 `AAAA`를 출력하고 xCount가 2보다 크면 `BB`를 출력하게 하고 그 사이즈만큼씩 xCount에서 빼준다.
3. 마지막에 `X` 또는 `.`으로 끝난다면 이전에 쌓아 놓은 것들을 똑같이 출력한다.

### 풀이 2
내 풀이가 너무 길어서 검색한 결과 재밌고 간단한 풀이를 찾았다. 시간은 더 걸리지만 코드가 간결하다. [참고](https://airzinc.tistory.com/entry/%EB%B0%B1%EC%A4%80-1343-JAVA)

1. 먼저 입력값에 `XXXX`가 있는 문자열을 `AAAA`로 replace 한다.
2. 이후 입력값에 `XX`가 있는 문자열을 `BB`로 replace 한다.
3. 남은 입력값에 `X`가 남아있다면 그 문자열은은 변환할 수 없는 문자열이므로 `-1`만 출력하고 끝낸다.
4. 아니라면 변환한 문자열을 그대로 출력한다.

```
import java.util.*;
 
public class Main {
 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
 
        String res = "";
 
        res = poliomino(s);
 
        System.out.println(res);
    }
 
    private static String poliomino(String s) {
        String ans = "";
        String A = "AAAA", B = "BB";
        
        s = s.replaceAll("XXXX", A);
        ans = s.replaceAll("XX", B);
        
        if(ans.contains("X")) {
            ans = "-1";
        }
 
        return ans;
    }
}
```
