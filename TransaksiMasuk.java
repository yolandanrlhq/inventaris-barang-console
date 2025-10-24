public class TransaksiMasuk {
    private String id;
    private String tanggal;
    private int jumlah;
    private Barang barang;
    private Petugas petugas;

    public void catatMasuk(String idBarang, String jumlah, int stok, String tanggal) {
        System.out.println("Transaksi masuk dicatat untuk barang " + idBarang + " pada tanggal " + tanggal);
    }

    public void ubahData(String id, int jumlah) {
        System.out.println("Data transaksi masuk " + id + " diperbarui dengan jumlah " + jumlah);
    }

    public void hapusData(String id) {
        System.out.println("Transaksi masuk dengan ID " + id + " dihapus.");
    }
}
