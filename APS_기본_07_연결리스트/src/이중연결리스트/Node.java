package 이중연결리스트;

public class Node {
	// 단순연결리스트는 하나의 데이터 필드와 하나의 링크 필드를 가지지만,
	// 이중연결리스트는 하나의 데이터 필드와 두 개의 링크 필드를 갖는다(이전필드, 이후필드)
	public String data;
	public Node prev; // 이전 노드 링크
	public Node next; // 이후 노드 링크
}
