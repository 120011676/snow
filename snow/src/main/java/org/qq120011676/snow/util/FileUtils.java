package org.qq120011676.snow.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.qq120011676.snow.util.file.IFile;

public class FileUtils {

	public static boolean isFileOrFolder(String pathname) {
		return new File(pathname).exists();
	}

	public static boolean createFolder(String pathname) {
		return new File(pathname).mkdirs();
	}

	public static boolean deleteFileOrFolder(String pathname) {
		return new File(pathname).delete();
	}

	public static void fileWriter(String pathname, String fileContent)
			throws IOException {
		FileWriter fileWriter = new FileWriter(new File(pathname), true);
		fileWriter.write(fileContent);
		fileWriter.flush();
		fileWriter.close();
	}

	public static byte[] readerStream(InputStream inputStream)
			throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		int i = -1;
		while ((i = inputStream.read()) != -1) {
			byteArrayOutputStream.write(i);
		}
		inputStream.close();
		byteArrayOutputStream.close();
		return byteArrayOutputStream.toByteArray();
	}

	public static String readerString(InputStream inputStream)
			throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		StringBuilder stringBuilder = new StringBuilder();
		String tempString;
		while ((tempString = bufferedReader.readLine()) != null) {
			stringBuilder.append(tempString);
		}
		bufferedReader.close();
		return stringBuilder.toString();
	}

	public static String readerString(InputStream inputStream, String charset)
			throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream, charset));
		StringBuilder stringBuilder = new StringBuilder();
		String tempString;
		while ((tempString = bufferedReader.readLine()) != null) {
			stringBuilder.append(tempString);
		}
		bufferedReader.close();
		return stringBuilder.toString();
	}

	public static String fileReader(String pathname) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = getBufferedReader(pathname);
		String tempString;
		while ((tempString = bufferedReader.readLine()) != null) {
			stringBuilder.append(tempString);
		}
		bufferedReader.close();
		return stringBuilder.toString();
	}

	public static void fileReader(String pathname, IFile file)
			throws IOException {
		BufferedReader bufferedReader = getBufferedReader(pathname);
		String tempString;
		while ((tempString = bufferedReader.readLine()) != null) {
			file.readLine(tempString);
		}
		bufferedReader.close();
	}

	public static void fileReader(String pathname, String charset, IFile file)
			throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(pathname)),
						charset));
		String tempString;
		while ((tempString = bufferedReader.readLine()) != null) {
			file.readLine(tempString);
		}
		bufferedReader.close();
	}

	private static BufferedReader getBufferedReader(String pathname)
			throws FileNotFoundException {
		return new BufferedReader(new FileReader(new File(pathname)));
	}

	public static Map<String, String> filePropertiesReader(String filePath) {
		ResourceBundle bundle = ResourceBundle.getBundle(filePath);
		Enumeration<String> enumeration = bundle.getKeys();
		Map<String, String> map = new HashMap<String, String>();
		while (enumeration.hasMoreElements()) {
			String key = (String) enumeration.nextElement();
			String value = bundle.getString(key);
			map.put(key, value);
		}
		return map;
	}

	public static void fileBufferedWriter(String pathname, String charset,
			String fileContent) throws IOException {
		Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File(pathname), true), charset));
		writer.write(fileContent);
		writer.flush();
		writer.close();
	}

	public static char[] fileBufferedRead(String pathname, String charset)
			throws IOException {
		File file = new File(pathname);
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(file), charset));
		char[] chars = new char[(int) file.length()];
		bufferedReader.read(chars);
		bufferedReader.close();
		return chars;
	}

	public static void fileStreamWrite(String pathname, byte[] bytes)
			throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(new File(
				pathname), true);
		fileOutputStream.write(bytes);
		fileOutputStream.flush();
		fileOutputStream.close();
	}

	public static void fileStreamWrite(String pathname, InputStream inputStream)
			throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(new File(
				pathname));
		int i = -1;
		while ((i = inputStream.read()) != -1) {
			fileOutputStream.write(i);
		}
		fileOutputStream.flush();
		inputStream.close();
		fileOutputStream.close();
	}

	public static byte[] fileStreamRead(String pathname) throws IOException {
		File file = new File(pathname);
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] bytes = new byte[(int) file.length()];
		fileInputStream.read(bytes);
		fileInputStream.close();
		return bytes;
	}

}
