import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
				System.out.println("파일 생성되지 않음"); // 파일이 이미 있을 경우 생성되지 않음
			}
			
			// 마지막 수정일 : lastModified(), 기준은 밀리초, 1000 = 1s
			long lastSave = f3.lastModified();
			System.out.println(lastSave); // 1970년 1월 1일 0시 0분을 기준으로 계산
			
			// 밀리초로 Calendar 객체 만들기
			Calendar dateTime = Calendar.getInstance(); // Calendar에는 new를 사용할 수 없으므로 우선 현재를 구한 뒤에 여기에 원하는 값을 대입
			dateTime.setTimeInMillis(lastSave);
			
			// 2023-01-04 오전 11:46
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
			String dateStr = fmt.format(dateTime.getTime());
			System.out.println(dateStr);
			
			// 특정위치(드라이브, 폴더)
			File f8 = new File("c://");
			File[] fileList = f8.listFiles();
			for(File f9: fileList) {
				// getPath() : 드라이브, 경로, 파일명
				// getName() : 파일명(확장자 포함)
				// getAbsolutePath() : 드라이브, 경로, 파일명
				// getParent() : 드라이브, 경로
				if(f9.isDirectory()) { // 폴더
					if(f9.isHidden()) { // 숨김 폴더
						System.out.println(f9.getPath()+"[숨김폴더]");
					} else { // 기본 폴더
						System.out.println(f9.getPath()+"[폴더]");
					}
				} else { // 폴더가 아닐 때(파일일 때)
					if(f9.isHidden()) {
						System.out.println(f9.getPath()+"[숨김파일]");
					} else {
						System.out.println(f9.getPath()+"[파일]");
					}
				}
			}
			
			// 현재 컴퓨터의 드라이브 목록
			File[] drive = File.listRoots();
			for(File f9 : drive) {
				System.out.println(f9.getPath());
			}
			
			// 파일 크기(byte)
			System.out.println("파일크기=" + f2.length());
			
			// 파일 삭제
			// f7.delete();
			
			// 디렉토리 삭제(단, 폴더 내에 파일이 없어야 한다)
			// f5.delete();
			
		} catch(IOException ie) {
			ie.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new FileTest();
	}

}
