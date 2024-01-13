package priority_queue_03;

import java.util.Comparator;

// Comparator : 얘와 쟤 비교
public class AgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.age - o2.age;
	}

}
