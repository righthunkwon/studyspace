import java04_oop.MyData;

public class ProtectedTestMain {

	public ProtectedTestMain() {

	}
	public void start() {
		// MyData md = new MyData(); 
		/*
			접근 제한자 : public > protected > default(기본값) > private
			
				MyData를 사용하려고 하지만, 패키지가 다르기에 import가 필요하다. 하지만 import를 해도 오류가 발생한다.
				이는 MyData에 생성자메소드가 MyData라고만 기술되어 있다면 접근제한자가 기본값인 default인데,
				default의 경우 다른 패키지에 소속된 클래스는 접근이 불가하므로 오류가 발생하는 것이다.
				결과적으로 접근할 수 없는 클래스가 없는 public을 선언해주면 문제가 해결된다.
				
				그렇다면 다른 접근 제한자는 어떨까?
				private는 범위가 default보다 작고,모든 외부 클래스의 접근을 차단하므로 당연히 되지 않는다.
				그렇다면 protected는 가능할까. protected 역시 오류가 발생한다.
				protected는 자식 클래스가 아닌 다른 패키지에 소속된 클래스에 접근할 수 없기 때문이다. 
		*/
	}
	public static void main(String[] args) {

	}

}
