import java.io.Serializable;

public class alumnos implements Serializable {
    private String codigoMatricula;
    private String apellidos;
    private String nombre;
    private String convocatoriaAsignatura;

    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getConvocatoriaAsignatura() {
        return convocatoriaAsignatura;
    }



    public alumnos(String codigoMatricula, String apellidos, String nombre, String convocatoriaAsignatura) {
        this.codigoMatricula = codigoMatricula;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.convocatoriaAsignatura = convocatoriaAsignatura;
    }

    @Override
    public String toString() {
        return codigoMatricula + " " + nombre + " " + apellidos +" ," + convocatoriaAsignatura;
    }
}
