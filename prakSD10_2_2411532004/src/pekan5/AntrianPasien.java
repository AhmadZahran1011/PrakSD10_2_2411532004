package pekan5;

import java.util.Scanner;

public class AntrianPasien {
    
    // Node dalam Linked List
    static class Node {
        int noAntrian;
        String nama;
        String keluhan;
        Node next;

        Node(int noAntrian, String nama, String keluhan) {
            this.noAntrian = noAntrian;
            this.nama = nama;
            this.keluhan = keluhan;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    // 1. Tambah Pasien
    public void tambahPasien(int noAntrian, String nama, String keluhan) {
        Node pasienBaru = new Node(noAntrian, nama, keluhan);
        if (isEmpty()) {
            head = tail = pasienBaru;
        } else {
            tail.next = pasienBaru;
            tail = pasienBaru;
        }
        System.out.println("Data pasien berhasil ditambahkan!");
    }

    // 2. Tampilkan Antrian
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("--- Daftar Antrian Pasien ---");
        int i = 1;
        Node current = head;
        while (current != null) {
            System.out.println(i + ". [" + current.noAntrian + "] " + current.nama + " - " + current.keluhan);
            current = current.next;
            i++;
        }
    }

    // 3. Hapus Pasien Pertama
    public void hapusPasienPertama() {
        if (isEmpty()) {
            System.out.println("Antrian kosong. Tidak ada pasien yang bisa dilayani.");
            return;
        }
        System.out.println("Pasien dengan nama " + head.nama + " telah dilayani (dihapus dari antrian).");
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    // 4. Cari Pasien berdasarkan nama
    public void cariPasien(String nama) {
        Node current = head;
        boolean ditemukan = false;
        while (current != null) {
            if (current.nama.equalsIgnoreCase(nama)) {
                System.out.println("Pasien ditemukan:");
                System.out.println("[" + current.noAntrian + "] " + current.nama + " - " + current.keluhan);
                ditemukan = true;
                break;
            }
            current = current.next;
        }
        if (!ditemukan) {
            System.out.println("Pasien dengan nama \"" + nama + "\" tidak ditemukan dalam antrian.");
        }
    }

    // 5. Cek apakah antrian kosong
    public boolean isEmpty() {
        return head == null;
    }

    // 6. Hitung jumlah pasien
    public int hitungPasien() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // MAIN PROGRAM
    public static void main(String[] args) {
        AntrianPasien antrian = new AntrianPasien();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        System.out.println("=== SISTEM ANTRIAN PASIEN KLINIK ===");

        do {
            System.out.println("\n1. Tambah Pasien");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Layani Pasien (Hapus Antrian Pertama)");
            System.out.println("4. Cari Pasien");
            System.out.println("5. Jumlah Pasien");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    int no = scanner.nextInt();
                    scanner.nextLine(); // buffer
                    System.out.print("Masukkan Nama Pasien: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Keluhan: ");
                    String keluhan = scanner.nextLine();
                    antrian.tambahPasien(no, nama, keluhan);
                    break;
                case 2:
                    antrian.tampilkanAntrian();
                    break;
                case 3:
                    antrian.hapusPasienPertama();
                    break;
                case 4:
                    System.out.print("Masukkan nama pasien yang dicari: ");
                    String cariNama = scanner.nextLine();
                    antrian.cariPasien(cariNama);
                    break;
                case 5:
                    System.out.println("Jumlah pasien saat ini: " + antrian.hitungPasien());
                    break;
                case 6:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih ulang.");
            }

        } while (pilihan != 6);

        scanner.close();
    }
}

