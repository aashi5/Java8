package com.tutorial.javaeight.pattern;

import java.util.function.Consumer;

/**
 * Template Method Pattern Java 8 solution.
 * 
 * @author ashwi
 *
 */
public class TemplatePattern {

	public static void main(String[] args) {

		TemplatePattern temp = new TemplatePattern();
		Consumer<Customer> processConsumer= n->System.out.println(n);
		temp.processTemplate("2", processConsumer);

	}
	
	private void processTemplate(String id, Consumer<Customer> processCustomer) {
		Customer c =  getCustomerById(id);
		processCustomer.accept(c);
	}
	
	public Customer getCustomerById(String id){
		return new Customer(id);
	}

}



class Customer{
	
	String id;
	String name;
	public Customer(String id) {
		this.id=id;
		this.name="Aashi";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
}



