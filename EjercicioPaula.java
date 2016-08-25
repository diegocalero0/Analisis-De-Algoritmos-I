
public class EjercicioPaula {

	public static void main(String[] args) {
			int a[] = {4,1,2,3};
			int b[]=ordenamiento(a);
			for (int i = 0; i < b.length; i++) {
				System.out.print(b[i]+" ");
			}
			
	}
	
	/**
	 * Metodo de ordenamiento
	 * este algoritmo no funciona
	 * @param a
	 * @return
	 */
	public static int[] ordenamiento(int[] a){
		
		int aux=0;
		for(int i=0;i<a.length;i++){
			aux=a[i];
			for(int j=i+1;j<a.length;j++){
				if(aux<a[j]){
					a[i]=a[j];
					a[j]=aux;
					
					for (int j2 = 0; j2 < a.length; j2++) {
						System.out.print(a[j2]+" ");
					}
					System.out.println();
					
					
				}
			}
		}
		
		return a;
	}

}
