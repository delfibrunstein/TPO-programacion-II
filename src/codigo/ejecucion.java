package codigo;
import java.util.Scanner;

public class ejecucion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//Se inicializa el Scanner
	Scanner sc = new Scanner(System.in);
	
	// Se inicializa la cola de prioridad y los conjuntos determinados 
	ColaPrioridad cola = new ColaPrioridad();
        cola.inicializarCola();

        Conjunto ConjuntoEmpresa = new Conjunto();             //prioridad 1
        ConjuntoEmpresa.inicializarConjunto();

        Conjunto ConjuntoParticularCliente = new Conjunto();   //prioridad 2
        ConjuntoParticularCliente.inicializarConjunto();

        Conjunto ConjuntoParticularNoCliente = new Conjunto(); //prioridad 3
        ConjuntoParticularNoCliente.inicializarConjunto();
        
        // Se guardan en la cola prioridad el DNI del cliente con la prioridad asociadada
        for(int i = 0; i < 16; i ++) {
	    System.out.println("Ingrese el DNI del cliente: ");
            int dni = sc.nextInt();
            
            System.out.println("Ingrese el tipo de cliente siendo 1- Empresa, 2- Particular Cliente y 3- Particular No Cliente: ");
            int tipoCliente = sc.nextInt();
            
            cola.acolarPrioridad(dni, tipoCliente);
        }
	sc.close();
		
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
