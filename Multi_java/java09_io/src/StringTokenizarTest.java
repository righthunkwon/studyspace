import java.util.StringTokenizer;

public class StringTokenizarTest {

	public StringTokenizarTest() {
		// 문자열을 특정 문자로 쪼개기, 연속 구분기호일 때는 공백을 버린다
		
		String data = "12 54, 32.65 76:32 75"; // 12, 54, 32, 65, 76, 32, 75로 구분
		StringTokenizer st = new StringTokenizer(data, " ,.: ");
		System.out.println("토큰 수 : " + st.countTokens());
		
		// StringTokenizer는 index가 없고, nextToken() 메소드를 이용하여 토큰을 얻어와야 한다.
		// 데이터의 합 구하기
		int sum = 0;
		while(st.hasMoreTokens()) { // 토큰이 있을 때까지 반복수행, true: 있음, false: 없음
			sum += Integer.parseInt(st.nextToken());
		}
		System.out.println("sum="+sum);
	}

	public static void main(String[] args) {
		new StringTokenizarTest();
	}

}
