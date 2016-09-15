
public class EjerciciosParcial {
	public static void main(String args[]){
		System.out.println(sucesionP(34));
		System.out.println(sucesionP2(34));
	}
	
	/**
	 * Calcula el enesimo termino de la sucesion p
	 * p(0)=0; p(1)=1; p(2)=2; p(3)=2p(2)
	 * p(n)=n*p(n-1)+p(n-2)/2+p(n-3)/3
	 * @param n el termino al calcular
	 * @return el enesimo termino de la sucecion p
	 */
	public static double sucesionP(int n){
		if(n==0||n==1||n==2)
			return n;
		else if(n==3)
			return 2*sucesionP(n-1);
		else
			return n*sucesionP(n-1)+sucesionP(n-2)/2+sucesionP(n-3)/3;
	}
	
	/**
	 * Calcula el enesimo termino de la sucesion p
	 * p(0)=0; p(1)=1; p(2)=2; p(3)=2p(2)
	 * p(n)=n*p(n-1)+p(n-2)/2+p(n-3)/3
	 * @param n el termino al calcular
	 * @return el enesimo termino de la sucecion p
	 */
	public static double sucesionP2(int n){
		double aux=4;
		double p0=0;
		double p1=1;
		double p2=2;
		double p3=4;
		double res=0;
		if(n==0||n==1||n==2)
			return n;
		else if(n==3)
			return 4;
		else
			while(aux<=n){
				res=(aux*p3)+p2/2+p1/3;
				aux++;
				p0=p1;
				p1=p2;
				p2=p3;
				p3=res;
			}
		return res;
	}
	
}
