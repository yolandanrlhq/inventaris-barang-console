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

    // === Login ===
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // === Input data baru ===
    public void tambahData(Scanner scanner) {
        System.out.println("\n=== Tambah Data Petugas ===");
        System.out.print("ID Petugas: ");
        this.id = scanner.nextLine();
        System.out.print("Nama: ");
        this.nama = scanner.nextLine();
        System.out.print("Username: ");
        this.username = scanner.nextLine();
        System.out.print("Password: ");
        this.password = scanner.nextLine();
        System.out.println("Petugas berhasil ditambahkan!\n");
    }

    // === Hapus data petugas berdasarkan ID ===
    public boolean hapusData(String id) {
        return this.id.equals(id);
    }

    // === Getter ===
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
