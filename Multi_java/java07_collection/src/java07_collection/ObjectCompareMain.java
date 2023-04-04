package java07_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectCompareMain {
	List<ProductDTO> list = new ArrayList<ProductDTO>();
	public ObjectCompareMain() {
		// 객체 내의 값을 이용하여 정렬하기

		// list는 정렬이 되지 않고 중복이 가능하다.
		list.add(new ProductDTO(10000, "초코바 기본", 9500, 15));
		list.add(new ProductDTO(10001, "초코바 딸기", 10500, 23));
		list.add(new ProductDTO(10002, "초코바 녹차", 10500, 11));
		list.add(new ProductDTO(10010, "화이트 초코바", 10000, 17));
		list.add(new ProductDTO(10003, "초코바 바닐라", 12000, 20));
		list.add(new ProductDTO(10004, "초코바 위스키", 15000, 2));

		System.out.println("=================== 정렬 전 ===================");
		productPrint();
		
		/*
			sort() : 
		*/
		
		// 가격을 기준으로 숫자를 오름차순으로 정렬
		Collections.sort(list, new ComparePriceAsc());
		System.out.println("========== 가격을 기준으로 오름차순 정렬 후 ==========");
		productPrint();
		
		// 가격을 기준으로 숫자를 내림차순으로 정렬
		Collections.sort(list, new ComparePriceDesc());
		System.out.println("========== 가격을 기준으로 내림차순 정렬 후 ==========");
		productPrint();
		
		// 상품명을 기준으로 문자를 오름차순으로 정렬: sort(정렬대상, 정렬기준)
		// 크기를 비교해주는 compare 메소드는 Comparator 인터페이스에서 상속받아 오버라이딩된다.
		Collections.sort(list, new CompareProductNameAsc());
		System.out.println("========== 상품명을 기준으로 오름차순 정렬 후 ==========");
		productPrint();
		
		// 상품명을 기준으로 문자를 내림차순으로 정렬: sort(정렬대상, 정렬기준)
		Collections.sort(list, new CompareProductNameDesc());
		System.out.println("========== 상품명을 기준으로 내림차순 정렬 후 ==========");
		productPrint();


	}
	
	// 출력 메서드
	public void productPrint() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	// 가격을 기준으로 숫자를 오름차순으로 정렬
	class ComparePriceAsc implements Comparator<ProductDTO> {
		public int compare(ProductDTO d1, ProductDTO d2) {
			// d1의 가격이 크면 +, d1의 가격이 작으면 -, d1, d2의 가격이 같으면 0 리턴
			return(d1.getPrice() > d2.getPrice()) ? 1 : (d1.getPrice()==d2.getPrice() ? 0 : -1);
		}
	}
	
	// 가격을 기준으로 숫자를 내림차순으로 정렬
	class ComparePriceDesc implements Comparator<ProductDTO> {
		public int compare(ProductDTO d1, ProductDTO d2) {
			// d1의 가격이 크면 +, d1의 가격이 작으면 -, d1, d2의 가격이 같으면 0 리턴
			return(d1.getPrice() > d2.getPrice()) ? -1 : (d1.getPrice()==d2.getPrice() ? 0 : 1);
		}
	}
	
	// 상품명을 기준으로 문자에 대한 오름차순 정렬
	class CompareProductNameAsc implements Comparator<ProductDTO> { // List의 제너릭 : ProductDTO
		public int compare(ProductDTO dto1, ProductDTO dto2) {
			// 반환값이 -인 경우 그냥 두지만, 반환값이 +인 경우 dto1의 상품명이 크기 때문에 sort()메소드가 이를 교환해준다.
			return dto1.getProductName().compareTo(dto2.getProductName());
		}
	}

	// 상품명을 기준으로 문자에 대한 내림차순 정렬
	class CompareProductNameDesc implements Comparator<ProductDTO> {
		public int compare(ProductDTO d1, ProductDTO d2) {
			// 반환값이 -인 경우 그냥 두지만, 반환값이 +인 경우 dto1의 상품명이 크기 때문에 sort()메소드가 이를 교환해준다.
			return d2.getProductName().compareTo(d1.getProductName());
		}
	}
	
	public static void main(String[] args) {
		new ObjectCompareMain();
	}

}
