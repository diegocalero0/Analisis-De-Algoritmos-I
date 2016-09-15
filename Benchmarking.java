import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Benchmarking {
	public static void main(String args[]){
		long t1;
		long t2;
		//File archivo = new File("tiempos.txt");
		BufferedWriter escritor;
		try {
			escritor = new BufferedWriter(new FileWriter("tiempos.txt"));
			
			//para el iterativo
			for (int i = 20; i <= 41; i++) {
				t1=System.nanoTime();
				numerosDeJacobsthal2(i);
				t2=System.nanoTime();
				escritor.write(String.valueOf(t2-t1)+"\n");
				
			}
			
			escritor.write("----------\n");
			
			//para el recursivo
			for (int i = 20; i <= 41; i++) {
				t1=System.nanoTime();
				numerosDeJacobsthal(i);
				t2=System.nanoTime();
				escritor.write(String.valueOf(t2-t1)+"\n");
			}
			
			escritor.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo que encuentra el enesimo numero de Jacobsthal
	 * @param n
	 * @return el numero n de los numeros de Jacobsthal
	 */
	public static int numerosDeJacobsthal(int n){
		if(n==0){
			return 0;
		}else if(n==1){
			return 1;
		}else{
			return numerosDeJacobsthal(n-1)+2*(numerosDeJacobsthal(n-2));
		}
	}
	
	/**
	 * Metodo que encuentra el enesimo numero de Jacobsthal
	 * @param n
	 * @return el numero n de los numeros de Jacobsthal
	 */
	public static long numerosDeJacobsthal2(int n){
		if(n==0)
			return 0;
		long a=0;
		long b=1;
		long c=0;
		while(--n>0){
			c=b+2*(a);
			a=b;
			b=c;
		}
		return b;
	}
}
