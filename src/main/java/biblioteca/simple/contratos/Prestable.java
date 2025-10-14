package biblioteca.simple.contratos;

import biblioteca.simple.modelo.Usuario;

public interface Prestable {

    void prestar(Usuario usuario);
    void devolver();

    boolean estaPrestado();
}
