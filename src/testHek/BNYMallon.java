package testHek;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class BNYMallon {


	public static void main(String[] args) {
		String[] dateArray = { "20th Aug 2018", "02th May 2016", "10th Jan 2015", "30th Mar 2010", "07th Dec 2018",
				"14th Nov 2018", "20th Feb 2011", "20th Aug 2013" };
		List<String>  ListOfdate=listofString(dateArray);
		ListOfdate.stream().forEach(System.out::println);
		

	}
	
	

	private static List<String> listofString(String[] dateArray) {
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-dd-MM" ,Locale.CANADA);
		List<String>  liststr=new ArrayList<>();
		for(int i=0;i<dateArray.length ;i++) {
			String str=dateArray[i].replaceAll("th", "").replaceAll(" ","-");
			Date date=new Date(str );
			System.out.println(date);
			String str1=sd.format(date);
			System.out.println(str1);
			liststr.add(str1);
		}
		return liststr;
	}

	//Expected output 21-05-2018 listof
}
