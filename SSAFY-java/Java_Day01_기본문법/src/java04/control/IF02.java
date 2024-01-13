package src.java04.control;

public class IF02 {
	public static void main(String[] args) {
		// if(조건식) { }  조건식이 참일 경우 if 블록 내부 수행
		// else { }  	   거짓이면 else 블록 수행

		//무슨 음료를 마실수 있는가??
		int age = 17;
		
		if (age < 20) {
			System.out.println("사이다");
		} else {
			System.out.println("참이슬");
		}
		
	}
}
