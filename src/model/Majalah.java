package model;

/**
 *
 * @author Maria
 */
public class Majalah extends KoleksiPustaka implements Terarsip {
    private String edisi;
    private String bulanTerbit;
    private boolean edisiTerbaru;

    public Majalah(String kodeKoleksi, String judul, int tahunTerbit, String edisi, String bulanTerbit, boolean edisiTerbaru) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.edisiTerbaru = edisiTerbaru;
    }

    @Override
    public boolean cekKelayakanPinjam() {
        // Layak apabila bukan edisi terbaru
        return !edisiTerbaru;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Edisi: " + edisi + " | Bulan: " + bulanTerbit + " | Terbaru: " + edisiTerbaru;
    }

    @Override
    public String nomorRak() {
        return "B-04"; // Contoh nomor rak khusus majalah
    }

    @Override
    public int lokasiLantai() {
        return 2;
    }
}
