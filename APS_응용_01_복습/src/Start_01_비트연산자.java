
public class Start_01_비트연산자 {
	public static void main(String[] args) {
		// 0011 (3) 
		// 0101 (5)
		
		// & : 두 비트가 1이면 1을 내뱉고 아니면 0을 내뱉어
		System.out.println(3 & 5); // 1

		// | : 하나의 비트라도 1이면 1을 내뱉고 아니면 0을 내뱉어
		System.out.println(3 | 5); 

		// ^ : XOR 같으면 0 다르면 1으롤 내뱉는다.
		System.out.println(3 ^ 5);

		// ~ : 단항연산자. 모든 비트를 반전 시키겠다.
		System.out.println(~3);

		// A << B : A의 비트를 왼쪽으로 B번 움직이겠다.
		// 한번 움직일 때마다 2배씩 커진다.
		System.out.println(3 << 2);

		// A >> B : A의 비트를 오른쪽으로 B번 움직이겠다.
		// 한번 움직일 때마다 2배씩 작아진다.
		System.out.println(12 >> 2);
		System.out.println(13 >> 1);

	}
}
