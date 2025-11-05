package biblioteca.simple.modelo;

/**
 * Clase que representa un Usuario dentro del sistema de gestión de una biblioteca
 *
 * @author José
 * @version 1.0
 */
public class Usuario {
    private int id;
    private String nombre;

    /**
     * Constructor que recibe únicamente el nombre del usuario.
     *
     * <p>
     * Este constructor se usa al dar de alta un nuevo usuario en la base de datos.
     * El sistema gestor de la base de datos se encargará de asignarle un ID automáticamente.
     * </p>
     *
     * @param nombre nombre del usuario
     */
    public Usuario(String nombre){
        this.nombre = nombre;
    }

    /**
     * Constructor que recibe el ID y el nombre del usuario.
     *
     * <p>
     * Se utiliza para instanciar un usuario ya existente en la base de datos, con su ID asignado.
     * </p>
     *
     * @param id     ID asignado por la base de datos
     * @param nombre nombre almacenado en la base de datos
     */
    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /** Devuelve el nombre del usuario */
    public String getNombre() { return nombre; }

    /** Devuelve el ID del usuario */
    public int getId() { return id; }

    /**
     * Actualiza el nombre del usuario al nuevo nombre ingresado
     *
     * @param nombre Nuevo nombre del usuario
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Devuelve una representación en cadena de texto del Usuario.
     *
     * @return Cadena de texto que muestra la información del Usuario
     */
    @Override
    public String toString() {
        return "ID: " + id +
                " | Nombre: " + nombre;
    }
}