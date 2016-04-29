package com.g4.utils.excel;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.jdo.JDODataStoreException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.g4.beans.Flight;
import com.g4.dao.DAO;
import com.g4.dao.FlightDao;

public class ReadFile {
	

	private XSSFSheet sheet;
	private FlightDao fd;
	
	private InputStream is;
	
	public ReadFile(InputStream is) {
		// TODO Auto-generated constructor stub
		this.is = is;
		fd = DAO.getFlightDao();
		
	}
	
	public void readFile() {

		boolean commercial_num = false, atc = false, dep_airport = false, arr_airport = false;
		boolean dep_date = false, arr_date = false, dep_time = false, arr_time = false;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(this.is);

			// Get first/desired sheet from the workbook
			this.sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = rowIterator.next().cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				// Check the cell type and format accordingly
				String val = cell.getStringCellValue();
				if (val.equals("Commercial_num")) {
					commercial_num = true;
				} else if (val.equals("ATC")) {
					atc = true;
				} else if (val.equals("Dep_airport")) {
					dep_airport = true;
				} else if (val.equals("Arr_airport")) {
					arr_airport = true;
				} else if (val.equals("Dep_date")) {
					dep_date = true;
				} else if (val.equals("Arr_date")) {
					arr_date = true;
				} else if (val.equals("Dep_time")) {
					dep_time = true;
				} else if (val.equals("Arr_time")) {
					arr_time = true;
				}
			}

			if (commercial_num && atc && dep_airport && arr_airport && dep_date && arr_date && dep_time && arr_time) {

				addFlight();

			}

		} catch (IOException e) {

		}
	}

	public void addFlight() {
		int i = 0;
		Date dep_date, arr_date, dep_time,arr_time;
 		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
 		SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm");
		Iterator<Row> rowIterator = sheet.iterator();
		Flight f; 
		
		 while (rowIterator.hasNext()) 
         {
             Row row = rowIterator.next();
             if (i == 0)
            	 row = rowIterator.next();
             //For each row, iterate through all the columns
             Iterator<Cell> cellIterator = row.cellIterator();
             
             f = new Flight();
             i = 0;
			while (cellIterator.hasNext()) {

				// java.lang.IllegalStateException
				Cell cell = cellIterator.next();
				// Check the cell type and format accordingly
				switch (i) {
				case 0:
					f.setCommercial_number(cell.getStringCellValue());
					break;
				case 1:
					f.setAtc_number(cell.getStringCellValue());
					break;
				case 2:
					f.setDeparture_airport(cell.getStringCellValue());
					break;
				case 3:
					f.setArrival_airport(cell.getStringCellValue());
					break;
				case 4:
					dep_date = cell.getDateCellValue();
					System.out.println(dep_date);
					f.setDeparture_date(formatter.format(dep_date));
					break;
				case 5:
					arr_date = cell.getDateCellValue();
					f.setArrival_date(formatter.format(arr_date));
					break;
				case 6:
					dep_time = cell.getDateCellValue();
					f.setDeparture_time(sdfDate.format(dep_time));
					break;
				case 7:
					arr_time = cell.getDateCellValue();
					f.setArrival_time(sdfDate.format(arr_time));
					break;
				default:
					break;
				}
				i++;
			}
			try {
				fd.putFlight(f);
			} catch (JDODataStoreException e) {
				// TODO: handle exception
				System.out.println("Error already in database");
			}
		}
	}
}
