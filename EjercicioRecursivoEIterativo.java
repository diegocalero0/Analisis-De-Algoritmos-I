
public class EjercicioRecursivoEIterativo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Dado un numero m y un numero n cuantas veces debe operarse m para convertirlo en n
	 * sabiendo que solo se puede multiplicar por dos o restarle 1
	 * @param m primer numero
	 * @param n segundo numero
	 * @return el numero de operaciones
	 */
	public static int dosFunciones(int m,int n){
		
		if(m==n){
			return 0;
		}else{
			if(m<n){
				if(n%2==0){
					return 1+dosFunciones(m, n/2);
				}else{
					return 2+dosFunciones(m, (n+1)/2);
				}
				
			}else{
				return 1+dosFunciones(m-1, n);
			}
		}
	}
	
	/**
	 * Dado un numero m y un numero n cuantas veces debe operarse m para convertirlo en n
	 * sabiendo que solo se puede multiplicar por dos o restarle 1
	 * @param m primer numero
	 * @param n segundo numero
	 * @return el numero de operaciones que se hacen
	 */
	public static int dosFunciones2(int m,int n){
		int c=0;
		while(m!=n){
			if(m<n){
				if(n%2==0){
					c++;
					n/=2;
				}else{
					c+=2;
					n=(n+1)/2;
				}
			}else{
				c++;
				m--;
			}
		}
		return c;
	}

	
}
