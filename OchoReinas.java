
public class OchoReinas {

	public int solucion[];
	private int intentos = 0;
	public static void main(String[] args) {
		OchoReinas or = new OchoReinas();
		boolean sol = or.solucionDos();
		if(sol){
			for (int i = 0; i < 8; i++) {
				System.out.println(or.solucion[i]);
			}
		}
	}
	
	public boolean solucionAleatoria(){
		solucion = new int[8];
		intentos = 0;
		do{
			int visitados[] = new int[8];
			int aleatorio;
			for(int i = 0; i < 8; i++){
				aleatorio = (int)(Math.random()*8);
				if(visitados[aleatorio] == 0){
					visitados[aleatorio] = 1;
					solucion[i] = aleatorio;
				}else{
					i--;
				}
			}
			intentos++;
		}while(!verificar() && intentos != 1000);
		
		if(intentos == 1001)
			return false;
		return true;
	}
	
	public boolean solucionDos(){
		solucion = new int[8];
		int iDef=0;
		int atacI = Integer.MAX_VALUE;
		int c;
		do{
			int visitados[] = new int[8];
			for (int i = 0; i < solucion.length; i++) {
				atacI = Integer.MAX_VALUE;
				iDef=0;
				for (int j = 0; j < solucion.length; j++) {
					if(visitados[j] == 0){
						solucion[i] = j;
						c = verificarDos(i);
						solucion[i] = 0;
						if(c < atacI){
							iDef = j;
							atacI = c;
						}
						
						if(c == 0)
							break;
						
					}
				}
				visitados[iDef] = 1;
				solucion[i] = iDef;
			}
			
			intentos++;
			
		}while(!verificar() && intentos != 1000 );
		if(intentos == 1001)
			return false;
		return true;
		
	}
	
	public int verificarDos(int r){
		boolean valido = true;
		int c = 0;
		for(int i = 0; i < r; i++){
			valido = valido && (solucion[r]!=solucion[i]);
			if(!valido){
				c++;
				valido = true;
			}
			valido = valido && r+solucion[r]!=i+solucion[i];
			if(!valido){
				c++;
				valido = true;
			}
			valido = valido && r-solucion[r]!=i-solucion[i];
			if(!valido){
				c++;
				valido = true;
			}
			
		}
		return c;
	}
	
	public boolean verificar(){
		boolean valido = true;
		for (int i = 1; i < 8; i++) {
			int r = i;
			valido = true;
			for(int j = 1; j < r; j++){
				valido = valido && (solucion[r]!=solucion[j]);
				valido = valido && r+solucion[r]!=j+solucion[j];
				valido = valido && r-solucion[r]!=j-solucion[j];
			}
			if(!valido){
				break;
			}
		}
		if(!valido)
			return false;
		return true;
	}
}
