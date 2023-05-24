package CODE.Clases;

public class Materia {
    private String nombre, profesor, descripcion;
    private double nota;

    public Materia(String nombre, double nota, String descripcion, String profesor) {
        this.nombre = nombre;
        this.nota = nota;
        this.descripcion = descripcion;
        this.profesor = profesor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

}
