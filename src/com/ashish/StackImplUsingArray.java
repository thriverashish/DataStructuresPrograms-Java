package com.ashish; 

import java.util.InputMismatchException;
import java.util.Scanner;

//Array Implementation of Stack

public class StackImplUsingArray {
	String[] arr = new String[10];
	private int top = -1;
	private Scanner reader = new Scanner(System.in);
	
	private String userInput(){
		System.out.println("Enter the data to be pushed onto stack");
		return reader.next();
		}
	
	public boolean isEmpty() {
		return this.top==-1;
	}
	
	public boolean isFull() {
		return this.top==(arr.length-1);
	}
	
	public void push(String data) {
		if(isFull()){
			System.out.println("Stack is full: Max capacity is 10 elements The Inserted Element is not Pushed");
		}else{
			top++;
			arr[this.top] = data;
			System.out.println("The Element is successfully pushed into stack");
		}
	}// end of push
	
	public void pop(){
		if(isEmpty()){
			System.out.println("Stack is Empty nothing to pop");
		}else{
			top--;
			System.out.println("The Element is Successfully Poped from the Stack");
		}
	}
	
	public void displayTop(){
		System.out.println("The elemnt at the Top of the Stack is :" + arr[this.top]);
	}
	
	public void numberOfElementsInStack() {
		System.out.println("The number of Elements present inside the stack are :" + (this.top+1));
	}
	
	public void execute(){
		char response;		
		do {
			try {
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
			}catch(InputMismatchException e) {
				System.out.println("Please enter the choices/positions as positive Integer, other inputs are not valid");
				System.out.println("Try Again!");
				reader.next();
			}
			System.out.println("\n Do you want to continue (Y/N)");
			response = reader.next().charAt(0);
			if(response !='N' || response !='n' || response !='Y'|| response !='y')
				System.out.println("Exiting Program since Y/y is not entered");
		}while(response == 'Y' || response == 'y');
	}//end of execute

}
