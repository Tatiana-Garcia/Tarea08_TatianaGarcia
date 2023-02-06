
package tarea8_tatianagarcia;

import java.util.ArrayList;
import java.util.Date;

public class Alumnos extends Personas{
    private long ID_al;
    private ArrayList <Clases> clases = new ArrayList();

    public Alumnos() {
        super();
    }

    public Alumnos(long ID, String nombre, long ID_al, Date fecha) {
        super(nombre, ID, fecha);
        this.ID_al = ID_al;
    }

    public long getID_al() {
        return ID_al;
    }

    public void setID_al(long ID_al) {
        this.ID_al = ID_al;
    }

    public ArrayList<Clases> getClases() {
        return clases;
    }

    public void setClases(ArrayList<Clases> clases) {
        this.clases = clases;
    }
    
    @Override
    public String toString() {
        String cl = "No hay clases";
        if(!clases.isEmpty()){
            cl= clases.toString();
        }
        return "\nAlumnos{" + "ID de alumno: " + ID_al + ", clases=" + cl + '}'+super.toString();
    }
    
}
