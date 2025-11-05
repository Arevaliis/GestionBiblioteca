package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

/**
 * Clase que representa un videojuego dentro del sistema.
 *
 * <p>
 * Hereda de {@link Producto} e implementa la interfaz {@link Prestable}.
 * </p>
 *
 * @author José
 * @version 1.0
 */
public class Videojuego extends Producto implements Prestable {

    private String plataforma;
    private String genero;
    private boolean prestado;
    private Usuario prestadoA;

    /**
     * Constructor que recibe título, año, formato, plataforma y género del videojuego.
     *
     * <p>
     * Este constructor se usa al crear un nuevo videojuego antes de asignarle un ID.
     * </p>
     *
     * @param titulo     Título del videojuego
     * @param anyo       Año de lanzamiento del videojuego
     * @param formato    Formato del videojuego (DIGITAL o FISICO)
     * @param plataforma Plataforma en la que se puede jugar el videojuego
     * @param genero     Género del videojuego
     */
    public Videojuego(String titulo, String anyo, FORMATO formato, String plataforma, String genero) {
        super(titulo, anyo, formato);
        this.plataforma = plataforma;
        this.genero = genero;
    }

    /**
     * Constructor que recibe ID, título, año, formato, plataforma y género del videojuego.
     *
     * <p>
     * Se utiliza para instanciar un videojuego ya existente en la base de datos, con su ID asignado.
     * </p>
     *
     * @param id         ID asignado al videojuego en la base de datos
     * @param titulo     Título del videojuego
     * @param anyo       Año de lanzamiento del videojuego
     * @param formato    Formato del videojuego (DIGITAL o FISICO)
     * @param plataforma Plataforma en la que se puede jugar el videojuego
     * @param genero     Género del videojuego
     */
    public Videojuego(int id, String titulo, String anyo, FORMATO formato, String plataforma, String genero) {
        super(id, titulo, anyo, formato);
        this.plataforma = plataforma;
        this.genero = genero;
    }

    /** Devuelve la plataforma del videojuego */
    public String getPlataforma() {
        return plataforma;
    }

    /** Devuelve el género del videojuego */
    public String getGenero() {
        return genero;
    }

    /**
     * Presta el videojuego a un usuario.
     *
     * <p>
     * Si el videojuego ya se encuentra prestado, se lanzará una excepción {@link IllegalStateException}.
     * </p>
     *
     * @param usuario Usuario al que se le presta el videojuego
     * @throws IllegalStateException si el videojuego ya está prestado
     */
    @Override
    public void prestar(Usuario usuario) {
        if (prestado) throw new IllegalStateException("Libro ya prestado.");

        this.prestado = true;
        this.prestadoA = usuario;
    }

    /**
     * Devuelve un videojuego prestado. Cambia el estado de prestado a False y prestadoA a null.
     */
    @Override
    public void devolver() {
        if (!prestado) throw new IllegalStateException("Película no está prestada.");

        this.prestado = false;
        this.prestadoA = null;

    }

    /**
     * Indica si el videojuego se encuentra actualmente prestado.
     *
     * @return True si está prestado, False si no.
     */
    @Override
    public boolean estaPrestado(){return this.prestado; }

    /**
     * Devuelve una representación en cadena de texto del videojuego.
     *
     * @return Cadena de texto que muestra la información del videojuego.
     */
    @Override
    public String toString() {
        return "ID: " + id +
                " | Título: " + titulo +
                " | Plataforma: " + plataforma +
                " | Género: " + genero +
                " | Año: " + anyo +
                " | Formato: " + formato;
    }
}
