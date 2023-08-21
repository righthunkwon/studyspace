import java.util.Arrays;

public class Queue_04_원형큐 {
	// 배열을 선언함으로써 createQueue 연산을 한 것이라고 생각할 것.
	public static String[] queue = new String[5]; // 1차원 배열이지만 직사각형처럼 생각하지말고
	public static int size = queue.length;
	// 원형의 도넛 모양으로 생각을 해보자.
	// front : 마지막으로 삭제된 원소의 위치, 공백상태와 포화상태를 구분하기 위해서 비워둔다.
	// rear : 마지막 원소의 위치
	public static int front = 0, rear = 0; // 갱신하는 방식으로 코드를 바꿔보기도 하자.

	public static void main(String[] args) {
		enQueue("박민아");
		enQueue("전민정");
		enQueue("이호진");
		enQueue("이민지");
		System.out.println(deQueue());
		System.out.println(deQueue());
		enQueue("이지은");
		enQueue("양띵균");
		System.out.println(Arrays.toString(queue));
		System.out.println(front);
		System.out.println(rear);
	}

	// front 와 rear가 동일하면 공백상태
	// 선형큐와 똑같다.
	public static boolean isEmpty() {
		return front == rear;
	}

	// 포화상태
	// rear에서 한칸 더 진행한 곳이 front가 가리키는 곳이라면 그것은 포화상태이다.
	public static boolean isFull() {
		return (rear + 1) % size == front;
	}

	// 삽입 : boolean / 자료형 / void
	public static void enQueue(String item) {
		// 배열로 만들었을 때 (연결리스트로 만들었다면 생략 가넝)
		if (isFull()) {
			System.out.println("가득 차서 더 이상 넣을 수 없다!");
			return;
		}
		// 넣는 행위를 하려면
//		rear++
//		++rear
		queue[(++rear) % size] = item;
	}

	// 삭제
	public static String deQueue() {
		// 공백쳌은 꼭 필요
		if (isEmpty()) {
			System.out.println("공백상태 입니다.");
			return null;
		}
		return queue[(++front) % size];
	}
}
