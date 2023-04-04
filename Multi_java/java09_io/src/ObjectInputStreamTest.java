import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Vector;

public class ObjectInputStreamTest {

	public ObjectInputStreamTest() {
		try {
			// ObjectInputStream : 객체 읽기를 할 수 있는 클래스
			File f = new File("c://java_test", "object.txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			VectorTest vt = (VectorTest)ois.readObject(); // 상위 클래스인 Object를 하위 클래스인 VectorTest에 바로 넣을 수 없기에 강제로 이를 변환 
			System.out.println("vt.msg-->"+vt.msg);
			
			Vector v = vt.getData();
			MemberDTO dto = (MemberDTO)v.get(3);
			System.out.println(dto.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ObjectInputStreamTest();
	}

}
