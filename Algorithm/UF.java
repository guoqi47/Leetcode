package TestCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Data files:   https://algs4.cs.princeton.edu/15uf/tinyUF.txt
 *                https://algs4.cs.princeton.edu/15uf/mediumUF.txt
 *                https://algs4.cs.princeton.edu/15uf/largeUF.txt
 */
public class UF {
	private int id[]; //parent link
	private int sz[]; // size of components for roots
	private int isOpen[]; // size of components for roots
	private int count;
	public UF(int N) {
		count = N*N;
		id = new int[N*N];
		sz = new int[N*N];
		isOpen = new int[N*N];
		for(int i=0;i<N*N;i++) {
			if(i<N) {id[i]=0;sz[i]=N;continue;}
			if(i>=N*(N-1)) {id[i]=N*(N-1);sz[i]=N;continue;}
			id[i]=i;
			sz[i]=1;
		}
	}
	public int count() {
		return count;
	}
	public boolean connected(int p, int q) {
		return find(p)==find(q);
	}
	private int find(int p) {
		while(p!=id[p]) p=id[p];
		return p;
	}
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if(sz[i]>sz[j]) {id[j]=i;sz[i]+=sz[j];}
		else			{id[i]=j;sz[j]+=sz[i];}
		count--;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("input7.txt");
			Scanner scanner = new Scanner(fis);
			int N = scanner.nextInt();
			UF uf = new UF(N);
			while(scanner.hasNext()) {
				int p = scanner.nextInt();
				int q = scanner.nextInt();
				if(!uf.connected(p, q)) {uf.union(p, q);}
			}
			System.out.println(uf.connected(0, N*(N-1)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
