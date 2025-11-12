package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

/**
 * Clase que representa un libro dentro del sistema.
 *
 * <p>
 * Hereda de {@link Producto} e implementa la interfaz {@link Prestable}.
 * </p>
 *
 * @author José
 * @version 1.0
 */
public class Libro extends Producto implements Prestable {
    private String tipo = "Libro";
    private String autor;
    private String isbn;
    private boolean prestado;
    private Usuario prestadoA;

    /**
     * Constructor que recibe el ID, título, año, formato, autor e ISBN del libro.
     *
     * <p>
     * Se utiliza para instanciar un libro ya existente en la base de datos, con su ID asignado.
     * </p>
     *
     * @param id      ID asignado al libro en la base de datos
     * @param titulo  Título del libro
     * @param anyo    Año de publicación del libro
     * @param formato Formato del libro (DIGITAL o FISICO)
     * @param autor   Nombre del autor del libro
     * @param isbn    Código ISBN del libro
     */
    public Libro(int id, String titulo, String anyo, FORMATO formato, String autor, String isbn) {
        super(id, titulo, anyo, formato);
        this.autor = autor;
        this.isbn = isbn;
    }

    /**
     * Constructor que recibe título, año, formato, autor e ISBN del libro.
     *
     * <p>
     * Este constructor se usa al dar de alta un nuevo libro en la base de datos. El sistema gestor
     * de la base de datos se encargará de asignarle un ID automáticamente.
     * </p>
     *
     * @param titulo  Título del libro
     * @param anyo    Año de publicación del libro
     * @param formato Formato del libro (DIGITAL o FISICO)
     * @param autor   Nombre del autor del libro
     * @param isbn    Código ISBN del libro
     */
    public Libro(String titulo, String anyo, FORMATO formato, String autor, String isbn) {
        super(titulo, anyo, formato);
        this.autor = autor;
        this.isbn = isbn;
    }

    /** Devuelve el autor del libro */
    public String getAutor() { return autor; }

    /** Devuelve el ISBN del libro */
    public String getIsbn() { return isbn; }

    /** Devuelve el tipo del libro */
    @Override
    public String getTipo() { return tipo; }

    /**
     * Presta el libro a un usuario.
     *
     * <p>
     * Si el libro ya se encuentra prestado, se lanzará una excepción {@link IllegalStateException}.
     * </p>
     *
     * @param usuario Usuario al que se le presta el libro
     * @throws IllegalStateException si el libro ya está prestado
     */
    @Override
    public void prestar(Usuario usuario) {
        if (prestado) throw new IllegalStateException("Libro ya prestado.");

        this.prestado = true;
        this.prestadoA = usuario;
    }

    /**
     * Devuelve un libro prestado. Cambia el estado de prestado a False y prestadoA a null.
     */
    @Override
    public void devolver() {
        if (!prestado) throw new IllegalStateException("Película no está prestada.");

        this.prestado = false;
        this.prestadoA = null;

    }

    /**
     * Indica si el libro se encuentra actualmente prestado.
     *
     * @return True si está prestado, False si no.
     */
    @Override
    public boolean estaPrestado(){return this.prestado; }

    /**
     * Devuelve una representación en cadena de texto del libro.
     *
     * @return Cadena de texto que muestra la información del libro
     */
    @Override
    public String toString() {
        return "ID: " + id +
                " | Título: " + titulo +
                " | Autor: " + autor +
                " | Año: " + anyo +
                " | ISBN: " + isbn +
                " | Formato: " + formato;
    }
}
