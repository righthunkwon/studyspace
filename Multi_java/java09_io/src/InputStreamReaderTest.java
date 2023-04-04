import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		/*
			InputStreamReader
				: 콘솔에서 문자(유니코드)단위로 입력받는 클래스
				: InputStream은 1byte 단위로 입력받지만, InputStreamReader는 유니코드 문자 단위로 입력받으므로
				  3byte인 한글이 깨지지 않고 정상적으로 입력된다.
		
		*/
		
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			int strInt = isr.read(); // InputStreamReader : 한 번에 한 문자씩 읽어온다.
			System.out.println(strInt + "-->" + (char)strInt);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		new InputStreamReaderTest();
	}

}
