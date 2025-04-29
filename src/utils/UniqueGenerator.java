package utils;

import java.util.Random;

import com.github.javafaker.Faker;

public class UniqueGenerator {

	public static String getUniqueString() {
		Faker faker = new Faker();
		return faker.name().firstName();

	}
	
	public static int getRandomNumber() {
		Random r= new Random();
       return r.nextInt(100000);
	}
}
