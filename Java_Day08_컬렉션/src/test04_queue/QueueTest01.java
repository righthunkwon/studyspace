package test04_queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest01 {
	public static void main(String[] args) {
		// Queue
		// FIFO, 선입선출
		// 큐는 인터페이스로 큐의 구현체는 LinkedList
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// queue에 값 순서대로 집어넣기
		for (int i = 0; i < 10; i++) {
			queue.offer(i);
		}
		
		// queue에서 값 순차적으로 꺼내기
		// 먼저 들어간 값이 먼저 나온다(FIFO, 선입선출)
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
	}
}
