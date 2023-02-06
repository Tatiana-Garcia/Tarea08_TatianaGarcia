
package tarea8_tatianagarcia;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Personas {
    protected String nombre; 
    protected long ID;//Identidad UNICO
    protected Date fecha; //Fecha de nacimiento
    
    public Personas() {
    }

    public Personas(String nombre, long ID, Date fecha) {
        this.nombre = nombre;
        this.ID = ID;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("EEEE, dd MMMM, yyyy");
        return "\nPersonas{" + "nombre=" + nombre + ", ID=" + ID + ", fecha=" + df.format(fecha)+ '}';
    }
    
    
}
