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
                    6. Alta Usuario
                    7. Exportar Usuarios
                    8. Importar Usuarios
                    9. Exportar Catalogo
                    10. Importar Catalogo
                    0. Salir
            
            """;

    /** Mensaje mostrado cuando el usuario elige una opción fuera del rango válido. */
    public static final String OPCION_FUERA_DE_RANGO = "La opción elegida está fuera del rango de opciones válida.";

    /** Mensaje mostrado cuando el usuario ingresa un dato no válido. */
    public static final String ERROR_DATO_NO_VALIDO = "Debe ingresar un número.";

    /** Mensaje mostrado cuando una búsqueda no devuelve resultados o la base de datos está vacía  */
    public static final String ERROR_SIN_RESULTADOS = "No se han encontrado productos en el catálogo.";

    /** Mensaje mostrado cuando el usuario decide salir del programa. */
    public static final String SALIR = "Saliendo del programa";

    /** Mensaje mostrado cuando una operación de préstamo se realiza correctamente. */
    public static final String PRESTAMO_EXITO = "El producto ha sido prestado con éxito.";

    /** Mensaje mostrado cuando una operación de devolución se realiza correctamente. */
    public static final String DEVOLUCION_EXITO = "El producto ha sido devuelto con éxito.";

    /** Mensaje mostrado cuando el identificador ingresado no coincide con ningún registro. */
    public static final String ID_NO_ENCONTRADO = "El id ingresado no coincide.";

    /** Mensaje mostrado en el cuadro de diálogo al solicitar el ID de un producto. */
    public static final String INGRESAR_ID_PRODUCTO = "Ingrese el id del producto: ";

    /** Título de la ventana emergente utilizada para solicitar el ID de un producto. */
    public static final String TITULO_RESERVAR_PRODUCTO = "Reservar Producto";

    /** Mensaje mostrado en el cuadro de diálogo al solicitar el ID de un usuario. */
    public static final String INGRESAR_ID_USUARIO = "Ingrese el id del usuario: ";

    /** Mensaje mostrado en el cuadro de diálogo al solicitar el nombre de un nuevo usuario. */
    public static final String INGRESAR_NOMBRE_USUARIO = "Ingrese el nombre del nuevo usuario: ";

    /** Título de la ventana emergente utilizada para dar de alta un nuevo usuario. */
    public static final String TITULO_ALTA_USUARIO = "Alta Usuario";

    /** Mensaje mostrado en el cuadro de diálogo al solicitar el título de un producto para buscarlo. */
    public static final String INGRESAR_TITULO_BUSQUEDA = "Ingrese el título a buscar: ";

    /** Título de la ventana emergente utilizada para buscar un producto por título. */
    public static final String TITULO_BUSCAR_TITULO = "Buscar por Título";

    /** Mensaje mostrado cuando la exportación de usuarios se realiza correctamente. */
    public static final String EXPORTACION_USUARIOS_EXITO = "Usuarios exportados con éxito";

    /** Mensaje mostrado cuando la importación de usuarios se realiza correctamente. */
    public static final String IMPORTACION_USUARIOS_EXITO = "Usuarios cargados con éxito";

    /** Mensaje mostrado cuando ocurre un error durante la exportación de usuario. */
    public static final String ERROR_EXPORTACION_USUARIOS = "Error durante la exportación de usuarios.";

    /** Mensaje mostrado cuando ocurre un error durante la importación de usuarios. */
    public static final String ERROR_IMPORTACION_USUARIOS = "Error durante la importación de usuarios.";

    /** Mensaje mostrado cuando la exportación de productos se realiza correctamente. */
    public static final String EXPORTACION_PRODUCTOS_EXITO = "Productos exportados con éxito";

    /** Mensaje mostrado cuando la importación de productos se realiza correctamente. */
    public static final String IMPORTACION_PRODUCTOS_EXITO = "Productos cargados con éxito";

    /** Mensaje mostrado cuando ocurre un error durante la exportación de productos. */
    public static final String ERROR_EXPORTACION_PRODUCTOS = "Error durante la exportación de productos.";

    /** Mensaje mostrado cuando ocurre un error durante la importación de productos. */
    public static final String ERROR_IMPORTACION_PRODUCTOS = "Error durante la importación de productos.";

}