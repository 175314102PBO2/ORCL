/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL_RS;

import UTIL.MyOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class RumahSakit {

    private String nama;
    private String alamat;

    private ArrayList<Dokter> daftarDokter = new ArrayList<Dokter>();
    private ArrayList<Pasien> daftarPasien = new ArrayList<Pasien>();

    public RumahSakit() {
    }

    public RumahSakit(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    /**
     * Fungsi untuk tambah dokter di array list
     *
     * @param dokter
     */
    public void tambahDokter(Dokter dokter) {
        getDaftarDokter().add(dokter);
    }

    /**
     * Fungsi untuk menyimpan data dari array list masuk ke database
     */
    public void simpanDataDokter() {
        try {
            // buat kelas database

            MyOracle ora = new MyOracle("172.23.9.185", "1521", "orcl", "MHS175314102", "MHS175314102");
            // buat koneksi
            Connection con = ora.getConnection();
            // buat statement
            Statement statement = con.createStatement();
            // buat query
            String query;
            if (getDaftarDokter().isEmpty()) {
                // daftar dokter kosong
                JOptionPane.showMessageDialog(null, "Dokter tidak ada");
            } else {
                // daftar dokter tidak kosoong
                for (int i = 0; i < getDaftarDokter().size(); i++) {
                    Dokter temp = getDaftarDokter().get(i);
                    // buat query
                    query = "SELECT ID_DOKTER, NAMA "
                            + "FROM MHS175314102.DOKTER" + temp.getIdDokter() + "','"
                            + temp.getNama();
                    // eksekusi query
                    statement.execute(query);
                    con.commit();
                }
            }
            // tutup koneksi
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(RumahSakit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fungsi untuk membaca data dari database masuk ke arrayList
     */
    public void bacaDataDokter() {
        try {
            // buat kelas database
            MyOracle ora = new MyOracle("172.23.9.185", "1521", "orcl",
                    "MHS175314102", "MHS175314102");
            // buat koneksi
            Connection con = ora.getConnection();
            // buat statement
            Statement statement = con.createStatement();
            // buat query
            // SELECT id_dokter,nama from puspa.dokter 
            String query = "SELECT ID_DOKTER, NAMA "
                    + "FROM MHS175314102.DOKTER";
            // kosongkan list 
            setDaftarDokter(new ArrayList<Dokter>());
            // jalankan/eksekusi queri
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Dokter temp = new Dokter();
                temp.setIdDokter(rs.getString("id_dokter"));
                temp.setNama(rs.getString(2));
                // tambahkan ke list
                getDaftarDokter().add(temp);
            }
            // tutup koneksi
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(RumahSakit.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the daftarDokter
     */
    public ArrayList<Dokter> getDaftarDokter() {
        return daftarDokter;
    }

    /**
     * @param daftarDokter the daftarDokter to set
     */
    public void setDaftarDokter(ArrayList<Dokter> daftarDokter) {
        this.daftarDokter = daftarDokter;
    }

    /**
     * @return the daftarPasien
     */
    public ArrayList<Pasien> getDaftarPasien() {
        return daftarPasien;
    }

    /**
     * @param daftarPasien the daftarPasien to set
     */
    public void setDaftarPasien(ArrayList<Pasien> daftarPasien) {
        this.daftarPasien = daftarPasien;
    }
}
