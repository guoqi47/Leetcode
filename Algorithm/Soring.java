package algorithm;

public class Soring {
	private static Comparable[] aux ;
	
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	
	private static void show(Comparable[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]);
			System.out.println();
		}
	}
	
	public boolean isSorted(Comparable[] a) {
		for(int i=0; i<a.length; i++) 
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	
	public static void selectSort(Comparable[] a) {
		int N = a.length;
		for(int i=0; i<N; i++) {
			int min = i;
			for(int j=i+1; j<N; j++) {
				if(less(a[j],a[min])) min = j;
			}
			exch(a,i,min);
		}
	}
	
	public static void insertSort(Comparable[] a) {
		for(int i =1; i<a.length; i++) {
			for(int j=i;j>0 && less(a[j],a[j-1]);j--) {
				exch(a,j-1,j);
			}
		}
	}
	
	public static void shellSort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while(h<N/3) h = h*3+1;
		while(h>=1) {
			for(int i=h; i<N; i++) {
				for(int j=i; j-h>=0 && less(a[j],a[j-h]); j-=h) exch(a,j,j-h);
			}
			h = h/3;
		}
	}
	
	public static void mergeTDSort(Comparable[] a) {
		aux = new Comparable[a.length];
		mgsort(a,0,a.length -1);
	}
	public static void mgsort(Comparable[] a, int lo, int hi) {
		if (lo>=hi) return;
		int mid = lo+(hi-lo)/2;
		mgsort(a,lo,mid);
		mgsort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	public static void merge(Comparable[] a,int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		for(int k=lo;k<=hi;k++) aux[k] = a[k];
		for(int k = lo; k<=hi; k++) {
			if 		(i>=mid+1) 				a[k]=aux[j++];
			else if (j>hi) 					a[k]=aux[i++];
			else if (less(aux[i],aux[j])) 	a[k]=aux[i++];
			else   							a[k]=aux[j++];
		}
	}
	
	public static void mergeBUSort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		
		for(int size=1; size<N; size*=2) {
			for(int lo =0; lo<N-size;lo+=2*size)	merge(a,lo,lo+size-1,Math.min(lo+2*size, N-1));
		}
	}
	
	public static void main(String args[]) {
//		String[] s = new String[] {"a","s","d"};
		Integer[] i = new Integer[] {1,3,2,4,0,8,5};
		mergeBUSort(i);
		show(i);
		
	}
}
