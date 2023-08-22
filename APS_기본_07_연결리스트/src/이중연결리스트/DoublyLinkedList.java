package 이중연결리스트;

public class DoublyLinkedList {
	private Node head;
	private int size;
	
	// 중간 삽입
	// 순서 중요
	// 0. Node nextNode = curr.next;
	// 1. curr.next = node;
	// 2. node.prev = curr;
	// 3. node.next = nextNode;
	// 4. nextNode.prev = node;
	
	// 배열과 연결리스트의 장단점을 고려하여,
	// 자료를 조회할 일이 더 많다면 배열을,
	// 자료를 삭제하거나 추가할 일이 더 많더면 연결리스트를 사용하자.
}
