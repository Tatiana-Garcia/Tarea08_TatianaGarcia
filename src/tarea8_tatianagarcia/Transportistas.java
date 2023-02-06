
package tarea8_tatianagarcia;

import java.util.Date;

public class Transportistas extends Personas{
    private int experiencia; 
    private String apodo; 

    public Transportistas() {
        super();
    }

    public Transportistas(int experiencia, String apodo, String nombre, long ID, Date fecha) {
        super(nombre, ID, fecha);
        this.experiencia = experiencia;
        this.apodo = apodo;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    @Override
    public String toString() {
        return "\nTransportistas{" + "experiencia=" + experiencia + ", apodo=" + apodo + '}'+super.toString();
    }
    
}
