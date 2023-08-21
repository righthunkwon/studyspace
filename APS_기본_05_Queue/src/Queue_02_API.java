import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Queue_02_API {
	public static void main(String[] args) {
		// Stack<Type> stack = new Stack<>(); (O)
		// Queue<Type> queue = new Queue<>(); (X)
		// Queue는 Stack과 달리 구현 클래스가 없고 인터페이스만 존재한다.
		
		// Queue는 LinkedList를 구현 클래스로 활용한다.
		Queue<String> queue = new LinkedList<>();
		
		// Queue Interface에는 6개의 메소드가 정의되어 있다.
		
		// 삽입(enqueue)
		// (1) add();
	    // (2) offer();

		// 삭제(dequeue)
		// (3) remove();
		// (4) poll();
		
		// 조회(search)
		// (5) element();
		// (6) peek();
		
		// add, remove, element는 예외가 발생하고,
		// offer, poll, peek는 예외가 발생하지 않는다는 차이가 있다.
		
		// case1
		queue.add("박민아");
		queue.offer("서만기");
		System.out.println(queue.remove()); // 박민아, FIFO
		System.out.println(queue.poll()); // 서만기, FIFO
		
		// case2
		queue.add("전민정");
		queue.offer("석지명");
		System.out.println(queue.peek()); // 전민정
		System.out.println(queue.element()); // 전민정
		
		// case3
		// 비어있는 queue를 가정
		queue.remove(); // 예외 발생
		queue.poll(); // 예외 미발생
	}
}
