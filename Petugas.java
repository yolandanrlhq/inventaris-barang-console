import java.util.Scanner;

public class Petugas {
    private String id;
    private String nama;
    private String username;
    private String password;

    public Petugas(String id, String nama, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void tambahData(Scanner scanner) {
        System.out.println("=== Tambah Data Petugas ===");
        System.out.print("ID: ");
        this.id = scanner.nextLine();
        System.out.print("Nama: ");
        this.nama = scanner.nextLine();
        System.out.print("Username: ");
        this.username = scanner.nextLine();
        System.out.print("Password: ");
        this.password = scanner.nextLine();
        System.out.println("Petugas berhasil ditambahkan!\n");
    }

    public void ubahData(Scanner scanner) {
        System.out.println("=== Ubah Data Petugas ===");
        System.out.print("Nama baru: ");
        this.nama = scanner.nextLine();
        System.out.print("Username baru: ");
        this.username = scanner.nextLine();
        System.out.print("Password baru: ");
        this.password = scanner.nextLine();
        System.out.println("Data petugas berhasil diubah!\n");
    }

    public void hapusData(String id) {
        if (this.id.equals(id)) {
            System.out.println("Petugas dengan ID " + id + " berhasil dihapus.");
        }
    }

    public String getNama() {
        return nama;
    }
}
