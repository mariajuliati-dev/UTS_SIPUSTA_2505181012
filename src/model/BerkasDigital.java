package model;

/**
 *
 * @author Maria
 */
public class BerkasDigital extends KoleksiPustaka {
    private double ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kodeKoleksi, String judul, int tahunTerbit, double ukuranMB, String tautanUnduh) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public boolean cekKelayakanPinjam() {
        // Berkas digital selalu layak dipinjam
        return true;
    }

   @Override
    public String deskripsi() {
        return super.deskripsi()
                + "\nUkuran: " + ukuranMB + " MB"
                + "\nTautan: " + tautanUnduh;
}
}
