package com.g4.utils.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;

import com.g4.beans.Files;

public class CreateFile {

	public static void createFile(Files file) {
		// TODO Auto-generated method stub
		byte[] data = Base64.decodeBase64(file.getFile().getBytes());
		OutputStream stream;
		try {
			int i = 0;
			String path;
			while(true){
				if (i==0)
					path = System.getProperty("user.dir") + "/src/main/resources/files/" + file.getName() + ".xlt";
				else
					path = System.getProperty("user.dir") + "/src/main/resources/files/" + file.getName() +"(" + i +").xlt";
				File f = new File(path);
				if(!f.exists() && f.isDirectory()) { 
				    // do something
					stream = new FileOutputStream(path);
					stream.write(data);			
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
//		try (OutputStream stream = new FileOutputStream("Backlogstest.xlt")) {
//		    stream.write(data);
//		}

}
