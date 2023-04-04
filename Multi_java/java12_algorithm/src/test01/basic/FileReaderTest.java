package test01.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderTest {

	public FileReaderTest() {
	}

	public static void main(String[] args) throws FileNotFoundException{
		// 파일의 내용을 InputStream 세팅하기
		System.setIn(new FileInputStream("src/test01/basic/sungjuk.txt"));
		Scanner scan = new Scanner(System.in);
			while(scan.hasNextLine()) {
				String str = scan.next();
				System.out.println(str);
			}	
	}

}
