package java07_collection;

import java.util.Calendar;
import java.util.LinkedList;

public class LinkedListTest {
	public static int count = 1;
	// 번호표를 뽑으면 PersonDTO 객체를 만들어 Queue에 추가한다.
	public static LinkedList<PersonDTO> waitingList = new LinkedList<PersonDTO>();
	
	// Guest in : 번호표를 뽑을 때
	public void inGuest() {
		
		// 1. PersonDTO 객체를 만들어 num의 dto를 추가, num은 1증가
		PersonDTO person = new PersonDTO();
		person.setNum(count++);
		// 2. 현재날짜와 시간을 추가
		person.setDateTime(Calendar.getInstance());
		// 3. 대기인수 : waitingList의 크기를 구하여 waitingCount에 세팅
		person.setWaitingCount(waitingList.size());
		// 4. person을 waitingList에 추가
		waitingList.offer(person);
		// 5. 출력
		System.out.println(person.toString());

	}
	
	// Guest out : 차례가 되었을 때
	public void outGuest() {
		// 1. 제일 앞의 객체를 꺼내서 삭제
		waitingList.poll();
		System.out.println("남은 대기인 수 : " + (waitingList.size()-1)); // 남은 대기인 수 = 남은 객체 수 - 1 
		
	}
}


	/*
			static
			
				정적이란?
					정적(static)은 고정된이란 의미를 가지고 있습니다. Static이라는 키워드를 사용하여 Static변수와 Static메소드를 만들 수 있는데 
					이들은 다른 말로 정적필드와 정적 메소드라고도 하고, 이 둘을 합쳐 정적 멤버라고 합니다. (클래스 멤버라고도 합니다.) 정적 필드와 정적 메소드는 
					객체(인스턴스)에 소속된 멤버가 아니라 클래스에 고정된 멤버입니다. 그렇기에 클래스 로더가 클래스를 로딩해서 메소드 메모리 영역에 적재할 때 
					클래스별로 관리됩니다. 따라서 클래스의 로딩이 끝나는 즉시 바로 사용할 수 있습니다. 
				
				정적(Static)멤버 생성
					Static 키워드를 통해 생성된 정적멤버들은 Heap영역이 아닌 Static영역에 할당됩니다. 
					Static 영역에 할당된 메모리는 모든 객체가 공유하여 하나의 멤버를 어디서든지 참조할 수 있는 장점을 가지지만,
					Garbage Collector의 관리 영역 밖에 존재하기에 Static영역에 있는 멤버들은 프로그램의 종료시까지 메모리가 할당된 채로 존재하게 됩니다.
					그렇기에 Static을 너무 남발하게 되면 만들고자 하는 시스템 성능에 악영향을 줄 수 있습니다.
				
				정적(Static)멤버 선언
					필드나 메소드를 생성 시 인스턴스로 생성할 것인지 정적으로 생성할 것인지에 대한 판단 기준은 공용으로 사용하느냐 아니냐로 내리면 됩니다. 
					그냥 생성한다면 자동으로 인스턴스로 생성되며 정적으로 생성하려면 필드와 메소드 선언 시 static이라는 키워들를 추가적으로 붙이면 됩니다. 

			void

			LinkedList

			element, poll, peek
	*/
