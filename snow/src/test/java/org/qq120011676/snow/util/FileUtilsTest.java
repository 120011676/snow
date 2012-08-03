package org.qq120011676.snow.util;

import org.junit.Test;

public class FileUtilsTest {

	@Test
	public void test() {
		FileUtils.createFolder("G:\\a\\a\\cc\\c.txt");
		System.out.println(FileUtils.isFileOrFolder("G:\\a\\a\\cc\\c.txt"));
	}

	@Test
	public void testDelete() {
		FileUtils.deleteFileOrFolder("G:\\a\\");
	}

	@Test
	public void is() {
		System.out.println(FileUtils.isFileOrFolder("e:\\gits"));
	}

	@Test
	public void in() {
		String pageTagFileAddr = "E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\AutoShowManager\\WEB-INF\\classes\\resources\\pageTag.ftl";
		pageTagFileAddr = pageTagFileAddr.substring(0,
				pageTagFileAddr.lastIndexOf("\\") + 1);
		System.out.println(pageTagFileAddr);
		System.out.println(FileUtils.isFileOrFolder(pageTagFileAddr));
		if (!FileUtils.isFileOrFolder(pageTagFileAddr)) {
			FileUtils.createFolder(pageTagFileAddr);
		}
	}
}
