package algorithm;

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
	public int id[]; //parent link
	public int sz[]; // size of components for roots
	private int count;
	public UF(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for(int i=0;i<N;i++) {
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
	public int find(int p) {
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
