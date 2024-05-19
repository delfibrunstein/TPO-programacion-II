package codigo;

public class ejecucion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	// Se inicializa la cola de prioridad y los conjuntos determinados 
	ColaPrioridad cola = new ColaPrioridad();
        cola.inicializarCola();

        Conjunto ConjuntoEmpresa = new Conjunto();             //prioridad 1
        ConjuntoEmpresa.inicializarConjunto();

        Conjunto ConjuntoParticularCliente = new Conjunto();   //prioridad 2
        ConjuntoParticularCliente.inicializarConjunto();

        Conjunto ConjuntoParticularNoCliente = new Conjunto(); //prioridad 3
        ConjuntoParticularNoCliente.inicializarConjunto();

        // Elementos de entrada que representan diferentes tipos de clientes en la cola de prioridad
        int[] elementos = {1, 3, 1, 2, 1, 2, 1, 3, 3, 3, 2, 1, 3, 2, 1, 2, 3, 3, 2, 2, 1, 1};

        // Se acolan los elementos segun su tipo de cliente
        for (int i = 1; i < elementos.length; i++) {  //length nos indica el tamaño del arreglo (cantidad de nros que contiene)
            cola.acolarPrioridad(i, elementos[i]);    //i es el cliente (arranca en 1) y elementos[i] es su prioridad asociada
        }

        // Se atienden los clientes (teniendo mayor prioridad los tipos de cliente 1 y menor los tipos de clientes 3)
	//y se almacenan en los conjuntos 
        while (!cola.colaVacia()) {
            int cliente = cola.Primero();
            int tipoCliente = cola.Prioridad();
            switch (tipoCliente) {
                case 1:
                    ConjuntoEmpresa.Agregar(cliente);             //si el tipo de cliente es 1
                    break;
                case 2:
                    ConjuntoParticularCliente.Agregar(cliente);   //si el tipo de cliente es 2
                    break;
                case 3:
                    ConjuntoParticularNoCliente.Agregar(cliente); //si el tipo de cliente es 3
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
