import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AplikasiInventaris app = new AplikasiInventaris();

        // Tambah admin default
        app.kelolaPetugas(scanner);

        boolean loginSuccess = false;
        while (!loginSuccess) {
            System.out.println("\n=== Login Aplikasi Inventaris Barang ===");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (app.loginPetugas(username, password)) {
                loginSuccess = true;
                System.out.println("--------------------------------------------");
                System.out.println("Login berhasil! Selamat datang, admin.");
            } else {
                System.out.println("--------------------------------------------------");
                System.out.println("Username atau password salah. Silahkan coba lagi.");
                System.out.println("--------------------------------------------------");
            }
        }

        int pilihan;
        boolean keluar = false;
        do {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Petugas");
            System.out.println("2. Kelola Barang");
            System.out.println("3. Laporan Stok");
            System.out.println("4. Riwayat Transaksi"); 
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    app.KelolaPetugas(scanner);
                    break;               
                case 2:
                    app.kelolaBarang(scanner);
                    break;
                case 3:
                    app.kelolaLaporan();
                    break;
                case 4:
                    app.kelolaRiwayat();
                    break;
                case 5:
                    System.out.print("Apakah Anda yakin ingin keluar? (y/n): ");
                    String konfirmasi = scanner.nextLine();
                    if (konfirmasi.equalsIgnoreCase("y")) {
                        keluar = true;
                        System.out.println("Terima kasih telah menggunakan Aplikasi Inventaris Barang!");
                    } else {
                        System.out.println("Kembali ke menu utama...");
                    }
                    break;                    
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (!keluar);

        scanner.close();
    }
}
