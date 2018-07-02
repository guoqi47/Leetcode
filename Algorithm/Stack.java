package algorithm;

import java.util.Iterator;
import java.util.Scanner;

public class Stack<Item> implements Iterable<Item> {
	
	private Node first; //top of the stack
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {return first==null;}
	public int size() {return N;}
	
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	class ListIterator implements Iterator<Item>{
		private Node current = first; 

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack <String> s = new Stack<String> ();
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] arrays = line.split(" ");
		for(String str:arrays) {
			if(!str.equals("-")) s.push(str);
			else if(!s.isEmpty()) s.pop();
		}
		for(String str:s) {
			System.out.print(str+" ");
		}
	}


}
