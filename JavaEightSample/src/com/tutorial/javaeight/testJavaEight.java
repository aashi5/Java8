package com.tutorial.javaeight;

import java.util.Scanner;

public class testJavaEight {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		System.out.println("Hello, What is your name");

		System.out.println("Hello, "+	scanner.next());
		scanner.close();
	}
}
