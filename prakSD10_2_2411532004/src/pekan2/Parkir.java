package pekan2;

import java.util.ArrayList;
import java.util.Scanner;

public class Parkir {

	public static void main(String[] args) {
		ArrayList<mobil> daftarMobil = new ArrayList<>();
		Scanner scanner = new Scanner (System.in);
		
		 String[] platAwal = {
		            "BA1111AA", "BA2222BB", "BA3333CC", "BA4444DD",
		            "BA5555EE", "BA6666FF", "BA7777GG"
		        };
		 		for (String plat : platAwal) {
	            daftarMobil.add(new mobil(plat));
		        }
		int choice;
		do {
			System.out.println("menu:");
			System.out.println("1. Tambah mobil ke parkiran");
			System.out.println("2. Keluarkan mobil dari parkiran");
			System.out.println("3. Tampilkan isi parkiran");
			System.out.println("4. Cari mobil di parkiran");
			System.out.println("5. Keluar");
			System.out.print("Pilih Menu: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // costume newline
			switch (choice) {
			   case 1:
                   System.out.print("Masukkan Plat: ");
                   String platBaru = scanner.nextLine();
                   daftarMobil.add(new mobil(platBaru));
                   break;

               case 2:
                   System.out.print("Masukkan plat mobil yang dikeluarkan: ");
                   String platHapus = scanner.nextLine();
                   boolean removed = daftarMobil.removeIf(m -> m.getPlatNomor().equalsIgnoreCase(platHapus));
                   if (removed) {
                       System.out.println("Mobil dikeluarkan.");
                   } else {
                       System.out.println("Mobil tidak ditemukan.");
                   }
                   break;

               case 3:
                   System.out.println("Data Mobil:");
                   for (mobil m : daftarMobil) {
                       System.out.println(m);
                   }
                   break;

               case 4:
                   System.out.print("Masukkan plat nomor yang dicari: ");
                   String platCari = scanner.nextLine();
                   boolean found = false;
                   for (mobil m : daftarMobil) {
                       if (m.getPlatNomor().equalsIgnoreCase(platCari)) {
                           System.out.println("Mobil ditemukan: " + m);
                           found = true;
                           break;
                       }
                   }
                   if (!found) {
                       System.out.println("Mobil tidak ditemukan.");
                   }
                   break;

               case 5:
                   System.out.println("Keluar dari program.");
                   break;

               default:
                   System.out.println("Pilihan tidak valid.");
           }
		}while (choice != 5);
		scanner.close();
	}	
}
