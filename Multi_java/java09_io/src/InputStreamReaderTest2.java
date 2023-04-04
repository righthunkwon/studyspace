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