

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class InputStreamTest2 {

	public InputStreamTest2() {

			InputStream is = System.in;
			try {
				while(true) { // read는 1byte만 입력받아 Test를 입력할 경우 T의 값만 알 수 있는데, 이를 반복문으로 처리하여 모든 값을 구할 수 있다. 
					// read(byte[]) : 한 번에 바이트 배열 크기만큼 읽어오기
					byte data[] = new byte[10];
					int cnt = is.read(data);
					System.out.println(Arrays.toString(data));
					System.out.println("cnt->" + cnt);
					// byte 배열의 값을 문자열로 변환하여 출력하기 : String(byte[] bytes), String(byte[] bytes) 
					System.out.println(new String(data)+ "======"); // Test를 입력했을 때 비어있는 공백 부분을 출력(총 네 개의 공간)
					System.out.println(new String(data, 0, cnt)+ "======"); 

				}
			} catch(IOException ie) {
				System.out.println(ie.getMessage());
			}
			System.out.println("프로그램이 종료되었습니다.");
	}

	public static void main(String[] args) {
		new InputStreamTest2();
	}

}

	/*
			(1) byte array to String
					: String data = new String(byteArray);
			
			(2) String to byte array
					: String.getBytes()
	*/
