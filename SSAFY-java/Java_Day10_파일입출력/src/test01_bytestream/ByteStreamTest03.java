package test01_bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest03 {
	public static void main(String[] args) {
		// bytestream을 활용한 이미지 입출력
		// try with resources(자동자원반납 )
		// 자동자원반납 시 자동으로 close() 수행
		try (FileInputStream fis = new FileInputStream("dog.jpg");
				FileOutputStream fos = new FileOutputStream("dog-copy3.jpg");) {

			// 배열
			byte[] buffer = new byte[10];
			int input;
			
			while ((input = fis.read(buffer)) != -1) { // 데이터가 없을 경우 -1 반환
				fos.write(buffer, 0, input);
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		System.out.println("끝");
	}
}
