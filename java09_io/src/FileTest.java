import java.io.File;
import java.io.IOException;

public class FileTest {

	public FileTest() {
		// File : 하드디스크, USB 등 메모리의 드라이브, 폴더, 파일을 처리할 수 있는 객체
		
		// File 객체 생성하기
		File f1 = new File("c://java_test"); // 경로
		File f2 = new File(f1, "CalendarTest.java"); // 경로, 파일
		File f3 = new File("c://java_test/CalendarTest.java"); // 경로 + 파일
		File f4 = new File("c://java_test", "CalendarTest.java"); // 경로, 파일
		
		// 현재 C 드라이브에 없는 폴더
		// mkdir()	: 하위 디렉토리가 없을 경우 하나의 폴더 생성 (make directory)
		// mkdirs()	: 최하위 디렉토리까지 여러 폴더 생성
		// isDirectory() : 폴더(디렉토리)인지 파일인지
		// exists()	: 디렉토리 또는 파일이 존재하는지 아닌지(있으면 true, 없으면 false)
		File f5 = new File("c://sample"); 
		File f6 = new File("c://goguma/folder");
		f5.mkdir();
		f6.mkdirs();
		
		// 파일 생성 : create();
		File f7 = new File(f5, "kwon.txt");
		try {
			boolean result = f7.createNewFile();
			if(result) {
				System.out.println("파일 생성됨");
			} else {
				System.out.println("파일 생성되지 않음");
			}
		} catch(IOException ie) {
			ie.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {

	}

}
