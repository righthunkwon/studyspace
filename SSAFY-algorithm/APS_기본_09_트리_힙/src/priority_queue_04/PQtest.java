package priority_queue_04;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQtest {
	public static void main(String[] args) {
		
		// 한 번만 사용하므로 익명클래스로 구현 
		PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>( ) {

			@Override
			public int compare(Person o1, Person o2) {
				if (o1.age == o2.age) {
					return o1.name.compareTo(o2.name);
				}
				return o1.age - o2.age;
			}
			
		});
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
