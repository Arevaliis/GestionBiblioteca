package biblioteca.simple.servicios;

import biblioteca.simple.contratos.Prestable;
import biblioteca.simple.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el catálogo de productos de la biblioteca.
 *
 * @author José
 * @version 1.0
 */
public class Catalogo {

    /** Lista que almacena los productos del catálogo. */
    private final List<Producto> productos = new ArrayList<>();

    /**
     * Agrega un nuevo producto al catálogo.
     *
     * @param producto Producto a agregar
     */
    public void alta(Producto producto) { productos.add(producto); }

    /**
     * Devuelve una copia de la lista con todos los productos del catálogo, para evitar que se pueda modificar la lista original.
     *
     * @return Copia de la lista con todos los productos
     */
    public List<Producto> listar() { return new ArrayList<>(productos); }

    /**
     * Busca los productos cuyo título contiene la palabra o frase indicada.
     *
     * @param titulo Palabra o frase ingresada por el usuario
     * @return lista de productos que coinciden con la búsqueda por título
     */
    public List<Producto> buscar(String titulo) {
        return productos.stream()
                .filter(producto -> producto.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .toList();
    }

    /**
     * Busca los productos cuyo año coincide con el indicado.
     *
     * @param anyo Año ingresado por el usuario
     * @return lista de productos que coinciden con la búsqueda por año
     */
    public List<Producto> buscar(int anyo) {
        return productos.stream()
                .filter(producto -> Integer.parseInt(producto.getAnyo()) == anyo)
                .toList();
    }

    /**
     * Busca productos que implementen la interfaz {@link Prestable} y no estén prestados.
     *
     * @return Lista con los productos que pueden ser prestados
     */
    public List<Producto> buscarProductosDisponibles(){
        return productos.stream()
                .filter(p -> p instanceof Prestable nuevoProducto && !nuevoProducto.estaPrestado())
                .toList();
    }

    /**
     * Busca productos que implementen la interfaz {@link Prestable} y que estén prestados.
     *
     * @return Lista con los productos que se encuentran prestados
     */
    public List<Producto> buscarProductosReservados(){
        return productos.stream()
                .filter(p -> p instanceof Prestable nuevoProducto && nuevoProducto.estaPrestado())
                .toList();
    }

    /**
     * Busca un producto por su ID
     *
     * @param id ID ingresado
     *
     * @return El ID si encuentra el producto o null si no hay coincidencia alguna
     */
    public Producto buscarProductoId(int id){
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }

    /** Vacía la lista de usuarios */
    public void vaciarListaProductos(){productos.clear(); }

    /**
     * Importa todos los productos a la lista vacía
     *
     * @param productosCargados Lista con todos los productos
     */
    public void cargarTodosLosProductos(List<Producto> productosCargados) {productos.addAll(productosCargados);}
}