package interface05;

public interface HdmiInput {
	// HdmiOutput device
	// device는 HdmiOutput이라는 인터페이스를 구현한 클래스의 객체
	void setOutput(HdmiOutput device);
	void show();
}
