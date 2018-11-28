/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testOracle;

import MODEL_RS.Dokter;
import MODEL_RS.RumahSakit;

/**
 *
 * @author admin
 */
public class TestRumahSakit1 {
    public static void main(String[] args) {
        RumahSakit rs = new RumahSakit("Panti Rapih", "Yogyakarta");
        Dokter dr1 = new Dokter("001", "Puspaningtyas");
        Dokter dr2 = new Dokter("002", "Budi");
        
        rs.tambahDokter(dr1);
        rs.tambahDokter(dr2);
        
        rs.simpanDataDokter();
}
}
