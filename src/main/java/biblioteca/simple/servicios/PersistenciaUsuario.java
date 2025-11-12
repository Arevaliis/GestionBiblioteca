package biblioteca.simple.servicios;

import biblioteca.simple.modelo.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona las importaciones y exportaciones de los usuarios
 */
public final class PersistenciaUsuario {
    /* Ruta al archivo json */
    private static final String ARCHIVO = "src/main/resources/data/usuarios.json";

    /* Instancia de la clase Gson */
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private PersistenciaUsuario(){}

    /**
     * Crea un archivo json con la lista de los usuarios, en caso de existir la sobrescribe
     *
     * @param usuarios Lista con todos los usuarios de la biblioteca
     * @throws IOException Excepción que salta en caso de error con el fichero
     */
    public static void exportar(List<Usuario> usuarios) throws IOException {
        try(Writer writer = new OutputStreamWriter( new FileOutputStream(ARCHIVO), StandardCharsets.UTF_8 )){
            gson.toJson(usuarios, writer);
        }
    }

    /**
     * Crea una lista con los usuarios del archivo json
     *
     * @return Lista con todos los usuarios de la biblioteca
     * @throws IOException Excepción que salta en caso de error con el fichero
     */
    public static List<Usuario> importar() throws IOException{
        File file = new File(ARCHIVO);

        if (!file.exists()) return new ArrayList<>();

        try (Reader reader = new InputStreamReader(new FileInputStream(ARCHIVO), StandardCharsets.UTF_8) ) {
            Type tipoLista = new TypeToken<ArrayList<Usuario>>() {}.getType();
            List<Usuario> usuario = gson.fromJson(reader,  tipoLista);
            return (usuario != null) ? usuario: new ArrayList<>();
        }
    }
}
