package com.babailiren.ec.common;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {

	public static boolean isFileExist(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}

	public static void writeFile(String path, String content) throws IOException {
		writeFile(new File(path), content);
	}

	public static void writeFile(File file, String content) throws IOException {
		org.apache.commons.io.FileUtils.writeStringToFile(file, content);
	}

	public static String readFile(String filePath) throws IOException {
		return org.apache.commons.io.FileUtils.readFileToString(new File(filePath));
	}

	public static void createDir(String path) throws Exception {
		File dirFile = new File(path);
		if (!dirFile.exists()) {
			if (!dirFile.mkdirs()) {
				throw new Exception("目录不存在");
			}
		}
	}

	public static String getProjectUrl() {
		String path = FileUtils.class.getResource("/").getPath();
		path = path.substring(0, path.lastIndexOf("/"));
		return path.substring(0, path.lastIndexOf("/") + 1);
	}
	public static void main(String[] args) {
		//System.out.println(getProjectUrl());
	}
	
	/**
	 * @param in 一个输入流
	 * @param fileName 期望保存为的文件名及路径
	 * @return 已保存的文件
	 * @throws IOException
	 */
	public static File save(InputStream in,String fileName) throws IOException{
		File f = new File(fileName);
		return save(in,f);
		
	}


	/**
	 * @param in 一个输入流
	 * @param f 期望保存为的文件
	 * @return 已保存的文件
	 * @throws IOException
	 */
	public static File save(InputStream in,File f) throws IOException{
		mkdir(f);
		OutputStream out = new DataOutputStream(new FileOutputStream(f));		
		byte[] buffer = new byte[8192];
		int count = 0;
		while ((count = in.read(buffer)) > 0) {
			out.write(buffer, 0, count);
		}
		out.close();
		in.close();
		return f;
	}
	
	/**
	 * 为file创建父级目录
	 * @param f
	 */
	public static void mkdir(File f) {
		File parentFile = f.getParentFile();
		if(!parentFile.exists()) {
			parentFile.mkdirs();
		}
	}
}
