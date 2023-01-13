package java07_collection;

public class ProductDTO {

	private int productCode; // 상품코드 : 일반적으로 실무에서 상품코드는 구별번호-일련번호 순으로 만든다. (ex. 프린트 4번 모델 pt-147). 단 예제에서는 숫자로만 만든다.
	private String productName; // 상품명
	private int price; // 가격
	private int amount; // 수량
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(int porductCode, String productName, int price, int amount) {
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.amount = amount;
	}
	
	// toString 오버라이딩
	@Override
	public String toString() {
		return productCode + "\t" + productName + "\t" + price + "\t" + "\t" + amount;
	}


	// getter, setter
	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	


}
