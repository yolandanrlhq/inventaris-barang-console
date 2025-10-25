import java.util.Scanner;

public class Barang {
    private String id;
    private String nama;
    private String kategori;
    private String lokasi;
    private int jumlah;

    public Barang(String id, String nama, String kategori, String lokasi, int jumlah) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.lokasi = lokasi;
        this.jumlah = jumlah;
    }

    public void tambahData(Scanner scanner) {
        System.out.println("\n=== Tambah Data Barang ===");
        System.out.print("ID: "); this.id = scanner.nextLine();
        System.out.print("Nama: "); this.nama = scanner.nextLine();
        System.out.print("Kategori: "); this.kategori = scanner.nextLine();
        System.out.print("Lokasi: "); this.lokasi = scanner.nextLine();
        System.out.print("Jumlah: "); this.jumlah = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Barang berhasil ditambahkan!\n");
    }

    public void ubahData(Scanner scanner) {
        System.out.println("\n=== Ubah Data Barang ===");
        System.out.print("Nama baru: "); this.nama = scanner.nextLine();
        System.out.print("Kategori baru: "); this.kategori = scanner.nextLine();
        System.out.print("Lokasi baru: "); this.lokasi = scanner.nextLine();
        System.out.print("Jumlah baru: "); this.jumlah = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Data barang berhasil diubah!\n");
    }

    public void hapusData(String id) {
        if (this.id.equals(id)) {
            System.out.println("Barang dengan ID " + id + " berhasil dihapus.");
        }
    }

    public void lihatData() {        
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Kategori: " + kategori);
        System.out.println("Lokasi: " + lokasi);
        System.out.println("Jumlah: " + jumlah);
    }

    public void updateStok(int jumlah) {
        this.jumlah += jumlah;
        System.out.println("Stok barang berhasil diperbarui. Jumlah sekarang: " + this.jumlah);
    }

    public String getId() { 
        return id; 
    }
    public String getNama() { 
        return nama; 
    }
    public int getJumlah() { 
        return jumlah; 
    }
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
