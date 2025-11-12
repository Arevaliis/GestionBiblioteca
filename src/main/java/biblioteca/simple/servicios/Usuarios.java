package biblioteca.simple.servicios;

import biblioteca.simple.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa los usuarios de la biblioteca.
 *
 * @author José
 * @version 1.0
 */
public class Usuarios {

    /** Lista que almacena los usuarios. */
    private final List<Usuario> usuarios = new ArrayList<>();

    /**
     * Agrega un nuevo usuario a la biblioteca.
     *
     * @param u Usuario a agregar
     */
    public void alta(Usuario u){ usuarios.add(u); }

    /**
     * Devuelve una copia de la lista con todos los usuarios de la biblioteca, para evitar que se pueda modificar la lista original.
     *
     * @return Copia de la lista con todos los productos
     */
    public List<Usuario> listar() { return new ArrayList<>(usuarios); }

    /**
     * Busca un usuario por su ID
     *
     * @param id ID ingresado
     *
     * @return El ID si encuentra el producto o null si no hay coincidencia alguna
     */
    public Usuario buscarUsuario(int id){
        return usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /** Vacía la lista de usuarios */
    public void vaciarListaUsuarios(){ usuarios.clear(); }

    /**
     * Importa todos los usuarios a la lista vacía
     *
     * @param usuariosCargados Lista con todos los usuarios
     */
    public void cargarTodosLosUsuarios(List<Usuario> usuariosCargados){ usuarios.addAll(usuariosCargados); }
}