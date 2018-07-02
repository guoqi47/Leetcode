package algorithm;
/**
 * 用数组实现自适应大小,可遍历的Stack.
 */
import java.util.Iterator;


public class ResizingArrayStack<Item> implements Iterable<Item>{
	private int N = 0;
	private Item[] a = (Item[]) new Object[1];
	
	
	private void resize(int max) {
		Item[] temp = (Item[])new Object[max];
		for(int i = 0; i<N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void push(Item item) {
		if(N==a.length)	resize(N*2);
		a[N++] = item;
	}
	public Item pop() {
		Item item = a[--N];
		if (N<a.length/4) resize(a.length/2);
		return item;
	}
	public int len() {
		return a.length;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ResizingArrayIterator();
	}
	class ResizingArrayIterator implements Iterator<Item>{
		private int i = N;
		
		@Override
		public boolean hasNext() {return i>0;}

		@Override
		public Item next() { return a[--i];}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResizingArrayStack<Integer> r = new ResizingArrayStack();
		r.push(1);
		r.push(2);
		r.push(3);
		r.pop();
		for(int i:r) {
			System.out.println(i);
		}
		System.out.println(r.len());
	}

}
