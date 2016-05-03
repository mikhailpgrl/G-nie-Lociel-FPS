package com.g4.utils.quartz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		String s = "20/03/2016";
		String t = "14:00";
		String sss = "13/03/2016";
		String t1 = "02:00";
		String st = s+ " " + t;
		String st1 = s+ " " + t1;
		String st2 = sss+ " " + t;
		Date d = new Date();
		System.out.println(d);
		System.out.println(s);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		System.out.println(formatter.format(d));
		//Date d1 = formatter.parse(s);
		//System.out.println(formatter.format(d1));
		Date d2 = formatter.parse(st);
		System.out.println(formatter.format(d2));
		System.out.println(formatter.format(d));
		DateTime jodaTime = new DateTime();

		DateTimeFormatter formatter1 = DateTimeFormat.forPattern("YYYY/MM/dd HH:mm");
		System.out.println("jodaTime = " + formatter1.print(jodaTime));

		Date dd = formatter.parse(st);
		DateTime ddd = new DateTime(dd);
		Date dds = formatter.parse(st1);
		Date ddss = formatter.parse(st2);
		DateTime ddds = new DateTime(dd);
		//DateTime jt = DateTime.parse(st, formatter1);
		System.out.println(dd.getTime());
		System.out.println(dds.getTime());
		System.out.println(dd.getTime() - dds.getTime());
		System.out.println(dd.getTime() - ddss.getTime());
		System.out.println(ddd);
	}

}
