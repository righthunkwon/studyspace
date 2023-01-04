
public class Mult {

	public static void main(String[] args) {
		
		// 단 부분
		System.out.println("\t구구단");
		int dan = 0;
		for (dan=1; dan<=9; dan+=3) {
			for(int i=0; i<3; i++){
		    System.out.print(dan+i<10 ? "==" + (dan+i) + "단==\t" : "" );
		    }
		
		System.out.println();
			
			// 계산 부분
			for(int i=2; i<=9; i++){
				for(int j =0; j<3; j++){
					String str = (dan+j) + "*" + i + "=" + (dan+j)*i;
					System.out.print(dan+j<10 ? str + "\t" : "");
			      }
				System.out.println();
			}
		}
		  
	}
}