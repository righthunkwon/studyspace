package priority_queue_02;

import java.util.PriorityQueue;

public class PQtest {
	public static void main(String[] args) {
		PriorityQueue<Person> pq = new PriorityQueue<>();
		pq.add(new Person("이예원", 20));
		pq.add(new Person("전지현", 10));
		pq.add(new Person("박영규", 25));
		pq.add(new Person("전성재", 29));
		pq.add(new Person("박광진", 56));
		pq.add(new Person("차다운", 24));
		
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
