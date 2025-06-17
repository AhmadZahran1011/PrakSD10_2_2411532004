package Pekan8;

//Nama: Ahmad Zahran
//NIM: 2411532004

import java.util.Arrays;

public class TugasSortingLanjutan {

    public static void main(String[] args) {
        int[] deretPrima = new int[15];
        int indeks = 0;
        for (int i = 1; i <= 50; i++) {
            boolean prima = true;
            if (i < 2) prima = false;
            else {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        prima = false;
                        break;
                    }
                }
            }
            if (prima) {
                deretPrima[indeks++] = i;
            }
        }
        deretPrima = Arrays.copyOf(deretPrima, indeks);
        System.out.println("Deret awal: " + Arrays.toString(deretPrima));
        System.out.println("Algoritma: Bubble Sort");
        bubbleSortDescending(deretPrima);
        System.out.println("Hasil: " + Arrays.toString(deretPrima));
    }
    public static void bubbleSortDescending(int[] array) {
        int n = array.length;
        boolean ditukar;

        for (int i = 0; i < n - 1; i++) {
            ditukar = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    // Tukar
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    ditukar = true;
                    System.out.println("Tukar: " + Arrays.toString(array));
                }
            }
            if (!ditukar) break;
        }
    }
}
