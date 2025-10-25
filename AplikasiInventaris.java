import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiInventaris {
    private ArrayList<Petugas> daftarPetugas = new ArrayList<>();
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private ArrayList<TransaksiMasuk> daftarMasuk = new ArrayList<>();
    private ArrayList<TransaksiKeluar> daftarKeluar = new ArrayList<>();
    private Petugas petugasAktif;

    // === Inisialisasi petugas awal (admin default) ===
    public void kelolaPetugas(Scanner scanner) {
        Petugas p = new Petugas("P001", "Admin", "admin", "1234");
        daftarPetugas.add(p);
        petugasAktif = p;
    }

    // === LOGIN ===
    public boolean loginPetugas(String username, String password) {
        for (Petugas p : daftarPetugas) {
            if (p.login(username, password)) {
                petugasAktif = p;
                return true;
            }
        }
        return false;
    }

    // === MENU KELOLA PETUGAS ===
    public void KelolaPetugas(Scanner scanner) {
        int pilih;
        do {
            System.out.println("\n=== Kelola Data Petugas ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Lihat Data");
            System.out.println("0. Kembali");
            System.out.print("Pilih opsi: ");
            pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1:
                    Petugas p = new Petugas("", "", "", "");
                    p.tambahData(scanner);
                    daftarPetugas.add(p);
                    break;

                case 2:
                    System.out.print("Masukkan ID Petugas yang ingin dihapus: ");
                    String idHapus = scanner.nextLine();
                    boolean ditemukan = false;

                    for (int i = 0; i < daftarPetugas.size(); i++) {
                        Petugas petugas = daftarPetugas.get(i);
                        if (petugas.getId().equals(idHapus)) {
                            System.out.print("Apakah Anda yakin ingin menghapus petugas ini? (y/n): ");
                            String konfirmasi = scanner.nextLine();
                            if (konfirmasi.equalsIgnoreCase("y")) {
                                daftarPetugas.remove(i);
                                System.out.println("Data Petugas berhasil dihapus!");
                            } else {
                                System.out.println("Penghapusan dibatalkan.");
                            }
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Petugas dengan ID tersebut tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.println("\n=== Daftar Petugas ===");
                    if (daftarPetugas.isEmpty()) {
                        System.out.println("(Belum ada data petugas)");
                    } else {
                        for (Petugas pet : daftarPetugas) {
                            System.out.println(pet.getId() + " - " + pet.getNama() +
                                    " (" + pet.getUsername() + ") | Pass: " + pet.getPassword());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Kembali ke menu utama...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 0);
    }

    // === KELOLA BARANG ===
    public void kelolaBarang(Scanner scanner) {
        int pilih;
        do {
            System.out.println("\n-- Kelola Data Barang --");
            System.out.println("1. Tambah Data Barang");
            System.out.println("2. Ubah Data Barang");
            System.out.println("3. Hapus Data Barang");
            System.out.println("4. Lihat Data Barang");
            System.out.println("5. Barang Masuk");
            System.out.println("6. Barang Keluar");
            System.out.println("7. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1 -> {
                    Barang b = new Barang("", "", "", "", 0);
                    b.tambahData(scanner);
                    daftarBarang.add(b);
                }
                case 2 -> {
                    System.out.print("Masukkan ID Barang yang ingin diubah: ");
                    String idUbah = scanner.nextLine();
                    boolean ditemukanUbah = false;
                    for (Barang bItem : daftarBarang) {
                        if (bItem.getId().equals(idUbah)) {
                            bItem.ubahData(scanner);
                            ditemukanUbah = true;                            
                            break;
                        }
                    }
                    if (!ditemukanUbah) System.out.println("Barang dengan ID tersebut tidak ditemukan.");
                }
                case 3 -> {
                    System.out.print("Masukkan ID Barang yang ingin dihapus: ");
                    String idHapus = scanner.nextLine();
                    boolean ditemukanHapus = false;
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        if (daftarBarang.get(i).getId().equals(idHapus)) {
                            daftarBarang.remove(i);
                            System.out.println("Data barang berhasil dihapus!");
                            ditemukanHapus = true;
                            break;
                        }
                    }
                    if (!ditemukanHapus) System.out.println("Barang dengan ID tersebut tidak ditemukan.");
                }
                case 4 -> {
                    if (daftarBarang.isEmpty()) {
                        System.out.println("(Belum ada data barang)");
                    } else {
                        for (Barang bItem : daftarBarang) {
                            System.out.println("\n=== Daftar Barang ===");
                            bItem.lihatData();
                        }
                    }
                }
                case 5 -> kelolaTransaksiMasuk(scanner);
                case 6 -> kelolaTransaksiKeluar(scanner);
                case 7 -> System.out.println("Kembali ke menu utama...");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 7);
    }

    // === TRANSAKSI MASUK ===
    public void kelolaTransaksiMasuk(Scanner scanner) {
        System.out.println("\n=== TRANSAKSI BARANG MASUK ===");

        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada data barang. Tambahkan dulu sebelum transaksi.");
            return;
        }

        System.out.println("Daftar Barang:");
        for (Barang b : daftarBarang) {
            System.out.println(b.getId() + " - " + b.getNama() + " (Jumlah: " + b.getJumlah() + ")");
        }

        System.out.print("Masukkan ID Barang: ");
        String idBarang = scanner.nextLine();

        Barang barangDitemukan = null;
        for (Barang b : daftarBarang) {
            if (b.getId().equalsIgnoreCase(idBarang)) {
                barangDitemukan = b;
                break;
            }
        }

        if (barangDitemukan == null) {
            System.out.println("Barang dengan ID tersebut tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan jumlah barang masuk: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();

        // Tambah jumlah barang
        barangDitemukan.setJumlah(barangDitemukan.getJumlah() + jumlah);

        // Simpan transaksi
        TransaksiMasuk tm = new TransaksiMasuk(
            "TM" + (daftarMasuk.size() + 1),
            barangDitemukan,
            jumlah,
            petugasAktif,
            java.time.LocalDate.now().toString()
        );
        daftarMasuk.add(tm);

        System.out.println("Transaksi masuk berhasil dicatat!");
        System.out.println("Jumlah barang sekarang: " + barangDitemukan.getJumlah());
    }

    // === TRANSAKSI KELUAR ===
    public void kelolaTransaksiKeluar(Scanner scanner) {
        System.out.println("\n=== TRANSAKSI BARANG KELUAR ===");

        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada data barang. Tambahkan dulu sebelum transaksi.");
            return;
        }

        System.out.println("Daftar Barang:");
        for (Barang b : daftarBarang) {
            System.out.println(b.getId() + " - " + b.getNama() + " (Jumlah: " + b.getJumlah() + ")");
        }

        System.out.print("Masukkan ID Barang: ");
        String idBarang = scanner.nextLine();

        Barang barangDitemukan = null;
        for (Barang b : daftarBarang) {
            if (b.getId().equalsIgnoreCase(idBarang)) {
                barangDitemukan = b;
                break;
            }
        }

        if (barangDitemukan == null) {
            System.out.println("Barang dengan ID tersebut tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan jumlah barang keluar: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();

        if (jumlah > barangDitemukan.getJumlah()) {
            System.out.println("Jumlah keluar melebihi stok yang tersedia!");
            return;
        }

        // Kurangi jumlah barang
        barangDitemukan.setJumlah(barangDitemukan.getJumlah() - jumlah);

        // Simpan transaksi
        TransaksiKeluar tk = new TransaksiKeluar(
            "TK" + (daftarKeluar.size() + 1),
            barangDitemukan,
            jumlah,
            petugasAktif,
            java.time.LocalDate.now().toString()
        );
        daftarKeluar.add(tk);

        System.out.println("Transaksi keluar berhasil dicatat!");
        System.out.println("Jumlah barang sekarang: " + barangDitemukan.getJumlah());
    }

    // === RIWAYAT TRANSAKSI (gabungan masuk + keluar) ===
    public void kelolaRiwayat() {
        System.out.println("\n=== Riwayat Transaksi ===");

        if (daftarMasuk.isEmpty() && daftarKeluar.isEmpty()) {
            System.out.println("(Belum ada transaksi yang dicatat)");
            return;
        }

        int i = 1;
        for (TransaksiMasuk tm : daftarMasuk) {
            System.out.println(i++ + ". [Masuk]  " + tm.getNamaBarang() + " - " + tm.getJumlah() + " unit");
        }
        for (TransaksiKeluar tk : daftarKeluar) {
            System.out.println(i++ + ". [Keluar] " + tk.getNamaBarang() + " - " + tk.getJumlah() + " unit");
        }
    }

    // === LAPORAN STOK (sederhana) ===
    public void kelolaLaporan() {
        System.out.println("\n=== Laporan Stok Barang ===");
        if (daftarBarang.isEmpty()) {
            System.out.println("(Belum ada data barang)");
            return;
        }

        // Loop data barang
        for (Barang b : daftarBarang) {
            String status;
            if (b.getJumlah() <= 0) {
                status = "Habis";
            } else if (b.getJumlah() <= 5) {
                status = "Menipis";
            } else {
                status = "Aman";
            }

            System.out.println("ID\t: " + b.getId());
            System.out.println("Nama\t: " + b.getNama());
            System.out.println("Stok\t: " + b.getJumlah());
            System.out.println("Status\t: " + status);
            System.out.println();
        }

        System.out.println("---------------------------------------");
        System.out.println("Total Barang\t: " + daftarBarang.size());

        // Format tanggal seperti "23/10/25"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String tanggalCetak = LocalDate.now().format(formatter);
        System.out.println("Tanggal Cetak\t: " + tanggalCetak);
    }
}
