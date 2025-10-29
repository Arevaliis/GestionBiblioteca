package biblioteca.simple.servicios;

import javax.swing.*;

/**
 * Clase que permite ingresar datos al usuario mediante ventanas emergentes de JOptionPane.
 */
public class Input {

    /**
     * Muestra un cuadro de diálogo para que el usuario elija una opción del menú.
     *
     * @param menu  Menu a mostrar
     * @param titulo Título de la ventana emergente.
     * @return Opción elegida por el usuario, o -1 si el usuario cierra la pestaña clicando la 'X' o usa ESC.
     */
    public static int elegir_opcion(String menu, String titulo) {
        String opc = JOptionPane.showInputDialog(null, menu, titulo, JOptionPane.QUESTION_MESSAGE);

        if (opc != null) return Integer.parseInt(opc);

        return -1;
    }

    /**
     * Muestra un cuadro de diálogo para que el usuario ingrese un título a buscar.Si no ingresa ningún valor
     * se lanzará una excepción {@link IllegalStateException}.
     *
     * @return el título ingresado por el usuario, o cadena vacía {@code ""} si cancela
     * @throws IllegalStateException si el producto es null o está vacío.
     */
    public static String ingresarTitulo() {
        String titulo = JOptionPane.showInputDialog(null, "Ingrese el titulo a buscar: ", "Buscar por Titulo", JOptionPane.QUESTION_MESSAGE);

        if (titulo.isEmpty()) throw new IllegalStateException("Debe ingresar un titulo.");

        return titulo;
    }

    /**
     * Muestra un cuadro de diálogo para que el usuario ingrese un año a buscar. Si no ingresa ningún valor
     * se lanzará una excepción {@link IllegalStateException}.
     *
     * @return el año ingresado convertido a entero, o -1 si el usuario cancela
     * @throws IllegalStateException si el producto es null o está vacía.
     */
    public static int ingresarAnyo() {
        String anyo = JOptionPane.showInputDialog(null, "Ingrese el año a buscar: ", "Buscar por año", JOptionPane.QUESTION_MESSAGE);

        if (anyo.isEmpty()) throw new IllegalStateException("Debe ingresar un año.");

        return Integer.parseInt(anyo);
    }

    /**
     * Muestra un cuadro de diálogo para que el usuario elija el tipo de producto.
     *
     * @return el tipo de producto seleccionado como cadena ("Película", "Libro" o "Videojuegos")
     */
    public static String ingresarTipo() {
        String[] tipos = new String[]{"Pelicula", "Libro", "Videojuegos"};

        int posicion_categoria = JOptionPane.showOptionDialog(
                null,
                "Elegir Producto",
                "Continuar",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos,
                tipos[0]
        );

        return tipos[posicion_categoria];
    }
}
