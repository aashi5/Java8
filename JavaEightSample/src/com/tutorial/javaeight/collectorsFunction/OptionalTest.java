package com.tutorial.javaeight.collectorsFunction;

import java.util.Optional;

public class OptionalTest {

	
	public static void main(String[] args) {
		
		Insurance insurance = new Insurance("Geiko");
		Car c = new Car(Optional.ofNullable(insurance));
		Person p = new Person(Optional.ofNullable(c));
		
		OptionalTest optTest = new OptionalTest();
		optTest.usingFlatMap(Optional.ofNullable(p));
		
		p.setAge(25);
		optTest.usingFilter(Optional.ofNullable(p));
		
		optTest.printValidInsurance(Optional.ofNullable(p), 21);
	}
	
	/**
	 * Print the insurance company name
	 * @param p
	 */
	private void usingFlatMap(Optional<Person> p) {
		String geikoinsurance= 
				p.flatMap(Person::getCar)
				.flatMap(Car::getInsurance)
				.map(Insurance::getName)
				.orElse("Unknown");
		System.out.println("Insurance company name " +geikoinsurance);
	}
	
	
	private void usingFilter(Optional<Person> p) {
		Optional<Insurance> insu= p.flatMap(Person::getCar).flatMap(Car::getInsurance);
		insu.filter(insurance->"Cambridge".equals(insurance.getName()))
			.ifPresent(x->System.out.println("Insurnance is Cambridge"));
	}
	
	
	private void printValidInsurance(Optional<Person> p, int minAge) {
		
		p.filter(person->person.getAge().orElse(21)>minAge).flatMap(Person::getCar).flatMap(Car::getInsurance)
		.map(Insurance::getName).ifPresent(x->System.out.println(x));
	}
}



class Person{
	
	Optional<Integer> age;
	Optional<Car> car;
	
	Person(Optional<Car> car){
		this.car=car;
	}
	
	public Optional<Car> getCar() {
		return this.car;
	}
	
	public void setAge(int age) {
		this.age=Optional.ofNullable(age);
	}
	
	
	public Optional<Integer> getAge() {
		return this.age;
	}
}

class Car {
	Optional<Insurance> insurance;
	
	Car(Optional<Insurance> insurance){
		this.insurance=insurance;
	}
	
	public Optional<Insurance> getInsurance() {
		return this.insurance;
	}
}

class Insurance {
	String name;

	Insurance(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}