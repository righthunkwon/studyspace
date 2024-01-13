package priority_queue_03;

import java.util.PriorityQueue;

public class PQtest {
	public static void main(String[] args) {
		PriorityQueue<Person> pq = new PriorityQueue<>(new AgeComparator());
		pq.add(new Person("이예원", 20));
		pq.add(new Person("하지현", 10));
		pq.add(new Person("권영규", 25));
		pq.add(new Person("전성재", 29));
		pq.add(new Person("나광진", 56));
		pq.add(new Person("차다운", 24));
		
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
