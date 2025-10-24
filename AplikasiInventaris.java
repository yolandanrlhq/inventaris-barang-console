import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiInventaris {
    private ArrayList<Petugas> daftarPetugas = new ArrayList<>();
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private ArrayList<TransaksiMasuk> daftarMasuk = new ArrayList<>();
    private ArrayList<TransaksiKeluar> daftarKeluar = new ArrayList<>();
    private Petugas petugasAktif;

    public void kelolaPetugas(Scanner scanner) {
        Petugas p = new Petugas("P001", "Admin", "admin", "1234");
        daftarPetugas.add(p);
        petugasAktif = p;
    }

    public boolean loginPetugas(String username, String password) {
        for (Petugas p : daftarPetugas) {
            if (p.login(username, password)) {
                petugasAktif = p;
                return true;
            }
        }
        return false;
    }

    public void kelolaBarang(Scanner scanner) {
        Barang b = new Barang("", "", "", "", 0);
        b.tambahData(scanner);
        daftarBarang.add(b);
    }

    public void kelolaTransaksiMasuk(Scanner scanner) {
        System.out.println("Catat Transaksi Masuk...");
    }

    public void kelolaTransaksiKeluar(Scanner scanner) {
        System.out.println("Catat Transaksi Keluar...");
    }

    public void kelolaRiwayat() {
        System.out.println("Tampilkan Riwayat Transaksi...");
    }

    public void kelolaLaporan() {
        System.out.println("Tampilkan Laporan Stok...");
    }
}
