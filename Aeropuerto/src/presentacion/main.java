/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.util.ArrayList;
import logica.*;
import persistencia.*;

/**
 *
 * @author FELIX
 */
public class main extends vtSistemaAeoropuerto {

    public void iniciar() {

        try {
            registro registro = new registro();

            Aerolinea aerolinea1 = new Aerolinea("American Airlines", 100);
            Aerolinea aerolinea2 = new Aerolinea("Turkish Airlines", 200);
            Aerolinea aerolinea3 = new Aerolinea("United Airlines", 300);

            aerolinea1.setVuelos(registro.lecturaVuelos(100));
            aerolinea2.setVuelos(registro.lecturaVuelos(200));
            aerolinea3.setVuelos(registro.lecturaVuelos(300));
            
            
            vtSistemaAeoropuerto.getAeropuertoUIS().agregarAerolineas(aerolinea1);
            vtSistemaAeoropuerto.getAeropuertoUIS().agregarAerolineas(aerolinea2);
            vtSistemaAeoropuerto.getAeropuertoUIS().agregarAerolineas(aerolinea3);
            
         /**   for (Aerolinea aerolinea: vtSistemaAeoropuerto.getAeropuertoUIS().getAerolineas()){
                for(Vuelo vuelo: aerolinea.getVuelos()){
                    vuelo.setPasajeros(registro.lecturaPasajeros(1));
                }
            }
         **/
            
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
