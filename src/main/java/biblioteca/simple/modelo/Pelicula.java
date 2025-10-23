package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

public class Pelicula extends Producto implements Prestable {

    private String director;
    private int minutosDuracion;
    private boolean prestado;
    private Usuario prestadoA;

    public Pelicula(String titulo, String anyo, FORMATO formato, int minutosDuracion, String director) {
        super(titulo, anyo, formato);
        this.minutosDuracion = minutosDuracion;
        this.director = director;
    }

    public Pelicula(int id, String titulo, String anyo, FORMATO formato, int minutosDuracion, String director) {
        super(id, titulo, anyo, formato);
        this.minutosDuracion = minutosDuracion;
        this.director = director;
    }

    public String getDirector() { return director; }

    public int getMinutosDuracion() { return minutosDuracion; }

    // public int calcularPenalizacion(){}

    @Override
    public boolean estaPrestado(){return this.prestado; }

    @Override
    public void prestar(Usuario usuario) {
        if (prestado) throw new IllegalStateException("Película ya prestada.");

        this.prestado = true;
        this.prestadoA = usuario;
    }

    @Override
    public void devolver() {

        this.prestado = false;
        this.prestadoA = null;

    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "director='" + director + '\'' +
                ", minutosDuracion=" + minutosDuracion +
                ", formato=" + formato +
                ", anyo='" + anyo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", id=" + id +
                '}';
    }
}
