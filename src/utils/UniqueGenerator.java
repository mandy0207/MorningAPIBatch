package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.github.javafaker.Faker;

public class UniqueGenerator {

	public static Faker getFaker() {
		Faker faker = new Faker();
		return faker;

	}
	
	public static String getUniqueString() {
	    SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
	    return "Ingrid" + ft.format(new Date()).replaceAll("[:/\\s]", "");
	}

	
	public static int getRandomNumber() {
		Random r= new Random();
       return r.nextInt(100000);
	}
}
