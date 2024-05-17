package codigo;

public class Conjunto implements ConjuntoTDA{
	int [] array;
	int cont;
	
	public void inicializarConjunto() {
		array = new int [100];
		cont = 0;
	}
	
	public void Agregar(int x) {
		if (!this.Pertenece(x)) { // Verificar si x no está presente en el conjunto
			array[cont] = x; // Agregar x al conjunto en la posición cont
			cont ++;
		}
	}
	
	public int Elegir() {
	    if (!conjuntoVacio()) {
	        return array[cont - 1]; // Devuelve el último elemento agregado al conjunto
	    } else {
	        return -1; // Si el conjunto está vacío, devuelve un valor por defecto o maneja el error de alguna otra manera
	    }
	}
	
	public boolean conjuntoVacio() {
		return (cont == 0); 
			
	}
	
	public boolean Pertenece(int x) {
		int i = 0;
		while (i < cont && array[i] != x) {
			i ++;
		}
		return (i < cont); // Devuelve true si se encontró el elemento en el conjunto, sino, devuelve false
	}
	
	public void Sacar(int x) {
		int i = 0;
		while (i < cont && array[i] != x) {
			i ++;
		}
		if (i < cont) {
			array[i] = array[cont - 1]; // Reemplazar el elemento a eliminar por el último elemento
			cont --;
		}
	}
	//Si no agregabamos este metodo, marcaba error en el Conjunto, es un solucion que nos proporciono eclipse
	@Override
	public boolean ConjuntoVacio() {
		// TODO Auto-generated method stub
		return false;
	}
}
