import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        ArrayList<alumnos> alumnosBD = new ArrayList<>();
        ArrayList<alumnos> alumnosIS = new ArrayList<>();
        ArrayList<alumnos> alumnosResultado = new ArrayList<>();


        //nombres de los archivos
        String nombreArchivo1 = " Alumnos_BD.ser";
        String nombreArchivo2 = " Alumnos_IS.ser";
        String nombreArchivo3 = " Resultado.ser";


        //Creo los alumnos de BD y los añado al arraylist
        alumnos a1 = new alumnos("C2324", "López García", "Luis", "BD-1");
        alumnos a2 = new alumnos("C2327", "García Pérez", "María ", "BD-2");
        alumnos a3 = new alumnos("C2328", "Pérez Pérez", "José", "BD-1");

        alumnosBD.add(a1);
        alumnosBD.add(a2);
        alumnosBD.add(a3);

        //Creo los alumnos de IS y los añado a su arraylist
        alumnos a4 = new alumnos("C2324", "López García", "Luis", "IS-1");
        alumnos a5 = new alumnos("C2326", "Álvarez Pérez", "Luisa ", "BD-3");
        alumnos a6 = new alumnos("C2328", "Pérez Pérez", "José", "IS-1");

        alumnosIS.add(a4);
        alumnosIS.add(a5);
        alumnosIS.add(a6);

        //escribimos el array 1 (BD) en un archivo
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo1));

            oos.writeObject(alumnosBD);

            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //escribimos el array 2 (IS) en un archivo
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo2));

            oos.writeObject(alumnosIS);

            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //añadimos los alumnos de BD e IS a un array conjunto y creamos el archivo Resultado.ser
        alumnosResultado.addAll(alumnosIS);
        alumnosResultado.addAll(alumnosBD);


        //ordenamos el array por departamento y luego por nombre
        alumnosResultado.sort(Comparator.comparing(alumnos::getCodigoMatricula));

        //pruebas
        for(alumnos a : alumnosResultado){
            System.out.println(a);}

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo3));

            oos.writeObject(alumnosResultado);

            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}