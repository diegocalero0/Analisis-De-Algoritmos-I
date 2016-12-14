import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class AlgoritmosDivideYVenceras {

	public static void main(String[] args) {
			
			System.out.println(multiplicar(5648, 4225));
	}
	
	/**
	 * Metodo que busca la suma de la subsecuencia maxima de una  arreglo dado
	 * @param a aarreglo
	 * @param i limite izquierdo
	 * @param d limite derecho
	 * @return la maxima suma dentro del arreglo
	 */
	public static int SSM(int a[],int i,int d){
		
		if(i==d){
			if(a[i]>0){
				return a[i];
			}else{
				return 0;
			}
		}else{
			int centro = (i+d)/2;
			int s1=SSM(a,i,centro);
			int s2=SSM(a,centro+1,d);
			
			int sumaI=0;
			int sumaMaxI=0;
			for (int j = centro; j>=i; j--) {
				sumaI+=a[j];
				if(sumaI>sumaMaxI){
					sumaMaxI=sumaI;
				}
			}
			
			int sumaD=0;
			int sumaMaxD=0;
			for (int j = centro+1; j <= d; j++) {
				sumaD+=a[j];
				if(sumaD>sumaMaxD){
					sumaMaxD=sumaD;
				}
			}

			if(sumaMaxD + sumaMaxI > s1 && sumaMaxD + sumaMaxI > s2){
				return sumaMaxD + sumaMaxI;
			}else if(s1 >= s2 && s1 >= sumaMaxD + sumaMaxI){
				return s1;
			}else{
				return s2;
			}
			
			
		}
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
	
	/**
	 * Multiplica dos numeros haciendo uso de la tecnica divide y venceras
	 * @param u primer numero
	 * @param v segundo numero
	 * @return
	 */
	public static int multiplicar(int u,int v){
		int n;
		if(u>v)
			n=(int)Math.log10(u)+1;
		else
			n=(int)Math.log10(v)+1;
		if(n==1)
			return u*v;
		else{
			int s=n/2;
			int w=u/(int)Math.pow(10, s);
			int x=u%(int)Math.pow(10, s);
			int y=v/(int)Math.pow(10, s);
			int z=v%(int)Math.pow(10, s);
			
			int r = multiplicar(w+x, y+z);
			int p = multiplicar(w, y);
			int q =multiplicar(x, z);
			int a;
			return p*(int)Math.pow(10, 2*s)+(r-p-q)*(int)Math.pow(10, s)+q;
		}
	}
	
}
