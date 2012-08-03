package org.qq120011676.snow.util;

import org.junit.Test;

public class FileUtilsTest {

	@Test
	public void test() {
		FileUtils.createFolder("G:\\a\\a\\cc\\c.txt");
		System.out.println(FileUtils.isFileOrFolder("G:\\a\\a\\cc\\c.txt"));
	}
	
	@Test
	public void testDelete(){
		FileUtils.deleteFileOrFolder("G:\\a\\");
	}
	
	@Test
	public void is(){
		System.out.println(FileUtils.isFileOrFolder("e:\\gits"));
	}
	
	@Test
	public void in(){
		String pageTagFileAddr="e:\\gits\\a.txt";
		System.out.println(pageTagFileAddr.substring(0, pageTagFileAddr
				.lastIndexOf("\\")));
		if (FileUtils.isFileOrFolder(pageTagFileAddr.substring(pageTagFileAddr
				.lastIndexOf("\\")))) {
			FileUtils.createFolder(pageTagFileAddr.substring(pageTagFileAddr
					.lastIndexOf("\\")));
		}
	}
}
