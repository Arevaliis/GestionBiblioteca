package biblioteca.simple.modelo;

public abstract class Producto {
    protected int id;
    protected String titulo;
    protected String fechaLanzamiento;
    protected FORMATO formato;

    public Producto(String titulo, String fechaLanzamiento, FORMATO formato) {
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.formato = formato;
    }

    public Producto(int id, String titulo, String fechaLanzamiento, FORMATO formato) {
        this.id = id;
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.formato = formato;
    }

    public int getId() { return id; }

    public String getTitulo() { return titulo; }

    public String getFechaLanzamiento() { return fechaLanzamiento; }

    public FORMATO getFormato() { return formato; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setFormato(FORMATO formato) { this.formato = formato; }

    public void setFechaLanzamiento(String fechaLanzamiento) { this.fechaLanzamiento = fechaLanzamiento; }
}