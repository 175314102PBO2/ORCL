/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL_RS;

/**
 *
 * @author ACER
 */
public class Dokter {

    private String idDokter;
    private String nama;

    public Dokter() {
    }

    public Dokter(String idDokter, String nama) {
        this.idDokter = idDokter;
        this.nama = nama;
    }

    /**
     * @return the idDokter
     */
    public String getIdDokter() {
        return idDokter;
    }

    /**
     * @param idDokter the idDokter to set
     */
    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String toString() {
        return idDokter + " " + nama;
    }
}
