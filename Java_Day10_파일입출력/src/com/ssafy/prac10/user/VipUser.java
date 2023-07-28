package com.ssafy.prac10.user;

public class VipUser extends User {

	private String grade;
	private int point;

	public VipUser() {
	}

	public VipUser(String id, String password, String name, String email, int age, String grade, int point) {
		super(id, password, name, email, age);
		this.grade = grade;
		this.point = point;
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

	@Override
	public String toString() {
		return "VipUser [id=" + this.getId() + ", name=" + this.getName()
				+ ", age=" + this.getAge() + ", grade=" + grade + ", point=" + point
				+ "]";
	}
}
