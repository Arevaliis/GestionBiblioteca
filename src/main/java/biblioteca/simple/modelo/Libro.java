package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

public class Libro extends Producto implements Prestable {
    private String autor;
    private String isbn;
    private boolean prestado;
    private Usuario prestadoA;

    public Libro (int id, String titulo, String anyo, FORMATO formato, String autor, String isbn) {
        super(id, titulo, anyo, formato);
        this.autor = autor;
        this.isbn = isbn;
    }

    public Libro ( String titulo, String anyo, FORMATO formato, String autor, String isbn) {
        super(titulo, anyo, formato);
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getAutor() { return autor; }

    public String getIsbn() { return isbn; }

    // public int calcularPenalizacion(){}

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
        // En caso de que el padre tenga los atributos con private debemos usar super()
        return "Libro{" +
                "autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", formato=" + formato +
                ", titulo='" + titulo + '\'' +
                ", id=" + id +
                ", anyo='" + anyo + '\'' +
                '}';
    }
}
