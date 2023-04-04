package test05.linkedlist;

public class LinkedListData<E> {
	// 노드: Data 보관 & 다음 객체 주소를 보관 (데이터를 사슬처럼 연결)
	
	// 내부 클래스
	class Node<E> {
		private E data; // 현재 데이터
		private Node<E> next; // 다음 데이터의 포인트
		
		// 생성자 메소드
		Node(E data, Node<E> next) { 
			this.data = data;
			this.next = next;
		}
	}
	private Node<E> head; // 머리 노드를 가질 변수
	private Node<E> ctrl; // 선택 노드를 가질 변수
	
	// 생성자
	LinkedListData() {
		// 최초 객체 생성 시 머리노드, 선택노드는 없으므로 null로 초기화
		head = ctrl = null;
	}
	
	// 1. 머리에 노드를 삽입
	public void addFirst(E obj) {
		// 머리 노드가 null이면 List가 비어있고,
		// 머리 노드가 null이 아니면 현재 노드의 next로 설정한다.
		Node<E> ptr = head;
		head = ctrl = new Node(obj, ptr); 
	}
	
	// 2. 꼬리에 노드를 삽입
	public void addLast(E obj) {
		// 노드가 하나도 없다면 addFirst를 호출
		if(head == null) {
			addFirst(obj);
		} else { // 노드가 하나 이상 존재하면 마지막 노드를 찾아 obj를 다음 노드로 삽입
			Node<E> ptr = head;
			while(ptr.next != null) {
				ptr = ptr.next;
			}
			ptr. next = ctrl = new Node(obj, null);
		}
	}
	
	// 3. 머리 노드 삭제
	public void removeFirst() {
		// head의 노드를 head의 next 노드로 대체하면 가비기 컬렉터가 이를 자동으로 삭제
		if(head != null) {
			head = ctrl = head.next;
		}
		
	}
	
	// 노드 삭제 (4번 기능)
	public void remove(Node n) {
		if(head != null) { // 노드가 있다면,
			if(head == n) { // head 노드일 경우
				removeFirst();
			} else {
				Node<E> ptr = head;
				while(ptr.next != n) {
					ptr = ptr.next;
					if(ptr == null) { // n이 존재하지 않을 때
						return;
					}
				}
				ptr.next = n.next;
				ctrl = ptr;
			}
		}
	}
	
	//	4. 최근 노드 삭제
	public void removeCurrent() {
		remove(ctrl);
	}
	
	// 5. 모든 노드 출력
	public void dump() {
		Node<E> ptr = head;
		
		while(ptr!=null) {
			System.out.println(ptr.data.toString());
			ptr = ptr.next;
		}
	}
			
}
	
	/*
		Linked List
		
			linked list의 구조를 알아봅시다. 리스트는 노드(엘리먼트)들의 모임입니다.
			따라서 내부적으로 노드를 가지고 있어야 합니다. array list의 경우 엘리먼트가 배열의 엘리먼트였습니다.
			linked list는 배열 대신에 다른 구조를 사용합니다.
		
			노드는 최소한 두 가지 정보를 알고 있어야 합니다. 노드의 값과 다음 노드입니다. 
			각각의 노드가 다음 노드를 알고 있기 때문에 하나의 연결된 값의 모임을 만들 수 있는 것입니다.
			사슬이 무작위로 서로 연결되어 있는 것에 비유할 수 있습니다.
	*/

