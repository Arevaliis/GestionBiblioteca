package biblioteca.simple.contratos;

import biblioteca.simple.modelo.Usuario;

/**
 * Interfaz que define el comportamiento de un objeto que puede ser prestado a un usuario.
 *
 * @author José
 * @version 1.0
 */
public interface Prestable {

    /**
     * Presta un objeto a un usuario.
     *
     * @param usuario Usuario al que se le presta el objeto.
     */
    void prestar(Usuario usuario);

    /**
     * Modifica el estado del objeto ha devuelto
     */
    void devolver();

    /**
     * Indica si el objeto se encuentra prestado.
     *
     * @return True sí está prestado, False si no.
     */
    boolean estaPrestado();
}