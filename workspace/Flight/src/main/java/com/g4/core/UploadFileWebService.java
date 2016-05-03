package com.g4.core;

import java.io.IOException;

import javax.jdo.JDODataStoreException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.g4.beans.Files;
import com.g4.beans.Leaflet;
import com.g4.dao.DAO;
import com.g4.dao.LeafletDao;
import com.g4.utils.excel.InitializationFile;
import com.g4.utils.pdf.FilePdf;


@Path("/cco/upload")
public class UploadFileWebService {
	
	
	private static LeafletDao ld;
	

	public UploadFileWebService() {
		// TODO Auto-generated constructor stub
		ld = DAO.getLeafletDao();
	}
	
	@POST
	@Path("/file")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response uploadFile(Files file) throws IOException {
		
		InitializationFile.createFile(file);
		
		return Response.status(200).entity("ok").build();

	}
	@POST
	@Path("/file-pdf")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response uploadFilePDF(Files file) throws IOException {


		Leaflet leaflet = new Leaflet();
		FilePdf.savePDF(leaflet, file);
		leaflet.setContent(file.getContent());
		String message = ld.putLeaflet(leaflet);
		
		
		return Response.status(200).entity("ok").build();

	}
}
