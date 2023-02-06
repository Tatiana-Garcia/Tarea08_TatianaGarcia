
package tarea8_tatianagarcia;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JColorChooser;

public class Tarea8_TatianaGarcia {
    static Scanner leer = new Scanner(System.in);
    static ArrayList<Clases>clases = new ArrayList();
    static ArrayList<Personas>personas = new ArrayList();
    static ArrayList<Transportes>transportes = new ArrayList();
    static ArrayList<Estaciones>estaciones = new ArrayList();

    public static void main(String[] args) {
        int menu = 1;
        do {
            System.out.print("Menu de opciones:\n"
                    + "0-Salir\n"
                    + "1-Crear Clase\n"
                    + "2-Crear Ruta\n"
                    + "3-Crear Alumno\n"
                    + "4-Agregar Clase a Alumno\n"
                    + "5-Crear Transportista\n"
                    + "6-Crear Transporte\n"
                    + "7-Simulacion\n"
                    + "8-Listar Clases\n"
                    + "9-Listar Rutas\n"
                    + "10-Listar Alumnos\n"
                    + "11-Listar Transportistas\n"
                    + "12-Listar Transportes\n\n"
                    + "Ingrese opcion: ");

            menu = leer.nextInt();
            switch (menu) {
                case 0:
                    System.out.println(">> Salida del sistema");
                    break;
                case 1: {
                    clases.add(CrearClase());
                    break;
                }
                case 2: {//Crear Ruta
                    estaciones.add(CrearRuta());
                    break;
                }
                case 3: {
                    personas.add(CrearPersona(0));
                    break;
                }
                case 4: {//Agregar Clase a ALumno
                    int pos = -1;
                    do{
                        System.out.println(Listar(personas, 0));
                        System.out.println("Ingrese posicion de alumno al que desea agregarle la clase: ");
                        pos = leer.nextInt();
                        if(personas.get(pos) instanceof Alumnos){
                            //transportista = (Transportistas)personas.get(pos);
                            int num =1;
                            do{
                                int pos2 = -1;
                                do{
                                    System.out.println(Listar(clases, 2));
                                    System.out.println("Ingrese posicion de la clase a agregar: ");
                                    pos2 = leer.nextInt();
                                }while(pos2<0 ||pos2>clases.size());
                                ((Alumnos)personas.get(pos)).getClases().add(clases.get(pos2));
                                
                                System.out.println("Desea agregar otra clase? "
                                        + "1. Si"
                                        + "numero>1. No");
                                num = leer.nextInt();
                            }while(num ==1);
                            
                        }else{
                            System.out.println("La posicion ingresada no es de Alumno");
                            pos = -1;
                        }   
                    }while(pos<0 ||pos>personas.size());
                    
                    break;
                }
                case 5: {
                    personas.add(CrearPersona(1));
                    break;
                }
                case 6: {
                    transportes.add(CrearTransporte());
                    break;
                }
                case 7: {//simulacion
                    int pos = -1;
                    do{
                        System.out.println(Listar(transportes, 2));
                        System.out.println("Ingrese posicion del Transporte para la Simulacion: ");
                        pos = leer.nextInt();
                    }while(pos<0 ||pos>transportes.size());
                    
                    int menu2 = 1;
                    do {
                        System.out.print("Menu de opciones:\n"
                                + "0-Salir\n"
                                + "1-Subir alumno al transporte\n"
                                + "2-Bajar alumno del transporte\n"
                                + "3-Listar alumnos del transporte\n"
                                + "4-Escoger Transportista\n"
                                + "5-Quitar Transportista\n"
                                + "6-Añadir ruta\n"
                                + "7-Quitar ruta\n"
                                + "8-Imprimir transporte\n"
                                + "9-Comenzar\n\n"
                                + "Ingrese opcion: ");

                        menu2 = leer.nextInt();
                        
                        switch (menu2) {
                            case 1 -> {
                                int posa = -1;
                                boolean valid = true;
                                int num =1;
                                do{

                                    System.out.println(Listar(personas, 0));
                                    System.out.println("Ingrese posicion de alumno al que desea agregar al transporte: ");
                                    posa = leer.nextInt();

                                    if(personas.get(posa) instanceof Alumnos){
                                        //transportista = (Transportistas)personas.get(pos);

                                            if (transportes.get(pos)instanceof Buses buses) {
                                                if(buses.getAlumnos().size()<=(buses.getSillas()+buses.getPersonas_paradas())){
                                                    buses.getAlumnos().add((Alumnos)personas.get(posa));
                                                }else{
                                                    valid=false;
                                                }
                                            }else if(transportes.get(pos)instanceof Rapiditos rapiditos){
                                                if(rapiditos.getAlumnos().size()<=rapiditos.getSillas()){
                                                    rapiditos.getAlumnos().add((Alumnos)personas.get(posa));
                                                }else{
                                                    valid=false;
                                                }
                                            }else if(transportes.get(pos)instanceof Taxis taxis){
                                                if(taxis.getAlumnos().size()<5){
                                                    taxis.getAlumnos().add((Alumnos)personas.get(posa));
                                                }else{
                                                    valid=false;
                                                }
                                            }else if(transportes.get(pos)instanceof Mototaxis mototaxis){
                                                if(mototaxis.getAlumnos().size()<3){
                                                    mototaxis.getAlumnos().add((Alumnos)personas.get(posa));
                                                }else{
                                                    valid=false;
                                                }
                                            }
                                    }else{
                                        System.out.println("La posicion ingresada no es de Alumno");
                                        posa = -1;
                                    }
                                    System.out.println("Desea agregar otro alumno? "
                                            + "1. Si"
                                            + "numero>1. No");
                                    num = leer.nextInt();

                                }while(posa<0 ||posa>personas.size()||(num ==1&&valid==true));
                            }
                            case 2 -> {
                                int num =1;
                                boolean valid = true;
                                do{
                                    if (transportes.get(pos)instanceof Buses buses) {
                                        if(buses.getAlumnos().isEmpty()){
                                            valid = false;
                                        }else{
                                            System.out.println(Listar(buses.getAlumnos(), 0));
                                            int posa =-1;
                                            do{
                                                System.out.println("Ingreser posicion de alumno a bajar del transporte: ");
                                                posa = leer.nextInt();
                                            }while(posa<0||posa>buses.getAlumnos().size());
                                            buses.getAlumnos().remove(posa);
                                        }
                                    }else if(transportes.get(pos)instanceof Rapiditos rapiditos){
                                        if(rapiditos.getAlumnos().isEmpty()){
                                            valid = false;
                                        }else{
                                            System.out.println(Listar(rapiditos.getAlumnos(), 0));
                                            int posa =-1;
                                            do{
                                                System.out.println("Ingreser posicion de alumno a bajar del transporte: ");
                                                posa = leer.nextInt();
                                            }while(posa<0||posa>rapiditos.getAlumnos().size());
                                            rapiditos.getAlumnos().remove(posa);
                                        }
                                    }else if(transportes.get(pos)instanceof Taxis taxis){
                                        if(taxis.getAlumnos().isEmpty()){
                                            valid = false;
                                        }else{}
                                        System.out.println(Listar(taxis.getAlumnos(), 0));
                                        int posa =-1;
                                        do{
                                            System.out.println("Ingreser posicion de alumno a bajar del transporte: ");
                                            posa = leer.nextInt();
                                        }while(posa<0||posa>taxis.getAlumnos().size());
                                        taxis.getAlumnos().remove(posa);
                                    }else if(transportes.get(pos)instanceof Mototaxis mototaxis){
                                        if(mototaxis.getAlumnos().isEmpty()){
                                            valid = false;
                                        }else{
                                            System.out.println(Listar(mototaxis.getAlumnos(), 0));
                                            int posa =-1;
                                            do{
                                                System.out.println("Ingreser posicion de alumno a bajar del transporte: ");
                                                posa = leer.nextInt();
                                            }while(posa<0||posa>mototaxis.getAlumnos().size());
                                            mototaxis.getAlumnos().remove(posa);
                                        }
                                    }
                                    System.out.println("Desea agregar otro alumno? "
                                            + "1. Si"
                                            + "numero>1. No");
                                    num = leer.nextInt();
                                }while(num ==1&&valid==true);
                            }
                            case 3 -> {
                                if (transportes.get(pos)instanceof Buses buses) {
                                    System.out.println(Listar(buses.getAlumnos(),0));
                                }else if(transportes.get(pos)instanceof Rapiditos rapiditos){
                                    System.out.println(Listar(rapiditos.getAlumnos(),0));
                                }else if(transportes.get(pos)instanceof Taxis taxis){
                                    System.out.println(Listar(taxis.getAlumnos(),0));
                                }else if(transportes.get(pos)instanceof Mototaxis mototaxis){
                                    System.out.println(Listar(mototaxis.getAlumnos(),0));
                                }
                            }
                            case 4 -> {
                                System.out.println(Listar(personas,1));
                                int pos2 = -1;
                                do{
                                    System.out.println("Ingrese posicion de Transportista a asignar transporte ");
                                    pos2 = leer.nextInt();
                                    if(personas.get(pos) instanceof Transportistas){
                                        transportes.get(pos).setTransportista((Transportistas)personas.get(pos2));
                                    }else{
                                        System.out.println("La posicion ingresada no es de Transportista");
                                        pos2 = -1;
                                    }   
                                }while(pos2<0 ||pos2>personas.size());

                            }
                            case 5 -> {
                                transportes.get(pos).setTransportista(null);
                            }
                            case 6 -> {
                                System.out.println(Listar(estaciones,2));
                                int pos2 = -1;
                                do{
                                    System.out.println("Ingrese la posicion de la estacion a agregar la ruta: ");
                                    pos2 = leer.nextInt();
                                }while(pos2<0||pos2>estaciones.size());
                                transportes.get(pos).getEstaciones().add(estaciones.get(pos2));
                            }
                            case 7 -> {
                                System.out.println(Listar(transportes.get(pos).getEstaciones(),2));
                                int pos2 = -1;
                                do{
                                    System.out.println("Ingrese la posicion de la estacion a borrar de la ruta: ");
                                    pos2 = leer.nextInt();
                                }while(pos2<0||pos2>transportes.get(pos).getEstaciones().size());
                                transportes.get(pos).getEstaciones().remove(pos2);
                            }
                            case 8 -> {
                                System.out.println(transportes.get(pos));
                            }
                            case 9 -> {
                                
                                Estaciones pos1 = estaciones.get(0);
                                Estaciones pos2 = estaciones.get(0);
                                int x=0, y=0;
                                int x2 = 0,y2 = 0;
                                double d = 0;
                                for (Estaciones t : estaciones) {
                                    if (estaciones.indexOf(t)==0) {
                                        d = Distancia(x,y,t.getCoordenadaX(),t.getCoordenadaY());
                                        x2 = t.getCoordenadaX();
                                        y2 = t.getCoordenadaY();
                                        pos2 = t;
                                    }else if (d>Distancia(x,y,t.getCoordenadaX(),t.getCoordenadaY())){
                                        d = Distancia(x,y,t.getCoordenadaX(),t.getCoordenadaY());
                                        x2 = t.getCoordenadaX();
                                        y2 = t.getCoordenadaY();
                                        pos2 = t;
                                    }
                                    
                                }
                                System.out.println(pos1.toString()+" con una distancia de "+d+" de la estacion "+pos2.toString());
                                pos1=pos2;
                                x = x2;
                                y = y2;
                                
                                int total = 0;
                                if(transportes.get(pos)instanceof Buses buses){
                                    total = buses.getAlumnos().size()/transportes.get(pos).getEstaciones().size();
                                }else if(transportes.get(pos)instanceof Rapiditos rapiditos){
                                    total = rapiditos.getAlumnos().size()/transportes.get(pos).getEstaciones().size();
                                }else if(transportes.get(pos)instanceof Taxis taxis){
                                    total = taxis.getAlumnos().size()/transportes.get(pos).getEstaciones().size();
                                }else if(transportes.get(pos)instanceof Mototaxis moto){
                                    total = moto.getAlumnos().size()/transportes.get(pos).getEstaciones().size();
                                }
                                
                                if(total%1 ==0){
                                    while(total != 0){
                                        if(transportes.get(pos)instanceof Buses buses){
                                            buses.getAlumnos().remove(0);
                                        }else if(transportes.get(pos)instanceof Rapiditos rapiditos){
                                            rapiditos.getAlumnos().remove(0);
                                        }else if(transportes.get(pos)instanceof Taxis taxis){
                                            taxis.getAlumnos().remove(0);
                                        }else if(transportes.get(pos)instanceof Mototaxis moto){
                                            moto.getAlumnos().remove(0);
                                        }
                                        total--;
                                    }
                                    System.out.println(total+" alumnos se bajan en la estacion");
                                }else{
                                    System.out.println("No se bajan alumnos en esta parada");
                                }
                            }
                        }
                    }while(menu2 != 0);
                    break;
                }
                case 8: {
                    System.out.println(Listar(clases, 2));
                    break;
                }
                case 9: {//Listar Rutas
                    System.out.println(Listar(estaciones, 2));
                    break;
                }
                case 10: {
                    System.out.println(Listar(personas, 0));
                    break;
                }
                case 11: {
                    System.out.println(Listar(personas, 1));
                    break;
                }
                case 12: {
                    System.out.println(ListarTransportes(transportes));
                    break;
                }
            }
            
        }while(menu != 0);      
    }//Fin del main
    static double Distancia(int x, int y, int x2, int y2){
        double distancia;
        distancia = Math.sqrt((x2-x)+(y2-y));
        return distancia;
    }
    static Estaciones CrearRuta(){
        int coordenadaX; 
        int coordenadaY;
        Estaciones retorno; 
        
        System.out.println("Ingrese la coordenada en X: ");
        coordenadaX = leer.nextInt();
        System.out.println("Ingrese la coordenada en Y: ");
        coordenadaY = leer.nextInt();
        
        retorno = new Estaciones(coordenadaX, coordenadaY);
        return retorno;
        
    }
    
