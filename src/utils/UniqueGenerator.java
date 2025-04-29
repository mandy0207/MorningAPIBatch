package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.github.javafaker.Faker;

public class UniqueGenerator {

	public static Faker getFaker() {
		Faker faker = new Faker();
		return faker;

	}
	
	public static String getUniqueString() {
		return "client"+getCurrentDateTime();
	}
	
	public static String getCurrentDateTime() {
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());  
		  return date.replaceAll("[^0-9]", "");
	    
	}

	
	public static int getRandomNumber() {
		Random r= new Random();
       return r.nextInt(100000);
	}
}
