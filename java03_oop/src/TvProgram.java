import java.util.Scanner;

public class TvProgram {
	Scanner scan = new Scanner(System.in);
	
	// 메뉴
	public void startMenu() {
		TvTest tv = TvTest.getInstance();
		System.out.println("TV를 켭니다.");
		do {
			tv.tvInfor();
			System.out.print("메뉴 선택(1:볼륨업, 2:볼륨다운, 3:채널업, 4:채널다운, 5:전원) = ");
			int menu = scan.nextInt();
			switch(menu) {
			case 1: tv.volumeUp(); break; // 볼륨업
			case 2: tv.volumeDown(); break; // 볼륨다운
			case 3: tv.channelUP(); break; // 채널업
			case 4: tv.channelDown(); break; // 채널다운
			case 5: tv.setOnOff(); break; // 전원
			}
	
		} while(true);
	}
	
// -------------------- 다른 클래스라 생각하고 작업-------------------- 
	public static void main(String[] args) {
		TvProgram main = new TvProgram();
		main.startMenu();
	}

}

