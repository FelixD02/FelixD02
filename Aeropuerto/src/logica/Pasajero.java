package logica;

public class Pasajero{

    private int edad;
    private Nacionalidad nacionalidad;
    private Sexo sexo;
    private long documento;
    private String nombre;

    public Pasajero(int edad, Nacionalidad nacionalidad, Sexo sexo, String nombre, long documento) {
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.documento = documento;
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pasajero{" + "edad=" + edad + ", nacionalidad=" + nacionalidad + ", sexo=" + sexo + ", documento=" + documento + ", nombre=" + nombre + '}';
    }
    
    
    
}
