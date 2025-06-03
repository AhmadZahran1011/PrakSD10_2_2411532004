package pekan6;

import java.util.*;

public class DaftarBelanja {
    private Node head;
    private Node tail;

    public void tambahItem(String nama, int kuantitas, String kategori) {
        ItemBelanja item = new ItemBelanja(nama, kuantitas, kategori);
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Item berhasil ditambahkan!");
    }
    public void hapusItem(String nama) {
        Node current = head;

        while (current != null) {
            if (current.data.nama.equalsIgnoreCase(nama)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Item berhasil dihapus.");
                return;
            }
            current = current.next;
        }
        System.out.println("Item tidak ditemukan.");
    }
    public void tampilkanSemuaItem() {
        if (head == null) {
            System.out.println("Daftar belanja kosong.");
            return;
        }
        System.out.println("--- Daftar Belanja ---");
        Node current = head;
        while (current != null) {
            ItemBelanja item = current.data;
            System.out.printf("- %s (%d) [%s]%n", item.nama, item.kuantitas, item.kategori);
            current = current.next;
        }
    }

    public void tampilkanPerKategori(String kategori) {
        boolean ditemukan = false;
        Node current = head;
        System.out.printf("--- Item dalam kategori '%s' ---%n", kategori);
        while (current != null) {
            if (current.data.kategori.equalsIgnoreCase(kategori)) {
                System.out.printf("- %s (%d)%n", current.data.nama, current.data.kuantitas);
                ditemukan = true;
            }
            current = current.next;
        }

        if (!ditemukan) {
            System.out.println("Tidak ada item dalam kategori tersebut.");
        }
    }

    public void cariItem(String nama) {
        Node current = head;
        while (current != null) {
            if (current.data.nama.equalsIgnoreCase(nama)) {
                ItemBelanja item = current.data;
                System.out.printf("Item ditemukan: %s (%d) [%s]%n", item.nama, item.kuantitas, item.kategori);
                return;
            }
            current = current.next;
        }
        System.out.println("Item tidak ditemukan.");
    }

        public static void main(String[] args) {
            DaftarBelanja daftar = new DaftarBelanja();
            Scanner input = new Scanner(System.in);
            int pilihan;

            do {
                System.out.println("\n=== MENU DAFTAR BELANJA ===");
                System.out.println("1. Tambah Item");
                System.out.println("2. Hapus Item");
                System.out.println("3. Tampilkan Semua Item");
                System.out.println("4. Tampilkan Item Berdasarkan Kategori");
                System.out.println("5. Cari Item");
                System.out.println("6. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = input.nextInt();
                input.nextLine(); // membersihkan buffer

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan nama item: ");
                        String nama = input.nextLine();
                        System.out.print("Masukkan kuantitas: ");
                        int qty = input.nextInt();
                        input.nextLine(); // buffer
                        System.out.print("Masukkan kategori: ");
                        String kategori = input.nextLine();
                        daftar.tambahItem(nama, qty, kategori);
                        break;

                    case 2:
                        System.out.print("Masukkan nama item yang ingin dihapus: ");
                        String hapusNama = input.nextLine();
                        daftar.hapusItem(hapusNama);
                        break;

                    case 3:
                        daftar.tampilkanSemuaItem();
                        break;

                    case 4:
                        System.out.print("Masukkan kategori: ");
                        String kat = input.nextLine();
                        daftar.tampilkanPerKategori(kat);
                        break;

                    case 5:
                        System.out.print("Masukkan nama item yang ingin dicari: ");
                        String cari = input.nextLine();
                        daftar.cariItem(cari);
                        break;

                    case 6:
                        System.out.println("Terima kasih!");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } while (pilihan != 6);

            input.close();
        }
    }
