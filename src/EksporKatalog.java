import Layanan.KatalogPustaka;
import model.KoleksiPustaka;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author Maria
 */

public class EksporKatalog {
    public static void simpanKeBerkas(KatalogPustaka katalog, String namaFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(namaFile))) {
            writer.println(String.format("%-10s | %-35s | %-10s | %-20s", "KODE", "JUDUL", "TAHUN", "STATUS LAYAK"));
            writer.println("----------------------------------------------------------------------------------");
            
            for (KoleksiPustaka k : katalog.getDaftarKoleksi()) {
                writer.println(String.format("%-10s | %-35s | %-10d | %-20s", 
                    k.getKodeKoleksi(), 
                    k.getJudul(), 
                    k.getTahunTerbit(), 
                    (k.cekKelayakanPinjam() ? "Layak" : "Tidak Layak")));
            }
            System.out.println("Katalog berhasil diekspor ke " + namaFile);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis berkas: " + e.getMessage());
        }
    }
}
