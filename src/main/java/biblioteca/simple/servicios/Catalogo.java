package biblioteca.simple.servicios;

import biblioteca.simple.modelo.Producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Catalogo {

    private final List<Producto> productos = new ArrayList<>();

    public void alta(Producto producto){ productos.add(producto); }

    public List<Producto> listar(){ return new ArrayList<>(productos);}

    public List<Producto> buscar(String titulo){
        return productos.stream()
                        .filter(producto -> producto.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                        .toList();
    }

    public List<Producto> buscar(int anyo){
        return productos.stream()
                        .filter(producto -> Integer.parseInt(producto.getAnyo()) == anyo)
                        .toList();
    }

    public void mostrar(List<Producto> productos){

        List<String> frases = productos.stream().map(Producto::toString).toList();
        String mensaje = String.join("\n", frases);

        JOptionPane.showMessageDialog(null, mensaje, "Prestamos Registrados", JOptionPane.INFORMATION_MESSAGE);
    }
}