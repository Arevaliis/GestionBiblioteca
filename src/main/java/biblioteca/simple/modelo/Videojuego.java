package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

public class Videojuego extends Producto implements Prestable {

    private String plataforma;
    private String genero;
    private boolean prestado;
    private Usuario prestadoA;

    public Videojuego(String titulo, String anyo, FORMATO formato, String plataforma, String genero) {
        super(titulo, anyo, formato);
        this.plataforma = plataforma;
        this.genero = genero;
    }

    public Videojuego(int id, String titulo, String anyo, FORMATO formato, String plataforma, String genero) {
        super(id, titulo, anyo, formato);
        this.plataforma = plataforma;
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public void prestar(Usuario usuario) {
        if (prestado) throw new IllegalStateException("Libro ya prestado.");

        this.prestado = true;
        this.prestadoA = usuario;
    }

    @Override
    public void devolver() {

        this.prestado = false;
        this.prestadoA = null;

    }

    @Override
    public boolean estaPrestado(){return this.prestado; }

    @Override
    public String toString() {
        return "Videojuego{" +
                "plataforma='" + plataforma + '\'' +
                ", genero='" + genero + '\'' +
                ", id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anyo='" + anyo + '\'' +
                ", formato=" + formato +
                '}';
    }
}
