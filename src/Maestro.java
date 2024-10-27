import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Clase Maestro 
 * 
 * Cordina una lista de trabajadores para realizar una estimacion 
 * del valor de pi, usando la implementacion del metodo de montecarlo.
 * 
 */
public class Maestro {
    private List<Trabajador> trabajadores;


    /**
     * Descripcion: Constructor de la clase Maestro 
     * @param trabajadores lista de objetos ded trabajador que realizaran la generacion de puntos.
     */
    public Maestro(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    /**
     * Descripcion: Estima el valor de pi dividiendo la tarea para asi generar
     * numeros aleatorios.
     * 
     * @param N numero de puntos que se generan para la estimacion 
     * @return la estimacion del valor de Pi
     */
    public double estimarPi(int N) {
        int n = trabajadores.size();
        int puntosPorTrabajador = N / n;
        ExecutorService executor = Executors.newFixedThreadPool(n);
        List<Future<Integer>> resultados = new ArrayList<>();

        // Distribuye el trabajo (Trabajadores)
        for (Trabajador trabajador : trabajadores) {
            Callable<Integer> tarea = () -> trabajador.generarPuntos(puntosPorTrabajador);
            resultados.add(executor.submit(tarea));
        }

        // Resultados recolectados
        int puntosDentroDelCirculo = 0;
        for (Future<Integer> resultado : resultados) {
            try {
                puntosDentroDelCirculo += resultado.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Se estima Pi
        executor.shutdown();
        return 4.0 * puntosDentroDelCirculo / N;
    }
}