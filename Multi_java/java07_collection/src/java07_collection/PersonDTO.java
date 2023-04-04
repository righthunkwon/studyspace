package java07_collection;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PersonDTO {
	// 번호표 번호
	private int num;
	// 날짜, 시간
	private Calendar dateTime;
	// 대기 인수
	private int waitingCount;
	
	public String toString() {
		/*
			번호 		: 5
			현재시간	: 2023-01-12 03:15:16 (목)
			대기인수 	: 3
		*/
		String message = "";
		message += "번호 :" + num+"\n";
		
		// SimpleDateFormat 클래스를 이용하면 날짜를 원하는 패턴으로 만들 수 있다.
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss (E)");
		
		// 날짜를 패턴에 적용
		String dateTimeStr = dFormat.format(dateTime.getTime());
		message += "현재시간 : " + dateTimeStr + "\n";
		
		// 대기열에 남아 있는 객체 수
		LinkedListTest.waitingList.size();
		message += "대기인수 : " + waitingCount;
		
		return message;
	}
	
	
	// getter, setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Calendar getDateTime() {
		return dateTime;
	}
	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}
	public int getWaitingCount() {
		return waitingCount;
	}
	public void setWaitingCount(int waitingCount) {
		this.waitingCount = waitingCount;
	}
	
	
}
	
	/*
			DTO(Data Transfer Object)	
				: 순수하게 데이터를 담아 계층 간으로 전달하는 객체
				: DTO는 로직을 갖고 있지 않은 순수한 데이터 객체이며 메서드로는 getter/setter 만을 갖는다.
				  getter/setter 이외에 다른 로직이 필요 없는 이유는, DTO가 데이터 전달 만을 위한 객체이기에,
				  즉, DTO는 완전히 데이터 '전달' 용도로만 사용되기 때문에 getter/setter로직만이 필요하지 다른 로직이 필요하지 않은 것이다.
				  
			VO(Value Object)
				: VO는 값 자체를 표현하기 위해 존재한다. 
				  로직을 포함할 수 있으며, 객체의 불변성(객체의 정보가 변경하지 않음)을 보장한다.
				  서로 다른 이름을 갖는 VO 인스턴스더라도 모든 속성 값이 같다면 두 인스턴스는 같은 객체라고 할 수 있다.
				  이를 위해 VO에는 Object 클래스의 equals()와 hashCode()를 오버라이딩해야 한다.
	*/
	
	/*
			SimpleDateFormat
				
	*/
	



