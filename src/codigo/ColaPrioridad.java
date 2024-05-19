package codigo;

public class ColaPrioridad {
	class Elemento{ //encapsular el valor y la prioridad en lugar de tener dos arreglos separados.
		int valor;
		int prioridad;
	}
	Elemento [] elementos;
	int indice;

	// Inicializa la cola de prioridad con un array de tamaño 100
	public void inicializarCola() {
		indice = 0;
		elementos = new Elemento [100];
	}

	// Agrega un elemento con una prioridad específica a la cola
	public void acolarPrioridad(int x, int prioridad) {
		int j = indice;
		//desplaza a la derecha los elementos de la cola mientras
		//estos tengan mayor o igual prioridad que la de x
		for (; j > 0 && elementos[j - 1].prioridad >= prioridad; j--) {
			//mientras j sea mayor que 0 y la prioridad del elemento en la posición j - 1 
			//sea mayor o igual que la prioridad del nuevo elemento
			elementos[j] = elementos[j - 1];
		}
		elementos[j] = new Elemento();
		elementos[j].valor = x;
		elementos[j].prioridad = prioridad;
		indice ++;
	}

	// Elimina el elemento con la mayor prioridad (al final del array)
	public void Desacolar() {
		elementos[indice - 1] = null;
		indice --;
		
	}

	// Verifica si la cola está vacía
	public boolean colaVacia() {
		return (indice == 0);
	}

	// Devuelve el valor del elemento con la mayor prioridad
	public int Primero() {
		return elementos[indice - 1].valor;
	}

	// Devuelve la prioridad del elemento con la mayor prioridad
	public int Prioridad() {
		return elementos[indice - 1].prioridad;
	}
}
