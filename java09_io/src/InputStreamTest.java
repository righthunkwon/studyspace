

import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
		/*
			Stream
				: 프로그램은 외부에서 데이터를 읽거나 외부로 데이터를 출력하는 작업이 빈번하게 일어납니다. 
				  데이터는 어떠한 통로를 통해서 데이터가 이동되는데, 이 통로를 Stream 이라고 합니다.
				  자바에는 이러한 기능을 수행하기 위해 InputStream와 OutputStream이 존재하며 단일 방향으로 연속적으로 흘러갑니다.
  				  InputStream과 OutputStream은 추상 클래스이며 추상 메소드를 오버라이딩해서 다양한 역할을 수행할 수 있습니다. (예 : 파일, 네트워크, 메모리 입출력)
  				  자바에서 기본적으로 제공하는 I/O 기능은 java.io 패키지에서 제공됩니다. 
				  InputStream은 외부에서 데이터를 읽는 역할을 수행하고, OutputStream은 외부로 데이터를 출력하는 역할을 수행합니다.
			
				입출력 기준 분류
					(1) 입력 스트림
					(2) 출력 스트림
					
				데이터 기준 분류
					(1) 바이트 기반 스트림	: 최상위 클래스 -> InputStream, OutputStream
					(2) 문자 기반 스트림		: 최상위 클래스 -> Reader(입력), Writer(출력)
  				  

			InputStream
				: InputStream은 추상 메소드를 포함한 추상 클래스이므로 상속을 받아 추상 메소드를 오버라이딩 해야 합니다.
				  파일 데이터를 읽거나 네트워크 소켓을 통해 데이터를 읽거나 키보드에서 입력한 데이터를 읽을 때 사용합니다.
				  바이트 기반 입력 스트림의 최상위 추상클래스이고, 입력시 한번에 1byte만 입력합니다. 또한, 모든 바이트 기반 입력 스트림은 이 클래스를 상속받습니다.
				  InputStream은 읽기에 대한 다양한 추상 메소드를 정의해 두었습니다.
				  그리고 InputStream의 추상메소드를 오버라이딩하여 목적에 따라 데이터를 입력 받을 수 있습니다.
				 
		*/  
			InputStream is = System.in;
			try {
				while(true) { // read는 1byte만 입력받아 Test를 입력할 경우 T의 값만 알 수 있는데, 이를 반복문으로 처리하여 모든 값을 구할 수 있다. 
					// read() : 콘솔, 파일, 네트워크에서 자바로 읽어오기, 사용자가 값(문자)를 입력 후 enter 입력시까지 기다린다.
					int code = is.read(); // 입력 후 값이 없을 때는 -1이 들어온다.
					if(code == -1) {
						break;
					}
					System.out.println(code + ", " + (char)code); // Test를 입력할 경우 T: 84, e:101, s:115, t:116 뿐만 아니라 enter키: 13, 10의 값도 들어간다.
				}
			} catch(IOException ie) {
				System.out.println(ie.getMessage());
			}
			System.out.println("프로그램이 종료되었습니다.");
	}

	

	public static void main(String[] args) {
		new InputStreamTest();
	}

}
