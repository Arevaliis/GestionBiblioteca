package biblioteca.simple.servicios;

import biblioteca.simple.modelo.*;
import com.google.gson.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Clase que gestiona las importaciones y exportaciones de los productos en catálogo
 */
public final class PersistenciaProducto {
    /* Ruta al archivo json */
    private static final String ARCHIVO = "src/main/resources/data/catalogo.json";

    /* Instancia de la clase Gson */
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private PersistenciaProducto(){}

    /**
     * Crea un archivo json con la lista de los productos, en caso de existir la sobrescribe
     *
     * @param productos Lista con todos los productos de la biblioteca
     * @throws IOException Excepción que salta en caso de error con el fichero
     */
    public static void exportar(List<Producto> productos) throws IOException {
        try(Writer writer = new OutputStreamWriter( new FileOutputStream(ARCHIVO), StandardCharsets.UTF_8 )){
            gson.toJson(productos, writer);
        }
    }

    /**
     * Crea un JsonArray con los productos que hay en el archivo json
     *
     * @return JsonArray con todos los productos de la biblioteca
     * @throws IOException Excepción que salta en caso de error con el fichero
     */
    public static JsonArray importar() throws IOException{
        File file = new File(ARCHIVO);

        if (!file.exists()) return new JsonArray();
        if (file.length() == 0) return new JsonArray();

        try (Reader reader = new InputStreamReader(new FileInputStream(ARCHIVO), StandardCharsets.UTF_8) ) {
            JsonArray array = JsonParser.parseReader(reader).getAsJsonArray();

            return (array != null) ? array: new JsonArray();

        }
    }
}
