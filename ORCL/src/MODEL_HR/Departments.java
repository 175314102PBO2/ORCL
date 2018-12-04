/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL_HR;

import UTIL.MyOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class Departments {

    private int department_id;
    private String department_name;
    private ArrayList<Employee> listEmployees = new ArrayList<Employee>();
    private ArrayList<Employee> managers = new ArrayList<Employee>();

    public Departments(int department_id, String department_name) {
        this.department_id = department_id;
        this.department_name = department_name;
    }

    public void readEmployees() {
        try {
            // buat koneksi
            MyOracle ora = new MyOracle("172.23.9.185", "1521", "orcl", "MHS175314102", "MHS175314102");
            //step2 create  the connection object
            Connection con = ora.getConnection();
            //step3 create the statement object
            Statement stmt = con.createStatement();
            //step4 execute query
            String query = "SELECT FIRST_NAME, LAST_NAME\n"
                    + "FROM MHS175314102.EMPLOYEES \n"
                    + "WHERE EMPLOYEES.DEPARTMENT_ID = 10";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
//                System.out.println(rs.getString(1) + "  " + rs.getString(2));
                Employee reg = new Employee(rs.getString(1), rs.getString(2));
                listEmployees.add(reg);
            }
            //step5 close the connection object
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void readManager() {

    }

    public Departments() {
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public ArrayList<Employee> getListEmployees() {
        return listEmployees;
    }

    public void setListEmployees(ArrayList<Employee> listEmployees) {
        this.listEmployees = listEmployees;
    }

    public ArrayList<Employee> getManagers() {
        return managers;
    }

    /**
     * @param managers the managers to set
     */
    public void setManagers(ArrayList<Employee> managers) {
        this.managers = managers;
    }
}
