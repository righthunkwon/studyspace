package test01_bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest02 {
	public static void main(String[] args) {
		// bytestream을 활용한 이미지 입출력
		try (FileInputStream fis = new FileInputStream("dog2.jpg");
				FileOutputStream fos = new FileOutputStream("dog-copy2.jpg");) {

			int input; // 읽어온 데이터
			// try with resources

			while ((input = fis.read()) != -1) { // 데이터가 없을 경우 -1 반환
				fos.write(input);
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		System.out.println("끝");
	}
}
