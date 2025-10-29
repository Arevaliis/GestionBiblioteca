package biblioteca.simple.app;

import biblioteca.simple.contratos.Prestable;
import biblioteca.simple.modelo.*;
import biblioteca.simple.servicios.Catalogo;
import biblioteca.simple.servicios.Input;
import biblioteca.simple.servicios.Mensajes;

import javax.swing.*;
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
    private static final List<Usuario> usuarios = new ArrayList<>();

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
        // Libros
        catalogo.alta(new Libro(1, "1984", "1949", FORMATO.DIGITAL, "George Orwell", "9780451524935"));
        catalogo.alta(new Libro(2, "El Hobbit", "1937", FORMATO.FISICO, "J.R.R. Tolkien", "9780261102217"));
        catalogo.alta(new Libro(3, "Cien años de soledad", "1967", FORMATO.FISICO, "Gabriel García Márquez", "9780307474728"));
        catalogo.alta(new Libro(4, "Don Quijote de la Mancha", "1605", FORMATO.DIGITAL, "Miguel de Cervantes", "9788491050067"));
        catalogo.alta(new Libro(5, "Fahrenheit 451", "1953", FORMATO.FISICO, "Ray Bradbury", "9781451673319"));

        // Películas
        catalogo.alta(new Pelicula(6, "Inception", "2010", FORMATO.DIGITAL, 148, "Christopher Nolan"));
        catalogo.alta(new Pelicula(7, "El Padrino", "1972", FORMATO.FISICO, 175, "Francis Ford Coppola"));
        catalogo.alta(new Pelicula(8, "Matrix", "1999", FORMATO.DIGITAL, 136, "Lana y Lilly Wachowski"));
        catalogo.alta(new Pelicula(9, "Parásitos", "2019", FORMATO.FISICO, 132, "Bong Joon-ho"));
        catalogo.alta(new Pelicula(10, "Interstellar", "2014", FORMATO.DIGITAL, 169, "Christopher Nolan"));

        // Videojuegos
        catalogo.alta(new Videojuego(11, "The Legend of Zelda: Tears of the Kingdom", "2023", FORMATO.FISICO, "Nintendo Switch", "Aventura"));
        catalogo.alta(new Videojuego(12, "God of War: Ragnarök", "2022", FORMATO.DIGITAL, "PS5", "Acción"));
        catalogo.alta(new Videojuego(13, "Starfield", "2023", FORMATO.DIGITAL, "Xbox Series X", "Rol"));
        catalogo.alta(new Videojuego(14, "Hollow Knight", "2017", FORMATO.DIGITAL, "PC", "Plataformas"));
        catalogo.alta(new Videojuego(15, "Pokémon Escarlata", "2022", FORMATO.FISICO, "Nintendo Switch", "Rol"));

        // Usuarios
        new Usuario(1, "Ana López");
        new Usuario(2, "Carlos Pérez");
        new Usuario(3, "María Gómez");
        new Usuario(4, "Juan Rodríguez");
        new Usuario(5, "Lucía Fernández");
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
        }while (opc != 6 && opc != -1);
    }

    /**
     * El programa ejecuta la opción seleccionada por el usuario.
     *
     * @param opc Opción ingresada por el usuario
     */
    private static void ejecutarOpcion(int opc){
        switch (opc){
            case 1 -> listar();
            case 2 -> buscarPorTitulo();
            case 3 -> buscarPorAnyo();
            case 4 -> prestar();
            case 5 -> devolver();
            case -1 , 6 -> JOptionPane.showMessageDialog(null, Mensajes.SALIR, "Salir", JOptionPane.INFORMATION_MESSAGE);

            default -> JOptionPane.showMessageDialog(null, Mensajes.OPCION_FUERA_DE_RANGO, "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra el listado completo de productos registrados en el catálogo
     */
    private static void listar(){
        List<Producto> lista = catalogo.listar();
        mostrar(lista);
    }

    /**
     * Muestra los productos cuyo título contiene la palabra ingresada por el usuario.
     */
    private static void buscarPorTitulo() {
        String titulo = Input.ingresarTitulo();
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
     *
     */
    private static void prestar() {
        List<Producto> productosDisponibles = catalogo.listar().stream()
                .filter(p -> p instanceof Prestable nuevoProducto && !nuevoProducto.estaPrestado())
                .toList();
    }

    /**
     *
     */
    private static void devolver() {
        System.out.println();
    }

    /**
     * Crea una nueva lista que contiene la descripción de cada producto. Después la muestra en una ventana emergente.
     * Si la lista está vacía se lanzará una excepción {@link IllegalStateException}.
     *
     * @param productos Lista con los productos a mostrar
     * @throws IllegalStateException Si el título ingresado por el usuario no coincide con el título de algún producto
     */
    public static void mostrar(List<Producto> productos){

        if (productos.isEmpty()) throw new IllegalStateException(Mensajes.ERROR_SIN_RESULTADOS);

        List<String> frases = productos.stream()
                                        .map(p -> (productos.indexOf(p) + 1 )+ ". " +  p.toString())
                                        .toList();

        JOptionPane.showMessageDialog(null, String.join("\n", frases), "Prestamos Registrados", JOptionPane.INFORMATION_MESSAGE);
    }
}