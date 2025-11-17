package biblioteca.simple.modelo;

import java.util.Objects;

/**
 * Clase abstracta que representa un producto
 *
 * @author José
 * @version 1.0
 */
public abstract class Producto {
    protected int id;
    protected String titulo;
    protected String anyo;
    protected FORMATO formato;

    /**
     * Constructor que recibe el título, el año y el formato del producto.
     *
     * <p>
     * Este constructor se usa al crear un nuevo producto antes de asignarle un ID.
     * </p>
     *
     * @param titulo  Título del producto
     * @param anyo    Año de lanzamiento o publicación del producto
     * @param formato Formato del producto (DIGITAL o FISICO)
     */
    protected Producto(String titulo, String anyo, FORMATO formato) {
        this.titulo = titulo;
        this.anyo = anyo;
        this.formato = formato;
    }

    /**
     * Constructor que recibe el ID, el título, el año y el formato del producto.
     *
     * <p>
     * Se utiliza para instanciar un producto ya existente en la base de datos, con su ID asignado.
     * </p>
     *
     * @param id      ID asignado al producto en la base de datos
     * @param titulo  Título del producto
     * @param anyo    Año de lanzamiento o publicación del producto
     * @param formato Formato del producto (DIGITAL o FISICO)
     */
    protected Producto(int id, String titulo, String anyo, FORMATO formato) {
        this.id = id;
        this.titulo = titulo;
        this.anyo = anyo;
        this.formato = formato;
    }

    /** Devuelve el ID del producto */
    public int getId() { return id; }

    /** Devuelve el título del producto */
    public String getTitulo() { return titulo; }

    /** Devuelve el año del producto */
    public String getAnyo() { return anyo; }

    /** Devuelve el tipo del producto */
    public abstract String getTipo();

    /** Devuelve el formato del producto */
    public FORMATO getFormato() { return formato; }

    /**
     * Devuelve una representación en cadena de texto del producto.
     *
     * @return Cadena de texto que muestra la información del producto
     */
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anyo='" + anyo + '\'' +
                ", formato=" + formato +
                '}';
    }

    /**
     * Compara si dos instancias de la clase Producto son iguales.
     * Dos productos se consideran iguales si tienen el mismo id.
     *
     * @param o Objeto a comparar
     * @return True si son la misma instancia, False en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id;
    }

    /**
     * Calcula el código hash del producto.
     *
     * @return Código hash correspondiente al ID del producto.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}