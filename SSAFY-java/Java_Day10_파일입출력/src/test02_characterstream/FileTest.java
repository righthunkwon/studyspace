package test02_characterstream;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		// File : 파일이나 폴더를 관리하기 위한 class
		File f= new File("big_input.txt");
		System.out.println(f.getPath());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getName());
		System.out.println(f.isDirectory());
		System.out.println(f.isFile());
	}
}