    static Clases CrearClase(){
        Clases retorno; 
        String nombre; 
        int codigo; //debe ser Unico
        
        System.out.println("Ingrese nombre de la clase: ");
        leer = new Scanner(System.in);
        nombre = leer.nextLine();
        
        
        System.out.println("Ingrese un codigo para la clase: ");
        codigo = leer.nextInt();
        
        if(!clases.isEmpty()){
            for (Clases t : clases) {
                while(t.getCodigo() == codigo){
                    System.out.println("Ingrese un codigo para la clase: ");
                    codigo = leer.nextInt();
                }
            }
        }
        retorno = new Clases(nombre, codigo);
        return retorno; 
    }
    static Personas CrearPersona(int x){
        Personas retorno = null; 
        String nombre; 
        long ID;//Identidad UNICO
        Date fecha; //Fecha de nacimiento
        
        System.out.println("Ingrese nombre: ");
        leer = new Scanner(System.in);
        nombre = leer.nextLine();
        
        System.out.println("Ingrese Identidad: ");
        ID = leer.nextLong();
        if(!personas.isEmpty()){///Error en validadicion
            for (Personas t : personas) {
                while(t.getID()==ID){
                    System.out.println("Ingrese un ID que no exista: ");
                    ID = leer.nextLong();
                }
            }
        }
        
        System.out.println("Ingrese fecha de nacimiento: ");
        leer = new Scanner(System.in);
        String cadena = leer.next();
        String t[]= cadena.split("/");
        fecha = new Date(Integer.parseInt(t[2])-1900, Integer.parseInt(t[1])-1, Integer.parseInt(t[0]));
        
        
        if(x ==0){
            long ID_al;
            ID_al = ID;
            retorno = new Alumnos(ID, nombre, ID_al, fecha);
        }
        if(x ==1){
            int experiencia; 
            String apodo; 
            
            System.out.println("Ingrese años de experiencia: ");
            experiencia = leer.nextInt();
            
            System.out.println("Ingrese apodo: ");
            leer = new Scanner(System.in);
            apodo = leer.nextLine();
            
            retorno = new Transportistas(experiencia, apodo, nombre, ID, fecha);
        }
        
        return retorno; 
    }
    static Transportes CrearTransporte(){
        Transportes retorno = null;
        
        String placa; 
        Color color; 
        Transportistas transportista = null;
        
        System.out.println("Ingrese placa: ");
        leer = new Scanner(System.in);
        placa = leer.nextLine();
        
        if(!transportes.isEmpty()){
            for (Transportes t : transportes) {
                do{
                    System.out.println("Ingrese un ID que no exista: ");
                    leer = new Scanner(System.in);
                    placa = leer.nextLine();
                }while(t.getPlaca().equals(placa));
            }
        }
        
        //System.out.println("Ingrese color de transporte: ");
        color = JColorChooser.showDialog(null, "Ingrese color de transporte: ", Color.BLACK);
        
        System.out.println(Listar(personas,1));
        
        //System.out.println("Ingrese posicion de Transportista a asignar vehiculo: ");
        int pos = -1;
        do{
            System.out.println("Ingrese posicion de Transportista a asignar vehiculo: ");
            pos = leer.nextInt();
            if(personas.get(pos) instanceof Transportistas){
                transportista = (Transportistas)personas.get(pos);
            }else{
                System.out.println("La posicion ingresada no es de Transportista");
                pos = -1;
            }   
        }while(pos<0 ||pos>personas.size());
        
        int op=0;
        do{
        System.out.println("Transportes \n"
                + "1.Buses\n"
                + "2.Rapiditos\n"
                + "3.Taxis\n"
                + "4.Mototaxis\n"
                + "Ingrese opcion: ");
        op = leer.nextInt();
        }while(op<1||op>4);
        if (op==1) {
            int sillas; 
            int personas_paradas;
            
            System.out.println("Ingrese numero de sillas: ");
            sillas = leer.nextInt();
            
            System.out.println("Ingrese capacidad de personas de pie: ");
            personas_paradas = leer.nextInt();
            
            retorno = new Buses(sillas, personas_paradas, placa, color, transportista);
            
        }
        if(op ==2){
            int sillas; 
            System.out.println("Ingrese numero de sillas: ");
            sillas = leer.nextInt();
            retorno = new Rapiditos(sillas, placa, color, transportista);
            
        }
        if (op ==3){
            int taxi; 
            System.out.println("Ingrese numero de taxi: ");
            taxi = leer.nextInt();
            
            retorno = new Taxis(taxi, placa, color, transportista);
        }
        if (op ==4) {
            retorno = new Mototaxis(placa, color, transportista);
        }
        return retorno; 
    }
    
