package modifier07_student;

import java.util.Scanner;

public class StudentTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentManager sm = StudentManager.getManager();
		int sel;
		do {
			System.out.println("번호를 입력하시오~~!");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 조회(이름으로)");
			System.out.println("3. 전공변경");
			System.out.println("0. 종료");
			sel = sc.nextInt();
			if (sel == 1) {
				// 학생 추가
				System.out.println("학생을 추가합니다.");
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("나이 : ");
				int age = sc.nextInt();
				System.out.print("전공 : ");
				String major = sc.next();
				Student st = new Student(name, age, major);
				sm.addStudent(st);
			} else if (sel == 2) {
				// 학생 조회
				System.out.println("학생을 조회합니다.");
				System.out.print("이름 : ");
				String name = sc.next();
				Student st = sm.getStudent(name);
				if (st == null) {
					System.out.println("학생을 못찾았어~~");
				} else {
					System.out.println("조회한 학생의 정보?");
					System.out.println(st.getName());
					System.out.println(st.getAge());
					System.out.println(st.getMajor());
				}
			} else if (sel == 3) {
				// 전공변경
				System.out.println("전공을 변경합니다.");
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("전공 : ");
				String major = sc.next();
				sm.changeMajor(name, major);
			}
		} while (sel != 0);
	}// main

}
