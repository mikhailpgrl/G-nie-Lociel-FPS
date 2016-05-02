package com.g4.utils.excel;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.xmlbeans.impl.util.Base64;

import com.g4.beans.Files;

public class InitializationFile {

	public static void createFile(Files file) throws IOException {
		// TODO Auto-generated method stub
		byte[] data = Base64.decode(file.getFile().getBytes());
		InputStream is = new ByteArrayInputStream(data);
		ReadFile af = new ReadFile(is);
		af.readFile();
	}
}
