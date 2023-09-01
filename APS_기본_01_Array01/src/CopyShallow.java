import java.util.Arrays;

public class CopyShallow {
	public static void main(String[] args) {
		// 주소만을 복사하는 얕은 복사의 경우에는 원본 배열이든 복사한 배열이든 
		// 어떤 배열을 수정하더라도 대응하는 배열에 이것이 반영되어 사실상 복사의 의미를 갖지 못한다.
		
		int[] a = {1,2,3,};
		int[] b = a;
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		b[2] = 100;
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		a[1] = 200;
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
}
