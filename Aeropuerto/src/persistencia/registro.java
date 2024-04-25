
package persistencia;

import java.io.*;
import java.util.*;
import logica.*;

public class registro {
    
    public ArrayList<Pasajero> lecturaPasajeros(int id){
        ArrayList<Pasajero> pasajeros = new ArrayList();
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(new File("src/persistencia/pasajeros/PasajerosVuelo"+id+".txt")));
            String line = reader.readLine();
            while(line != null){
                String[] lineSplit = line.split(";");
                Pasajero pasajero;
                pasajero = new Pasajero(Integer.parseInt(lineSplit[0]),Nacionalidad.valueOf(lineSplit[1]),Sexo.valueOf(lineSplit[2]),lineSplit[3],Long.parseLong(lineSplit[4]));
                pasajeros.add(pasajero);
                line = reader.readLine();
            } reader.close();
            
        }catch (Exception e){
            e.getMessage();
        }
        return pasajeros;
    }
    
    public void actualizarPasajeros(ArrayList<Pasajero> arraylist, int id){ //ESTE METODO YA NO SE USARÁ
        BufferedWriter writer;
        try{
            writer = new BufferedWriter(new FileWriter(new File("src/persistencia/pasajeros/PasajerosVuelo"+id+".txt")));
            for (Pasajero arrayPasajero : arraylist){
                writer.write(arrayPasajero.getEdad()+";"+arrayPasajero.getNacionalidad()+";"+arrayPasajero.getSexo()+";"+arrayPasajero.getNombre()+";"+arrayPasajero.getDocumento()+ "\n");
            }
            writer.close();
            
        }catch (Exception a){
            a.getMessage();
        }
    }
    
    public ArrayList<Vuelo> lecturaVuelos(int id){
        ArrayList<Vuelo> vuelos = new ArrayList();
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(new File("src/persistencia/vuelos/VuelosAerolinea"+id+".txt")));
            String line = reader.readLine();
            while(line != null){
                String[] lineSplit = line.split(";");
                Vuelo vuelo;
                Destino destino = new Destino(lineSplit[0]);
                vuelo = new Vuelo(destino, lineSplit[1], Double.parseDouble(lineSplit[2]), Integer.parseInt(lineSplit[3]),  Integer.parseInt(lineSplit[4]),  Integer.parseInt(lineSplit[5]), lineSplit[6],  Integer.parseInt(lineSplit[7]));
                vuelo.setPasajeros(lecturaPasajeros(Integer.parseInt(lineSplit[7])));
                vuelos.add(vuelo);
                line = reader.readLine();
            }reader.close();
        }catch(Exception e){
            e.getMessage();
        }
        return vuelos;
    }
    
    public void actualizarVuelos(Aerolinea aerolinea){
        BufferedWriter writer;
       try{
            writer = new BufferedWriter(new FileWriter(new File("src/persistencia/vuelos/VuelosAerolinea"+aerolinea.getId()+".txt")));
            for(Vuelo vuelo : aerolinea.getVuelos()){
                writer.write(vuelo.getDestino().getNombre()+";"+vuelo.getAvion()+";"+vuelo.getPrecio()+";"+vuelo.getDia()+";"+vuelo.getMes()+";"+vuelo.getAño()+";"+vuelo.getHora()+";"+vuelo.getId());
            }
            writer.close();
       }catch(Exception e){
           e.getMessage();
       }
    }
    
}
