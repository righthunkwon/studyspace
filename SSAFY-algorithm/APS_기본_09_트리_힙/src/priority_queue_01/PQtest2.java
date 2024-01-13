package priority_queue_01;

import java.util.PriorityQueue;

public class PQtest2 {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// 우선순위큐는 최소힙으로 구현
		// 최대힙으로 바꾸는 방법 : 전부 음수처리
		pq.add(- 100);
		pq.add(- 2);
		pq.add(- 3);
		pq.add(- 4);
		
		while (!pq.isEmpty()) {
			System.out.println(- pq.poll());
		}
	}
}
