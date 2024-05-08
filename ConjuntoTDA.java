package codigo;

public interface ConjuntoTDA {
	void inicializarConjunto();  //sin precondiciones
	void Agregar(int x);       	 //conjunto inicializado
	int Elegir ();               //conjunto inicializado y no vacio
	boolean ConjuntoVacio();     //conjunto inicializado
	boolean Pertenece(int x);    //conjunto inicializado y no vacio
	void Sacar(int x);  		 //conjunto inicializado y no vacio
}
