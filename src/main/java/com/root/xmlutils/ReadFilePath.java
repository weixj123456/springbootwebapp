package com.root.xmlutils;

public class ReadFilePath {
	
	public static void main(String[] args) {
		ReadFilePath.getRootPath();
		ReadFilePath.getXmlfile("7131","CF001018");
	}
        
	private static String getRootPath() {
		String filepath=System.getProperty("user.dir")+"\\";
//		System.out.println(filepath);
		return filepath;
	}
	
	public static String getXmlfile(String channelno,String filename) {
		String file=ReadFilePath.getRootPath()+"XMLfile\\"+channelno+"\\"+filename+".xml";
		System.out.println(file);
		return file;
		
	}
}
