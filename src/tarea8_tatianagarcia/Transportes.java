
package tarea8_tatianagarcia;

import java.awt.Color;
import java.util.ArrayList;

public class Transportes {
    protected String placa; 
    protected Color color; 
    protected Transportistas transportista;
    protected ArrayList<Estaciones>estaciones = new ArrayList();
    ////

    public Transportes() {
        
    }

    public Transportes(String placa, Color color, Transportistas transportista) {
        this.placa = placa;
        this.color = color;
        this.transportista = transportista;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Transportistas getTransportista() {
        return transportista;
    }

    public void setTransportista(Transportistas transportista) {
        this.transportista = transportista;
    }

    public ArrayList<Estaciones> getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(ArrayList<Estaciones> estaciones) {
        this.estaciones = estaciones;
    }

    @Override
    public String toString() {
        String est = "No hay alumnos";
        if(!estaciones.isEmpty()){
            est= estaciones.toString();
        }
        return "\nTransportes{" + "placa=" + placa + ", color=" + color + ", transportista=" + transportista + ", estaciones=" + est + '}';
    }
    
}
