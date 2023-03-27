import java.util.Date;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

// mongoDB Connection Framework
// 1. https://repo1.maven.org/maven2/org/mongodb/mongo-java-driver/
// 2. 3.9.1 버전 다운로드 후 build path 설정

public class InsertOneTest {
	
	// 연동에 필요한 요소
	// 사전에 mongoDB에 데이터베이스와 컬렉션이 생성되어 있어야 한다.
	// (1) mongoDB의 서버
	private final String URI = "localhost";
	
	// (2) 포트번호
	private final int PORT = 27017;

	// (3) 데이터베이스
	private final String DATABASE = "mydb";

	// (4) 컬렉션
	private final String COLLECTION = "employee";
	
	// DB연결
	MongoClient mongoClient;
	MongoDatabase mydbDatabase;
	MongoCollection<Document> collection;
	
	Scanner scan = new Scanner(System.in);
	
	public InsertOneTest() {
		start();
	}
	
	public void start() {
		// 1개의 document 추가
		try {
			// 1. DB 연결(mongoDB의 기본 포트 : 27017)
			mongoClient = new MongoClient(URI, PORT);
			System.out.println("접속 성공");
			
			// 2. 사용할 데이터베이스 가져오가
			mydbDatabase = mongoClient.getDatabase(DATABASE); 
					
			// 3. 컬렉션 가져오기(bson)
			collection = mydbDatabase.getCollection(COLLECTION);
			
			// 데이터 입력받기
			System.out.print("사원번호: ");
			int empno = Integer.parseInt(scan.nextLine());
			
			System.out.print("사원명: ");
			String ename = scan.nextLine();
			 
			System.out.print("담당업무: ");
			String job = scan.nextLine();
			
			System.out.print("급여: ");
			int sal = Integer.parseInt(scan.nextLine());
			
			System.out.print("부서명: ");
			String dname = scan.nextLine();
			
			// Document 객체를 만들어 collection 객체를 통해 insert 수행
			Document document = new Document();
			document.append("empno", empno);
			document.append("ename", ename);
			document.append("job", job);
			document.append("sal", sal);
			document.append("dname", dname);
			document.append("hiredate", new Date());
			
			collection.insertOne(document);
			
			// DB 연결 해제
			System.out.println("도큐먼트 추가 완료!!!");
			mongoClient.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new InsertOneTest();
	}

}
