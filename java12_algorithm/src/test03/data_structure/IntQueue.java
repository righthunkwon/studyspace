package test03.data_structure;
	
	/*
		큐(Queue)
				: 선입선출(FIFO, First in, First out), 중복가능
				: front(삭제 연산이 수행되는 곳), rear(삽입 연산이 이루어지는 곳)
				: Enqueue = 큐의 리어(rear)에서 이루어지는 삽입 연산, Dequeue = 큐의 프론트(front)에서 이루어지는 삭제 연산
				: 카페에서 먼저 와서 주문한 손님이 음료를 먼저 받고 나가는 것
				  (은행 업무, 대기열 순서와 같은 우선순위의 작업 예약, 서비스센터의 대기, 프로세스 관리 등)
			
	*/

public class IntQueue {
	// 용량
	private int max;
	// front(삭제, dequeue)
	private int front;
	// rear(삽입, enqueue)
	private int rear;
	// 데이터의 수
	private int num;
	// queue를 처리할 배열
	private int queue[];  
	
	// 예외 클래스////////////////////////////////////////////////////////
	// ENQUEUE 실행 시 스택에 데이터가 넘칠 때(오버플로우 시) 발생시킬 예외 클래스
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
			
		}
	}
	
	// DEQUEUE 실행 시 스택에 데이터가 비어있는데 실행할 경우 발생시킬 예외 클래스
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
			
		}
	}
	///////////////////////////////////////////////////////////////////
	
	
	public IntQueue() {
		this(5);
	}
	
	public IntQueue(int capacity) {
		num = front = rear = 0; // 초기화
		max = capacity;
		try {
			queue = new int[max];
		} catch(OutOfMemoryError oome) {
			max = 0;
		}
	}
	
	// ENQUEUE(1): REAR에 데이터 추가
	public int enqueue(int data) {
		// queue가 가득 차있을 경우 예외 발생
		if(max == num) {
			throw new OverflowIntQueueException();
		}
		
		// queue에 공간이 있을 때
		queue[rear++] = data; // rear에 data를 담고 rear는 1증가
		num++; // 데이터 수 1증가
		
		// 용량과 rear가 같아 배열의 범위를 벗어날 때 rear 초기화
		if(max==rear) {
			rear = 0;
		}
		return data;
	}
	
	// DEQUEUE(2): FRONT에 데이터 삭제
	public int deque() {
		// queue가 비어있을 때 예외 발생
		if(num==0) {
			throw new EmptyIntQueueException();
		}
		// 데이터가 있을 때 front의 값을 구하고 다음 위치 값으로 설정
		// (1이 증가하므로 다음 데이터가 front의 가장 앞 데이터가 된다)
		int data = queue[front++];
		// 데이터의 갯수 감소
		num--;
		if(front==max) {
			front = 0;
		}
		return data;
	} 
	
	// PEEK(3): 제일 앞의 데이터 가져오기
	public int peek() {
		if(num==0) {
			throw new EmptyIntQueueException();
		}
		return queue[front];
	}
	
	// 데이터 확인(4)
	public String dataView() {
		String str = "";
		for(int i=0; i<max; i++) {
			str += "queue["+i+"]="+queue[i];
			if(i!=max-1) {
				str += ", ";
			}
		}
		return str;
	}
	
	// 데이터 찾기(5)
	public int indexOf(int data) {
		// 데이터가 있으면 index 반환, 데이터가 없으면 -1 반환
		for(int i=0; i<num; i++) {
			int index = (front + i) % max;
			if(queue[index] == data) { // index 위치의 값이 찾는 값과 동일할 때
				return index;
			}
		}
		return -1;
	}
	
	// 큐정보표시(6) : 용량, 데이터의 수, 비어있는지, 가득찼는지, 마지막 데이터 출력, 마지막 데이터 출력 후 삭제
	// 큐의 용량(크기)
	public int capacity() {
		return max;
	}
	// 큐의 현재 데이터 수
	public int size() {
		return num;
	}
	// 큐의 상태(비어있는지 아닌지)
	public boolean isEmpty() { // is- 로 시작하는 메소드는 결과값을 boolean으로 지정한다.
		if(num==0) {
			return true;
		} else {
			return false;
		}
	}
	// 큐의 상태(가득찼는지 아닌지)
	public boolean isFull() {
		if(max == num) {
			return true;
		} else {
			return false;
		}
	}
	// 큐의 마지막 데이터 출력
	public int peekLast() {
		if(isEmpty()) {
			return -1;
		}
		// rear의 이전 위치의 값
		int index = rear - 1;
		if(index == -1) {
			index = max-1;
		}
		return queue[index];
	}
	// 큐의 마지막 데이터 출력 이후 삭제
	public int pollLast() {
		if(isEmpty()) {
			return -1;
		}
		int index = rear -1;
		if(index == -1) {
			index = max - 1;
		}
		rear = index;
		num--;
		return queue[index];
	}


}
