package java07_collection;

import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public TreeMapTest() {
		/*
			TreeMap
				: key와 value를 가진다.
				: key를 정렬한다. (tree -> 정렬)
		*/
		
		TreeMap<String, MemberDTO> tm = new TreeMap<>();
		tm.put("권정훈", new MemberDTO("kko", "권정훈", "010-1234-5678"));
		tm.put("초밥", new MemberDTO("Sushi", "초밥", "010-1234-5678"));
		tm.put("돈가스", new MemberDTO("Tonkatsu", "돈가스", "010-1234-5678"));
		tm.put("등촌칼국수", new MemberDTO("BackChon", "등촌칼국수", "010-1234-5678"));
		tm.put("커피", new MemberDTO("coffee", "커피", "010-1234-5678"));
		
		System.out.println("======================== key목록을 구하여 전체 출력 ========================");
		Set<String> keyList = tm.keySet();
		System.out.println(keyList.toString());
		
		System.out.println("======================== value목록을 구하여 전체 출력 ========================");
		Collection<MemberDTO> valueList = tm.values();
		
		Object[] objList = valueList.toArray();
		for(Object obj : objList) {
			MemberDTO dto = (MemberDTO)obj;
			System.out.println(dto.toString());
		}
	}
	
	public static void main(String[] args) {
		new TreeMapTest();
	}
}

	/*
		컬렉션 프레임워크(Collection Framework)
				: 객체를 수집해 저장하는 것
				: 기존에 배열은 저장할 수 있는 개체 수가 배열 생성 시에 결정되었는데,
				  이는 불특정 다수의 객체의 저장 공간을 미리 설정하기 어렵다는 문제가 있었음
				: 또한, 배열은 객체를 삭제했을 때 해당 인덱스가 그냥 비어있는 공간으로 남아 있게 되어
				  객체를 저장하려면 어디가 비어있는지 일일이 확인해야 한다는 문제 또한 있었음
				: 컬렉션 프레임워크는 객체들을 효율적으로 추가, 삭제, 검색할 수 있도록 제공됨
				: 컬렉션은 java.util 패키지 내에 포함되며, 인터페이스를 통해 정황화된 방법으로 
				  다양한 컬렉션 클래스를 이용할 수 있음.
		
		
			List : 순서 유지 O, 중복 허용 O, index로 관리
				ArrayList	: 초기 저장 용량 10, 저장 용량을 초과한 객체들이 들어오면 자동적으로 늘어남, 고정 가능, 중간 객체 제거 시 바로 뒤부터 마지막까지 전체가 앞으로 당겨짐
				Vector		: 복수의 스레드가 동시에 Vector에 접근해 객체를 추가
				Linked List	: 인접 참조를 링크해서 체인처럼 관리, 특정 인덱스에서 객체를 제거하거나 추가하게 되면 바로 앞 뒤 링크만 변경
				
			Set	 : 순서 유지 X, 중복 허용 X, 수학의 집합에 해당, 하나의 null만 저장 가능
				 : 전체 객체를 대상으로 한번씩 반복해 가져오는 반복자(Iterator) 제공, 인덱스를 검색해서 가져오는 기능X
				 : HasSet, LinkedHashSet, TreeSet
							
			Map	 : 순서 유지 X, 키 중복 허용 X, 값 중복 허용 O, key와 value의 쌍으로 이루어진 데이터 집합, key와 value는 모두 객체
				 :
			
			Que	 :
			deque:
	*/