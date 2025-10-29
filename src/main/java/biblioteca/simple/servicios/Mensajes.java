package biblioteca.simple.servicios;

public class Mensajes {

    public  static final String MENU_PRINCIPAL = """
            
            ===== MENÚ BIBLIOTECA =====
                    1. Listar
                    2. Buscar por titulo
                    3. Buscar por año
                    4. Prestar
                    5. Devolver
                    6. Salir
            
            """;

    public static final String OPCION_FUERA_DE_RANGO = "La opción elegida esta fuera del rango de opciones válida.";
    public static final String ERROR_DATO_NO_VALIDO = "Debe ingresar un número.";
    public static final String ERROR_BBDD_VACIA = "El catálogo está vacío";
}
