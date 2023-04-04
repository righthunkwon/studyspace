import com.multi.Student;

public class ModifierTest01 {

	public ModifierTest01() {
		// 객체 생성
		Student studentInfor = new Student();
		System.out.println("이름=" + studentInfor.name);
		studentInfor.studentPrint();
	}

	public static void main(String[] args) {
		new ModifierTest01();
	}

}
