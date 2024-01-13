import java.util.LinkedList;
import java.util.Queue;

public class Queue_03_마이쮸 {
	// offer, poll, peek
	static class Person {
		int num; // 사람의 고유번호
		int cnt; // 마이쮸 수
		
		public Person(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {
		int mn = 20; // 마이쮸 개수
		int pn = 1; // 사람의 고유번호
		
		// 큐 생성
		Queue<Person> queue = new LinkedList<>();

		// 첫번째 사람 넣어두기
		queue.add(new Person(pn++, 1));
		
		// 반복횟수를 모르므로 while문 사용
		while(mn > 0) {
			Person p = queue.remove();
			mn -= p.cnt;
			if (mn <= 0) {
				System.out.println(p.num + "번 사람이 마지막 마이쮸를 가져갔다.");
			} else {
				System.out.println(p.num + "번 사람이 " + p.cnt + "개의 마이쮸를 가져갔다.");
				p.cnt++;
				System.out.println("남은 마이쮸 : " + mn + "개");
				queue.add(p);
				queue.add(new Person(pn++, 1));
			}
		}
	}
}
