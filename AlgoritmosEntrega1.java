import java.util.ArrayList;
import java.util.Scanner;

public class AlgoritmosEntrega1 {

	public static void main(String[] args) {		
		System.out.println(aHexadecimal(65987));
		
	}
	
	/**
	 * Metodo que suma la diagonal primaria y secundaria de una matriz
	 * @param m la matriz
	 * @return la suma de los valores de las diagonales
	 */
	public static int sumaDiagonales1(int[][] m){
		int suma=0;
		for(int i=0;i<m.length;i++){
			suma+=m[i][i];
			suma+=m[i][m.length-(i+1)];
		}
		if(m.length%2==1){
			suma-=m[m.length/2][m.length/2];
		}
		return suma;
	}
	
	/**
	 * Metodo que suma la diagonal primaria y secundaria de una matriz
	 * @param m la matriz
	 * @return la suma de los valores de las diagonales
	 */
	public static int sumaDiagonales2(int[][] m){
		int suma=0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if(i==j){
					suma+=m[i][j];
				}
				if(j==m.length-i-1){
					suma+=m[j][m.length-i-1];
				}
			}
		}
		if(m.length%2==1){
			suma-=m[m.length/2][m.length/2];
		}
		return suma;
	}
	
	
	
	/**
	 * Metodo que retorna el enesimo numerico de la seria fibonacci
	 * @param n el numero a saber de la serie
	 * @return el termino enesimo de la serie
	 */
	public static long terminoNFibonacci(int n,long a,long b){
		if(n==3){
			return a+b;
		}else if(n==1||n==2){
			return 1;
		}else{
			return terminoNFibonacci(n-1, b, a+b);
		}
	}
	
	/**
	 * Metodo que busca el enesimo primo
	 * @param n. representa la posicion del primo a buscar 
	 * @return el enesimo primo
	 */
	public static int NPrimo(int n){
		ArrayList<Integer> primos=new ArrayList<Integer>();
		int p=2;
		int i;
		continuar:while(primos.size()<n){
			for(i=0;i<primos.size();i++){
				if(p%primos.get(i)==0){
					p++;
					continue continuar;
				}
			}
			
			primos.add(p);
			p++;
		}
		return primos.get(n-1);
		
	}
	
	
	/**
	 * Dada una matriz de m*n se crea un arreglo de m*n posiciones
	 * @param matriz de orden m*n
	 * @return un arreglo de m*n posiciones con los valores de la matriz
	 */
	public  static int[] matrizAArreglo(int m[][]){
		int a[]=new int[m.length*m[0].length];
		int k=0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				a[k++]=m[i][j];
			}
		}
		return a;
	}
	
	/**
	 * Dada una matriz de enteros el metodo la recorre y si el numero que se encuentra
	 * en la matriz es par lo intercambia con el anterior en caso contrario lo eleva a la 3
	 * @param m una matriz de enteros
	 * @return la matriz m con los nuevos valores
	 */
	public static int[][] operarMatriz(int m[][]){
		int aux;
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if(m[i][j]%2==0){
					if(i+j!=0){
						if(j==0){
							aux=m[i][j];
							m[i][j]=m[i-1][m[0].length-1];
							m[i-1][m[0].length-1]=aux;
							
						}else{
							aux=m[i][j];
							m[i][j]=m[i][j-1];
							m[i][j-1]=aux;
							
						}
					}
				}else{
					m[i][j]=(int) Math.pow(m[i][j],3);
				}
			}
		}
		return m;
	}
	
	
	/**
	 * Metodo que dice si una palabra es palindroma
	 * @param a, el string a verificar si es palindromo
	 * @return true, si la palabra es palindroma
	 */
	
	public static boolean isPalindrome(String a){
		if(a.length()==0||a.length()==1){
			return true;
		}else{
			if(a.charAt(0)==a.charAt(a.length()-1)){
				return isPalindrome(a.substring(1, a.length()-1));
			}
			return false;
		}
	}
	
	/**
	 * Dado un numero este metodo retorna una matriz de n*n rellenada diagonalmente
	 * @param n el orden de la matriz cuadrada
	 * @return la matriz.
	 */
	public static int[][] matrizLlenaEnDiagonal(int n){
		int matriz[][] = new int[n][n];
		int aux=1;
		int fila=0;
		int columna=n-1;
		
		while(columna>=0){
			fila=0;
			for(int i=columna;i<n;i++){
				matriz[fila++][i]=aux++;
			}
			columna--;
		}
		fila=1;
		while(fila<n){
			columna=0;
			for(int i=fila;i<n;i++){
				matriz[i][columna++]=aux++;
			}
			fila++;
		}
		return matriz;
		
	}
	
	/**
	 * Metodo que suma dos matriz de manera especial, primer elemento de la matriz a
	 * con ultimo elemento de la matriz b y asi sucesivamente
	 * @param a
	 * @param b
	 * @return una matriz c con las sumas de las otras dos matrices correspondientemente
	 */
	public static int[][] sumaMatrices(int a[][], int b[][]){
		int c[][]=new int[a.length][a[0].length];
		int k=a.length-1;
		int l=a[0].length-1;
		
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				c[i][j]=a[i][j]+b[k][l];
				if(l-1==-1){
					k--;
					l=a[0].length-1;
				}else{
					l--;
				}
			}
		}
		return c;
	}
	
	/**
	 * Metodo que dada una matriz, una fila inicial, columna inicial, fila final y columna
	 * final, genere una submatriz
	 * @param a la matriz a operar
	 * @param fi fila inicial de la submatriz
	 * @param ff fila final de la submatriz
	 * @param ci columna inicial de la submatriz
	 * @param cf columna final de la submatriz
	 */
	public static int[][] subMatriz(int a[][],int fi,int ff,int ci,int cf){
		int m=(ff-fi)+1;
		int n=(cf-ci)+1;
		
		int c[][]= new int[m][n];
		int k=0;
		int l=0;
		
		for (int i = fi; i <= ff; i++) {
			for (int j = ci; j <= cf; j++) {
				c[k][l]=a[i][j];
				if(l+1==n){
					k++;
					l=0;
				}else{
					l++;
				}
			}
		}
		return c;
	}
	
	/**
	 * Algoritmo que suma las cifras de un numero
	 * @param n el numero a sumar las cifras
	 * @return la suma de las cifras
	 */
	public static int sumaDigitos(int n){
		if(n<10){
			return n;
		}else{
			return (n%10)+sumaDigitos(n/10);
		}
	}
	
	/**
	 * Convierte un numero Decimal a binario recursivo
	 * @param n, un numero decimal
	 * @return el numero decimal en binario convertido en string
	 */
	public static String decimalABinario(int n){
		if(n==0||n==1){
			return n+"";
		}else{
			return decimalABinario(n/2)+(n%2);
		}
	}
	
	/**
	 * Convierte un numero Decimal a binario iterativo
	 * @param n, un numero decimal
	 * @return el numero decimal en binario convertido en string
	 */
	public static String decimalABinario2(int n){
		String bin="";
		while(n!=1&&n!=0){
			bin=(n%2)+bin;
			n/=2;
		}
		return n+bin;
	}
	
	
	/**
	 * Resuelve un cuadrado magico de orden impar
	 * @param n el orden del cuadrado
	 * @return la matriz con el cuadrado resuelto
	 */
	public static int[][] cuadradoMagico(int n){
		int i=1;
		int m[][] = new int[n][n];
		int x=n-1;
		int y=n/2;
		while(i<=n*n){
			m[y][x]=i++;
			if((i-1)%n==0){
				x--;
			}else{
				if(x+1==n){
					x=0;
				}else{
					x++;
				}
				
				if(y-1==-1){
					y=n-1;
				}else{
					y--;
				}
			}
		}
		return m;
	}
	
	/**
	 * Convierte un numero decimal a hexadecimal
	 * @param n el numero a convertir
	 * @return un string con la representacion en hexadecimal del numero n
	 */
	public static String aHexadecimal(int n){
		if(n<=9){
			return n+"";
		}else if(n<=15){
			switch(n){
			case 10:
				return "A";
			case 11:
				return "B";
			case 12:
				return "C";
			case 13:
				return "D";
			case 14:
				return "E";
			case 15:
				return "F";
			}
		}else{
			switch(n%16){
			case 10:
				return aHexadecimal(n/16)+"A";
			case 11:
				return aHexadecimal(n/16)+"B";
			case 12:
				return aHexadecimal(n/16)+"C";
			case 13:
				return aHexadecimal(n/16)+"D";
			case 14:
				return aHexadecimal(n/16)+"E";
			case 15:
				return aHexadecimal(n/16)+"F";
			}
		}
		return aHexadecimal(n/16)+ (n%16);
	}
	
}
