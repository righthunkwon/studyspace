package test01_bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest01 {
	public static void main(String[] args) {
		// bytestream을 활용한 이미지 입출력
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("dog.jpg");
			fos = new FileOutputStream("dog-copy.jpg");

			int input; // 읽어온 데이터

			while ((input = fis.read()) != -1) { // 데이터가 없을 경우 -1 반환
				fos.write(input);
			}
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			try {
				if (fis != null) { // NullPointException 예외 방지
					fis.close();
				}
				if (fos != null) { // NullPointException 예외 방지
					fos.close();
				}
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
		System.out.println("끝");
	}
}
