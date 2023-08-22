package 단순연결리스트;

public class SinglyLinkedList {
	private Node head; // 노드의 시작점, 참고자료형, 초기값 null
	private int size; // 연결리스트의 노드의 개수(이론상 필수는 아니지만 있으면 편함), 초기값 0

	// SinglyLinkedList의 기본 생성자
	// 생성 시 Java의 초기값의 성질을 이용하여 자동으로 head는 null로, size는 0으로 설정
	public SinglyLinkedList() {
	}

	// 첫번째 위치에 원소를 삽입하는 메서드
	public void addFirst(String data) {
		// 미리 만들어둔 생성자를 통해 인스턴스 생성 가능 -> 추가할 노드를 생성
		Node node = new Node(data); 

		// 순서 중요
		node.link = head; // 1. 먼저, 추가할 노드의 링크에 헤드를 연결하고
		head = node; // 2. 그 다음에 노드의 시작점인 헤드에 노드를 담는다.
		size++;
	}

	// 마지막 위치에 원소를 삽입하는 메서드
	public void addLast(String data) {
		if (head == null) { // or if (size == 0)
			addFirst(data);
			return;
		}
		Node node = new Node(data);
		Node curr = head;
		while (curr.link != null) {
			curr = curr.link;
		}
		curr.link = node;
		size++;
	}

	// 중간에 원소를 삽입하는 메서드
	public void add(int idx, String data) {
		if (idx < 0 || idx > size) {
			return;
		}
		if (idx == 0) {
			addFirst(data);
			return;
		}
		if (idx == size) {
			addLast(data);
			return;
		}

		Node pre = get(idx - 1);
		Node node = new Node(data);
		node.link = pre.link;
		pre.link = node;
		size++;
	}

	// 첫번째 원소 삭제
	// 반환값은 삭제된 데이터
	public String removeFirst() {
		if (head == null) {
			return null;
		}
		String data = head.data; // head의 data를 반환하기 위해 head를 삭제하기 전에 먼저 head의 data를 담는다.
		head = head.link;
		size--;
		return data;
	}

	// 중간 원소 삭제
	public String remove(int idx) {
		if (idx < 0 || idx >= size) {
			return null; // 유효하지 않은 인덱스에 접근할 경우 함수를 종료
		}
		if (idx == 0) {
			return removeFirst();
		}
		Node pre = get(idx - 1);
		Node removeNode = pre.link; // Node removeNode = get(idx); 와 동일하지만 pre.link가 효율적 
		String data = removeNode.data; // String data = pre.link.data; 와 동일한 의미
		pre.link = removeNode.link; // pre.link = pre.link.link; 와 동일한 의미
		size--;
		return data;
	}

	// 단순연결리스트의 요소들을 조회하는 메서드
	public Node get(int idx) {
		// 예외처리는 자유롭게 가능
		// 0보다 작은 값이 들어오면 첫 번째 노드를 반환되게 하거나,
		// size 이상이 들어오면 마지막 노드를 반환되게 할 수 있다.
		if (idx < 0 || idx >= size) {
			return null;
		}

		Node curr = head;
		for (int i = 0; i < idx; i++) { // index의 위치만큼 반복하여 이동하여 원하는 요소에 접근
			curr = curr.link;
		}
		return curr;
	}

	// 단순연결리스트의 요소들을 출력하는 메서드
	public void printList() {
		Node curr = head;
		if (head == null) { // or if (size == 0)
			System.out.println("출력할 요소가 없습니다.");
			return;
		}

		// size 필드를 이용한다면 for문으로 반복도 가능
		// size 필드를 이용하지 않는다면 반복 횟수를 모르므로 while문 사용이 편리
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.link; // curr의 link는 다음 node를 가리킨다.
		}
		System.out.println();
	}
}
