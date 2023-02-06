package tarea8_tatianagarcia;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mototaxis extends Transportes{
    ArrayList <Alumnos> alumnos = new ArrayList();
    //2 alumnos

    public Mototaxis() {
        super();
    }

    public Mototaxis(String placa, Color color, Transportistas transportista) {
        super(placa, color, transportista);
    }
    

    public ArrayList<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumnos> alumnos) {
        if(alumnos.size()<3){
            this.alumnos = alumnos;
        }
        else{
            JOptionPane.showMessageDialog(null, "La mototaxi ya tiene la cantidad maxima de alumnos posibles");
        }
    }

    @Override
    public String toString() {
        String al = "No hay alumnos";
        if(!alumnos.isEmpty()){
            al= alumnos.toString();
        }
        return "\nMototaxis{" + "alumnos=" + al + '}'+super.toString();
    }
    
}
