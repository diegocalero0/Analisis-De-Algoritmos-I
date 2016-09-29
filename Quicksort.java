
public class Quicksort {

	public static void main(String[] args) {
		int a[]={1,5,6,4,7,-2,0,8,6,4,2,6,5,4,7,9,1,22,44,65,12,14,-5,-7,-6};
		quicksort(a, 0, a.length-1);
		for(int b:a){
			System.out.print(b+" ");
		}

	}
	
	/**
	 * Metodo que ordena un arreglo de menor a mayor haciendo uso del algoritmo quicksort
	 * @param a
	 * @param limInf
	 * @param limSup
	 */
	public static void quicksort(int a[],int limInf,int limSup){
		int i=limInf;
		int j=limSup;
		int pivote=a[(limInf+limSup)/2];
		
		do{
			while(a[i]<pivote){
				i++;
			}
			while(a[j]>pivote){
				j--;
			}
			
			if(i<=j){
				int aux=a[i];
				a[i]=a[j];
				a[j]=aux;
				i++;
				j--;
			}
		}while(i<=j);
		
		if(j>limInf)
			quicksort(a, limInf, j);
		if(i<limSup)
			quicksort(a, i, limSup);
	}

}
