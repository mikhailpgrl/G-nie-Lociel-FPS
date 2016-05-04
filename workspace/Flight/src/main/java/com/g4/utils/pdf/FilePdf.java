package com.g4.utils.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.xmlbeans.impl.util.Base64;

import com.g4.beans.Files;
import com.g4.beans.Leaflet;

public class FilePdf {

	public static int idfile;

	public FilePdf() {
		idfile = 0;
	}

	public static void deletePDF(Leaflet lf) {
		File file = new File(lf.getUrl());
		file.delete();

	}

	public static void savePDF(Leaflet lf, Files f) {

		try {

			byte[] data = Base64.decode(f.getFile().getBytes());
			String path = System.getProperty("user.dir") + "/src/main/webapp/pdf/";
			String pathurl = "localhost:8080/pdf/";
			String pathtemp =  idfile + ".pdf";
			OutputStream stream;
			int i = 0;
			while (true) {
				File file = new File(path + pathtemp);
				if (!file.exists() && !file.isDirectory()) {
					stream = new FileOutputStream(file);
					stream.write(data);
					stream.flush();
					stream.close();
					break;
				} else {
					i++;
					pathtemp =  idfile + "(" + i + ")" + ".pdf";

				}
			}
			lf.setUrl(pathurl + pathtemp);
			idfile++;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
