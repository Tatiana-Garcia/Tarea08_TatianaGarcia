
package tarea8_tatianagarcia;


public class Clases {
    private String nombre; 
    private int codigo; //debe ser Unico

    public Clases() {
    }

    public Clases(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "\nClases{" + "nombre=" + nombre + ", codigo=" + codigo + '}';
    }
    
}
