
package tarea8_tatianagarcia;
public class Estaciones {
    private int coordenadaX; 
    private int coordenadaY;

    public Estaciones() {
    }

    public Estaciones(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    @Override
    public String toString() {
        return "\nEstaciones{" + "coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + '}';
    }
    
}
