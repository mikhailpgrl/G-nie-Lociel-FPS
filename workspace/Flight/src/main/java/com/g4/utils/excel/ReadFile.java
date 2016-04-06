package com.g4.utils.excel;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFile {
	
	private String folderInput;
	private Sheet worksheet;
	private int column_commecial_num, column_atc, column_dep_airport, column_arr_airport;
	private int column_dep_date, column_arr_date, column_dep_time, column_arr_time;
	
	
	public ReadFile(String folderInput) {
		// TODO Auto-generated constructor stub
		
		this.folderInput = folderInput;
		
	}
	
	public void readFile(){

		byte[] result;
		boolean commercial_num = false, atc = false, dep_airport = false, arr_airport = false;
		boolean dep_date = false, arr_date = false , dep_time = false , arr_time = false;
		try {
			int i = 0;
			result = Files.readAllBytes(Paths.get(folderInput));
			InputStream is = new ByteArrayInputStream(result);
			Workbook book = WorkbookFactory.create(is);
			worksheet = book.getSheetAt(0);
			Sheet worksheet = book.getSheetAt(0);
			Row row = worksheet.getRow(0);
			while ((!commercial_num || !atc || !dep_airport || !arr_airport || !dep_date ||
					!arr_date || !dep_time || !arr_time) && i < 10) {
				Cell cell = row.getCell((short) i);
				String val = cell.getStringCellValue();
				if (val.equals("Commercial_num")) {
					column_commecial_num = i;
					commercial_num = true;
				}else if (val.equals("ATC")) {
					column_atc = i;
					atc = true;
				}else if (val.equals("Dep_airport")) {
					column_dep_airport = i;
					dep_airport = true;
				}else if (val.equals("Arr_airport")) {
					column_arr_airport = i;
					arr_airport = true;
				}else if (val.equals("Dep_date")) {
					column_dep_date= i;
					dep_date = true;
				}else if (val.equals("Arr_date")) {
					column_arr_date = i;
					arr_date = true;
				}else if (val.equals("Dep_time")) {
					column_dep_time = i;
					dep_time = true;
				}else if (val.equals("Arr_time")) {
					column_arr_time = i;
					arr_time = true;
				}
				i++;
			}
			if(commercial_num && atc && dep_airport && arr_airport && dep_date &&
					arr_date && dep_time && arr_time){
				
				addFlight();

			}
		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addFlight() {
		// TODO Auto-generated method stub
		Cell c1,c2,c3,c4,c5,c6,c7,c8;
		
		/*for (int i = 1; i < worksheet.getLastRowNum() - 1; i++) {
			c1 = worksheet.getRow(i).getCell(titresession,
					Row.CREATE_NULL_AS_BLANK);
			c2 = worksheet.getRow(i).getCell(theme,
					Row.CREATE_NULL_AS_BLANK);
			c3 = worksheet.getRow(i).getCell(idprog,
					Row.CREATE_NULL_AS_BLANK);
			c4 = worksheet.getRow(i).getCell(nom,
					Row.CREATE_NULL_AS_BLANK);
			c5 = worksheet.getRow(i).getCell(prenom,
					Row.CREATE_NULL_AS_BLANK);
			c6 = worksheet.getRow(i).getCell(fonction,
					Row.CREATE_NULL_AS_BLANK);
			c7 = worksheet.getRow(i).getCell(salle,
					Row.CREATE_NULL_AS_BLANK);
			c8 = worksheet.getRow(i).getCell(horaire,
					Row.CREATE_NULL_AS_BLANK);
			*/
	}

}
