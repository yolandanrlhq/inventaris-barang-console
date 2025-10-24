import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AplikasiInventaris app = new AplikasiInventaris();

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
        do {
            System.out.println("=== Menu Utama ===");
            System.out.println("1. Kelola Barang");
            System.out.println("2. Transaksi Masuk");
            System.out.println("3. Transaksi Keluar");
            System.out.println("4. Laporan Stok");
            System.out.println("5. Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    app.kelolaBarang(scanner);
                    break;
                case 2:
                    app.kelolaTransaksiMasuk(scanner);
                    break;
                case 3:
                    app.kelolaTransaksiKeluar(scanner);
                    break;
                case 4:
                    app.kelolaLaporan();
                    break;
                case 5:
                    app.kelolaRiwayat();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
