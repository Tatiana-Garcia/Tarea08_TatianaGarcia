package tarea8_tatianagarcia;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Taxis extends Transportes{
    private int num_taxi; 
    private ArrayList<Alumnos> alumnos = new ArrayList();
    //Maximo 4 alumnos

    public Taxis() {
        super();
    }

    public Taxis(int num_taxi, String placa, Color color, Transportistas transportista) {
        super(placa, color, transportista);
        this.num_taxi = num_taxi;
    }

    public int getNum_taxi() {
        return num_taxi;
    }

    public void setNum_taxi(int num_taxi) {
        this.num_taxi = num_taxi;
    }

    public ArrayList<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumnos> alumnos) {
        if(alumnos.size()<5){
            this.alumnos = alumnos;
        }
        else{
            JOptionPane.showMessageDialog(null, "El taxi ya tiene la cantidad maxima de alumnos posibles");
        }
        
    }

    @Override
    public String toString() {
        String al = "No hay alumnos";
        if(!alumnos.isEmpty()){
            al= alumnos.toString();
        }
        return "\nTaxis{" + "num_taxi=" + num_taxi + ", alumnos=" + al + '}'+super.toString();
    }
    
}
