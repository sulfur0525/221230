package Day15.Ex6;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 문자열클래스 {
	public static void main(String[] args) {
		String data = "ABC";
			System.out.println(data.hashCode());
		data +="DEF";
			System.out.println(data.hashCode());
		String data2 = new StringBuilder()
				.append("DEF")
				.insert(0, "ABC")
				.delete(3, 4)
				.toString();
		
		System.out.println(data2);
		
		StringBuilder data3 = new StringBuilder();
			System.out.println(data3.hashCode());
		data3.append("ABC");
			System.out.println(data3.hashCode());
		data3.append("DEF");
			System.out.println(data3.hashCode());
		System.out.println(data3);
		
		
		String data4 = "홍길동&이수홍-박연수";
		String[] arr = data4.split("&|-");
		
		System.out.println(Arrays.toString(arr));
		
		String data5 = "홍길동/이수홍/박연수";
		StringTokenizer st = new StringTokenizer(data5,"/");
		
		for(int i = 1 ; i<=st.countTokens() ; i++) {
		System.out.println(st.nextToken());}
	}
}
