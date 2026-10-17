package model;

/**
 *
 * @author Maria
 */
public interface Terarsip {
    String nomorRak();
    int lokasiLantai();
    
    default String ringkasanArsip() {
        return "Nomor Rak: " + nomorRak() + " | Lantai: " + lokasiLantai();
    }
}
