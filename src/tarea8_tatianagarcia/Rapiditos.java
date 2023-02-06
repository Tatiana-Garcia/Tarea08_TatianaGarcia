package tarea8_tatianagarcia;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Rapiditos extends Transportes{
    private int sillas;
    private ArrayList<Alumnos> alumnos = new ArrayList();
    //Capacidad maxima en lista = a numero de sillas

    public Rapiditos() {
        super();
    }

    public Rapiditos(int sillas, String placa, Color color, Transportistas transportista) {
        super(placa, color, transportista);
        this.sillas = sillas;
    }

    public int getSillas() {
        return sillas;
    }

    public void setSillas(int sillas) {
        this.sillas = sillas;
    }

    public ArrayList<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumnos> alumnos) {
        if(alumnos.size()<sillas){
            this.alumnos = alumnos;
        }
        else{
            JOptionPane.showMessageDialog(null, "El rapidito ya tiene la cantidad maxima de alumnos posibles");
        }
    }

    @Override
    public String toString() {
        String al = "No hay alumnos";
        if(!alumnos.isEmpty()){
            al= alumnos.toString();
        }
        return "\nRapiditos{" + "sillas=" + sillas + ", alumnos=" + al + '}'+super.toString();
    }
    
    
}
