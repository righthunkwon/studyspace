import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {

	public DataOutputStreamTest() {
		try {	
			// DataOutputStream : 기본 데이터형의 값을 해당 데이터형의 바이트만큼 확보하여 저장한다.
			File file = new File("C://java_test", "data.txt");
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			
			int dataInt = 1234; // 4바이트
			double dataDouble = 1234.5678; // 8바이트
			boolean dataBoolean = true; // 1바이트
			char dataChar = 'A'; // 1바이트(영어), 3바이트(한글)
			
			dos.writeInt(dataInt);
			dos.writeDouble(dataDouble);
			dos.writeBoolean(dataBoolean);
			dos.writeChar(dataChar);
			
			fos.close();
			dos.close();
			
			System.out.println("프로그램이 종료되었습니다.");
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
			fnfe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DataOutputStreamTest();
	}

}
