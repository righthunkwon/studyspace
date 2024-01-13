package test03_map;

import java.util.HashMap;
import java.util.Map;

public class MapTest01 {
	public static void main(String[] args) {
		// Map
		// 순서 X, 키 중복 X
		// 사전과 같은 자료구조
		// Key와 Value의 쌍으로 저장
		// Map<Key의 자료형, Map의 자료형> map
		
		Map<String, String> map = new HashMap<String, String>();
		
		// (1) 추가
		map.put("권정훈", "서울 7반");
		map.put("권정훈", "서울 6반"); // (2) 수정
		map.put("박민아", "서울 6반");
		map.put("이준혁", "대전 4반");
		map.put("이수지", "서울 8반");
		System.out.println(map); // 순서 X, 중복 X, 중복된 키를 넣으면 마지막에 작성된 Value가 저장
		
		// (3) 키와 값 확인
		System.out.println(map.keySet()); // [이준혁, 박민아, 이수지, 권정훈]
		System.out.println(map.get("권정훈")); // 서울 6반 // get(Key), return Value
		System.out.println(map.get("양명균")); // null
		
		// (4) 키와 값 존재 확인
		System.out.println(map.containsKey("권정훈")); // true
		System.out.println(map.containsKey("양명균")); // false
		System.out.println(map.containsValue("서울 6반")); // true
		System.out.println(map.containsValue("서울 1반")); // false
		System.out.println("==========================");
		// (5) 키와 밸류 확인
		for (String key : map.keySet()) {
			System.out.printf("%s : %s\n", key, map.get(key));
		}
		System.out.println("==========================");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
	}
}
