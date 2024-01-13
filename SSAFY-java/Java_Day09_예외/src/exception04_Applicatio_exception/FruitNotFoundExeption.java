package exception04_Applicatio_exception;

public class FruitNotFoundExeption extends RuntimeException {
	public FruitNotFoundExeption(String name) {
		super(name + "에 해당하는 과일은 없습니다 ㅠ^ㅠ");
	}
}