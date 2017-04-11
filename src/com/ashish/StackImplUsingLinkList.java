package com.ashish;

import java.util.Scanner;

public class StackImplUsingLinkList {
	private LLNode top;
	private int numberOfElements;
	
	private Scanner reader = new Scanner(System.in);
	
	public StackImplUsingLinkList() {
		this.numberOfElements = 0;
		this.top=null;
	}
			
	public boolean isEmpty(){
		return top == null;
	}
	
	private String userInput(){
		System.out.println("Enter the Data to be entered inside the Stack");
		String data = reader.next();
		return data;
	}
	
	public void displayTop(){
		if(isEmpty()){
			System.out.println("The Stack is Empty : Nothing to Dispay");
		}else {
			System.out.println("The Element/Data at the Top is : " + this.top.data);
		}
	}//end of Display
	
	
	public void push(String data) {
		LLNode node = new LLNode(); // node created
		node.data=data; //data entered
		
		if(isEmpty()){
			top = node;
		}
		else {
			node.next=top;
			top = node;
		}
		numberOfElements++;
		System.out.println("The Element is successfully pushed into Stack : Verify using display Option");
	}
	
	public void pop() {
		
		if(isEmpty()) {
			System.out.println("The Stack is Emty: Nothing to Pop");
		}else {
			this.top = this.top.next;
			numberOfElements--;
			System.out.println("The element is successfully Poped");
		}
	}
	
	public void numberOfElementsInStack(){

		System.out.println("Number Of Elements are : " + this.numberOfElements);
	}
	
	public void execute(){
		char response;		
		do {
			System.out.println("Enter your preference");
			System.out.println("press 1 push elements into Stack");
			System.out.println("press 2 to pop elements from Stack");
			System.out.println("press 3 to display the top element");
			System.out.println("press 4 to know the number of elements in the Stack");
			
			int choice = reader.nextInt();
			
			switch(choice){
				case 1:
					this.push(this.userInput());
					break;
				case 2:
					this.pop();
					break;
				case 3:
					this.displayTop();
					break;
				case 4:
					this.numberOfElementsInStack();
					break;
				default:
					System.out.println("Wrong Choice, Please fill in the appropriate choice");
					
			}
			System.out.println("\n Do you want to continue (Y/N)");
			response = reader.next().charAt(0);
		}while(response == 'Y' || response == 'y');
	}//end of execute
}
