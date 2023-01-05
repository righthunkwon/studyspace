import java.util.Arrays;
import java.util.Collections;

public class ArraysTest {

	public static void main(String[] args) {
		// Arrays 클래스를 이용한 배열 처리 : lang에 있지 않으므로 별도로 import 필요
		
		int[] data = {23,86,7,47,862,90,2};
		
		// copyOf(배열명, 갯수) : index 0부터 원하는 수만큼 복사 (무조건 0부터 복사)
		int[] copy1 = Arrays.copyOf(data, 4);
		String copy1Str = Arrays.toString(copy1); // 변수에 담은 뒤,
		System.out.println("copy1 : "+copy1Str); // 출력 (데이터는 저장)
		
		// copyOfRange(배열명, 시작위치, 끝위치) : 단 끝 위치는 포함하지 않는다(이상, 미만의 범위 지정)
		int[] copy2 = Arrays.copyOfRange(data, 2, 6);
		System.out.println("copy2 :"+Arrays.toString(copy2)); // 바로 출력 (출력 이후 데이터는 사라짐)
		
		// sort() : 배열 전체의 값을 오름차순으로 정렬한다. 단, 원래 배열의 값 순서를 변경하고 이전 상태로 돌릴 수 없다. 
		System.out.println("정렬 전 :"+Arrays.toString(data));
		Arrays.sort(data);
		System.out.println("정렬 후 :"+Arrays.toString(data));
		
		String[] color = {"orange","red","blue","yellow","green","pink"};
		System.out.println("정렬 전 :"+Arrays.toString(color));
		Arrays.sort(color);
		System.out.println("정렬 후 :"+Arrays.toString(color));
		
		// 숫자 배열을 내림차순으로 정렬(불가)
		// Arrays.sort(data, Collections.reverseOrder());
		/*
			String, Integer, Double 등과 같은 Object 타입에 배열은 sort에 Collections.reverseOrder() 사용이 가능하고 
			기본타입인 int, double, char, float 등은 사용이 불가하므로
			기본타입의 배열을 Object를 상속하는 Wrapper 클래스로 박싱해주어야 역순정렬도 가능하다.
		*/
	
		// 문자 배열을 내림차순으로 정렬
		Arrays.sort(color, Collections.reverseOrder());
		System.out.println("내림차순 정렬 후 : "+Arrays.toString(color));
	}

}
