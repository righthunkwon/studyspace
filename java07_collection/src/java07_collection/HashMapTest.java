package java07_collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {
	
	public HashMapTest() {
		
	}
	public void start() {
		/*
			HashMap
				: 키와 value를 가진다
				: 키는 중복될 수 없다.
				: HashMap<key의 데이터형, value의 데이터형>
		*/
		HashMap<String, MemberDTO> hm = new HashMap<>();
		
		// 키를 추가 : put(key, value)
		// 권정훈 key
		hm.put("권정훈", new MemberDTO("kko", "권정훈", "010-1234-5678"));
		
		// 손님 key
		MemberDTO dto = new MemberDTO();
		hm.put("손님", dto);
		dto.setUserId("guset");
		dto.setUserName("손님");
		dto.setEmail("guest@naver.com");
		
		// 이재용 key
		hm.put("이재용", new MemberDTO("SamsungGod", "이재용", "010-1111-1111"));
		
		// 말하는감자
		hm.put("말하는 감자", new MemberDTO("PotatoCOder", "말하는 감자", "010-0000-0000"));
		
		
		// Map 컬렉션에서 객체 얻어오기
		// key를 이용하여 value 얻어오기 : get(key)
		// key가 겹칠 경우 덮어쓰기하고 원래 데이터는 사라진다.
		MemberDTO value = hm.get("이재용");
		System.out.println(value.toString());
		
		// 모든 key 얻어오기 : keySet()
		// (key를 모를 때는 key를 알아야 value도 알 수 있으므로 key값을 구하고 싶을 때가 있다. 이때 바로 를 활용한다)
		Set<String> keyList = hm.keySet();
		Iterator<String> ii = keyList.iterator();
		System.out.println();
		System.out.println("======================== key를 이용한 정보 얻기 ========================");
		while (ii.hasNext()) {
			MemberDTO dto2 = hm.get(ii.next());
			System.out.println(dto2.toString());
		}
		
		// 모든 value 얻어오기 : collection
		Collection<MemberDTO> valueList = hm.values();
		Iterator<MemberDTO> iii = valueList.iterator();
		System.out.println();
		System.out.println("======================== value를 이용한 정보 얻기 ========================");
		while(iii.hasNext()) {
			System.out.println(iii.next().toString());
		}
	}
	public static void main(String[] args) {
		HashMapTest hmt = new HashMapTest();
		hmt.start();
	}

}
