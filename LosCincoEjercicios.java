
public class LosCincoEjercicios {

	public static void main(String[] args) {
		System.out.println(raizDeX(30, 0, 30));

	}

	/**
	 * Dado un numero, retorna su raiz.
	 * @param x el numero al cual halaremos su raiz.
	 * @return la parte entera de la raiz.
	 */
	public static int raizDeX(int x,int i,int d){
		if(d-i==1){
			if(d*d<=x){
				return d; 
			}else{
				return i;
			}
		}
		else{
			int mitad = (i+d)/2;
			if(mitad*mitad>(x)){
				return raizDeX(x,i,mitad);
			}else{
				return raizDeX(x,mitad,d);
			}
		}
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
	public static int[] beneficioMochila(int c,int[] pesos,int[] beneficios,int productos[]){
		quicksort(beneficios,pesos,productos, 0,pesos.length);
		int sol[] = new int[pesos.length];
		int resto = c;
		int i=0;
		
		while(i<pesos.length&&pesos[i]<=resto){
			sol[i]=productos[i];
			resto-=pesos[i++];
		}
		return sol;
	}
	
	/**
	 * Metodo que ordena un arreglo de menor a mayor haciendo uso del algoritmo quicksort
	 * @param beneficios
	 * @param pesos
	 * @param limInf
	 * @param limSup
	 */
	public static void quicksort(int beneficios[],int pesos[],int productos[],int limInf,int limSup){
		int i=limInf;
		int j=limSup;
		double pivote=(double)beneficios[(limInf+limSup)/2]/(double)pesos[(limInf+limSup)/2];
		
		do{
			while((double)beneficios[i]/(double)pesos[i]<pivote){
				i++;
			}
			while((double)beneficios[j]/(double)pesos[j]>pivote){
				j--;
			}
			
			if(i<=j){
				int aux=pesos[i];
				pesos[i]=pesos[j];
				pesos[j]=aux;
				
				aux=beneficios[i];
				beneficios[i]=beneficios[j];
				beneficios[j]=aux;
				
				aux=productos[i];
				productos[i]=productos[j];
				productos[j]=aux;
				
				i++;
				j--;
			}
		}while(i<=j);
		
		if(j>limInf)
			quicksort(beneficios,pesos,productos ,limInf, j);
		if(i<limSup)
			quicksort(beneficios,pesos, productos,i, limSup);
	}

}
