package com.g4.utils.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.xmlbeans.impl.util.Base64;

import com.g4.beans.Files;
import com.g4.beans.Leaflet;

public class SaveFilePdf {

	public static int idfile;
	
	public SaveFilePdf(){
		idfile = 0;
	}
	
	public static void savePDF(Leaflet lf,Files f){

		try {

			byte[] data = Base64.decode(f.getFile().getBytes());
			String path = System.getProperty("user.dir") +"/src/main/webapp/pdf/";
			String pathtemp = path + idfile + ".pdf";
			OutputStream stream;
			int i = 0;
			while (true){
				File file = new File(pathtemp);
				stream = new FileOutputStream(file);
				if (!file.exists() && file.isDirectory()){
					stream.write(data);
					stream.flush();
					stream.close();
					break;
				}else{
					i++;
					pathtemp  = path + idfile + "("+ i +")" + ".pdf";
					
				}
			}
			lf.setUrl(pathtemp);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