    static String Listar(ArrayList lista, int x){
        String s=""; 
        if(x ==2){
            for (Object t : lista) {
               s += "\nPosicion: "+lista.indexOf(t)+"\n"+t+"\n"; 
            }
        }
        if (x==0){
            for (Object t : lista) {
                if(t instanceof Alumnos){
                    s += "\nPosicion -> "+lista.indexOf(t)+": \n"+t+"\n\n";
                }
            }
        }
        if(x==1){
            for (Object t : lista) {
                if(t instanceof Transportistas){
                    s += "Posicion -> "+lista.indexOf(t)+": \n"+t+"\n\n";
                }
            }
        }
        return s;
    }
    static String ListarTransportes(ArrayList lista){
        String s=""; // Collections.swap(lista, menu, menu);
        for (Object t : lista) {
            if(t instanceof Buses){
                s += "Posicion -> "+lista.indexOf(t)+": \n"+t+"\n\n";
            }
        }
        for (Object t : lista) {
            if(t instanceof Rapiditos){
                s += "Posicion -> "+lista.indexOf(t)+": \n"+t+"\n\n";
            }
        }
        for (Object t : lista) {
            if(t instanceof Taxis){
                s += "Posicion -> "+lista.indexOf(t)+": \n"+t+"\n\n";
            }
        }
        for (Object t : lista) {
            if(t instanceof Mototaxis){
                s += "Posicion -> "+lista.indexOf(t)+": \n"+t+"\n\n";
            }
        }
        return s;
    }
    
    
}//fin de la clase
