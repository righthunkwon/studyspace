package java07_collection;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {
	
	public PropertiesTest() {
		// key와 value를 문자열로만 처리하는 컬렉션 : properties 클래스
		Properties pro = new Properties();
		
		// 객체 추가
		pro.setProperty("/seoul/index.do", "/index.jsp");
		pro.setProperty("/test.do", "/board/boardList.jsp");
		pro.setProperty("11111", "AAAAA");
		pro.setProperty("22222", "BBBBB");
		// 사용자가 보는 주소 (key) : /seoul/index.do, /test.do, 11111, 22222
		// 실제 처리되는 메소드 (value) : /index.jsp, /board/boardList.jsp, AAAAA BBBBB
		// 보안을 위해 실제 처리되는 메소드의 경로를 숨기기 위해 사용자가 보는 주소와 이를 다르게 설정한다.
		
		// key를 이용하여 값 얻어오기 : getProperty(key);
		System.out.println("/test.do-->"+ pro.getProperty("/test.do"));
		
		// key가 없을 때 key와 value를 만들어서 이를 출력 : getProperty(key, value)
		// 단, key가 있다면 해당 key의 value를 출력.
		System.out.println("/notice.do-->"+ pro.getProperty("/notice.do", "/error.jsp"));
		System.out.println("/notice.do-->"+ pro.getProperty("/seoul/index.do", "/error.jsp"));
		
		// 모든 key 목록 구하기
		Enumeration keyList = pro.propertyNames();
		while(keyList.hasMoreElements()) { // hasMoreElements() : 데이터가 계속해서 있다면 true를 반환, 없다면 false를 반환합니다
			String key = (String)keyList.nextElement();
			String value = pro.getProperty(key);
			System.out.println(key+"="+value); // 무작위로 key와 value가 담긴 걸 알 수 있다.
		}

	}

	public static void main(String[] args) {
		new PropertiesTest();
	}

}
