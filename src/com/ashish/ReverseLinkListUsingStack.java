package com.ashish;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

import com.ashish.LLNode;

public class ReverseLinkListUsingStack {
	Stack<LLNode> myStack = new Stack<LLNode>();
	
	public LLNode reverse(LLNode head) {
		LLNode temp = head;
		
		while(temp!=null) {
			myStack.push(temp);
			temp = temp.next;
		}
		
		head = myStack.peek();
		myStack.pop();
		temp=head;
		while(!myStack.isEmpty()) {
			temp.next= myStack.peek();
			myStack.pop();	
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}
	
}
