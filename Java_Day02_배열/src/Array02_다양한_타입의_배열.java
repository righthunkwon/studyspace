
public class Array02_다양한_타입의_배열 {

	public static void main(String[] args) {
		boolean[] bArr = new boolean[5];
		char[] cArr = new char[5];
		float[] fArr = new float[5];
		String[] sArr = new String[5];
		
		System.out.println(bArr[0]); // 기본값 false
		System.out.println(cArr[0]); // 기본값 공백문자(\u0000)
		System.out.println(fArr[0]); // 기본값 0.0
		
		// 참조자료형의 초기값은 null이다.
		System.out.println(sArr[0]); // 기본값 null(존재하지 않는다)
	}

}
