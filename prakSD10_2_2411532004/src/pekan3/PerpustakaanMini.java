package pekan3;

import java.util.Scanner;
import java.util.Stack;

class Buku{
	String judul;
	Buku (String judul) {
		this.judul = judul;
    }
}
class PerpustakaanMini {
    Stack<Buku> tumpukanBuku = new Stack<>();

    public PerpustakaanMini() {
        tambahBuku(new Buku("Algoritma Dasar"));
        tambahBuku(new Buku("Struktur Data"));
        tambahBuku(new Buku("Basis Data"));
        tambahBuku(new Buku("Pemrograman Java"));
        tambahBuku(new Buku("Jaringan Komputer"));
        tambahBuku(new Buku("Sistem Operasi"));
        tambahBuku(new Buku("Kecerdasan Buatan"));
    }

    public void tambahBuku(Buku buku) {
        tumpukanBuku.push(buku);
        System.out.println("Buku " + buku.judul + " telah ditambahkan.");
    }

    public void ambilBuku() {
        if (tumpukanBuku.isEmpty()) {
            System.out.println("Tumpukan kosong. Tidak ada buku yang dapat diambil.");
        } else {
            Buku diambil = tumpukanBuku.pop();
            System.out.println("Buku diambil: " + diambil.judul);
        }
    }

    public void lihatTumpukan() {
        if (tumpukanBuku.isEmpty()) {
            System.out.println("Tumpukan kosong.");
        } else {
            System.out.println("Tumpukan Buku Saat Ini:");
            for (int i = tumpukanBuku.size() - 1; i >= 0; i--) {
                System.out.println("- " + tumpukanBuku.get(i).judul);
            }
        }
    }

    public void cariBuku(String judul) {
        boolean ditemukan = false;
        for (Buku buku : tumpukanBuku) {
            if (buku.judul.equalsIgnoreCase(judul)) {
                ditemukan = true;
                break;
            }
        }
        if (ditemukan) {
            System.out.println("Buku " + judul + " ditemukan dalam tumpukan.");
        } else {
            System.out.println("Buku " + judul + " tidak ditemukan.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PerpustakaanMini perpustakaan = new PerpustakaanMini();

        int pilihan;
        do {
            System.out.println("1. Tambah Buku ke Tumpukan");
            System.out.println("2. Ambil Buku Teratas");
            System.out.println("3. Lihat Tumpukan Buku");
            System.out.println("4. Cari Buku");
            System.out.println("5. Keluar");
            System.out.print("\nPilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judul = scanner.nextLine();
                    perpustakaan.tambahBuku(new Buku(judul));
                    break;
                case 2:
                    perpustakaan.ambilBuku();
                    break;
                case 3:
                    perpustakaan.lihatTumpukan();
                    break;
                case 4:
                    System.out.print("Masukkan judul buku yang dicari: ");
                    String cari = scanner.nextLine();
                    perpustakaan.cariBuku(cari);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan Perpustakaan Mini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}
