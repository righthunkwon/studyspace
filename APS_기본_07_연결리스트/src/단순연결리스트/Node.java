package 단순연결리스트;

// 데이터 필드와 링크 필드로 구성
// 데이터 필드에는 값을, 링크 필드에는 다음 노드를 가리키는 주소가 존재 
public class Node {
	public String data; // 데이터 예시, 참조자료형, 초기값 null
	public Node link; // 주소를 저장할 Node 자료형, 참조자료형, 초기값은 null
	
	// Node의 기본 생성자
	public Node() {
	}
	
	// Node의 생성자
	// data는 입력한 data
	// link는 초기값인 null
	public Node(String data) { 
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
	
}
