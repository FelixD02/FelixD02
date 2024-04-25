package logica;

import javax.swing.JOptionPane;

public class Usuario {

    private String nombre;
    private long documento;
    private String contraseña;
    private static int cantidadUsuarios = 0;

    public Usuario(String nombre, long documento, String contraseña) {
        if (cantidadUsuarios < 1) {
            this.nombre = nombre;
            this.documento = documento;
            this.contraseña = contraseña;
            Usuario.cantidadUsuarios++;
        }
        else {
            JOptionPane.showMessageDialog(null, "No es posible crear un Usuario ahora");
        }
    }

    public boolean iniciarSesion(long documento, String contraseña) {
        return (documento == getDocumento() && contraseña.equals(getContraseña()));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
