package logica;

import java.util.*;
import persistencia.registro;

public class Aeropuerto {

    private String nombre;
    private ArrayList<Aerolinea> aerolineas;
    private int cantidadAerolineas;
    private ArrayList<Destino> destinos;
    private registro registro;

    public Aeropuerto(String nombre) {
        this.nombre = nombre;
        aerolineas = new ArrayList();
        cantidadAerolineas = 0;
        destinos = new ArrayList();
        registro = new registro();
    }

    public void agregarAerolineas(Aerolinea aerolinea) {
        aerolineas.add(aerolinea);
        cantidadAerolineas++;
    }
    
    public void agregarVuelos(Aerolinea aerolinea,Vuelo vuelo) {
        aerolinea.registrarVuelo(vuelo);
        registro.actualizarVuelos(aerolinea);
    }
    
    public void cancelarVuelos(Aerolinea aerolinea,Vuelo vuelo) {
        aerolinea.getVuelos().remove(vuelo);
        registro.actualizarVuelos(aerolinea);
    }

    public void guardarDestinos() {
        for (Aerolinea aerolinea : aerolineas) {
            for (Vuelo vuelo : aerolinea.getVuelos()) {
                destinos.add(vuelo.getDestino());
            }
        }
    }

    public ArrayList listaVuelos() {
        ArrayList vuelosAeropuerto = new ArrayList();
        for (Aerolinea aerolinea : aerolineas) {
            vuelosAeropuerto.add(aerolinea.getVuelos());
        }
        return vuelosAeropuerto;
    }

    public Vuelo seleccionarVuelo(int id) {
        Vuelo x = new Vuelo();
        for (Aerolinea aerolinea : aerolineas) {
            for (Vuelo vuelo : aerolinea.getVuelos()) {
                if (vuelo.getId() == id) {
                    x = vuelo;
                }
            }
        }
        return x;
    }

    public ArrayList<String> consultarVuelosAeropuertos() {
        ArrayList<String> vuelosConsultados = new ArrayList<>();
        for (Aerolinea a : aerolineas) {
            for (Vuelo v : a.getVuelos()) {
                vuelosConsultados.add("Aerolinea ID#" + a.getId() + ": " + a.getNombre() + " " + v.ConsultarVuelo());
            }
        }

        return vuelosConsultados;
    }

    public ArrayList destinosMasVisitados() {
        for (Aerolinea aerolinea : aerolineas) {
            for (Vuelo vuelo : aerolinea.getVuelos()) {
                for (Destino destino : destinos) {
                    if (vuelo.getDestino() == destino) {
                        destino.agregarVisitantes(vuelo.getPasajeros().size());
                    }
                }
            }
        }
        ArrayList<Destino> destinosMasVisitados = new ArrayList();
        Destino top1, top2, top3;
        top1 = new Destino();
        top2 = new Destino();
        top3 = new Destino();
        for (Destino destino : destinos) {
            if (destino.getVisitantes() > top1.getVisitantes()) {
                top3 = top2;
                top2 = top1;
                top1 = destino;
            } else if (destino.getVisitantes() > top2.getVisitantes()) {
                top3 = top2;
                top2 = destino;
            } else if (destino.getVisitantes() > top3.getVisitantes()) {
                top3 = destino;
            }
        }
        destinosMasVisitados.add(top1);
        destinosMasVisitados.add(top2);
        destinosMasVisitados.add(top3);
        return destinosMasVisitados;
    }

    public Aerolinea aerolineaMasUsada() { //NO SE USA
        Aerolinea aerolineaMasUsada = new Aerolinea();
        int pasajesVendidos = 0;
        for (Aerolinea aerolinea : aerolineas) {
            if (aerolinea.totalPasajesVendidos() > pasajesVendidos) {
                pasajesVendidos = aerolinea.totalPasajesVendidos();
                aerolineaMasUsada = aerolinea;
            }
        }
        return aerolineaMasUsada;
    }

    public Aerolinea seleccionarAerolinea(int idAerolinea) {
        Aerolinea aerolineaSeleccionada = new Aerolinea();
        for (Aerolinea aerolinea : aerolineas) {
            if (aerolinea.getId() == idAerolinea) {
                aerolineaSeleccionada = aerolinea;
            }
        }
        return aerolineaSeleccionada;
    }

