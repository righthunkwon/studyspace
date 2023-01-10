package innerclass;

public class Sample {

	public Sample() {
		
	}

	public void getSum() {
		int sum = 0;
		for(int i=1; i<=100; i++) {
			sum +=i;
		}
		System.out.println("sum = "+sum);
	}
	public void getOddSum() {
		int sum = 0;
		for(int i=1; i<=100; i+=2) {
			sum += i;
		}
		System.out.println("oddSum = "+sum);
	}

}
