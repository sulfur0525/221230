package Baekjoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		int[] arr = new int[8001];
		int[] arr2 = new int[8001];
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
		int cnt = 1;
		int many = 0;
		int mnum = 0; 
		int cnt2 = 1;
 		
		for(int i = 4000 ; i>=0 ; i--) {
			if(arr[i]!=0) {
				if(many<arr[i]) {
					many=arr[i];
					mnum=i*(-1);
				}else if(many==arr[i]) {
					if(cnt2==1) {
						mnum=i*(-1);
					}
					cnt2++;
				}
				
				for(int j =1 ; j<=arr[i] ; j++) {
					arr2[cnt] = i*(-1);
					cnt++;
				}
			}
			       
		}
		for(int i = 4001 ; i<8001 ; i++) {
			if(arr[i]!=0) {
				if(many<arr[i]) {
					many=arr[i];
					mnum=i-4000;
				}else if(many==arr[i]) {
					if(cnt2==1) {
						mnum=i-4000;
					}
					cnt2++;
				}
				for(int j =1 ; j<=arr[i] ; j++)  {
					arr2[cnt] = i-4000;
					cnt++;
				}
			}
		}
		
		
		System.out.println(Math.round(sum/N));
		System.out.println(arr2[N/2+1]);
		System.out.println(mnum);
		System.out.println(arr2[N]-arr2[1]);
		
		
	}

}
