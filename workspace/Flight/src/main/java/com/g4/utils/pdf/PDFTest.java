package com.g4.utils.pdf;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.util.Base64;

public class PDFTest {

	public static final String path = "D:\\Bureau\\javafx_1.pdf";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File(path);
		byte[] base64 = Base64.encode(FileUtils.readFileToByteArray(file));
		

//		Path path = Paths.get("D:\\Bureau\\javafx_1.pdf");
//
//		byte[] base64 = Base64.encode(FileUtils.readFileToByteArray(file));

//		byte[] data = Base64.encode(Files.readAllBytes(path));
		
		System.out.println(new String(base64));

		File file2 = new File("D:\\Bureau\\javafxtest.pdf");
//		byte[] data = Base64.decode(file.getFile().getBytes());
		
		String s = new String(base64);
		byte[] data = Base64.decode(s.getBytes());
		
		FileOutputStream stream = new FileOutputStream(file2);
			stream.write(data);
			stream.flush();
			stream.close();

		
			file2.delete();
		
	}

}