    public int[] pasajerosPorEdad() {
        int[] pasajerosPorEdad = new int[2];
        int menores = 0, mayores = 0;
        for (Aerolinea aerolinea : aerolineas) {
            for (Vuelo vuelo : aerolinea.getVuelos()) {
                for (Pasajero pasajero : vuelo.getPasajeros()) {
                    if (pasajero.getEdad() < 18) {
                        menores++;
                    }
                    if (pasajero.getEdad() >= 18) {
                        mayores++;
                    }
                }
            }
        }
        pasajerosPorEdad[0] = mayores;
        pasajerosPorEdad[1] = menores;
        return pasajerosPorEdad;
    }

    public int[] pasajerosPorNacionalidad() {
        int pasajerosPorNacionalidad[] = new int[2];
        int colombianos = 0, extranjeros = 0;
        for (Aerolinea aerolinea : aerolineas) {
            for (Vuelo vuelo : aerolinea.getVuelos()) {
                for (Pasajero pasajero : vuelo.getPasajeros()) {
                    if (pasajero.getNacionalidad() == Nacionalidad.Colombiana) {
                        colombianos++;
                    }
                    if (pasajero.getNacionalidad() == Nacionalidad.Extranjera) {
                        extranjeros++;
                    }
                }
            }
        }
        
        pasajerosPorNacionalidad[0] = colombianos;
        pasajerosPorNacionalidad[1] = extranjeros;
        
        return pasajerosPorNacionalidad;
    }

    public int[] pasajerosPorSexo() {
        int pasajerosPorSexo[] = new int[2];
        int masculino = 0, femenino = 0;
        for (Aerolinea aerolinea : aerolineas) {
            for (Vuelo vuelo : aerolinea.getVuelos()) {
                for (Pasajero pasajero : vuelo.getPasajeros()) {
                    if (pasajero.getSexo() == Sexo.Masculino) {
                        masculino++;
                    }
                    if (pasajero.getSexo() == Sexo.Femenino) {
                        femenino++;
                    }
                }
            }
        }
        pasajerosPorSexo[0] = masculino;
        pasajerosPorSexo[1] = femenino;
        return pasajerosPorSexo;
    }

    public Aerolinea buscarAerolinea(int id) {
        Aerolinea aerolineaEncontrada = new Aerolinea();
        for (Aerolinea aerolinea : aerolineas) {
            for (Vuelo vuelo : aerolinea.getVuelos()) {
                if (vuelo.getId() == id) {
                    aerolineaEncontrada = aerolinea;
                }
            }
        }
        return aerolineaEncontrada;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadAerolineas() {
        return cantidadAerolineas;
    }

    public void setCantidadAerolineas(int cantidadAerolineas) {
        this.cantidadAerolineas = cantidadAerolineas;
    }

    public ArrayList<Aerolinea> getAerolineas() {
        return aerolineas;
    }

    public void setAerolineas(ArrayList<Aerolinea> aerolineas) {
        this.aerolineas = aerolineas;
    }

    public ArrayList<Destino> getDestinos() {
        return destinos;
    }

    public void setDestinos(ArrayList<Destino> destinos) {
        this.destinos = destinos;
    }
    
      /*public static void main(String[] args){
        
        Aeropuerto aeropuertoUIS = new Aeropuerto("Aeropuerto UIS");
        registro registro = new registro();
        Aerolinea aerolinea1 = new Aerolinea("American Airlines",100);
        Aerolinea aerolinea2 = new Aerolinea("Turkish Airlines",200);
        Aerolinea aerolinea3 = new Aerolinea("United Airlines",300);
        
        aerolinea1.setVuelos(registro.lecturaVuelos(100));
        aerolinea2.setVuelos(registro.lecturaVuelos(200));
        aerolinea3.setVuelos(registro.lecturaVuelos(300));
        
        aeropuertoUIS.agregarAerolineas(aerolinea1);
        aeropuertoUIS.agregarAerolineas(aerolinea2);
        aeropuertoUIS.agregarAerolineas(aerolinea3); 
        
        //aerolinea1.getVuelos().get(0).imprimir();
        
        
          System.out.println(aeropuertoUIS.pasajerosPorEdad()[0] + "  y  " + aeropuertoUIS.pasajerosPorEdad()[1]);
    } */

}
