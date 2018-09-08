package com.lris.ain.blog.ainblog.init;

import java.io.File;

import com.lris.ain.blog.ainblog.utils.FileUtils;

public class ReadTextToDb {

	public static void main(String[] args) {
		String filepath = "F:\\lris-test\\";
		 File f = new File(filepath);
		 //FileUtils.readFileFilter(f, ".txt");
		 System.out.println("--");
		 if(f.isDirectory()) {
			 for(File file:FileUtils.readFileFilter(f, ".txt")) {
				 if(!file.isDirectory()) {
					 System.out.println("-----------");
					 System.out.println(file.getName());
					 System.out.println(FileUtils.readFileToString(file));
					 System.out.println("-----------");
				 }else {
					 
				 }
			 }
		 }
	}
}
