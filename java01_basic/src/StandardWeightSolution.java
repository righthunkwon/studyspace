import java.util.Scanner;

public class StandardWeightSolution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		 * 다음기준에 맞는 프로그램을 작성하라. 
		 * 클래스명 : StandardWeight
		 * 
		 * 표준체중 기준 
		 * 35세 이하 
		 * 		남성 : (키 - 100)*0.90
		 * 		여성 : (키 - 100)*0.85 
		 * 
		 * 36세 이상 
		 * 		남성 : (키 - 100)*0.95 
		 * 		여성 : (키 - 100)*0.90
		 * 
		 * 표준체중 지수 = (현재체중/표준체중) * 100
		 * 
		 * 표준체중지수 평가기준 
		 * 		마른형 : 85이하 
		 * 		조금마른형 : 86~95 
		 * 		표준형 : 96~115 
		 * 		조금 비만형 : 116~125 
		 * 		비만형 : 126이상
		 */
		
		// 값 입력
		System.out.print("나이 : ");
		int age = scan.nextInt();

		System.out.print("성별(남성:1, 여성:2) : ");
		int gender = scan.nextInt();
		
		System.out.print("키 : ");
		double height = scan.nextDouble();
		
		System.out.print("현재 체중 : ");
		double weight = scan.nextDouble();
		
		
		// 표준체중
		double w = 0.90; // 35세 이하 남성과 36세 이상 여성이 동일하므로 한 번에 선언 
		if(age>=36 && gender==1) {
			w = 0.95;
		} else if (age<36 && gender==2) {
			w = 0.85;
		}
		
		double sWeight = (height - 100) * w;
		
		
		// 표준체중지수
		double sWeightIndex = (weight / sWeight) * 100;
		
		
		// 체형
		String result = "";
		
		if (sWeightIndex >= 126) {
			result = "비만형";
		} else if (sWeightIndex >= 115) {
			result = "조금 비만형";
		} else if (sWeightIndex >= 96) {
			result = "표준형";
		} else if (sWeightIndex >= 86) {
			result = "조금 마른형";
		} else {
			result = "마른형";
		}
		
		
		// 출력
		System.out.println("표준체중 : " + sWeight);
		System.out.println("당신의 표준체중지수는 " + sWeightIndex + "으로 " + result + "입니다.");
	}

}
