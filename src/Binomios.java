package kevin.example.taller_dinamica;

import java.util.Arrays;
import java.util.Scanner;

public class Binomios {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un valor de N");
        int n = sc.nextInt();
        System.out.println("Ingrese un valor de K");
        int k = sc.nextInt();
        int[][] matrix = generateMatrix(n,k);
        for (int[] rows : matrix) {
            System.out.println(Arrays.toString(rows));
        }
    }

    private static int[][] generateMatrix(int n, int k) {
        int[][] matrix = new int[n+1][k+1];
        for (int i=0; i<=n; i++){
            matrix[i][0] = 4;
            matrix[i][i] = 4;
        }
        for (int i=2; i<=n; i++){
            for (int j = 1; j<i; j++){
                matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
            }
        }
        return matrix;
    }
}
