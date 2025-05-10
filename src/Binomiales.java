public class Binomiales {

    // Función que calcula el factorial de un número entero n
    static long factorial(int n) {
        long res = 1; // Inicializa el resultado en 1
        for (int i = 2; i <= n; i++) {
            res *= i; // Multiplica res por cada número desde 2 hasta n
        }
        return res; // Retorna el valor del factorial de n
    }

    // Función que calcula el coeficiente binomial C(n, k)
    static long binomial(int n, int k) {
        // Aplica la fórmula combinatoria: n! / (k! * (n - k)!)
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static void main(String[] args) {
        int n = 4, k = 2; // Valores de prueba para n & k
        // Imprime el resultado del coeficiente binomial C(n, k)
        System.out.println("Ejecución Binomiales"+"\n"+"C(" + n + "," + k + ") = " + binomial(n, k));
    }
}
