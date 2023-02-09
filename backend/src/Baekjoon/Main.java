package Baekjoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		int[] arr = new int[8001];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		double sum = 0;
		
		for(int i=0 ; i<N ; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			if(num>0) {
				arr[num+4000]++;
				
			}else {
				arr[num*(-1)]++;
			}
		}
		
		
		br.close();
		
		
		
	}

}
