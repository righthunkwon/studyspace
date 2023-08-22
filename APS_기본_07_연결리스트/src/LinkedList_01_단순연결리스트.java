import 단순연결리스트.SinglyLinkedList;

public class LinkedList_01_단순연결리스트 {
	public static void main(String[] args) {
		// head = null, size = 0인  SinglyLinkedList 생성
		SinglyLinkedList list = new SinglyLinkedList();
		
		// 주석 해제하면서 확인해보기
		// 주석
		list.printList();
		list.addFirst("1111");
		list.printList();
		list.addFirst("2222");
		list.printList();
		list.addFirst("3333");
		list.printList();
		
		// 주석
		list.addLast("4444");
		list.printList();
		
		// 주석
		System.out.println(list.get(0));
		System.out.println(list.get(3));
		System.out.println(list.get(10));
		
		// 주석
		list.add(2, "5555");
		list.add(2, "6666");
		list.printList();
		
		// 주석
		list.removeFirst();
		list.printList();
	}
}
