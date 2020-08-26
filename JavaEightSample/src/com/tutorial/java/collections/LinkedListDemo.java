package com.tutorial.java.collections;

public class LinkedListDemo {

	public static void main(String ...args) {
		LinkedListImpl linkedList  = new LinkedListImpl();
		linkedList=LinkedListImpl.insert(linkedList, "first");
		linkedList=LinkedListImpl.insert(linkedList, "second");
		linkedList=LinkedListImpl.insert(linkedList, "third");
		
		LinkedListImpl.printList(linkedList);
		
		LinkedListImpl.remove(linkedList, "second");
		
		System.out.println("After removing second");
		LinkedListImpl.printList(linkedList);
		
	}
	
}

/**
 * Implementation of Linked list.
 * @author Ashwini
 *
 */
class LinkedListImpl{
	/**
	 * Pointer to the first node. 
	 */
	Node head;
	
	/**
	 * The inner class node contains the actual data and 
	 * the pointer to the next item in the linked list.
	 * The last node will point to empty or null node.
	 * 
	 * The class is static since it doesnt require
	 *  access to the instance variables or methods of the Linked list class 
	 */
	
	static class Node {
		String val;
		
		Node nextNode;
		
		Node(String val){
			this.val=val;
		}
	}
	
	
	/**
	 * insert an item to the linked list. 
	 * @param list
	 * @param val
	 * @return
	 */
	public static LinkedListImpl insert(LinkedListImpl list,String val) {
		Node newNode = new Node(val);
		newNode.nextNode=null;
		
		//if the linked list is empty add it as head.
		if(list.head==null) {
			list.head=newNode;
		}else {
			
			Node lastNode= list.head;
			// traverse the list to get the last node.		
			while(lastNode.nextNode!=null) {
				lastNode= lastNode.nextNode;
			}
			
			//last node will point to the end of the linked list. 
			lastNode.nextNode=newNode;

		}	
		return list;
	}
	
	public static LinkedListImpl remove(LinkedListImpl list, String val) {
		//if the node to be removed is the first node itself. assign the next node 
		// as the new head.
		boolean nodeFound = false;
		if(val.equals(list.head.val)){
			list.head=list.head.nextNode;
			nodeFound=true;
		}else {
			// traverse through the list to find the val.
			Node currentNode = list.head;
			while(currentNode.nextNode!=null) {
				
				if(val.equals(currentNode.nextNode.val)) {					
					nodeFound=true;
					break;
				}
				currentNode=currentNode.nextNode;
			}
			// to remove a node , remove its pointer from the previous node.
			if(nodeFound)
				currentNode.nextNode=currentNode.nextNode.nextNode;
			
		}
		if(!nodeFound) {
			System.out.println("Node not found");
		}
		return list;
	}
	
	public static void printList(LinkedListImpl list) {
		Node currentNode= list.head;
		while(currentNode!=null) {
			
			System.out.println(currentNode.val);
			currentNode=currentNode.nextNode;
		}
		
	}
}