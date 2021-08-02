/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;

/**
 *
 * @author Danish
 */
public class StudentPromotionBean {

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getProClassId() {
        return proClassId;
    }

    public void setProClassId(int proClassId) {
        this.proClassId = proClassId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPromotionDate() {
        return promotionDate;
    }

    public void setPromotionDate(Date promotionDate) {
        this.promotionDate = promotionDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    int classId;
    int stdId;
    int sessionId;
    int proClassId;
    String description;
    Date promotionDate;
    String remarks;
//============================================================================================================================================
    String name;

    String stdCnic;
 
    String stdMobile;
    Date dateOfAddmission;
   
    String passingYear;
   
    
    String fName;
    String fCnic;
    String fMobile;
    String fQualification;
    String fOccupation;
    String mName;
    String mCnic;
    String mMobile;
    String mQualification;
    String mOccupation;
    String gName;
    String gCnic;
    String gMobile;
    String gQualification;
    String gOccupation;
    String gRelationship;  
    
    
    
        

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStdCnic() {
        return stdCnic;
    }

    public void setStdCnic(String stdCnic) {
        this.stdCnic = stdCnic;
    }

    public String getStdMobile() {
        return stdMobile;
    }

    public void setStdMobile(String stdMobile) {
        this.stdMobile = stdMobile;
    }

    public Date getDateOfAddmission() {
        return dateOfAddmission;
    }

    public void setDateOfAddmission(Date dateOfAddmission) {
        this.dateOfAddmission = dateOfAddmission;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(String passingYear) {
        this.passingYear = passingYear;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfCnic() {
        return fCnic;
    }

    public void setfCnic(String fCnic) {
        this.fCnic = fCnic;
    }

    public String getfMobile() {
        return fMobile;
    }

    public void setfMobile(String fMobile) {
        this.fMobile = fMobile;
    }

    public String getfQualification() {
        return fQualification;
    }

    public void setfQualification(String fQualification) {
        this.fQualification = fQualification;
    }

    public String getfOccupation() {
        return fOccupation;
    }

    public void setfOccupation(String fOccupation) {
        this.fOccupation = fOccupation;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCnic() {
        return mCnic;
    }

    public void setmCnic(String mCnic) {
        this.mCnic = mCnic;
    }

    public String getmMobile() {
        return mMobile;
    }

    public void setmMobile(String mMobile) {
        this.mMobile = mMobile;
    }

    public String getmQualification() {
        return mQualification;
    }

    public void setmQualification(String mQualification) {
        this.mQualification = mQualification;
    }

    public String getmOccupation() {
        return mOccupation;
    }

    public void setmOccupation(String mOccupation) {
        this.mOccupation = mOccupation;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgCnic() {
        return gCnic;
    }

    public void setgCnic(String gCnic) {
        this.gCnic = gCnic;
    }

    public String getgMobile() {
        return gMobile;
    }

    public void setgMobile(String gMobile) {
        this.gMobile = gMobile;
    }

    public String getgQualification() {
        return gQualification;
    }

    public void setgQualification(String gQualification) {
        this.gQualification = gQualification;
    }

    public String getgOccupation() {
        return gOccupation;
    }

    public void setgOccupation(String gOccupation) {
        this.gOccupation = gOccupation;
    }

    public String getgRelationship() {
        return gRelationship;
    }

    public void setgRelationship(String gRelationship) {
        this.gRelationship = gRelationship;
    }
//==========================================================================================================================================================    
}
