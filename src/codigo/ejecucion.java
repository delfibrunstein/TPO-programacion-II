package codigo;

public class ejecucion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		// Se inicializa la cola de prioridad y los conjuntos determinados 
		ColaPrioridad cola = new ColaPrioridad(); 
        cola.inicializarCola();

        Conjunto ConjuntoEmpresa = new Conjunto();
        ConjuntoEmpresa.inicializarConjunto();

        Conjunto ConjuntoParticularCliente = new Conjunto();
        ConjuntoParticularCliente.inicializarConjunto();

        Conjunto ConjuntoParticularNoCliente = new Conjunto();
        ConjuntoParticularNoCliente.inicializarConjunto();

        // Elementos de entrada que representan diferentes tipos de clientes en la cola de prioridad
        int[] elementos = {1, 3, 1, 2, 1, 2, 1, 3, 3, 3, 2, 1, 3, 2, 1, 2, 3, 3, 2, 2, 1, 1};

        // Se acolan los elementos segun su tipo de cliente
        for (int i = 1; i < elementos.length; i++) { //mientras que i sea menor a la longitud de mi array, sigo en el for y voy incrementando en 1  
            cola.acolarPrioridad(i, elementos[i]); 
        }

        // Se atienden los clientes y se almacenan en los conjuntos 
        while (!cola.colaVacia()) {
            int cliente = cola.Primero();
            int tipoCliente = cola.Prioridad();
            switch (tipoCliente) {
                case 1:
                    ConjuntoEmpresa.Agregar(cliente);
                    break;
                case 2:
                    ConjuntoParticularCliente.Agregar(cliente);
                    break;
                case 3:
                    ConjuntoParticularNoCliente.Agregar(cliente);
                    break;
            }
            cola.Desacolar();
        }

        // Se imprime los conjuntos de clientes atendidos según su tipo
        System.out.println("Clientes de tipo Empresa: ");
        imprimirConjunto(ConjuntoEmpresa);
        System.out.println("Clientes de tipo Particular Cliente: ");
        imprimirConjunto(ConjuntoParticularCliente);
        System.out.println("Clientes de tipo Particular No Cliente: ");
        imprimirConjunto(ConjuntoParticularNoCliente);
    }

    // Método para imprimir un conjunto
	public static void imprimirConjunto(Conjunto conjunto) {
	    while (!conjunto.conjuntoVacio()) {
	        int elemento = conjunto.Elegir();
	        System.out.println(elemento);
	        conjunto.Sacar(elemento);
	    }
	}
}
