
public class StringBufferTest {

	public static void main(String[] args) {
		
		// 문자열을 처리하는 클래스 : String, StringBuffer, StringBuilder
		// String과 StringBuffer, StringBuilder 클래스의 가장 큰 차이점은 String은 불변(immutable)의 속성을 갖는다는 점이다.
		// 문자열의 추가,수정,삭제가 빈번하게 발생할 경우라면 String 클래스가 아닌 StringBuffer나 StringBuilder를 사용해야 한다. (변동사항을 반영)
		
		/*
			StringBuffer  : 멀티스레드(동기화) O
			StringBuilder : 멀티스레드(동기화) X
		*/
		
		// 요소 추가 : .append()
		StringBuffer sb = new StringBuffer();
		System.out.println("capacity : "+ sb.capacity());
		sb.append(1234);
		sb.append("ABCDE");
		sb.append(5555.3456);
		sb.append(true);
		
		// StringBuffer는 자동으로 용량을 늘린다.
		System.out.println("capacity : "+ sb.capacity());
		System.out.println(sb.toString());
		
		// 원하는 위치에 요소 삽입 : .insert(원하는 위치, 추가할 요소)
		sb.insert(6, " String Buffer ");
		System.out.println("capacity : "+ sb.capacity()); // 용량이 남아있으면 늘어나지 않을 수도 있다.
		System.out.println(sb.toString());
		   
		// 0123456789012345678901234567890123456
		// 1234AB String Buffer CDE5555.3456true
		// 문자열의 일부 삭제하기 : .delete(n이상, m미만)
		sb.delete(3,6);
		System.out.println("capacity : "+ sb.capacity());
		System.out.println(sb.toString());
		
		// 문자열 역순 배열 : .reverse()
		sb.reverse();
		System.out.println(sb.toString());
	}

}
