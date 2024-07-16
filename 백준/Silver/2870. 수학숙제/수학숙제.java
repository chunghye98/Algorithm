import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<BigDecimal> numbers = new ArrayList<>();
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			
			Pattern number = Pattern.compile("[0-9]+");
			Matcher numberMatcher = number.matcher(input);
			
			while(numberMatcher.find()) {
				String matched = numberMatcher.group();
	            numbers.add(new BigDecimal(matched));
			}
		}
		Collections.sort(numbers);
		
		for(BigDecimal v : numbers) {
			System.out.println(v);
		}

	}
}