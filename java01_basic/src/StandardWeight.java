import java.util.Scanner;

public class StandardWeight {

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
		
		System.out.print("나이 입력 : ");
		int age = scan.nextInt();
		
		System.out.print("성별 입력(남성:1, 여성:2) : ");
		int gender = scan.nextInt();
		
		System.out.print("키 입력 : ");
		double height = scan.nextInt();
		
		System.out.print("체중 입력 : ");
		double weight = scan.nextInt();
		double sWeight = 0;
		
		// 표준체중
		if(age <= 35) {
			if(gender == 1) {
				sWeight = (height - 100) * 0.90;  
			} else {
				sWeight = (height - 100) * 0.85;  
			}
			
		} else {
			if(gender == 1) {
				sWeight = (height - 100) * 0.95;  
			} else {
				sWeight = (height - 100) * 0.90;  
			}
			
		}
		
		// 표준체중지수
		double sWeightNum = (weight / sWeight) * 100;
		String result = "비만형";
		
		if (sWeightNum >= 126) {
			result = "비만형";
		} else if (sWeightNum >= 115) {
			result = "조금 비만형";
		} else if (sWeightNum >= 96) {
			result = "표준형";
		} else if (sWeightNum >= 86) {
			result = "조금 마른형";
		} else {
			result = "마른형";
		}
		
		System.out.println("당신의 표준체중지수는 " + sWeightNum + "으로 " + result + "입니다.");
	}

}
