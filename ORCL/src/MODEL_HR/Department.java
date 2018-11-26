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
 * @author admin
 */
public class Department {
     private int deparment_ID;
    private String department_name;

    private ArrayList<Employee> listEmployees = new ArrayList<Employee>();

    private ArrayList<Employee> manager = new ArrayList<Employee>();

    public Department() {
    }

    public Department(int deparment_ID, String department_name) {
        this.deparment_ID = deparment_ID;
        this.department_name = department_name;
    }

    /**
     * Fungsi untuk membaca daftar/table employee lalu dipindahkan ke list
     * daftar employees;
     */
    public void readEmployees() {
        try {
            MyOracle ora = new MyOracle("172.23.9.185", "1521", "orcl", "puspa", "puspa");
            Connection con = ora.getConnection();
            Statement stmt = con.createStatement();
            String query = "select * from employees where department_id = "+getDeparment_ID();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Employee emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3));
                listEmployees.add(emp);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //step5 close the connection object
    /**
     * Fungsi untuk membaca manager sebuah departemen
     */
    public void readManager() {
try {
            MyOracle ora = new MyOracle("172.23.9.185", "1521", "orcl", "puspa", "puspa");
            Connection con = ora.getConnection();
            Statement stmt = con.createStatement();
            String query = "select m.employee_id, m.first_name, m.last_name from employees e "
                    +" "+"join employees m on e.manager_id = m.employee_id"
                    +" "+ "where e.department_id = "+ getDeparment_ID();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Employee emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3));
                manager.add(emp);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the deparment_ID
     */
    public int getDeparment_ID() {
        return deparment_ID;
    }

    /**
     * @param deparment_ID the deparment_ID to set
     */
    public void setDeparment_ID(int deparment_ID) {
        this.deparment_ID = deparment_ID;
    }

    /**
     * @return the department_name
     */
    public String getDepartment_name() {
        return department_name;
    }

    /**
     * @param department_name the department_name to set
     */
    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    /**
     * @return the listEmployees
     */
    public ArrayList<Employee> getListEmployees() {
        return listEmployees;
    }

    /**
     * @param listEmployees the listEmployees to set
     */
    public void setListEmployees(ArrayList<Employee> listEmployees) {
        this.listEmployees = listEmployees;
    }

    /**
     * @return the manager
     */
    public ArrayList<Employee> getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(ArrayList<Employee> manager) {
        this.manager = manager;
    }


}
