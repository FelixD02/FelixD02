package logica;

public class Destino {

    private String nombre;
    private int visitantes;

    public Destino(String nombre) {
        this.nombre = nombre;
        visitantes = 0;
    }
    
    public Destino(){ //Este constructuror está implementado para poder instanciar objetos con atributos nulos.
        this.nombre = "";
        this.visitantes = 0;
    }
    
    public void agregarVisitantes(int visitantesNuevos){
        this.visitantes = visitantes + visitantesNuevos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(int visitantes) {
        this.visitantes = visitantes;
    }

    @Override
    public String toString() {
        return "Destino: " + nombre;
    }
    
    

}
