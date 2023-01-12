package java07_collection;

import java.util.Calendar;

public class GenericMain {

	public static void main(String[] args) {
		
		// case 1
		// private Integer num; private String name;
		// int n1과 String name1이므로 타입이 동일하여 문제가 없다.
		int n1 = 10;
		String name1 = "무신사";
		
		GenericTest gt1 = new GenericTest();
		gt1.setNum(n1);
		gt1.setName(name1);
		System.out.println(gt1.toString());
		
		// case 2
		// case 1
		// private Integer num; private String name;
		// double n2와 Calendar now이므로 타입이 달라서 문제가 없다.
		// 이는 제네릭을 선언함으로써 해결할 수 있다.
		double n2 = 12.5;
		Calendar now = Calendar.getInstance();
		GenericTest<Double, Calendar> gt2 = new GenericTest<Double, Calendar>();
		gt2.setNum(n2);
		gt2.setName(now);
		System.out.println(gt2.getNum());
		System.out.println(gt2.getName());
	}

}
