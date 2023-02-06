
package tarea8_tatianagarcia;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Buses extends Transportes {
    private ArrayList <Alumnos> alumnos = new ArrayList();//maximo numero de sillas + personas de pie
    private int sillas; 
    private int personas_paradas;

    public Buses() {
        super();
    }

    public Buses(int sillas, int personas_paradas, String placa, Color color, Transportistas transportista) {
        super(placa, color, transportista);
        this.sillas = sillas;
        this.personas_paradas = personas_paradas;
    }

    public ArrayList<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumnos> alumnos) {
        if(alumnos.size()<sillas+personas_paradas){
            this.alumnos = alumnos;
        }
        else{
            JOptionPane.showMessageDialog(null, "El bus ya tiene la cantidad maxima de alumnos posibles");
        }
    }

    public int getSillas() {
        return sillas;
    }

    public void setSillas(int sillas) {
        this.sillas = sillas;
    }

    public int getPersonas_paradas() {
        return personas_paradas;
    }

    public void setPersonas_paradas(int personas_paradas) {
        this.personas_paradas = personas_paradas;
    }

    @Override
    public String toString() {
        String al = "No hay alumnos";
        if(!alumnos.isEmpty()){
            al= alumnos.toString();
        }
        return "\nBuses{" + "alumnos=" + al + ", sillas=" + sillas + ", capacidad de personas paradas=" + personas_paradas + '}'+super.toString();
    }
    
}
