package logica;

import java.util.ArrayList;
import persistencia.registro;

public class Aerolinea {

    private String nombre;
    private ArrayList<Vuelo> vuelos;
    private int id;

    public Aerolinea(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        vuelos = new ArrayList();
    }

    public Aerolinea() { //Este constructuror está implementado para poder instanciar objetos con atributos nulos.

    }

    public void registrarVuelo(Vuelo vuelo) {
        registro registro = new registro();
        vuelos.add(vuelo);
        vuelo.setPasajeros(registro.lecturaPasajeros(vuelo.getId()));
    }

    public void cancelarVuelo(Vuelo vuelo) {
        vuelos.remove(vuelo);
    }

    public void editarVuelo(Vuelo vueloEditar) {
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getId() == vueloEditar.getId()) {
                vuelo = vueloEditar;
            }
        }
    }

    public String consultarAerolinea() {
        return "Nombre " + nombre + ", cantidad de vuelos " + vuelos.size();
    }

    public int totalPasajesVendidos() {
        int pasajesVendidos = 0;
        for (Vuelo vuelo : vuelos) {
            pasajesVendidos = pasajesVendidos + vuelo.getPasajeros().size();
        }
        return pasajesVendidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
