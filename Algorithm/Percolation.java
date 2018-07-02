package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Percolation {
	private int open[][]; 
	
	public Percolation(int N) {
		open = new int[N][N];
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("input10-no.txt");
			Scanner scanner = new Scanner(fis);
			int N = scanner.nextInt();
			UF uf = new UF(N*N);
			Percolation per = new Percolation(N);
			for(int i=0;i<N*N;i++) {
				uf.id[i]=i;uf.sz[i]=1;
			}
			for(int i=0;i<N;i++) {
				uf.id[i]=0;
				uf.id[N*(N-1)+i]=N*N-1;
			}
			uf.sz[0]=N;
			uf.sz[N*(N-1)]=N;
			while(scanner.hasNext()) {
				int p = scanner.nextInt()-1;
				int q = scanner.nextInt()-1;
				per.open[p][q]=1;
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(per.open[i][j]==1) {
						if(i<N-1 && j<N-1) {
							if(per.open[i][j+1]==1) uf.union(i*N+j, i*N+j+1);
							if(per.open[i+1][j]==1) uf.union(i*N+j, (i+1)*N+j);
						}else if(i==N-1 && j<N-1 && per.open[i][j+1]==1) uf.union(i*N+j, i*N+j+1);
						else if(i<N-1 && j==N-1 && per.open[i+1][j]==1) uf.union(i*N+j, (i+1)*N+j);
					}
				}
			}
			System.out.println(uf.connected(0, N*(N-1)+1));
//			for(int i = 0;i<N*N; i++) {
//				System.out.print(uf.id[i]+" ");
//				if(i%N==(N-1)) {
//					System.out.println();
//				}
//			}
			//打印open
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					System.out.print(per.open[i][j]);		
//				}
//				System.out.println();
//			}
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
