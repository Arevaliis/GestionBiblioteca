package biblioteca.simple.app;

import biblioteca.simple.contratos.Prestable;
import biblioteca.simple.modelo.*;
import biblioteca.simple.servicios.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal donde se ejecuta el programa. El programa no parará su ejecución hasta que el
 * usuario decida salir.
 *
 * @author José
 * @version 1.0
 */
public class Main {
    private static final Catalogo catalogo = new Catalogo();
    private static final Usuarios usuarios = new Usuarios();

    /**
     * Metodo principal del programa, se encarga de cargar los datos dentro del catálogo y mantiene la
     * ejecución del programa hasta que el usuario decida salir.
     */
    public static void main(String[] args) {
        cargarDatos();
        menu();
    }

    /**
     * Carga inicial de datos del catálogo contiene libros, películas, videojuegos y usuario.
     */
    private static void cargarDatos(){
        importarProductos(false);
        importarUsuarios(false);
    }

    /**
     * Muestra por pantalla el menu de gestión de la biblioteca con las diferentes opciones que puede
     * seleccionar el usuario, y además, solicita el ingreso de una de las opciones. En caso de que el
     * usuario ingrese un valor fuera de rango o no numérico aparece un mensaje de error.
     */
    private static void menu() {
        int opc = 0;

        do {
            try{

                opc = Input.elegir_opcion(Mensajes.MENU_PRINCIPAL, "Menu");
                ejecutarOpcion(opc);

            }catch (IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, Mensajes.ERROR_DATO_NO_VALIDO, "Error", JOptionPane.ERROR_MESSAGE );

            }catch (IllegalStateException e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );

            }catch (NullPointerException _){}

        }while (opc != 0 && opc != -1);
    }

    /**
     * El programa ejecuta la opción seleccionada por el usuario.
     *
     * @param opc Opción ingresada por el usuario
     */
    private static void ejecutarOpcion(int opc){
        switch (opc){
            case 1 -> listarProductos();
            case 2 -> buscarPorTitulo();
            case 3 -> buscarPorAnyo();
            case 4 -> prestar();
            case 5 -> devolver();
            case 6 -> altaUsuario();
            case 7 -> exportarUsuario();
            case 8 -> importarUsuarios(true);
            case 9 -> exportarProductos();
            case 10 -> importarProductos(true);

            case -1 , 0 -> JOptionPane.showMessageDialog(null, Mensajes.SALIR, "Salir", JOptionPane.INFORMATION_MESSAGE);

            default -> JOptionPane.showMessageDialog(null, Mensajes.OPCION_FUERA_DE_RANGO, "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra el listado completo de productos registrados en el catálogo
     */
    private static void listarProductos(){
        List<Producto> lista = catalogo.listar();
        mostrar(lista);
    }

    /**
     * Muestra los productos cuyo título contiene la palabra ingresada por el usuario.
     */
    private static void buscarPorTitulo() {
        String titulo = Input.ingresarTexto(Mensajes.INGRESAR_TITULO_BUSQUEDA, Mensajes.TITULO_BUSCAR_TITULO);
        List<Producto> lista = catalogo.buscar(titulo);
        mostrar(lista);
    }

    /**
     * Muestra los productos cuyo año coincide con el año ingresado por el usuario.
     */
    private static void buscarPorAnyo() {
        int anyo = Input.ingresarAnyo();
        List<Producto> lista = catalogo.buscar(anyo);
        mostrar(lista);
    }

    /**
     * Permite realizar un préstamo de un producto a un usuario.
     */
    private static void prestar() {
        List<Producto> productosDisponibles = catalogo.buscarProductosDisponibles();

        // PRODUCTO
        int id = Input.ingresarId(crearMensaje(productosDisponibles), Mensajes.INGRESAR_ID_PRODUCTO, Mensajes.TITULO_RESERVAR_PRODUCTO);
        Producto pEncontrado = catalogo.buscarProductoId(id);

        if (pEncontrado == null){ throw new IllegalStateException(Mensajes.ID_NO_ENCONTRADO); }

        // USUARIO
        List<Usuario> u = usuarios.listar();

        int idUsuario = Input.ingresarId(crearMensaje(u), Mensajes.INGRESAR_ID_USUARIO, Mensajes.TITULO_RESERVAR_PRODUCTO);
        Usuario uEncontrado = usuarios.buscarUsuario(idUsuario);

        if (uEncontrado == null){
            JOptionPane.showMessageDialog(null, Mensajes.ID_NO_ENCONTRADO, Mensajes.TITULO_RESERVAR_PRODUCTO, JOptionPane.WARNING_MESSAGE);

            if (Input.confirmarAgregarNuevoUsuario()){ altaUsuario(); }
            return;
        }

        // PRÉSTAMO
        Prestable p =  (Prestable) pEncontrado;
        p.prestar(uEncontrado);

        JOptionPane.showMessageDialog(null, Mensajes.PRESTAMO_EXITO, "Préstamo Realizado", JOptionPane.INFORMATION_MESSAGE );

    }

    /**
     * Permite realizar una devolución de un producto.
     */
    private static void devolver() {
        List<Producto> productosPrestados = catalogo.buscarProductosReservados();

        // PRODUCTO
        int id = Input.ingresarId(crearMensaje(productosPrestados), Mensajes.INGRESAR_ID_PRODUCTO, Mensajes.TITULO_RESERVAR_PRODUCTO);
        Producto pEncontrado = catalogo.buscarProductoId(id);

        if (pEncontrado == null){ throw new IllegalStateException(Mensajes.ID_NO_ENCONTRADO); }

        // DEVOLUCIÓN
        Prestable p =  (Prestable) pEncontrado;
        p.devolver();

        JOptionPane.showMessageDialog(null, Mensajes.DEVOLUCION_EXITO, Mensajes.DEVOLUCION_EXITO, JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Permite crear un nuevo usuario
     */
    private static void altaUsuario(){
        int id = usuarios.listar().size() + 1;
        String nombre = Input.ingresarTexto(Mensajes.INGRESAR_NOMBRE_USUARIO, Mensajes.TITULO_ALTA_USUARIO);

        usuarios.alta(new Usuario(id, nombre));
    }

    /**
     * Muestra una lista de productos o usuarios en una ventana emergente.
     *
     * @param lista Lista con los elementos a mostrar
     * @param <T> Tipo de los elementos contenidos en la lista (Producto o Usuario)
     */
    public static <T> void mostrar(List<T> lista){

        List<String> mensaje = crearMensaje(lista);

        JOptionPane.showMessageDialog(null, String.join("\n", mensaje), "Prestamos Registrados", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Crea una lista que contiene la descripción de cada elemento a mostrar. Si la lista está vacía se lanzará una excepción {@link IllegalStateException}.
     *
     * @param lista Lista con los elementos a mostrar
     * @param <T> Tipo de los elementos contenidos en la lista (Producto o Usuario)
     *
     * @throws IllegalStateException Si no hay elementos que mostrar
     *
     * @return Lista con la descripción de cada elemento
     */
    public static <T> List<String> crearMensaje(List<T> lista){
        if (lista.isEmpty()) throw new IllegalStateException(Mensajes.ERROR_SIN_RESULTADOS);

        return lista.stream().map(Object::toString).toList();
    }

    /**
     * Exporta la lista actual de usuarios a un archivo .json
     */
    private static void exportarUsuario(){
        try {

            PersistenciaUsuario.exportar(usuarios.listar());

            JOptionPane.showMessageDialog(null, Mensajes.EXPORTACION_USUARIOS_EXITO, "Importación Usuarios", JOptionPane.INFORMATION_MESSAGE );

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, Mensajes.ERROR_EXPORTACION_USUARIOS,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Importa los usuarios desde un archivo .json
     */
    private static void importarUsuarios(boolean mostrarMensaje){
        try {

            List<Usuario> usuariosCargados = PersistenciaUsuario.importar();
            usuarios.vaciarListaUsuarios();
            usuarios.cargarTodosLosUsuarios(usuariosCargados);

            if (mostrarMensaje) {
                JOptionPane.showMessageDialog(null, Mensajes.IMPORTACION_USUARIOS_EXITO, "Importación Usuarios", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, Mensajes.ERROR_IMPORTACION_USUARIOS,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Exporta la lista actual de productos a un archivo .json
     */
    private static void exportarProductos(){
        try {
            PersistenciaProducto.exportar(catalogo.listar());
            JOptionPane.showMessageDialog(null, Mensajes.EXPORTACION_PRODUCTOS_EXITO, "Exportar Productos", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, Mensajes.ERROR_EXPORTACION_PRODUCTOS, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Importa los productos desde un archivo json
     */
    private static void importarProductos(boolean mostrarMensaje) {
        try {

            JsonArray array = PersistenciaProducto.importar();

            if (array.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Archivo json vacío", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<Producto> productos = new ArrayList<>();

            for (JsonElement element : array) {
                JsonObject object = element.getAsJsonObject();

                String tipo = object.get("tipo").getAsString();
                int id = object.get("id").getAsInt();
                String titulo = object.get("titulo").getAsString();
                String anyo = object.get("anyo").getAsString();
                FORMATO formato = FORMATO.valueOf(object.get("formato").getAsString());

                switch (tipo) {
                    case "Libro" -> productos.add(new Libro(id, titulo, anyo, formato, object.get("autor").getAsString(), object.get("isbn").getAsString()));
                    case "Pelicula" -> productos.add(new Pelicula(id, titulo, anyo, formato, object.get("minutosDuracion").getAsInt(), object.get("director").getAsString()));
                    case "Videojuego" -> productos.add(new Videojuego(id, titulo, anyo, formato, object.get("plataforma").getAsString(), object.get("genero").getAsString()));
                }
            }

            catalogo.vaciarListaProductos();
            catalogo.cargarTodosLosProductos(productos);

            if (mostrarMensaje){
                JOptionPane.showMessageDialog(null, Mensajes.IMPORTACION_PRODUCTOS_EXITO, "Importar Productos", JOptionPane.INFORMATION_MESSAGE);
            }


        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, Mensajes.ERROR_IMPORTACION_PRODUCTOS, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}