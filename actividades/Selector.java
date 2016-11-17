package actividades;

import java.util.ArrayList;
import java.util.List;

public class Selector {

	public static void main(String[] args) {
		List<Actividad> actividades = new ArrayList<>();
		actividades.add(new Actividad(8, 11, "A1"));
		actividades.add(new Actividad(9, 13, "A2"));
		actividades.add(new Actividad(14, 18, "A4"));
		actividades.add(new Actividad(13, 16, "A3"));
		
		Selector selector = new Selector();
		actividades = selector.seleccionarActividades(0, 24, actividades);
		System.out.println(actividades);
	}
	
	
	public List<Actividad> seleccionarActividades(int inicio, int fin, List<Actividad> actividades){
		List<Actividad> solucion = new ArrayList<>();
		ordenarActividades(actividades);
		int hora = inicio;
		while(hora < fin && !actividades.isEmpty()){
			Actividad actividad = actividades.get(0);
			if(actividad.getInicio() >= hora && actividad.getFin() <= fin){
				solucion.add(actividad);
				hora = actividad.getFin();
			} else {
				actividades.remove(0);
			}
		}
		return solucion;
	}

	private void ordenarActividades(List<Actividad> actividades) {
		int n = actividades.size();
		for (int i = 0; i < n; i++) {
			int indice = i;
			Actividad actividad = actividades.get(indice);
			for (int j = i + 1; j < n; j++) {
				Actividad aux = actividades.get(j); 
				if(actividad.getInicio() > aux.getInicio() || ( actividad.getInicio() == aux.getInicio() && actividad.getFin() < aux.getFin())){
					actividad = aux;
					indice = j;
				}
			}
			if(indice != i){
				actividades.remove(indice);
				actividades.add(i, actividad);
			}
		}
	}
	
}

