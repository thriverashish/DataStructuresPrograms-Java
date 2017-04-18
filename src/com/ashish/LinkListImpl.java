package com.ashish;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LinkListImpl {
	
	private LLNode head;
	private LLNode tail;
	private int size;
	
	private Scanner reader = new Scanner(System.in);
	
	public LinkListImpl() {
		this.size = 0;
		head=null;
		this.tail=null;
	}
		
	public int getSize() {
		return size;
	}	
	
	public boolean isEmpty(){
		return head == null;
	}
	
	/**
	 * The method is used to take the input data from user which will be entered in the LL node
	 * @return the user input data
	 */
	private String dataInNode(){
		System.out.println("Enter the Data to be entered inside the node");
		String data = reader.next();
		return data;
	}
	
	/**
	 * To display or print the link list element on console
	 */
	public void display(){
		System.out.println("The contents of Link List are: ");
		if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        } 
		
		if(head.next==null){
			System.out.print(head.data);
			return;
		}
		
		LLNode ptr = head;
		System.out.print(head.data+"->");
		ptr = head.next;
		
		while(ptr.next != null){
			System.out.print(ptr.data+"->");
			ptr = ptr.next;
		}
		System.out.print(ptr.data+ "\n");
	}//end of Display
	
	/**
	 * To add the element with a new node in the link list
	 * @param data : the data to be entered in LL
	 */
	public void addElementAtFirst(String data) {
		LLNode node = new LLNode(); // node created
		node.data=data; //data entered
		
		if(isEmpty()){
			head = node;
			tail=head;
		}
		else {
			node.next=head;
			head = node;
		}
		size++;
		
	}
	
	public void addElementAtLast(String data) {
		LLNode node = new LLNode(); // node created
		node.data=data; //data entered
		
		if(isEmpty()) {
			head = node;
			tail=head;
		}
		else {
			tail.next=node;
			tail=node;
		}
		size++;
	}// end of addElementAtLast
	
	public void addElementAtPosition(String data, int position) {
		if(position > size+1) {
			System.out.println("The number of elements in the link list are only   " + size + " therefore unable to add the element at specified position");
			
			if(size==0){
				System.out.println("Addind your element at first");
				this.addElementAtFirst(data);
			}else{
				System.out.println("Addind your element at last");
				this.addElementAtLast(data);
			}
			size++;
			return;
		}else if(position <= 0){
			System.out.println("Invalid position, please specify positive integer! PLEASE TRY AGAIN");
		}else{
			LLNode node = new LLNode(); // node created
			node.data=data; //data entered
			
			LLNode ptr;
			ptr = head;
			if(position==1){
				node.next = head;
				head = node;
			}else{
			for(int i = 1 ; i<=position-2 ;i++) {
				ptr = ptr.next;
				}
			node.next=ptr.next;
			ptr.next=node;
			}
			size++;
		}
		this.display();
		
	}// end of addElementAtPosition
	
	public void deleteElementAtPosition(int position) {
		LLNode ptr;
		ptr = head;
		if(position > this.size || position<=0){
			System.out.println("Invalid Position");
			System.out.println("The size of the link list is : " + this.size);
		}else if(position==1) {
			
			if(size==1)
			{
				head = null;
				tail=null;
				ptr = null;
			}
			else{
				head = ptr.next;
				ptr =null;
			}	
			size--;
		}
		else if(position==size){
			for(int i = 2 ; i<position ;i++) {
				ptr=ptr.next;
			}// end of for	
			ptr.setNext(ptr.next.next);
			tail=ptr;
			size--;
		}
		else {
			for(int i = 2 ; i<position ;i++) {
				ptr=ptr.next;
				}
			ptr.next = ptr.next.next;
			size--;
			//end of if-else
		}
	}// end of deleteAtPos
	
	//reverse the link list
	public LLNode reverseLL(LLNode llHead) {
		LLNode prev, current, nextref;
		prev = null;
		current = llHead;
		tail= llHead;
		
		while(current != null){
			nextref = current.next;
			current.next = prev;
			prev = current;
			current = nextref;
		}
		head= prev;
		return llHead;
	}
		
		
 	//end of reversal
	public void execute(){
		char response;		
		do {
			try {
				System.out.println("Enter your preference");
				System.out.println("press 1 to add element at first");
				System.out.println("press 2 to add element at last");
				System.out.println("press 3 to add element at position");
				System.out.println("press 4 to delete element from position");
				System.out.println("press 5 to display the contents of Link List");
				System.out.println("press 6 to Reverse the Link List ");
				int choice = reader.nextInt();
				switch(choice){
					case 1:
						addElementAtFirst(dataInNode()); //dataInNode is a function which will take value from the user
						break;
					case 2:
						this.addElementAtLast(dataInNode());
						break;
					case 3:
						int pos;
						System.out.println("Enter the postion");
						pos=reader.nextInt();
						this.addElementAtPosition(this.dataInNode(), pos);
						break;
					case 4:
						System.out.println("Enter the postion");
						pos=reader.nextInt();
						this.deleteElementAtPosition(pos);
						break;
					case 5:
						this.display();
						break;
					case 6:
						this.reverseLL(head);
						break;
					default:
						System.out.println("Wrong Choice, Please fill in the appropriate choice");
				}
				if(choice !=5)
				display();
			}catch(InputMismatchException e) {
				System.out.println("Please enter the choices/positions as positive Integer, other inputs are not valid");
				System.out.println("Try Again!");
				reader.next();
			}
			System.out.println("\nDo you want to continue (Y/N)");
			response = reader.next().charAt(0);
			if(response !='N' || response !='n' || response !='Y'|| response !='y')
				System.out.println("Exiting Program since Y/y is not entered");
		}while(response == 'Y' || response == 'y');
	}//end of execute

}//end of class
