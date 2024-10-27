import java.util.Arrays;
import java.util.List;


/**
 * Clase Cliente
 * 
 * Es el punto de entrada la cual configura una lista de trabajadores y un objeto Maestro 
 * para estimar el valor de Pi, usando el metodo de Monte Carlo.
 * 
 */
public class Cliente {


    /**
     * Descripcion: Configura la lista de trabajadofres y el objeto Maestro, solicita una 
     * estimacion de Pi para mostrar posteriormente su resultado
     * @param args son argumentos de la linea de comandos, pero en este caso no son utilizados 
     */
    public static void main(String[] args) {

        // Configuración del maestro y los trabajadores
        List<Trabajador> trabajadores = Arrays.asList(new Trabajador(), new Trabajador(), new Trabajador());
        Maestro maestro = new Maestro(trabajadores);

       
        int N = 100000; // Numero de Puntos
        //Peticion para estimar Pi
        double estimacionPi = maestro.estimarPi(N);
        System.out.println("Estimación de Pi: " + estimacionPi); //Resultado 
    }
}