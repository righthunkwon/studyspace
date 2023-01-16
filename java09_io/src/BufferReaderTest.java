import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BufferReaderTest {

	public BufferReaderTest() {
		/*
				InputStream()		  : 1byte
				InputStreamReader()	  : 1문자(유니코드)
				BufferedReader()	  : Reader(한 줄 단위, enter 기준, readLine() : 한 줄을 문자열로 받아서 리턴)
				
				BufferedReader()는 콘솔에서 입력받은 값을 버퍼에 임시로 저장한 뒤,
				이후 한 줄 단위로(enter 기준) 읽어오는 기능이 있다.
				
				BufferedReader를 만들기 위해서는 InputStreamReader가 필요하고, 
				InputStreamReader를 만들기 위해서는 InputStream가 필요하다.
		*/
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String line = br.readLine(); // 버퍼에서 한 줄 읽어오기.
			System.out.println(line);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		new BufferReaderTest();
	}

}

	/*
			IOException(자바 입출력 예외처리)
				: 컴퓨터 프로그램이 실행될 때 언제 어떤 문제가 발생할지 모르는 일이기 때문에 
				  프로그램을 만들 때는 예외로 발생하는 상황에 대처해야 하는데,
				  자바는 입력과 출력을 할 때 발생할 수 있는 예외에 대해서 까다롭게 규정하고 있다. 
				  그래서 입력과 출력을 다루는 메서드에 예외처리가 없다면 컴파일 에러가 발생하게 된다.
				  
				  단, 자바에서는 print(), println(), printf() 메서드에는 자체적으로 예외처리를 해놨기 때문에
				  이들에 대해서는 예외처리를 하지 않아도 되었던 것이다.
			
	*/
