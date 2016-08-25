
public class JacobSthal {

	public static void main(String[] args) {
		System.out.println(numerosDeJacobsthal(9));
		System.out.println(numerosDeJacobsthal2(9));
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
	public static int numerosDeJacobsthal2(int n){
		if(n==0)
			return 0;
		int a=0;
		int b=1;
		int c=0;
		while(--n>0){
			c=b+2*(a);
			a=b;
			b=c;
		}
		return b;
	}

}
