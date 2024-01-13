import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 5;
		int subway = 0;
		int gimbab = 0;
		int kfc = 0;
		
		for (int t = 1; t <= tc; t++) {
			subway += sc.nextInt();
			gimbab += sc.nextInt();
			kfc += sc.nextInt();
		}
		if (subway == gimbab) {
			System.out.println("서브웨이 or 싸다김밥");
		} else if (subway == kfc) {
			System.out.println("서브웨이 or KFC");
		} else if (subway > gimbab && subway > kfc) {
			System.out.println("서브웨이");
		} else if (gimbab > subway && gimbab > kfc) {
			System.out.println("싸다김밥");
		} else if (kfc > subway && kfc > gimbab) {
			System.out.println("kfc");
		}
	}
}
