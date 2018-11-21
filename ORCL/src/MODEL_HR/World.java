/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL_HR;

import MODEL_HR.Region;
import UTIL.MyOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class World {

    private ArrayList<Region> listRegions = new ArrayList<Region>();

    public World() {
    }

    public void readRegions() {
        try {
            // buat koneksi
            MyOracle ora = new MyOracle("172.23.9.185", "1521", "orcl", "MHS175314102", "MHS175314102");
            //step2 create  the connection object
            Connection con = ora.getConnection();
            //step3 create the statement object
            Statement stmt = con.createStatement();
            //step4 execute query
            String query = "select * from Region";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
//                System.out.println(rs.getString(1) + "  " + rs.getString(2));
                Region reg = new Region(rs.getInt(1), rs.getString(2));
                listRegions.add(reg);
            }
            //step5 close the connection object
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the listRegions
     */
    public ArrayList<Region> getListRegions() {
        return listRegions;
    }

    /**
     * @param listRegions the listRegions to set
     */
    public void setListRegions(ArrayList<Region> listRegions) {
        this.listRegions = listRegions;
    }

}
