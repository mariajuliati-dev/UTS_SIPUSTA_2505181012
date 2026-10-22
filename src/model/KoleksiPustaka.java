package model;

/**
 *
 * @author Maria
 */
public abstract class KoleksiPustaka {
    
    protected String kodeKoleksi;
    protected String judul;
    protected int tahunTerbit;
    private boolean sedangDipinjam;

    public KoleksiPustaka(String kodeKoleksi, String judul, int tahunTerbit) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.sedangDipinjam = false;
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
    
    public boolean isSedangDipinjam() {
        return sedangDipinjam;
    }
    public void setSedangDipinjam(boolean sedangDipinjam) {
        this.sedangDipinjam = sedangDipinjam;
    }

    public abstract boolean cekKelayakanPinjam();

    public String deskripsi() {
        return "Kode: " + kodeKoleksi
                + "\nJudul: " + judul
                + "\nTahun: " + tahunTerbit;
}
}
