package com.ssafy.prac7.user;

public class VipUser extends User {

	private String grade;
	private int point;

	public VipUser() {
	}

	public VipUser(String id, String password, String name, String email, int age, String grade, int point) {
		// 부모 클래스의 생성자 호출
		super(id, password, name, email, age);
		this.grade = grade;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "VipUser [id=" + this.getId() + ", password=" + this.getPassword() + ", name=" + this.getName()
				+ ", email=" + this.getEmail() + ", age=" + this.getAge() + ", grade=" + grade + ", point=" + point
				+ "]";
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
