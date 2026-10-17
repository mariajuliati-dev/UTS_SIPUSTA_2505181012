package Layanan;
import model.KoleksiPustaka;
import eksepsi.KoleksiTidakLayakException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author Maria
 */
public class KatalogPustaka {
    private List<KoleksiPustaka> daftarKoleksi;

    public KatalogPustaka() {
        this.daftarKoleksi = new ArrayList<>();
    }

    public void tambahKoleksi(KoleksiPustaka koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<KoleksiPustaka> getDaftarKoleksi() {
        return daftarKoleksi;
    }

    public void cetakStatus() {
        System.out.println("STATUS KATALOG PERPUSTAKAAN");
        for (KoleksiPustaka k : daftarKoleksi) {
            System.out.println(k.deskripsi());
            System.out.println("-> Layak Dipinjam: " + (k.cekKelayakanPinjam() ? "Ya" : "Tidak"));
            System.out.println("--------------------------------------------------");
        }
    }

    public void urut(Comparator<KoleksiPustaka> comparator) {
        Collections.sort(daftarKoleksi, comparator);
    }

    public void pinjam(String kodeKoleksi) throws KoleksiTidakLayakException {
        KoleksiPustaka target = null;
        for (KoleksiPustaka k : daftarKoleksi) {
            if (k.getKodeKoleksi().equalsIgnoreCase(kodeKoleksi)) {
                target = k;
                break;
            }
        }

        if (target == null) {
            throw new KoleksiTidakLayakException("Maaf, koleksi dengan kode " + kodeKoleksi + " tidak ditemukan di sistem perpustakaan.");
        }

        if (!target.cekKelayakanPinjam()) {
            throw new KoleksiTidakLayakException("Maaf, koleksi \"" + target.getJudul() + "\" saat ini tidak layak untuk dipinjam.");
        }

        System.out.println("Peminjaman berhasil! Silakan ambil koleksi: " + target.getJudul());
    }
}
