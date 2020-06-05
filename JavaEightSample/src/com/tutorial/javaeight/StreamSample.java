package com.tutorial.javaeight;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StreamSample {

	public static void main(String[] args) {
		
		List<String> parentList = Arrays.asList(new String[] {"Alex","bertha","catherine","Neo","lisa"});
		
		System.out.println("-------Printing each String in the List--------");
		//using foreach
		parentList.forEach(p-> System.out.println(p.toUpperCase()));
		
		System.out.println("-------Printing names with size less than 5--------");
		//using stream
		parentList.stream().filter(str ->str.length()<5).forEach(str->System.out.println(" "+str));
		
		System.out.println("-------Printing Size of each String in the List--------");
		//print the size of each item in the list.
		Map<Object,Object> nameSizeMap = parentList.stream().collect(Collectors.toMap(str->str.toString(), str->str.length()));
		System.out.println(nameSizeMap);
		//nameSizeMap.forEach(item->System.out.println(item.getKey()+" " + item.getValue));
		
		// multiple filters example
		System.out.println("Display names which begin with A and have a size less than 4");
		
		parentList.stream().filter(str->str.length()<=4 && str.startsWith("A")).forEach(item->System.out.println(item));
		
		
		StringJoiner finalString = new StringJoiner(",");
		
		parentList.forEach(item-> finalString.add(item));
		System.out.println("----------------Final String after String Joiner---------- \n" + finalString);
		
		//checking for null values using Optional.
		String[] checkNullArr = new String[10];
		checkNullArr[9] = "This has data";
		Optional<?> isNull = Optional.ofNullable(parentList);
		
		if(isNull.isPresent()) {
			System.out.println("The list is not Null "+ isNull.map(str->str));
		}else {
			System.out.println("The list is  null");
		}
		
	}
}
