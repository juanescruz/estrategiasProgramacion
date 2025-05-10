package kevin.example.taller_dinamica;

public class DynamicBag {

    static int[] values = {2, 5, 10, 14, 15};
    static int[] weights = {1, 3, 4, 5, 7};
    static int valuesLength = values.length;
    static int maxWeight = 8;
    static int[][] memo = new int[valuesLength][maxWeight + 1];

    public static void main(String[] args) {
        // Inicializar con -1 para indicar "no calculado aún"
        for (int i = 0; i < valuesLength; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                memo[i][w] = -1;
            }
        }

        int maxValue = guardar(valuesLength - 1, maxWeight);
        System.out.println("Valor máximo en la mochila: " + maxValue);
    }

    static int guardar(int i, int maxWeight) {
        // Caso base: sin objetos o capacidad cero
        if (i < 0 || maxWeight == 0) {
            return 0;
        }
        // Ya está memroizado
        if (memo[i][maxWeight] != -1) {
            return memo[i][maxWeight];
        }

        int result;
        if (weights[i] > maxWeight) {
            // No cabe el objeto i
            result = guardar(i - 1, maxWeight);
        } else {
            // Opción 1: no tomar i
            int anterior = guardar(i - 1, maxWeight);
            // Opción 2: tomar i
            int actual = values[i] + guardar(i - 1, maxWeight - weights[i]);
            result = Math.max(anterior, actual);
        }

        // Guardar en tabla
        memo[i][maxWeight] = result;
        return result;
    }
}
