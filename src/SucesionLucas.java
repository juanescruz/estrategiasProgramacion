package kevin.example.taller_dinamica;

import java.util.ArrayList;
import java.util.Scanner;

public class SucesionLucas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt();
        System.out.println(lucas(pos));
    }

    private static int lucas(int pos) {
        return lucasDinamico(pos, new ArrayList<>());
    }

    private static int lucasDinamico(int pos, ArrayList<Integer> integers) {
        integers.add(2);
        integers.add(1);
        if (pos == 0){
            return integers.get(0);
        }
        if (pos == 1){
            return integers.get(1);
        }
        for (int i=2; i<=pos; i++){
            integers.add(i, (integers.get(i-1)+integers.get(i-2)));
        }

        return integers.get(pos);
    }
}
