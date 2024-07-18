import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;

/*
1. n을 입력받는다.
2. 문자열 입력받은 후 해당 문자열에서 0-9 사이 숫자 뭉텅이를 찾는다.
3. 찾은 숫자들을 ArrayList에 넣는다. 이때 타입은 BigInteger로 넣어야 NumberformatException이 발생하지 않는다.
4. ArrayList를 오름차순 정렬한다.
5. ArrayList의 요소를 출력한다. 
*/
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<BigInteger> numbers = new ArrayList<>();
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			
			Pattern number = Pattern.compile("[0-9]+");
			Matcher numberMatcher = number.matcher(input);
			
			while(numberMatcher.find()) {
				String matched = numberMatcher.group();
	            		numbers.add(new BigInteger(matched));
			}
		}
		Collections.sort(numbers);
		
		for(BigInteger v : numbers) {
			System.out.println(v);
		}

	}
}
