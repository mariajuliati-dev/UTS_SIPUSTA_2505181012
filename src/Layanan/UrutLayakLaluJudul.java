package Layanan;
import model.KoleksiPustaka;
import java.util.Comparator;
/**
 *
 * @author Maria
 */
public class UrutLayakLaluJudul implements Comparator<KoleksiPustaka> {
    @Override
    public int compare(KoleksiPustaka k1, KoleksiPustaka k2) {
        Boolean layak1 = k1.cekKelayakanPinjam();
        Boolean layak2 = k2.cekKelayakanPinjam();
        int hasilKelayakan = layak2.compareTo(layak1);
        
        if (hasilKelayakan != 0) {
            return hasilKelayakan;
        }
        return k1.getJudul().compareTo(k2.getJudul());
    }
}
