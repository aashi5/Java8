package com.tutorial.javaeight.patterns;

public class SingletonPatternDemo {
	
	public static void main(String...strings) {
	
	SingletonItem item = SingletonItem.getInstance();
	System.out.println(item.getMessage());
	}
	
}


class SingletonItem{
	
	private String message="THis is a singleton ";
	
	
	public String getMessage() {
		return message;
	}

	/**
	 * Only instance of singletonItem.
	 */
	private static SingletonItem item;
	
	private SingletonItem() {
		
	}
	
	
	/**
	 * only way of creating an instance of Singleton item .
	 * for a thread safe version of this class 
	 * make the getInstance method synchronized
	 * 
	 * @return
	 */
	public static SingletonItem getInstance() {
		if(item==null) {
			item=new SingletonItem();
		}
		return item;
	}
	
	
	/**
	 * enhanced thread safe getInstance method.
	 * That locks only the instantiation block 
	 * @return
	 */
	//
	public static SingletonItem getThreadSafeInstance() {
		if(item==null) {
		synchronized (SingletonItem.class) {
			if(item==null) {
				item= new SingletonItem();
			}
		}
		
		}
		return item;
	}
}
