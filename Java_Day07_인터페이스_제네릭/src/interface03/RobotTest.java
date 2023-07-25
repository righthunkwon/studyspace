package interface03;

interface Movable {
	public abstract void move();
}

interface Cookable {
	public abstract void cook();
}

interface Chef extends Movable, Cookable {
	
}

class Machine {
	
}

class Robot extends Machine implements Chef {

	@Override
	public void move() {
		
	}

	@Override
	public void cook() {
		
	}
	
}

public class RobotTest {
	
}
