package biblioteca.simple.servicios;
/**
 * Clase que contiene los mensajes de texto utilizados en las ventanas emergentes y menús del programa.
 *
 * @author José
 * @version 1.0
 */
public class Mensajes {

    /** Menú principal del programa mostrado al usuario. */
    public static final String MENU_PRINCIPAL = """
            
            ===== MENÚ BIBLIOTECA =====
                    1. Listar
                    2. Buscar por titulo
                    3. Buscar por año
                    4. Prestar
                    5. Devolver
                    6. Salir
            
            """;

    /** Mensaje mostrado cuando el usuario elige una opción fuera del rango válido. */
    public static final String OPCION_FUERA_DE_RANGO = "La opción elegida está fuera del rango de opciones válida.";

    /** Mensaje mostrado cuando el usuario ingresa un dato no válido. */
    public static final String ERROR_DATO_NO_VALIDO = "Debe ingresar un número.";

    /** Mensaje mostrado cuando una búsqueda no devuelve resultados o la base de datos está vacía  */
    public static final String ERROR_SIN_RESULTADOS = "No se han encontrado productos en el catálogo.";

    /** Mensaje mostrado cuando el usuario decide salir del programa. */
    public static final String SALIR = "Saliendo del programa";
}
