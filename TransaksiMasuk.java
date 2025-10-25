import java.time.LocalDate;
import java.util.UUID;

public class TransaksiMasuk {
    private String id;
    private String tanggal;
    private int jumlah;
    private Barang barang;
    private Petugas petugas;

    // Constructor sederhana
    public TransaksiMasuk(String namaBarang, int jumlah) {
        this.jumlah = jumlah;
        this.barang = new Barang("", namaBarang, "", "", 0); // Barang sementara
        this.tanggal = LocalDate.now().toString();
        this.id = "TM" + UUID.randomUUID().toString().substring(0, 4);
        this.petugas = null;
    }

    // Constructor lengkap
    public TransaksiMasuk(String id, Barang barang, int jumlah, Petugas petugas, String tanggal) {
        this.id = id;
        this.barang = barang;
        this.jumlah = jumlah;
        this.petugas = petugas;
        this.tanggal = tanggal;
    }

    // Getter
    public String getId() { return id; }
    public String getTanggal() { return tanggal; }
    public int getJumlah() { return jumlah; }
    public String getNamaBarang() { return barang.getNama(); }
    public Barang getBarang() { return barang; }
    public Petugas getPetugas() { return petugas; }

    // Method manipulasi
    public void catatMasuk() {
        System.out.println("Transaksi masuk dicatat untuk barang " + barang.getNama() + " pada tanggal " + tanggal);
    }

    public void ubahData(int jumlahBaru) {
        this.jumlah = jumlahBaru;
        System.out.println("Data transaksi masuk " + id + " diperbarui dengan jumlah " + jumlah);
    }

    public void hapusData() {
        System.out.println("Transaksi masuk dengan ID " + id + " dihapus.");
    }
}
