package priority_queue_01;

import java.util.PriorityQueue;

public class PQtest {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(100);
		pq.add(2);
		pq.add(3);
		pq.add(4);
		// 우선순위큐는 최소힙으로 구현
		//			2
		//		4		3
		//	100
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		} 
	}
}
