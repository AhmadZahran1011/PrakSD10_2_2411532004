package pekan2;

import java.util.*;


public class Parkir1 {
	    ArrayList<mobil> daftarMobil = new ArrayList<>();

	    public void tambahMobil(String platNomor) {
	        daftarMobil.add(new mobil(platNomor));
	        System.out.println("Mobil dengan plat " + platNomor + " ditambahkan.");
	    }

	    public void keluarkanMobil(String platNomor) {
	    	  boolean ditemukan = false;
	          for (int i = 0; i < daftarMobil.size(); i++) {
	              if (daftarMobil.get(i).getPlatNomor().equalsIgnoreCase(platNomor)) {
	                  daftarMobil.remove(i);
	                  System.out.println("Mobil dengan plat " + platNomor + " dikeluarkan.");
	                  ditemukan = true;
	                  break;
	            }
	        }
	        if (!ditemukan) {
	            System.out.println("Mobil tidak ditemukan di parkiran.");
	        }
	    }

	    public void tampilkanParkiran() {
	        if (daftarMobil.isEmpty()) {
	            System.out.println("Parkiran kosong.");
	        } else {
	            System.out.println("Isi Parkiran:");
	            for (mobil m : daftarMobil) {
	                System.out.println("- " + m.getPlatNomor());
	            }
	        }
	    }

	    public void cariMobil(String platNomor) {
	        for (mobil m : daftarMobil) {
	            if (m.getPlatNomor().equalsIgnoreCase(platNomor)) {
	                System.out.println("Mobil ditemukan di parkiran.");
	                return;
	            }
	        }
	        System.out.println("Mobil tidak ditemukan di parkiran.");
	    }
	


	    public static void main(String[] args) {
	        Parkir1 parkir1 = new Parkir1();
	        Scanner scanner = new Scanner(System.in);

	        // Tambahkan 7 mobil awal
	        String[] platAwal = {
	            "BA1111AA", "BA2222BB", "BA3333CC", "BA4444DD",
	            "BA5555EE", "BA6666FF", "BA7777GG"
	        };
	        for (String plat : platAwal) {
	            parkir1.tambahMobil(plat);
	        }

	        while (true) {
	            System.out.println("\n=== Menu Parkiran Mobil ===");
	            System.out.println("1. Tambah mobil ke Parkiran");
	            System.out.println("2. Keluarkan mobil dari Parkiran");
	            System.out.println("3. Tampilkan isi Parkiran");
	            System.out.println("4. Cari mobil di Parkiran");
	            System.out.println("5. Keluar");
	            System.out.print("Pilih Opsi: ");
	            
	            int pilihan = scanner.nextInt();
	            scanner.nextLine(); // Buang newline

	            switch (pilihan) {
	                case 1:
	                    System.out.print("Masukkan plat nomor: ");
	                    parkir1.tambahMobil(scanner.nextLine());
	                    break;
	                case 2:
	                    System.out.print("Masukkan plat nomor yang ingin dikeluarkan: ");
	                    parkir1.keluarkanMobil(scanner.nextLine());
	                    break;
	                case 3:
	                    parkir1.tampilkanParkiran();
	                    break;
	                case 4:
	                    System.out.print("Masukkan plat nomor yang ingin dicari: ");
	                    parkir1.cariMobil(scanner.nextLine());
	                    break;
	                case 5:
	                    System.out.println("Terima kasih!");
	                    return;
	                default:
	                    System.out.println("Opsi tidak valid.");
	            }scanner.close();
	        }
	      
	    }
	}


	



