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
