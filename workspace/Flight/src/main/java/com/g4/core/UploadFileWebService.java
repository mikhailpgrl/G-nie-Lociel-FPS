package com.g4.core;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.g4.beans.Files;
import com.g4.utils.excel.CreateFile;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;


@Path("/cco/upload")
public class UploadFileWebService {

	@POST
	@Path("/file")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response uploadFile(Files file) {

		//String uploadedFileLocation = System.getProperty("user.dir") +"/Excel/" + fileDetail.getFileName();

		// save it
		//writeToFile(uploadedInputStream, uploadedFileLocation);

		//String output = "File uploaded to : " + uploadedFileLocation;
		
		CreateFile.createFile(file);
		
		return Response.status(200).entity("ok").build();

	}

	//	// save uploaded file to new location
	//	private void writeToFile(InputStream uploadedInputStream,
	//		String uploadedFileLocation) {
	//
	//		try {
	//			OutputStream out = new FileOutputStream(new File(
	//					uploadedFileLocation));
	//			int read = 0;
	//			byte[] bytes = new byte[1024];
	//
	//			out = new FileOutputStream(new File(uploadedFileLocation));
	//			while ((read = uploadedInputStream.read(bytes)) != -1) {
	//				out.write(bytes, 0, read);
	//			}
	//			out.flush();
	//			out.close();
	//		} catch (IOException e) {
	//
	//			e.printStackTrace();
	//		}
	//
	//	}
	//	
}
