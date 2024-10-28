package javaa;
import java.util.Random;

/**
 * Clase Trabajador 
 * 
 * Esta clase se encarga de generar puntos aleatorios dentro de un cuadrado de lado 2
 * centrado en el origen, contanto cuantos puntos de ellos caen dentro de un circulo de 
 * raido 1 centrado en el origen 
 */
public class Trabajador {

    //Genera numero aleatorios 
    private Random random = new Random();

    /**
     * Desripcion: Genera N puntos en el espacio y cuenta cuantos de esos
     * caen dentro del circulo (radio 1
     * 
     * @param N numero de puntos que se generaran
     * @return numero de puntos que caen dentro del circulo de radio 1
     */
    public int generarPuntos(int N) {
        int dentroCirculo = 0;
        for (int i = 0; i < N; i++) {
            double x = random.nextDouble() * 2 - 1; // Generar punto en [-1, 1]
            double y = random.nextDouble() * 2 - 1;
            if (x * x + y * y <= 1) {
                dentroCirculo++;
            }
        }
        return dentroCirculo;
    }
}