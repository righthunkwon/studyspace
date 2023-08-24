import java.util.Arrays;

// 배열을 이용한 힙 만들기
public class Tree_02_Heap {
	private static int[] heap = new int[100]; // 완전이진트리로 가정
	private static int heapSize = 0;

	public static void main(String[] args) {
		heapPush(5);
		heapPush(22);
		heapPush(17);
		heapPush(4038);
		heapPush(34);
		heapPush(6);
		System.out.println(Arrays.toString(heap));
		
		while(heapSize != 0) {
			System.out.println(heapPop());
		}
	}

	// 삽입
	private static void heapPush(int item) {
		heap[++heapSize] = item; // 마지막 자리에 삽입

		int child = heapSize; // 자식
		int parent = child / 2; // 부모

		while (parent > 0 && heap[child] > heap[parent]) {
			int tmp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = tmp;

			// 부모 자식을 한레벨 위로 다시 결정
			child = parent;
			parent = child / 2;
		}
	}

	// 삭제
	// 완전이진트리의 자료형이 정수이므로 int로 반환형 선정
	private static int heapPop() {
		// 힙이 공백상태일 경우
		if (heapSize <= 0)
			return -1; // -1이라는 값이 있을 수도 있으므로 유의
		int item = heap[1]; // 루트노드

		// 마지막 노드를 루트 노드에 덮어씌운다.
		// 이때 heapSize를 감소시키므로 다음 삽입 시 마지막 노드는 덮어씌워지므로 따로 마지막 노드를 삭제하는 건 불필요하다.
		heap[1] = heap[heapSize--];

		int parent = 1;
		int child = parent * 2;

		// 오른쪽 자식이 존재하고, 오른쪽 자식이 왼쪽 자식보다 클 경우
		if (child + 1 <= heapSize && heap[child] < heap[child + 1]) {
			child += 1; // 오른쪽 자식으로 변경
		}

		// 내려갈 수 있는 만큼 내려보내기
		while (child <= heapSize && heap[parent] < heap[child]) {
			int tmp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = tmp;

			parent = child;
			child = parent * 2;
			if (child + 1 <= heapSize && heap[child] < heap[child + 1]) {
				child += 1; // 오른쪽 자식으로 변경
			}
		}

		return item;
	}
}
