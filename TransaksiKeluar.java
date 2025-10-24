public class TransaksiKeluar {
    private String id;
    private String tanggal;
    private int jumlah;
    private Barang barang;
    private Petugas petugas;

    public void catatKeluar(String idBarang, String jumlah, int stok, String tanggal) {
        System.out.println("Transaksi keluar dicatat untuk barang " + idBarang + " pada tanggal " + tanggal);
    }

    public void ubahData(String id, int jumlah) {
        System.out.println("Data transaksi keluar " + id + " diperbarui dengan jumlah " + jumlah);
    }

    public void hapusData(String id) {
        System.out.println("Transaksi keluar dengan ID " + id + " dihapus.");
    }
}
