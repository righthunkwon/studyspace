import java.util.Scanner;
public class TvTest {

	/*
		TV
			객체 		: 전원, 채널, 볼륨
			멤버변수 	: 현재전원상태, 현재채널, 현재볼륨, 최대채널(final), 최대볼륨(final)
			생성자 	: 전원, 볼륨, 채널
			메소드 	: 채널업, 채널다운, 전원(on/off), 볼륨업, 볼륨다운, 현재상태확인, 메뉴
	*/	
	static final int MAX_CHANNEL = 20; 	// 최대채널
	static final int MAX_VOLUME = 30;	// 최대볼륨

	boolean power = false; // 전원
	int volume; // 볼륨 (초기값 0)
	int channel = 1; // 채널
	
	
	// 생성자 메서드의 오버로딩
	public TvTest() {
		// 초기값
		power = true;
		volume = 10;
		channel = 7;
	}

	public TvTest(boolean power, int channel, int volume) {
		this.power = power;
		this.channel = channel;
		this.volume = volume;
	}
	
	public TvTest(int channel, boolean power, int volume) {
		this(power, channel, volume); // 다른 생성자 호출, 첫줄에 기술해야 한다.
	}
	
	public TvTest(int channel, int volume, boolean power) {
		this(power, channel, volume); // 다른 생성자 호출, 첫줄에 기술해야 한다.
	}
	
	public static TvTest getInstance() {
		return new TvTest(); // 객체를 만들어서 반환
	}
	
	
	// 현재정보 출력
	public void tvInfor() {
		System.out.println("전원:"+power+", 채널:"+channel+", 볼륨:"+volume);
	}
	
	// 볼륨업
	public void volumeUp() {
		volume++;
		if(volume>MAX_VOLUME ) {
			volume=MAX_VOLUME; // 30 초과이면 버튼을 못 누르게 하는 게 아니라, 버튼을 누르더라도 결과가 반영되지 않게 만들어야 한다.
		}
	}
	
	// 볼륨다운
	public void volumeDown() {
		volume--;
		if(volume<0) {
			volume=0;
		}
	}
	
	// 채널업
	public void channelUP() {
		channel++;
		if (channel > MAX_CHANNEL) {
			channel = 1;
		}
	}
	
	// 채널다운
	public void channelDown() {
		channel--;
		if (channel < 1) {
			channel = MAX_CHANNEL;
		}
	}
	
	// 전원 on/off
	public void setOnOff() {
		power = !power;
		if(!power) {
			System.exit(0); // 프로그램을 종료시키는 API, 0: 정상종료
		}
	}
	
}
