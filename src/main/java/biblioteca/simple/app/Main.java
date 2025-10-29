package biblioteca.simple.app;

import biblioteca.simple.contratos.Prestable;
import biblioteca.simple.modelo.*;
import biblioteca.simple.servicios.Catalogo;
import biblioteca.simple.servicios.Mensajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Catalogo catalogo = new Catalogo();
    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatos();
        menu();
    }

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

        // Usuarios
        new Usuario(1, "Ana López");
        new Usuario(2, "Carlos Pérez");
        new Usuario(3, "María Gómez");
        new Usuario(4, "Juan Rodríguez");
        new Usuario(5, "Lucía Fernández");
    }

    private static void menu() {
        int opc;

        do {
            System.out.println(Mensajes.MENU_PRINCIPAL);
            System.out.print("Elije una opcion: ");
            while (!scanner.hasNextInt()) scanner.next();

            opc = scanner.nextInt();
            scanner.next();

            switch (opc){
                case 1 -> listar();
                case 2 -> buscarPorTitulo();
                case 3 -> buscarPorAnyo();
                case 4 -> prestar();
                case 5 -> devolver();
                case 6 -> System.out.println("Saliendo...");

                default -> System.out.println(Mensajes.OPCION_FUERA_DE_RANGO);
            }

        }while (opc != 6);
    }

    private static void listar(){
        List<Producto> lista = catalogo.listar();

        if (lista.isEmpty()) {
            System.out.println("Catalogo vacio");
            return;
        }

        lista.forEach(p -> System.out.println("- " + p));
    }

    private static void buscarPorTitulo() {
        System.out.print("Ingrese el titulo: ");
        String titulo = scanner.nextLine();

        catalogo.buscar(titulo).forEach(p -> System.out.println("- " + p));
    }

    private static void buscarPorAnyo() {
        System.out.print("Ingrese el año: ");
        int anyo = Integer.parseInt(scanner.nextLine());

        catalogo.buscar(anyo).forEach(p -> System.out.println("- " + p));
    }

    private static void prestar() {
        List<Producto> productosDisponibles = catalogo.listar().stream()
                .filter(p -> p instanceof Prestable nuevoProducto && !nuevoProducto.estaPrestado())
                .toList();
    }

    private static void devolver() {
        System.out.println();
    }
}



    /*
    private static void menu2() {
        do {
            try {
                int opc = Input.elegir_opcion(Mensajes.MENU_PRINCIPAL, "Menu");

                if (opc == 6 || opc == -1){
                    JOptionPane.showMessageDialog(null, "Saliendo...", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                ejecutarOpcionElegida(opc, catalogo);

            }catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, Mensajes.ERROR_DATO_NO_VALIDO, "Error", JOptionPane.ERROR_MESSAGE );
            }

        }while (Input.seguirEjecutando(Mensajes.VOLVER_MENU));
    }
    public static void ejecutarOpcionElegida(int opc, Catalogo catalogo){
        switch (opc){
            case 1 -> catalogo.mostrar(catalogo.listar());
            case 2 -> catalogo.mostrar(catalogo.buscar(Input.ingresarTitulo()));
            case 3 -> catalogo.mostrar(catalogo.buscar(Input.ingresarAnyo()));
            case 4 -> System.out.println("Prestar");
            case 5 -> System.out.println("Devolver");

            default -> JOptionPane.showMessageDialog(null, Mensajes.OPCION_FUERA_DE_RANGO, "Error", JOptionPane.ERROR_MESSAGE );
        }
    }
    */
