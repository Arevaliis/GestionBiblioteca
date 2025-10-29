package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

/**
 * Clase que representa una película dentro del sistema.
 *
 * <p>
 * Hereda de {@link Producto} e implementa la interfaz {@link Prestable}.
 * </p>
 *
 * @author José
 * @version 1.0
 */
public class Pelicula extends Producto implements Prestable {

    private String director;
    private int minutosDuracion;
    private boolean prestado;
    private Usuario prestadoA;

    /**
     * Constructor que recibe título, año, formato, duración y director de la película.
     *
     * <p>
     * Este constructor se usa al crear una nueva película antes de asignarle un ID.
     * </p>
     *
     * @param titulo            Título de la película
     * @param anyo              Año de estreno de la película
     * @param formato           Formato de la película (DIGITAL o FISICO)
     * @param minutosDuracion   Duración de la película en minutos
     * @param director          Nombre del director de la película
     */
    public Pelicula(String titulo, String anyo, FORMATO formato, int minutosDuracion, String director) {
        super(titulo, anyo, formato);
        this.minutosDuracion = minutosDuracion;
        this.director = director;
    }

    /**
     * Constructor que recibe ID, título, año, formato, duración y director de la película.
     *
     * <p>
     * Se utiliza para instanciar una película ya existente en la base de datos, con su ID asignado.
     * </p>
     *
     * @param id                ID asignado a la película en la base de datos
     * @param titulo            Título de la película
     * @param anyo              Año de estreno de la película
     * @param formato           Formato de la película (DIGITAL o FISICO)
     * @param minutosDuracion   Duración de la película en minutos
     * @param director          Nombre del director de la película
     */
    public Pelicula(int id, String titulo, String anyo, FORMATO formato, int minutosDuracion, String director) {
        super(id, titulo, anyo, formato);
        this.minutosDuracion = minutosDuracion;
        this.director = director;
    }

    /** Devuelve el director de la película */
    public String getDirector() { return director; }

    /** Devuelve los minutos de duración de la película */
    public int getMinutosDuracion() { return minutosDuracion; }

    /**
     * Presta la película a un usuario.
     *
     * <p>
     * Si la película ya se encuentra prestado, se lanzará una excepción {@link IllegalStateException}.
     * </p>
     *
     * @param usuario Usuario al que se le presta la película
     * @throws IllegalStateException si la película ya está prestado
     */
    @Override
    public void prestar(Usuario usuario) {
        if (prestado) throw new IllegalStateException("Película ya prestada.");

        this.prestado = true;
        this.prestadoA = usuario;
    }

    /**
     * Devuelve una película prestada. Cambia el estado de prestado a False y prestadoA a null.
     */
    @Override
    public void devolver() {

        this.prestado = false;
        this.prestadoA = null;

    }

    /**
     * Indica si la película se encuentra actualmente prestado.
     *
     * @return True si está prestado, False si no.
     */
    @Override
    public boolean estaPrestado(){return this.prestado; }

    /**
     * Devuelve una representación en cadena de texto de la película.
     *
     * @return Cadena de texto que muestra la información de la película.
     */
    @Override
    public String toString() {
        return "Pelicula{" +
                "director='" + director + '\'' +
                ", minutosDuracion=" + minutosDuracion +
                ", formato=" + formato +
                ", anyo='" + anyo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", id=" + id +
                '}';
    }
}
