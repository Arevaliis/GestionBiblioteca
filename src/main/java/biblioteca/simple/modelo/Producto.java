package biblioteca.simple.modelo;

public abstract class Producto {
    protected int id;
    protected String titulo;
    protected String anyo;
    protected FORMATO formato;

    protected Producto(String titulo, String anyo, FORMATO formato) {
        this.titulo = titulo;
        this.anyo = anyo;
        this.formato = formato;
    }

    protected Producto(int id, String titulo, String anyo, FORMATO formato) {
        this.id = id;
        this.titulo = titulo;
        this.anyo = anyo;
        this.formato = formato;
    }

    protected int getId() { return id; }

    public String getTitulo() { return titulo; }

    public String getAnyo() { return anyo; }

    protected FORMATO getFormato() { return formato; }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anyo='" + anyo + '\'' +
                ", formato=" + formato +
                '}';
    }
}