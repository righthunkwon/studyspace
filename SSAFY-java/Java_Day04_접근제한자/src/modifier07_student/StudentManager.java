package modifier07_student;

// 싱글턴 패턴
public class StudentManager {
	// 학생 객체를 배열로 관리, 매니저는 한 번만 생성하여 데이터를 관리
	private Student[] students = new Student[100];
	private int size = 0;
	
	private static StudentManager manager = new StudentManager();
	private StudentManager() {
	}
	
	public static StudentManager getManager() {
		return manager;
	}
	public static void setManager(StudentManager manager) {
		StudentManager.manager = manager;
	}

	public void addStudent(Student st) {
		if (size < students.length) {
			students[size++] = st;
		} else {
			System.out.println("정원초과. 다음 기수를 노려주세요!");
		}
	}
	public Student getStudent(String name) {
		for (int i = 0; i < size; i++) {
			if (name.equals(students[i].getName())) {
				return students[i];
			}
		}
		// 학생을 찾지 못할 경우 null 반환
		return null;
	}

	public void changeMajor(String name, String major) {
		// for문을 다시 활용하여 학생을 찾을 수도 있겠지만,
		// 이미 만들어진 getStudent() 메소드를 활용하면 코드의 중복을 막을 수 있다.
		Student st = getStudent(name); 
		if (st != null) {
			st.setMajor(major);
		} else {
			System.out.println("그런 학생은 존재하지 않아요!");
		}
	}
	
}
