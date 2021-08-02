/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

/**
 *
 * @author Danish
 */
public class WingBean {

    public int getWingId() {
        return wingId;
    }

    public void setWingId(int wingId) {
        this.wingId = wingId;
    }

    public String getWingName() {
        return wingName;
    }

    public void setWingName(String wingName) {
        this.wingName = wingName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String toString(){
    return wingName;
    }
    int wingId;
    String wingName;
    String remarks;
    
}
