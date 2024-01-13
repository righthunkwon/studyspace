package interface05;

public class TV implements HdmiOutput {

	@Override
	public void output() {
		System.out.println("티비에 출력합니다.");
	}

}
