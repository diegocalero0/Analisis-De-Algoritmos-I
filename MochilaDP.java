public class MochilaDP {

	private static int w = 10;
	private static int pesos[] = {2 ,2 ,2, 2, 3, 3, 3, 9};
	private static int beneficios[] = {40, 40, 40, 40, 50, 50, 50, 181};
	private static int dp[][] = new int[w + 1][pesos.length];
	
	public static void main(String[] args) {
		System.out.println( maximizar(0, w) );
		for (int i = 0; i < w + 1; i++) {
			for (int j = 0; j < pesos.length; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static int maximizar(int o, int w){
		
		int mejor = 0, i;
		
		if(o == beneficios.length){
			return 0;
		}
		if(dp[w][o] != 0){
			return dp[w][o];	
		}
		for (i = o; i < beneficios.length; i++) {
			if(pesos[i] <= w)
				mejor = Integer.max(maximizar(i + 1, w - pesos[i]) + beneficios[i], mejor);
		}
		dp[w][o] = mejor;
		return mejor;
		
	}

}