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
public class SessionBean {

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionYear() {
        return sessionYear;
    }

    public void setSessionYear(String sessionYear) {
        this.sessionYear = sessionYear;
    }

    public String getRemarks() {
        return remarks;
    }
    

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String toString(){
    return sessionYear;
    }
    int sessionId;
    String sessionYear;
    String remarks;
    
}
