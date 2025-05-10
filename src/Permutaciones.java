public class Permutaciones {

    // Función que calcula el factorial de un número n
    static long factorial(int n) {
        long res = 1; // Inicializa el resultado en 1
        for (int i = 2; i <= n; i++) {
            res *= i; // Multiplica res por cada número desde 2 hasta n
        }
        return res; // Retorna el valor del factorial
    }

    // Función que calcula la permutación P(n, k)
    static long permutacion(int n, int k) {
        // Aplica la fórmula P(n, k) = n! / (n - k)!
        return factorial(n) / factorial(n - k);
    }

    public static void main(String[] args) {
        int n = 8, k = 3; // Prueba: asignar 3 medallas entre 8 participantes
        System.out.println("Ejecución Permutaciones"+"\n"+"P(" + n + "," + k + ") = " + permutacion(n, k));
    }
}
