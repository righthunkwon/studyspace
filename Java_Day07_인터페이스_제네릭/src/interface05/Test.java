package interface05;

public class Test {
	public static void main(String[] args) {
		HdmiInput computer = new Computer();

		// 모니터
		HdmiOutput monitor = new Monitor();
		computer.setOutput(monitor);
		computer.show();

		// 티비
		HdmiOutput tv = new TV();
		computer.setOutput(tv);
		computer.show();
	}
}
