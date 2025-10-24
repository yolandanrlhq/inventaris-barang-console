import java.util.ArrayList;

public class LaporanStok {
    private ArrayList<Barang> daftarBarang;
    private String tanggalLaporan;

    public void tampilkanLaporan() {
        System.out.println("=== Laporan Stok Barang ===");
        for (Barang b : daftarBarang) {
            b.lihatData();
        }
    }
}
