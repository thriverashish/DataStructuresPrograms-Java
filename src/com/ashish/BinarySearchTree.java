package com.ashish;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree {
	
   	private TreeNode root;
	
   	private Scanner reader = new Scanner(System.in);
   	
	public BinarySearchTree() {
		this.root = null;
	}
	
	private TreeNode getNewNode(int data) {
		TreeNode newNode = new TreeNode();
		newNode.data = data;
		newNode.left = null;
		newNode.right = null;
		return newNode;
	}
	
	private int dataInNode(){
		System.out.println("Enter the Data to be entered inside the node");
		reader.nextLine(); // this line is added because without this line the data variable present in next line was taking empty line as input which was given after choosing preferences option
		int data = reader.nextInt();
		System.out.println("DATA " + data);
		return data;
	}
	
	private TreeNode addNode(TreeNode root, int data) {
		TreeNode newNode = this.getNewNode(data);
		TreeNode tempNode = null;
		if(root == null) {
			root= newNode;
		}
		else if(data < root.data) {
			root.left= this.addNode(root.left, data);
		}
		else if(data > root.data) {
			root.right= this.addNode(root.right, data);
		}
		return root;
	}// end of addNode
	
	private TreeNode deleteNode(TreeNode root, int data) {
		
		if(root == null) {
			return null;
		}
		else if(data < root.data) {
			root.left = deleteNode(root.left, data);
		}
		else if(data > root.data) {
			root.right = deleteNode(root.right, data);
		}else {
			//no child
			if(root.left==null && root.right==null) {
				root=null;
			}
			//one child
			else if(root.left==null) {
				root = root.right;
			}
			else if(root.right==null) {
				root = root.left;
			}
			//two children
			else {
				TreeNode temp = findMinNode(root.right);
				root.data = temp.data;
				root.right = deleteNode(root.right, temp.data);
			}
		}
		return root;
	}
	
	private TreeNode findMinNode(TreeNode root) {
		if(root == null) {
			System.out.println("Empty Tree");
			return null;
		}
		
		TreeNode current = root;
		
		while(current.left != null) {
			current = current.left;
		}
		return current;
	}
	
	
	private int findMin(TreeNode root) {
		
		if(root == null) {
			System.out.println("Empty Tree");
			return -1;
		}
		
		TreeNode current = root;
		
		while(current.left != null) {
			current = current.left;
		}
		return current.data;
	}// end of findMin
	
private int findMax(TreeNode root) {
		
		if(root == null) {
			System.out.println("Empty Tree");
			return -1;
		}
		
		TreeNode current = root;
		
		while(current.right != null) {
			current = current.right;
		}
		return current.data;
	}// end of findMax
	

	private void levelOrderTraversal(TreeNode root) {
		TreeNode current;
		if(root == null){
			System.out.println("Tree is empty");
			return;
		}else {
			Queue<TreeNode> que = new LinkedList<TreeNode>();
			que.add(root);
				while(!que.isEmpty()) {
					current = que.poll();
					System.out.print(current.data +" ");
					if(current.left != null)
						que.add(current.left);
					if(current.right != null)
						que.add(current.right);
				}
		}
	}//end of levelorderTraversal

	private void display() {
		
	}// end of display
	
	
	public void execute(){
		char response;		
		do {
			try {
				System.out.println("Enter your preference");
				System.out.println("press 1 to add an element into BST");
				System.out.println("press 2 to delete an element from BST");
				System.out.println("press 3 for Level Order Traversal of BST");
				System.out.println("press 4 for Inorder Traversal of BST");
				System.out.println("press 5 for Preorder Traversal");
				System.out.println("press 6 for Post Order Traversal");
				System.out.println("press 7 to Find Min Element in BST");
				System.out.println("press 8 to Find Max Element in BST");
				System.out.println("press 9 to Find Height of BST");
				System.out.println("press 10 Display the Elements of BST");

				int choice = reader.nextInt();
				switch(choice){
					case 1:
						this.root=addNode(this.root, dataInNode()); //dataInNode is a function which will take value from the user
						break;
					case 2:
						System.out.println("Enter Data to be deleted");
						int data = reader.nextInt();
						this.deleteNode(this.root, data);
						break;
					case 3:
						this.levelOrderTraversal(this.root);
						break;
					case 4:

						break;
					case 5:
						
						break;
					case 6:
						
						break;
					case 7:
						
						break;
					case 8:
						
						break;	
					case 9:
						
						break;
					case 10:
						
						break;	
					default:
						System.out.println("Wrong Choice, Please fill in the appropriate choice");
				}
				if(choice !=10)
				display();
			}catch(InputMismatchException e) {
				System.out.println("Please enter the choices/positions as positive Integer, other inputs are not valid");
				System.out.println("Try Again!");
				reader.next(); // this line is added because of concept of java- In case of exception input mismatch, the mismatched value should be consumed 
			}
			System.out.println("\nDo you want to continue (Y/N)");
			response = reader.next().charAt(0);
			if(response !='Y'|| response !='y')
				System.out.println("Exiting Program since Y/y is not entered");
		}while(response == 'Y' || response == 'y');
	}//end of execute
	
}// end of class
