package codigo;

public interface ColaPrioridadTDA {
	void inicializarCola();                //sin precondiciones
	void acolarPrioridad(int x, int y);    //cola inicializada
	void Desacolar();                      //cola inicializada y no vacia
	boolean colaVacia();                   //cola inicializada
	int Primero();                         //cola inicializada y no vacia
	int Prioridad();                       //cola inicializada y no vacia

}