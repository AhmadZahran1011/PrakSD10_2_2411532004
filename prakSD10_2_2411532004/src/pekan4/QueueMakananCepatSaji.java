package pekan4;

import java.util.*;

class Pelanggan {
    String id;
    int jumlahPesanan;

    Pelanggan(String id, int jumlahPesanan) {
        this.id = id;
        this.jumlahPesanan = jumlahPesanan;
    }
}

public class QueueMakananCepatSaji {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Pelanggan> antrian = new LinkedList<>();

        System.out.print("Masukkan jumlah pelanggan: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            int jumlahPesanan = scanner.nextInt();
            antrian.add(new Pelanggan(id, jumlahPesanan));
        }

        int waktuTotal = 0;
        while (!antrian.isEmpty()) {
            Pelanggan p = antrian.remove();
            waktuTotal += p.jumlahPesanan;
            System.out.println(p.id + " selesai dalam " + waktuTotal + " menit");
        }

        scanner.close();
    }
}
