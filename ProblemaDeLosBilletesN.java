
public class ProblemaDeLosBilletesN {
	public static void main(String[] args) {
		int b[] = {1000,2000,5000,10000,20000,50000,100000};
		int a[] = cantBilletes(b, 1827000);
		
		for(int i:b){
			System.out.print(i+"\t");
		}
		System.out.println();
		for(int i:a){
			System.out.print(i+"\t");
		}
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
	
}
