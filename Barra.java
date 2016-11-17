import java.util.LinkedList;
import java.util.Queue;

public class Barra {
	
	public static int dp[];
	public static int longitud[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	public static int precios[] = {3, 5, 8, 9, 10, 17, 17, 20, 24, 30};
	
	public static void main(String[] args) {
		
		dp = new int[longitud.length];
		for (int i = 0; i < dp.length; i++) 
				dp[i] = -1;
		int a = barra(50);
		System.out.println(a);
		
	}
	
	public static int barra(int tamanio){
		
		int mejor = 0;
		if(tamanio <= longitud.length && dp[tamanio - 1] != -1){
			return dp[tamanio - 1];
		}
			
		else{
			if(existeLongitud(1) && tamanio <= longitud.length)
				mejor = precios[tamanio - 1];
			for (int i = 1; i < tamanio; i++) {
				if(existeLongitud(i))
					mejor = Integer.max(precios[i - 1] + barra(tamanio - i), mejor);
			}
			if(tamanio <= longitud.length)
				dp[tamanio - 1] = mejor;
			return mejor;
		}
	}
	
	public static boolean existeLongitud(int n){
		for (int i = 0; i < longitud.length; i++) {
			if(longitud[i] == n)
				return true;
		}
		return false;
	}
	
}

