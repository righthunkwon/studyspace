import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest2 {

	public InputStreamReaderTest2() {

		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			while (true) {
				char[] str = new char[10];
				int cnt = isr.read(str);
				// char배열을 string로 바꾸는 방법 : new String(str); / String.valueOf(str);
				System.out.println(cnt + "-->" + String.valueOf(str)); // enter는 두 글자로 인식
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new InputStreamReaderTest2();
	}

}
	
	/*
			InputStream()		  : 1byte
			InputStreamReader()	  : 1문자(유니코드)
			BufferedReader()	  : Reader(한 줄 단위, enter 기준, readLine() : 한 줄을 문자열로 받아서 리턴)
			
			BufferedReader를 만들기 위해서는 InputStreamReader가 필요하고, InputStreamReader를 만들기 위해서는 InputStream가 필요하다.
	*/
