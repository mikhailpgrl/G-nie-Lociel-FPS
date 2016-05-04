package com.g4.utils.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.xmlbeans.impl.util.Base64;

import com.g4.beans.Files;
import com.g4.beans.Flight;
import com.g4.beans.Leaflet;

public class FileOFP {

	public static int idfile;

	public FileOFP() {
		idfile = 0;
	}
	
	public static void deletePDF(Flight f) {
		File file = new File(f.getOfp());
		file.delete();

	}
	public static void saveOFP(Flight flight, Files f) {

		try {

			byte[] data = Base64.decode(f.getFile().getBytes());
			String path = System.getProperty("user.dir") + "/src/main/webapp/ofp/";
			String pathurl = "localhost:8080/ofp/";
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
			flight.setOfp(pathurl + pathtemp);
			idfile++;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
