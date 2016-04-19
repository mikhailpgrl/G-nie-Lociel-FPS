package com.g4.utils.excel;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.util.Base64;

import com.g4.beans.Files;

public class CreateFile {

	public static void createFile(Files file) throws IOException {
		// TODO Auto-generated method stub
		//boolean canWrite = false;
		byte[] data = Base64.decode(file.getFile().getBytes());
		InputStream is = new ByteArrayInputStream(data);
		
		XSSFWorkbook wk = new XSSFWorkbook(is);
		ReadFile af = new ReadFile(is);
		af.readFile1();
		file.print();
//		OutputStream stream;
//		try {
//			int i = 0;
//			String path;
//			if (i==0)
//				path = System.getProperty("user.dir") + "/src/main/resources/files/" + file.getName() + ".xlsx";
//			else
//				path = System.getProperty("user.dir") + "/src/main/resources/files/" + file.getName() +"(" + i +").xlsx";
//			File f = new File(path);
//			stream = new FileOutputStream(path);
//			//if(!f.exists() && f.isDirectory()) { 
//				stream.write(data);		
//				stream.close();	
//				
//			//}
//		
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	
//		try (OutputStream stream = new FileOutputStream("Backlogstest.xlt")) {
//		    stream.write(data);
//		}
	}
}
