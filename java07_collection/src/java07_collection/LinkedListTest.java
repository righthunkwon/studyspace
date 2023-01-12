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
	*/

	/*
		void
	*/

	/*
		LinkedList
	*/

	/*
		element, poll, peek
	*/
