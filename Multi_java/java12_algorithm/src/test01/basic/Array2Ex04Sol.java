package test01.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Array2Ex04Sol {
	// 멤버변수
	// 학생 이름
	static String stdName[];
	
	// 개인별 각 과목점수, 과목별총점, 과목별평균, 개인총점, 개인평균
	static int stdScore[][];
	
	static int stdCount; // 학생 수
	static int subjectCount; // 과목 수
	
	public Array2Ex04Sol() {
		
	}

	// 이름과 점수를 배열에 저장(기본값 세팅)
	public static void setData() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("src/test01/basic/sungjuk.txt")));
		
		// 학생 수 읽어오기
		stdCount = Integer.parseInt(br.readLine());
		subjectCount = Integer.parseInt(br.readLine());
		
		// 학생 이름과 점수를 2차원 배열에 세팅(기본 데이터)
		stdName = new String[stdCount];
		stdScore = new int[stdCount+2][subjectCount+3]; // 12행 6열인 2차원 배열 생성
		
		for(int i=0; i<stdCount; i++) { // i=0,1,2,3, ..., 9
			String[] line = br.readLine().split(","); // "블랙핑크,85,92,25" , split으로 쪼갠 뒤에는 배열이므로 배열로 선언
			stdName[i] = line[0]; // i를 stdName에 index로 사용
			
			// 점수
			for(int j=0; j<subjectCount; j++) { 
				stdScore[i][j] = Integer.parseInt(line[j+1]);
			}
		}
	}
	
	// 성적 처리(과목별총점, 과목별평균, 개인총점, 개인평균, 석차) 
	static void scoreProcess() {
		for(int r=0; r<stdCount; r++) {
			for(int c=0; c<subjectCount; c++) {
				stdScore[r][subjectCount] += stdScore[r][c]; // 개인별 총점
				stdScore[stdCount][c] += stdScore[r][c];
			}
			stdScore[r][subjectCount+1] = stdScore[r][subjectCount]/subjectCount; // 개인별 평균
		}
		
		for(int c=0; c<subjectCount; c++) {
			stdScore[stdCount+1][c] = stdScore[stdCount][c] / stdCount; // 과목별 평균
		}
		scoreRank();
	}
	
	// 출력
	static void scorePrint() {
		for(int r=0; r<stdScore.length; r++) { // r=0,1,2, ... ,10,11
			if(r<stdCount) {
				System.out.printf("%-8s\t", stdName[r]); // 학생이름(1차원 배열)
			}
			if(r==stdCount) {
				System.out.printf("%-8s\t", "과목별총점"); 
			}
			if(r==stdCount+1) {
				System.out.printf("%-8s\t", "과목별평균"); 
			}
			// 점수(2차원 배열)
			for(int c=0; c<stdScore[r].length; c++) { // c=0,1,2, ... ,5
				System.out.printf("%5d", stdScore[r][c]);
			}
			System.out.println();
		}
	}
	
	// 석차
	static void scoreRank() {
		for(int p=0; p<stdCount; p++) { // 0,1,2, ... stdCount
			// 내 점수: p 위치의 값
			// 나보다 높은 사람의 점수의 수를 구한다.
			for (int r=0; r<stdCount; r++) {
				if(stdScore[p][subjectCount] < stdScore[r][subjectCount]) { // 내 점수 < 상대 점수
					stdScore[p][subjectCount+2]++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		try {
			setData(); // 점수 설정(기본 값 세팅)
			scoreProcess(); // 성적 처리
			scorePrint(); // 출력
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}

	/*
			Integer.parseInt() 	: 문자열을 숫자로, 기본 데이터 타입인 int 리턴
			Integer.valueOf() 	: 문자열을 숫자로, Integer Object 리턴
			
			Integer.toString()	: 숫자를 문자열로
			String.valueOf()	: 숫자를 문자열로
			int +""				: 숫자를 문자열로
	*/


