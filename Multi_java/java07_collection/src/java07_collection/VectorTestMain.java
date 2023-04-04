package java07_collection;
import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

public class VectorTestMain {

	public VectorTestMain() {
	}
	public void start() {
		VectorTest vt = new VectorTest();
		Vector vec = vt.getData();
		
		// 벡터의 객체 가져오기
		String name = (String)vec.get(0); // vec은 Object라는 상위클래스에 속해있으므로 하위 클래스 String으로 형변환 필요
		Random ran = (Random)vec.get(1); // 마찬가지 이유로 random으로 강제형변환.
		int age = (int)vec.get(2);
		Calendar cal = (Calendar)vec.get(3);
			int y = cal.get(Calendar.YEAR);
			int m = cal.get(Calendar.MONTH);
			int d = cal.get(Calendar.DAY_OF_MONTH);
		MemberDTO mem = (MemberDTO)vec.get(4);
			
		System.out.println("name : "+name);
		System.out.println("random : "+ran.nextInt(100));
		System.out.println("age : "+age);
		System.out.printf("날짜 : %d-%d-%d\n", y, m, d);
		System.out.println(mem.toString());
		
		System.out.println(vec.size()); // 삭제 전
		vec.remove(3); // 벡터의 index 3의 데이터를 삭제한다.
		vec.remove("갓정훈"); // 해당값이 들어간 객체를 삭제한다.
		System.out.println(vec.size()); // 삭제 후
	}
	public static void main(String[] args) {
		new VectorTestMain().start();
	}

}
