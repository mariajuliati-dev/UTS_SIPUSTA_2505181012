package model;

/**
 *
 * @author Maria
 */
public class BukuCetak extends KoleksiPustaka implements Terarsip {
    private int jumlahHalaman;
    private String nomorRak;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kodeKoleksi, String judul, int tahunTerbit, int jumlahHalaman, String nomorRak, boolean sedangDiperbaiki) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public boolean cekKelayakanPinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Halaman: " + jumlahHalaman + " | Status Perbaikan: " + (sedangDiperbaiki ? "Sedang Diperbaiki" : "Tidak");
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public int lokasiLantai() {
        return 1;
    }
}
