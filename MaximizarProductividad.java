
public class MaximizarProductividad {
	private static int disponible = 50;
	private static int[] productividad = {10, 3, 8};
	private static int[] precios = {50, 30, 20};
	private static int[] dp[] = new int[productividad.length][disponible + 1];
	public static void main(String[] args) {
		
	}
	
	
	public static int maximaProductvidad(int i, int disponible){
		int maximo = 0;
		if(i == productividad.length)
			return 0;
		if(dp[i][disponible] != 0)
			return dp[i][disponible];
		for (int j = 0; j < dp.length; j++) {
			if(precios[j] <= disponible)
				maximo = Integer.max(maximaProductvidad(j + 1, disponible - precios[j]), maximo);
		}
		dp[i][disponible] = maximo;
		return maximo;
	}
	
}
