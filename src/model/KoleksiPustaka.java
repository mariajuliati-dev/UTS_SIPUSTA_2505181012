package model;

/**
 *
 * @author Maria
 */
public abstract class KoleksiPustaka {
    
    protected String kodeKoleksi;
    protected String judul;
    protected int tahunTerbit;

    public KoleksiPustaka(String kodeKoleksi, String judul, int tahunTerbit) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    public String getKodeKoleksi() {
        return kodeKoleksi;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public abstract boolean cekKelayakanPinjam();

    public String deskripsi() {
        return "Kode: " + kodeKoleksi + " | Judul: " + judul + " | Tahun: " + tahunTerbit;
    }
}
