package java07_collection;

import java.util.ArrayList;

public class ArrayListMain {

	public void start() {
		ArrayListTest alt = new ArrayListTest();
		ArrayList al = alt.memberList();
		
		for(int i=0; i<al.size(); i++) { // index : 0,1,2,3
			MemberDTO dto = (MemberDTO)al.get(i);
			System.out.printf("%s\t %s\t %s\t %s\n", dto.getUserId(), dto.getUserName(), dto.getTel(), dto.getEmail());
			// 값을 넣지 않은 요소는 null로 출력된다.
		}
		System.out.println("===============================================");
		
		// 컬렉션 ArrayList의 객체를 배열로 얻어오기
		Object[] memObj = al.toArray();
		for(Object m: memObj) {
			MemberDTO dto = (MemberDTO)m;
			System.out.println(dto.toString());
		}
		System.out.println("===============================================");
		
		// ArrayList 확장 for문(데이터형 접근변수명 : 배열명 혹은 컬렉션변수명)
		for( Object m : al ) {
			MemberDTO dto = (MemberDTO)m;
			System.out.printf("%s\t %s\t %s\t %s\n", dto.getUserId(), dto.getUserName(), dto.getTel(), dto.getEmail());
		}
		
		System.out.println("===============================================");
		
		// 제너릭 사용(memberList2)
		ArrayList<MemberDTO> al2 = alt.memberList2();
		for( MemberDTO dto : al2) {
			System.out.println(dto.toString());
		}
		System.out.println("===============================================");
		for(int i=0; i<al2.size(); i++) {
			// 제너릭이 설정된 컬렉션은 Object가 아니라 제너릭으로 리턴하므로 형변환하지 않아도 된다.
			MemberDTO dto = al2.get(i);
			System.out.printf("%s %s %15s %s\n", dto.getUserId(), dto.getUserName(), dto.getTel(), dto.getEmail());
		}
	}
	public static void main(String[] args) {
		new ArrayListMain().start();
	}

}


	/*
			ArrayList
				ArrayList는 자바에서 기본적으로 많이 사용되는 클래스입니다.
				import java.util.ArrayList; 를 추가하여 사용할 수 있습니다.
				표준 배열보다는 느리지만 배열에서 많은 조작이 필요한 경우 유용하게 사용됩니다.

				ArrayList는 자바의 List 인터페이스를 상속받은 여러 클래스 중 하나입니다.
				일반 배열과 동일하게 연속된 메모리 공간을 사용하며 인덱스는 0부터 시작합니다.
				배열과의 차이점은 배열이 크기가 고정인 반면 ArrayList는 크기가 가변적으로 변합니다.
				내부적으로 저장이 가능한 메모리 용량(Capacity)이 있으며 현재 사용 중인 공간의 크기(Size)가 있습니다.
				만약 현재 가용량(Capacity) 이상을 저장하려고 할 때 더 큰 공간의 메모리를 새롭게 할당합니다.
				즉, ArrayList는 객체가 추가되어 용량을 초과하면 자동으로 부족한 크기만큼 용량이 늘어납니다.
				
			ArrayList의 메소드
					add(Object)			: 엘리먼트 추가(가장 끝에 값 추가)
					add(int, Object)	: int index번째에 데이터 추가
					set(int, Object) 	: int index번째의 데이터 변경
					remove(int)			: 값 삭제
					remove(Object)		: 값 삭제
					clear()				: 데이터 모두 삭제
	*/


	/*
			size와 capacity (+ length와 length())
				
				size()		: Vector, List, Array List 등 Collection Type 길이(원소 수), 문자열의 크기
				capacity()	: Vector, List, Array List 등 Collection Type 길이(물리적 크기)
				length		: 배열의 크기 (int, double, float...)
				length()	: 문자열의 길이
					
	*/