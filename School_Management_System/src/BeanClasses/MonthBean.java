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
public class MonthBean {

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getMonthId() {
        return monthId;
    }

    public void setMonthId(int monthId) {
        this.monthId = monthId;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String toString(){
    return monthName;
    }

    public int getWingId() {
        return wingId;
    }

    public void setWingId(int wingId) {
        this.wingId = wingId;
    }
    int wingId;
    int classId;
    int monthId;
    String monthName;
    String remarks;
}
