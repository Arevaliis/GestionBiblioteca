package biblioteca.simple.servicios;

import javax.swing.*;

public class Input {

    public static int elegir_opcion(String menu, String titulo){
        String opc = JOptionPane.showInputDialog(null, menu, titulo, JOptionPane.QUESTION_MESSAGE);

        if (opc != null) return Integer.parseInt(opc);

        return -1;
    }

    public static boolean seguirEjecutando(String mensaje){

        int resultado = JOptionPane.showOptionDialog(
                null,
                mensaje,
                "Continuar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null
        );

        return resultado == JOptionPane.YES_OPTION;
    }

    public static String ingresarTitulo(){
        String titulo = JOptionPane.showInputDialog(null, "Ingrese el titulo a buscar: ", "Buscar por Titulo", JOptionPane.QUESTION_MESSAGE);

        if (titulo == null) return "";

        return titulo;
    }

    public static int ingresarAnyo(){
        String anyo = JOptionPane.showInputDialog(null, "Ingrese el año a buscar: ", "Buscar por año", JOptionPane.QUESTION_MESSAGE);

        if (anyo == null) return -1;

        return Integer.parseInt(anyo);
    }

    public static String ingresarTipo(){
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