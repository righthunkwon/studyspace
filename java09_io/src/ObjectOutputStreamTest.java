
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputStreamTest {

	public ObjectOutputStreamTest() {
		try {
			// ObjectOutputStream : 객체를 쓰기 할 수 있는 클래스
			File f = new File("c://java_test", "object,txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			// 파일로 쓰기 할 객체는 직렬화가 필요하다. (public class VectorTest implements Serializable)
			VectorTest vt = new VectorTest();
			vt.msg = "ObjectOutputStream을 이용한 객체 파일로 기록하기"; 
			oos.writeObject(vt);
			
			oos.close();
			fos.close();
			System.out.println("객체 쓰기가 완료되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new ObjectOutputStreamTest();
	}

}
