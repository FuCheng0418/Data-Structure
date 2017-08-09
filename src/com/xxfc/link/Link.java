package com.xxfc.link;

public class Link<T> {
	Node<T> head=null;
	Node<T> tail=null;
	public Link(){
	}
	
	public void append(T data){
		Node<T> node=new Node<T>(data);
		if (head==null){
			head=node;
			tail=node;
		}else{
			tail.setNextNode(node);
			tail=node;
		}
	}
	
	public void replaceHead(T data){
		Node<T> node=new Node<T>(data);
		node.setNextNode(head);
		this.head=node;
	}
	
	public void insert(int idx,T data){
		int count=0;
		Node<T> onFocuse=head;
		while(count<idx){
			onFocuse=onFocuse.getNextNode();
			count++;
		}
		if (onFocuse==null){
			replaceHead(data);
		}else{
		
		
		Node<T> node=new Node<T>(data);
		if (	onFocuse.getNextNode()==null){
			this.tail=node;
		}else{
			node.setNextNode(onFocuse.getNextNode());
		}
		onFocuse.setNextNode(node);
		}	
	}
	
	public void delete(int idx){
		if (0==idx){
			Node<T> newHead=head.getNextNode();
			head=null;
			head=newHead;
		}else{
			int count=1;
			Node<T> before=head;
			Node<T> onFocuse=before.getNextNode();
			while(count<idx){
				before=onFocuse;
				onFocuse=onFocuse.getNextNode();
				count++;
			}
				if(tail==onFocuse){
					tail=before;
				}
				before.setNextNode(onFocuse.getNextNode());
				onFocuse=null;
				
		}
		
			
	}
	
	public static void main(String[] args){
		
		Link<String> link=new Link<String>();
		link.append("2");
		link.append("3");
		link.append("5");
		link.print();
		
		link.replaceHead("1");
		link.append("6");
		link.print();
		
		link.insert(2,"4");
		link.insert(3,"4.1");
		link.print();
		
		
		link.delete(4);
		link.print();
		
	}
	
	public void print( ){
		Node<T> onFocuse=this.head;
		do{
			System.out.println(onFocuse.getData());
			onFocuse=onFocuse.getNextNode();
		}while(onFocuse !=null);
		System.out.println("----------------");
	}
}
