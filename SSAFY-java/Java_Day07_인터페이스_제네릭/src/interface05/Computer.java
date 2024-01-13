package interface05;

public class Computer implements HdmiInput {
	private HdmiOutput outputDevice;
	
	@Override
	public void setOutput(HdmiOutput device) {
		outputDevice = device;
	}

	@Override
	public void show() {
		System.out.println("컴퓨터 화면을");
		outputDevice.output();
	}
	
}
