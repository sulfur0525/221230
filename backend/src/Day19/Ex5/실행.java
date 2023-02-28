package Day19.Ex5;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean musicState = false;
		boolean movieState = false;
		
		Thread thread = new Music();
		thread.start();
		
		Music music = new Music();
		Movie movie = new Movie();
		
		while (true) {
			System.out.println("1.음악재생 2.영화재생");
			int ch = scanner.nextInt();
			if(ch==1 && musicState==false) {
				music.start();
				musicState = true;
				music.stop = true;
			}
			else if(ch==1 && musicState==true) {
				musicState = false;
				music.stop = false;
				music = new Music();
			}
			else if(ch==2 && movieState==false) {
				movie.start();
				movieState = true;
				movie.stop = true;
			}else if(ch==2 && movieState==true) {
				movieState = false;
				movie.stop = false;
				movie = new Movie();
			}
		}
	}
}
