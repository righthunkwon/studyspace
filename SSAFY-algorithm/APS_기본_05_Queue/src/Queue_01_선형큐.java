
public class Queue_01_선형큐 {
	public static String[] queue = new String[5];
	public static int front = -1; // 마지막으로 삭제된 원소의 위치
	public static int rear = -1; // 마지막으로 삽입된 원소의 위치

	public static void main(String[] args) {
		// Queue는 front pointer와 rear pointer가 필요하다.
		// front에서는 삭제 연산이, rear에는 삽입 연산이 발생한다.
		// 초기 pointer의 값은 초기 Queue에 값이 없기 때문에 front와 rear 모두 -1로 설정한다.
	}

	// (1) isEmpty() : front == rear일 경우 Empty
	public static boolean isEmpty() {
		return front == rear;
	}

	// (2) isFull : rear == Queue.length - 1일 경우 Full (단, 앞이 차있지 않으면 가득차있지 않을 수 있다)
	public static boolean isFull() {
		return rear == queue.length - 1;
	}

	// (3) enQueue : queue[++rear] = item
	public static void enQueue(String item) {
		// 포화상태 확인
		// 단, 연결리스트로 작성할 경우 포화상태 체크 불필요
		if (isFull()) {
			System.out.println("Queue is Full !!!");
			return;
		}
		queue[++rear] = item;
	}

	// (4) deQueue : return queue[++front]; (front의 정의가 마지막으로 삭제한 원소의 위치이므로 ++front)
	//										(만약, front의 정의를 마지막 원소의 위치로 한다면 front++이 적절)
	public static String deQueue(String item) {
		// 공백상태 확인(필수)
		if (isEmpty()) {
			System.out.println("Queue is Empty !!!");
			return null;
		}
		return queue[++front];
	}
}
