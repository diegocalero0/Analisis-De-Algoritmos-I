
public class BusquedaBinaria {

	public static void main(String[] args) {

	}

	/**
	 * Busca n en un arreglo haciendo uso del divide y venceras.
	 * @param n
	 * @param inf
	 * @param sup
	 * @param m
	 * @param a
	 * @return
	 */
	public static boolean BusquedaBin(int n,int inf,int sup,int m,int[]a){
        if(sup-inf==1)
        {
            if(a[inf]==n)
                return true;
            return false;
        }else
        {
            if(n==a[m])
            {
                return true;
            }else if(n>a[m])
            {
                return BusquedaBin(n,m,sup,(sup+m)/2,a);
            }else
            {
                return BusquedaBin(n,inf,m,(inf+m)/2,a);
            }
        }
    }
	
}
