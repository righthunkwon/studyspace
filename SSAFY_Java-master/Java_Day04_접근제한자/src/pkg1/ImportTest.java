package pkg1;

// java.lang.*; 은 기본적으로 import 되어있다.
// import java.util.*; 를 통해 자주 사용하는 패키지를 사용할  수 있다.
// 하지만, 이를 권장하지는 않는다(무슨 패키지를 사용했는지 알 수 없기 때문이다.)
// 또한 *는 하위 패키지에 있는 요소들을 가져오지 못한다는 문제가 있다.
import java.util.Date;
import java.util.Scanner;

public class ImportTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Date date;
	}
}