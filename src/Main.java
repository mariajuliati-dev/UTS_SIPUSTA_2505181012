import Layanan.KatalogPustaka;
import Layanan.UrutLayakLaluJudul;
import model.BukuCetak;
import model.Majalah;
import model.BerkasDigital;
import eksepsi.PustakaException;
/**
 *
 * @author Maria
 */
public class Main {
    public static void main(String[] args) {
        KatalogPustaka katalog = new KatalogPustaka();

        katalog.tambahKoleksi(new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", false));
        katalog.tambahKoleksi(new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", true));
        katalog.tambahKoleksi(new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, "edisi 88", "Agustus", true));
        katalog.tambahKoleksi(new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, "edisi 87", "Juli", false));
        katalog.tambahKoleksi(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15.0, "unduh.polmed.ac.id/bd001"));
        katalog.tambahKoleksi(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8.0, "unduh.polmed.ac.id/bd002"));

        System.out.println("1. UJI CETAK STATUS POLIMORFIK");
        katalog.cetakStatus();

        System.out.println("2. UJI PENGURUTAN (UrutLayakLaluJudul)");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        System.out.println("\n 3. UJI VALIDASI PEMINJAMAN");
        try {
            katalog.pinjam("BK-002");
        } catch (PustakaException e) {
            System.out.println("Pesan Eksepsi Tertangkap: " + e.getMessage());
        }

        try {
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.out.println("Pesan Eksepsi Tertangkap: " + e.getMessage());
        }
        
        try {
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.out.println("Pesan Eksepsi Tertangkap: " + e.getMessage());
        }

        System.out.println("\n 4. UJI EKSPOR BERKAS TEKS (katalog.txt)");
        EksporKatalog.simpanKeBerkas(katalog, "katalog.txt");
    }
}
