package com.tutorial.javaeight;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Scanner;

/**
 * 
 * @author Ashwini
 *
 */
public class JavaDateTest {

	public static void main(String[] args) {
		
		JavaDateTest dateCheck = new JavaDateTest();
		//dateCheck.localDateCheck();
		//dateCheck.instantCheck();
		//dateCheck.durationCheck();
		System.out.println("What is your name");
		//Scanner input = new Scanner(System.in);
		//System.out.println(input);
	}
	
	
	public void localDateCheck() {
		LocalDate localDate = LocalDate.of(2020, 05, 18);
		System.out.println(LocalDate.now());
		System.out.println(localDate.getDayOfWeek());
		System.out.println(localDate.get(ChronoField.MONTH_OF_YEAR));
		
		LocalTime localTime = LocalTime.of(12, 33,2);
		System.out.println(localTime.getHour()+":"+ localTime.get(ChronoField.MINUTE_OF_HOUR));
		//using parse method
		localDate= LocalDate.parse("2000-01-01");
		System.out.println(localDate.getYear());
		
		
		LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
		System.out.println(localDateTime);
		
	}
	
	public void instantCheck() {
		System.out.println(Instant.ofEpochSecond(3));
	}
	
	public void durationCheck() {
		// to know the difference between 2 localtime, LocalDatetime or instant of objects. 
		Duration duration = Duration.between(LocalTime.now(), LocalTime.of(8, 30));
		System.out.println(duration);
		
		// to compute the difference in terms of days use Period.
		
	}
}
