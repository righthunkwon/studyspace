package java07_collection;

import java.util.ArrayList;

public class ArrayListTest {

	public ArrayListTest() {
		
	}
	// 메서드 : memberList, memberList 2
	
	// 회원 한 명의 정보를 DTO에 세팅하고 DTO를 ArrayList에 추가하여 리턴해주는 메서드
	public ArrayList<MemberDTO> memberList() { // 메서드는 소문자로 시작한다.
		
		// ArrayList Class
		ArrayList memList = new ArrayList();
		
		// add(Object) : 마지막에 객체 추가
		// add(int, Object) : 원하는 위치에 객체 추가(해당 위치 이후의 객체는 사라지는 게 아니라 한 칸씩 밀린다)
		
		// 네 명의 정보를 arrayList에 담는다.
		// 회원(1) - 생성자메서드
		memList.add(new MemberDTO());
		// 회원(2) - 일반메서드(임의로 생성한 메서드)
		memList.add(new MemberDTO("kko","권정훈","010-1111-2222"));
		// 회원(3) - 일반메서드(임의로 생성한 메서드)
		memList.add(new MemberDTO("kkokko","정훈권","010-1234-5678","kko@naver.com"));
		// 회원(4) - 객체
		MemberDTO dto = new MemberDTO();
		memList.add(dto);
		dto.setUserId("admin");
		dto.setUserName("관리자");
		dto.setEmail("admin@naver.com");

		return memList;

	}
	
	// =============================================================================================================
	
	public ArrayList memberList2() { 
		
		/*
			 제네릭(Generic) : <>
			 	
			 	생각해보자. 우리가 어떤 자료구조를 만들어 배포하려고 한다. 그런데 String 타입도 지원하고 싶고 Integer타입도 지원하고 싶고 
			 	기타 다른 많은 타입을 지원하고 싶다. 그러면 String에 대한 클래스, Integer에 대한 클래스 등 하나하나 타입에 따라 만들 것인가? 
			 	그건 너무 비효율적이다. 이러한 문제를 해결하기 위해 우리는 제네릭이라는 것을 사용한다.
			 	이렇듯 제네릭(Generic)은 클래스 내부에서 지정하는 것이 아닌 외부에서 사용자에 의해 지정되는 것을 의미한다. 
			 	한 마디로 특정(Specific) 타입을 미리 지정해주는 것이 아닌 필요에 의해 지정할 수 있도록 하는 일반(Generic) 타입이라는 것이다.
			 	
			 	
			 제네릭의 장점
			 	1. 제네릭을 사용하면 잘못된 타입이 들어올 수 있는 것을 컴파일 단계에서 방지할 수 있다.
				2. 클래스 외부에서 타입을 지정해주기 때문에 따로 타입을 체크하고 변환해줄 필요가 없다. 즉, 관리하기가 편하다.
				3. 비슷한 기능을 지원하는 경우 코드의 재사용성이 높아진다.
		*/
		
		// 컬렉션에 제네릭을 설정하면 켈렉션을 추가할 수 있다.
		// 단, 컬렉션에 설정된 타입과 다르면 추가할 수 없다.
		ArrayList<MemberDTO> memList = new ArrayList<MemberDTO>();
		
		// 회원(1) - 생성자메서드
		memList.add(new MemberDTO());
		// 회원(2) - 일반메서드(임의로 생성한 메서드)
		memList.add(new MemberDTO("kko2","권정훈","010-1111-2222"));
		// 회원(3) - 일반메서드(임의로 생성한 메서드)
		memList.add(new MemberDTO("kkokko2","정훈권","010-1234-5678","kko@naver.com"));
		// 회원(4) - 객체
		MemberDTO dto = new MemberDTO();
		memList.add(dto);
		dto.setUserId("admin2");
		dto.setUserName("관리자");
		dto.setEmail("admin@naver.com");
		
		// 제너릭 설정된 MemberDTO가 아니므로 추가할 수 없다.
		// memList.add(new Scanner(System.in));
		
		return memList;
	}
	
}


