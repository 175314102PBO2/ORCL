/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL_HR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class MYORCL {

    private String username;
    private String password;
    private String IPADDRESS;
    private String port;
    private String SID;

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getSID() {
        return SID;
    }

    public Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object  
            String connString = "jdbc:oracle:thin:@" + IPADDRESS + ":" + port + ":" + SID + ", " + username
                    + ", " + password + "";
            con = DriverManager.getConnection(connString);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MYORCL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MYORCL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public MYORCL() {
    }

    public MYORCL(String username, String password, String IPADDRESS, String port, String SID) {
        this.username = username;
        this.password = password;
        this.IPADDRESS = IPADDRESS;
        this.port = port;
        this.SID = SID;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIPADDRESS() {
        return IPADDRESS;
    }

    public void setIPADDRESS(String IPADDRESS) {
        this.IPADDRESS = IPADDRESS;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
