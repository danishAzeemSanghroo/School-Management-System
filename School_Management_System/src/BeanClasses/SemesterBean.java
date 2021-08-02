/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

import java.sql.Date;

/**
 *
 * @author Danish
 */
public class SemesterBean {

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Date getSemesterDate() {
        return semesterDate;
    }

    public void setSemesterDate(Date semesterDate) {
        this.semesterDate = semesterDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String toString(){
    return semester;
    }
    int classId;
    int semesterId;
    String semester;
    Date semesterDate;
    String remarks;
    
}
