package test03_보조스트림;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test01 {
	public static void main(String[] args) throws IOException {
		// BufferedReader & BufferedWriter가 더빠른지?

		// FileReader & FileWriter
		test1("    FileReader & FileWriter    ");

		// BufferedReader & BufferedWriter
		test2("BufferedReader & BufferedWriter");
	}

	public static void test1(String testname) throws IOException {
		try (FileReader reader = new FileReader("big_input.txt");
				FileWriter writer = new FileWriter("big_input-copy2.txt")) {
			long start = System.nanoTime();
			int c;
			while ((c = reader.read()) != -1) {
				writer.write(c);
			}
			long end = System.nanoTime();
			System.out.printf("%s - %15d ns. \n", testname, end - start);
		}
	}

	// 보조스트림 사용하기
	public static void test2(String testname) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader("big_input.txt"));
				BufferedWriter writer = new BufferedWriter(new FileWriter("big_input-copy3.txt"))) {
			long start = System.nanoTime();
			// buffered reader & writer는 character 하나씩 읽어오는 게 아님!
			String line; // line 단위
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}
			long end = System.nanoTime();
			System.out.printf("%s - %15d ns. \n", testname, end - start);
		}
	}
}
