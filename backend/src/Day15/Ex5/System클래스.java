package Day15.Ex5;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Properties;

public class System클래스 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		long time1 = System.nanoTime();
		System.out.println(time1);
		int sum = 0;
		for(int i = 1;i<=1000000 ; i++) {
			sum += i;
		}
		long time2 = System.nanoTime();
		System.out.println(time2-time1);
		
		System.out.println("----------------------------");
		System.out.println("key: value");
		System.out.println("----------------------------");
		Properties props = System.getProperties();
		for(Object obj : props.keySet()) {
			System.out.println((String)obj + "          "+ System.getProperty((String)obj));
			
		}
		
		String data = "자바";
		
		byte[] arr1 = data.getBytes();
		System.out.println("arr1: "+Arrays.toString(arr1));
		
		String str1 = new String(arr1);
		System.out.println("str1 : " + str1);
		
		byte[] arr2 = data.getBytes("EUC-KR");
		System.out.println("arr2 : "+ Arrays.toString(arr2));
		
		String str2 = new String(arr2, "EUC-KR");
		System.out.println("str2 : "+str2);
		
	}
}


/*
밀리초 -> 마이크로초 -> 나노초 -> 피코초 -> 펨토초 -> 아토초 -> 젭토초 -> 육토초 
1/1000	1/1000000 -> 0 3개씩 늘어남

*/