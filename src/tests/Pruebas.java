package tests;
import java.util.Arrays;
import java.util.List;
import javaa.Trabajador;
import javaa.Maestro;


public class Pruebas {

    public static void main(String[] args) {
        // Configuración del maestro y los trabajadores
        List<Trabajador> trabajadores = Arrays.asList(new Trabajador(), new Trabajador(), new Trabajador());
        Maestro maestro = new Maestro(trabajadores);

        // Diferentes valores de N para realizar las pruebas
        int[] puntos = { 1_000, 10_000, 100_000, 1_000_000};

        // Realizar pruebas
        for (int N : puntos) {
            // Medir tiempo de ejecución
            long inicioT = System.currentTimeMillis();
            double estimacionPi = maestro.estimarPi(N);
            long finT = System.currentTimeMillis();
            long duracion = finT - inicioT;

            // Imprimir resultados
            System.out.printf("Número de puntos: %d, Estimación de Pi: %.5f, Tiempo de ejecución: %d ms%n.", N, estimacionPi, duracion);
        }
    }
}

    

