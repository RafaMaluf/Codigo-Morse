package morse;

class Nodo {
    char simbolo;      
    Nodo esquerdo;          
    Nodo direito;          

    Nodo() {
        this.simbolo = '\0';
        this.esquerdo = null;
        this.direito = null;
    }
}