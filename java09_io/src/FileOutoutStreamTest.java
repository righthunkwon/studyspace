

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutoutStreamTest {

	public FileOutoutStreamTest() {
		// FileOutoutStream : byte 단위로 파일 쓰기
		
		try {
			File file = new File("C://java_test", "my_data.txt");
			FileOutputStream fos = new FileOutputStream(file);
			String[] inData = {"FileOutPutStream 객체를 활용하여 \n","자바에서 문자열을 ", "파일로 쓰기 연습 중",};
			for(String data : inData) {
				// 문자열 -> byte 배열 : getBytes()
				fos.write(data.getBytes());
			}
			fos.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public static void main(String[] args) {	
		new FileOutoutStreamTest();
	}

}
