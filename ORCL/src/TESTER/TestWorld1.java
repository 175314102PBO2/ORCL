/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TESTER;

import MODEL_HR.World;

/**
 *
 * @author admin
 */
public class TestWorld1 {

    public static void main(String[] args) {
        World test = new World();
        test.readRegions();
        System.out.println("Panjang = " + test.getListRegions().size());
        for (int i = 0; i < test.getListRegions().size(); i++) {
            System.out.println(test.getListRegions().get(i).toString());
        }
    }
}
