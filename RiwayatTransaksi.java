import java.util.ArrayList;

public class RiwayatTransaksi {
    private ArrayList<TransaksiMasuk> daftarMasuk;
    private ArrayList<TransaksiKeluar> daftarKeluar;

    public void lihatRiwayat() {
        System.out.println("=== Riwayat Transaksi Masuk ===");
        for (TransaksiMasuk t : daftarMasuk) {
            System.out.println(t);
        }
        System.out.println("=== Riwayat Transaksi Keluar ===");
        for (TransaksiKeluar t : daftarKeluar) {
            System.out.println(t);
        }
    }

    public void simpanRiwayat(TransaksiMasuk transaksi) {
        daftarMasuk.add(transaksi);
        System.out.println("Riwayat transaksi masuk disimpan.");
    }

    public void simpanRiwayat(TransaksiKeluar transaksi) {
        daftarKeluar.add(transaksi);
        System.out.println("Riwayat transaksi keluar disimpan.");
    }
}
