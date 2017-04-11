package com.ashish;


public class LLNode {
	
	public String data;
	public LLNode next;
	
	public LLNode(){
		this.data = null;
		this.next = null;
	}
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public LLNode getNext() {
		return next;
	}
	public void setNext(LLNode next) {
		this.next = next;
	}
	
}
