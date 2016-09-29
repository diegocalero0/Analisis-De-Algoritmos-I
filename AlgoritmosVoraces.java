import java.util.LinkedList;

public class AlgoritmosVoraces {

	public static void main(String[] args) {
		System.out.println(caminoCortoCaballo(new Nodo(7, 0, 0), new Nodo(5,4,0)));
	}
	
	
	/**
	 * Metodo que busca el camino mas corto de un caballo en un tablero de ajedres apartir de probar posibles soluciones
	 * @param Nodo ini
	 * @param Nodo fin
	 * @return camino mas corto de ini hasta fin
	 */
	public static int caminoCortoCaballo(Nodo ini,Nodo fin){
		int mov[][]={{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
		
		int m[][] = new int[8][8];
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				m[i][j]=0;
			}
		}
		
		LinkedList<Nodo> c = new LinkedList<Nodo>();
		c.push(ini);
		
		while(!c.isEmpty()){
			Nodo aux =c.pollLast();
			if(aux.getX()==fin.getX()&&aux.getY()==fin.getY())
				return aux.getC();
			for(int i=0;i<8;i++){
				int x=aux.getX()+mov[i][0];
				int y=aux.getY()+mov[i][1];
				int co=aux.getC()+1;
				if(verificar(x,y)&&m[x][y]==0){
					m[x][y]=1;
					Nodo n = new Nodo(x,y,co);
					c.push(n);
				}
			}
		}
		return -1;
	}
	
	/**
	 * Verifica si una posicion es valida
	 * @param x
	 * @param y
	 * @return true si la posicion es valida
	 */
	
	public static boolean verificar(int x,int y){
		if(x>=0&&x<=7&&y>=0&&y<=7){
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que me calcula la cantidad minima de billetes a devolver con una denominacion normalizada
	 * @param denominaciones
	 * @param dinero
	 * @return un arreglo con la cantidad de billetes
	 */
	public static int[] cantBilletes(int denominaciones[],int dinero){
		int c=0;
		int i=denominaciones.length-1;
		int a[] = new int[i+1];
		while(dinero>0){
			if(denominaciones[i]<=dinero){
				dinero-=denominaciones[i];
				a[i]++;
				c++;
			}
			else
				i--;
		}
		return a;
	}
	
	/**
	 * Obtiene el mayor beneficio al llevar objetos que pueden particionar en una mochila
	 * Se debe tener previamente los arreglos pesos y beneficios ordenados tal que
	 * beneficios[i]/pesos[i] >= beneficios[i+1]/pesos[i+1]
	 * @param n el numero de objetos
	 * @param c el perso maximo que soporta la mochila
	 * @param pesos arreglo con pesos Pi para el objeto Xi
	 * @param beneficios arreglo con los beneficios Bi para el objeto Xi
	 * @return
	 */
	public static double[] beneficioMochila(int c,int[] pesos,int[] beneficios){
		quicksort(beneficios,pesos, 0,pesos.length);
		double sol[] = new double[pesos.length];
		int resto = c;
		int i=0;
		
		while(i<pesos.length&&pesos[i]<=resto){
			sol[i]=1;
			resto-=pesos[i++];
		}
		if(i<pesos.length)
			sol[i]=pesos[i]=resto/pesos[i];
		return sol;
	}
	
	/**
	 * Metodo que ordena un arreglo de menor a mayor haciendo uso del algoritmo quicksort
	 * @param beneficios
	 * @param pesos
	 * @param limInf
	 * @param limSup
	 */
	public static void quicksort(int beneficios[],int pesos[],int limInf,int limSup){
		int i=limInf;
		int j=limSup;
		int pivote=beneficios[(limInf+limSup)/2]/pesos[(limInf+limSup)/2];
		
		do{
			while(beneficios[i]/pesos[i]<pivote){
				i++;
			}
			while(beneficios[j]/pesos[j]>pivote){
				j--;
			}
			
			if(i<=j){
				int aux=pesos[i];
				pesos[i]=pesos[j];
				pesos[j]=aux;
				
				aux=beneficios[i];
				beneficios[i]=beneficios[j];
				beneficios[j]=aux;
				i++;
				j--;
			}
		}while(i<=j);
		
		if(j>limInf)
			quicksort(beneficios,pesos, limInf, j);
		if(i<limSup)
			quicksort(beneficios,pesos, i, limSup);
	}

}

class Nodo{
	private int x;
	private int y;
	private int c;
	public Nodo(int x,int y,int c){
		this.x=x;
		this.y=y;
		this.c=c;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	
	
	
}
