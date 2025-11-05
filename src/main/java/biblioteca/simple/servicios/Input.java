package biblioteca.simple.servicios;

import javax.swing.*;
import java.util.List;

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
     *  Muestra un cuadro de diálogo para que el usuario ingrese un texto  título o nombre). Si no ingresa ningún valor se lanzará una excepción {@link IllegalStateException}.
     *
     * @param mensaje Texto que se mostrará antes del campo de entrada
     * @param titulo título de la ventana emergente
     *
     * @return Texto ingresado por el usuario, o cadena vacía {@code ""} si cancela
     *
     * @throws IllegalStateException si el producto es null o está vacío.
     */
    public static String ingresarTexto(String mensaje, String titulo) {
        String entrada = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);

        if (entrada == null || entrada.isEmpty()) { throw new IllegalStateException("Debe ingresar un valor."); }

        return entrada;
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
     * Muestra un cuadro de diálogo para que el usuario ingrese el ID. Si no ingresa ningún valor
     * se lanzará una excepción {@link IllegalStateException}.
     *
     * @param mensaje Mensaje con toda la información de productos o usuarios.
     * @param textoEntrada Texto informativo para ingreso de la información
     * @param titulo Título de la ventana emergente
     *
     * @return El ID ingresado convertido a entero, o -1 si el usuario cancela
     * @throws IllegalStateException si el ID es null o está vacío
     */
    public static int ingresarId(List<String> mensaje, String textoEntrada, String titulo) {
        String input = JOptionPane.showInputDialog(
                null,
                String.join("\n", mensaje) + "\n\n" + textoEntrada,
                titulo,
                JOptionPane.QUESTION_MESSAGE
        );

        if (input == null || input.isEmpty()) {
            throw new IllegalStateException("Debe ingresar un id.");
        }

        return Integer.parseInt(input);
    }

    /**
     * Muestra un cuadro de diálogo de confirmación para agregar un nuevo usuario.
     *
     * @return True si es 0 si no False
     */
    public static boolean confirmarAgregarNuevoUsuario(){
        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Desea agregar al nuevo usuario?",
                "Agregar Usuario",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        return 0 == opcion;
    }
}