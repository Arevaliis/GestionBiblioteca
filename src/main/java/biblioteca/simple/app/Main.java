package biblioteca.simple.app;

import biblioteca.simple.modelo.*;
import biblioteca.simple.servicios.Catalogo;
import biblioteca.simple.servicios.Input;
import biblioteca.simple.servicios.Mensajes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Catalogo c = new Catalogo();
        List<Usuario> usuarios = new ArrayList<>(List.of(
                new Usuario(1, "Ana López"),
                new Usuario(2, "Carlos Pérez"),
                new Usuario(3, "María Gómez"),
                new Usuario(4, "Juan Rodríguez"),
                new Usuario(5, "Lucía Fernández")
                )
        );

        // Libros
        c.alta(new Libro(1, "1984", "1949", FORMATO.DIGITAL, "George Orwell", "9780451524935"));
        c.alta(new Libro(2, "El Hobbit", "1937", FORMATO.FISICO, "J.R.R. Tolkien", "9780261102217"));
        c.alta(new Libro(3, "Cien años de soledad", "1967", FORMATO.FISICO, "Gabriel García Márquez", "9780307474728"));
        c.alta(new Libro(4, "Don Quijote de la Mancha", "1605", FORMATO.DIGITAL, "Miguel de Cervantes", "9788491050067"));
        c.alta(new Libro(5, "Fahrenheit 451", "1953", FORMATO.FISICO, "Ray Bradbury", "9781451673319"));

        // Películas
        c.alta(new Pelicula(6, "Inception", "2010", FORMATO.DIGITAL, 148, "Christopher Nolan"));
        c.alta(new Pelicula(7, "El Padrino", "1972", FORMATO.FISICO, 175, "Francis Ford Coppola"));
        c.alta(new Pelicula(8, "Matrix", "1999", FORMATO.DIGITAL, 136, "Lana y Lilly Wachowski"));
        c.alta(new Pelicula(9, "Parásitos", "2019", FORMATO.FISICO, 132, "Bong Joon-ho"));
        c.alta(new Pelicula(10, "Interstellar", "2014", FORMATO.DIGITAL, 169, "Christopher Nolan"));

        do {
            try {
                int opc = Input.elegir_opcion(Mensajes.MENU_PRINCIPAL, "Menu");

                if (opc == 6 || opc == -1){
                    JOptionPane.showMessageDialog(null, "Saliendo...", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                ejecutarOpcionElegida(opc, c);

            }catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, Mensajes.ERROR_DATO_NO_VALIDO, "Error", JOptionPane.ERROR_MESSAGE );
            }

        }while (Input.seguirEjecutando(Mensajes.VOLVER_MENU));
    }

    public static void ejecutarOpcionElegida(int opc, Catalogo c){
        switch (opc){
            case 1 -> c.mostrar(c.listar());
            case 2 -> c.mostrar(c.buscar(Input.ingresarTitulo()));
            case 3 -> c.mostrar(c.buscar(Input.ingresarAnyo()));
            case 4 -> System.out.println();
            case 5 -> System.out.println();

            default -> JOptionPane.showMessageDialog(null, Mensajes.OPCION_FUERA_DE_RANGO, "Error", JOptionPane.ERROR_MESSAGE );
        }
    }
}