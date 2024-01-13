package test02_characterstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CharacterStreamTest02 {
	public static void main(String[] args) {
		// 문자 입출력(Reader/Writer)
		try (Reader reader = new FileReader("big_input.txt"); 
				Writer writer = new FileWriter("big_input-copy.txt");) {
			
			// 배열
			int input;
			while ((input = reader.read()) != -1) {
				writer.write(input);
			}
			
		} catch (IOException io) {
			io.printStackTrace();
		}
		System.out.println("끝");
	}
}
