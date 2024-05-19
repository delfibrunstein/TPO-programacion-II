package codigo;

public class Conjunto implements ConjuntoTDA{
	int [] array;
	int cont;

	// Inicializa el conjunto con un array de tamaño 100 y contador en 0
	public void inicializarConjunto() {
		array = new int [100];
		cont = 0;
	}

	// Agrega un elemento x al conjunto si no está presente
	public void Agregar(int x) {
		if (!this.Pertenece(x)) { // Verificar si x no está presente en el conjunto
			array[cont] = x; // Agregar x al conjunto en la posición cont
			cont ++;
		}
	}

	// Devuelve un elemento del conjunto (el último agregado), si el conjunto no está vacío
	public int Elegir() {
	    if (!conjuntoVacio()) {
	        return array[cont - 1]; // Devuelve el último elemento agregado al conjunto
	    } else {
	        return -1; // Si el conjunto está vacío, devuelve un valor por defecto 
	    }
	}

	// Verifica si el conjunto está vacío
	public boolean conjuntoVacio() {
		return (cont == 0); 
			
	}

	// Verifica si un elemento x pertenece al conjunto
	public boolean Pertenece(int x) {
		int i = 0;
		while (i < cont && array[i] != x) {//mientras que i sea menor al contador e i sea distinto a x(que es mi valor por parametro)
			i ++;
		}
		return (i < cont); // Devuelve true si se encontró el elemento en el conjunto, sino, devuelve false
	}

	// Elimina un elemento x del conjunto si está presente
	public void Sacar(int x) {
		int i = 0;
		while (i < cont && array[i] != x) {
			i ++;
		}
		if (i < cont){
			array[i] = array[cont - 1]; // Reemplazar el elemento a eliminar por el último elemento
			cont --;
		}
	}
	
	// Método requerido por Eclipse para evitar errores, (marcaba error en el Conjunto)
	@Override
	public boolean ConjuntoVacio() {
		// TODO Auto-generated method stub
		return false;
	}
}

//inicializarConjunto = O(1)+O(1)+O(1)= Complejidad constante = O(1)
//ConjuntoVacio = O(1)+O(1)= Complejidad constante = O(1)
//Agregar = O(1)+O(1)+O(n)= Complejidad lineal =O(n) ya que nos quedamos con la mas compleja de las 3
//Elegir = O(1)+O(1)+O(1)=Complejidad constante = O(1)
//Pertenece = O(1)+O(1)+O(1)+O(n)= Complejidad lineal = O(n)
//Sacar = O(1)+O(1)+O(1)+O(1)+O(1)+O(n)= Complejidad lineal = O(n)