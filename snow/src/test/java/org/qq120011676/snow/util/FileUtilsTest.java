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
}
