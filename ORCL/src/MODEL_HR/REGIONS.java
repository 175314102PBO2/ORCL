/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL_HR;

/**
 *
 * @author admin
 */
public class REGIONS {

    private int region_id;
    private String region_name;

    public REGIONS(int region_id, String region_name) {
        this.region_id = region_id;
        this.region_name = region_name;
    }

    public REGIONS() {
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }
}
