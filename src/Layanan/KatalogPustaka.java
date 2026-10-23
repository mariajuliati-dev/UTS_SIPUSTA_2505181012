package layanan;
import model.KoleksiPustaka;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException; // [DIUBAH] Menambahkan import untuk PustakaException
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import eksepsi.KoleksiSedangDipinjamException;
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
    System.out.println("===== STATUS KATALOG PERPUSTAKAAN =====");

    for (KoleksiPustaka k : daftarKoleksi) {
        System.out.println("---------------------------------------");
        System.out.println("Kode: " + k.getKodeKoleksi());
        System.out.println("Judul: " + k.getJudul());
        System.out.println("Deskripsi:" );
        System.out.println(k.deskripsi());
        System.out.println("Layak Pinjam: " +
                (k.cekKelayakanPinjam() ? "Ya" : "Tidak"));
    }

    System.out.println("---------------------------------------");
}

    public void urut(Comparator<KoleksiPustaka> comparator) {
        Collections.sort(daftarKoleksi, comparator);
    }

    public void pinjam(String kodeKoleksi)
        throws PustakaException, // [DIUBAH] Menambahkan PustakaException ke daftar throws
               KoleksiTidakLayakException,
               KoleksiSedangDipinjamException {

    KoleksiPustaka target = null;

    for (KoleksiPustaka k : daftarKoleksi) {
        if (k.getKodeKoleksi().equalsIgnoreCase(kodeKoleksi)) {
            target = k;
            break;
        }
    }

    // [PERBAIKAN UTS] Mengganti KoleksiTidakLayakException menjadi PustakaException 
    if (target == null) {
        throw new PustakaException(
                "Koleksi dengan kode " + kodeKoleksi + " tidak ditemukan."
        );
    }

    if (!target.cekKelayakanPinjam()) {
        throw new KoleksiTidakLayakException(
                "Koleksi \"" + target.getJudul() + "\" tidak layak dipinjam."
        );
    }

    if (target.isSedangDipinjam()) {
        throw new KoleksiSedangDipinjamException(
                "Koleksi \"" + target.getJudul() + "\" sedang dipinjam."
        );
    }

    target.setSedangDipinjam(true);

    System.out.println(
            "Peminjaman berhasil! Silakan ambil koleksi: " + target.getJudul()
    );
    }
}
