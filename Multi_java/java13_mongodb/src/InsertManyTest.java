import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertManyTest {
	
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
	
	public InsertManyTest() {
		start();
	}

	public void start() {
		try {
			// 1. DB 연결(mongoDB의 기본 포트 : 27017)
			mongoClient = new MongoClient(URI, PORT);
			System.out.println("접속 성공");
						
			// 2. 사용할 데이터베이스 가져오가
			mydbDatabase = mongoClient.getDatabase(DATABASE); 
							
			// 3. 컬렉션 가져오기(bson)
			collection = mydbDatabase.getCollection(COLLECTION);
			
			// 데이터 가져오기
			// : inserMany는 List에 도큐먼드들을 반복하여 담아서 처리한다.
			
			// 여러 document를 담을 컬렉션
			List<Document> empList = new ArrayList<Document>();
			
			// 사원수 입력
			System.out.print("사원 수: ");
			int count = Integer.parseInt(scan.nextLine());
			
			// 사원 수 만큼 반복문 처리
			for(int i=1; i<=count; i++) {
				Document document = new Document();
				
				System.out.print("사원번호: ");
				document.append("empno", Integer.parseInt(scan.nextLine()));
				
				System.out.print("사원명: ");
				document.append("ename", scan.nextLine());
				
				System.out.print("담당업무: ");
				document.append("job", scan.nextLine());
				
				System.out.print("급여: ");
				document.append("sal", Integer.parseInt(scan.nextLine()));
				
				System.out.print("부서명: ");
				document.append("dname", scan.nextLine());
				
				System.out.print("입사일: ");
				document.append("hiredate", new Date());
				
				empList.add(document);
			}
			
			collection.insertMany(empList);
			
			System.out.println(count + " 개의 도큐먼트 추가 완료!!!");
			mongoClient.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new InsertManyTest();
	}

}
