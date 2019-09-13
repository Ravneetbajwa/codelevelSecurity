/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelevelsecurity.beans;

/**
 *
 * @author win8
 */
public class ProgramAccessMasterBean {
    private int programAccessId,userId,programId;
    private String accessDate;

    public int getProgramAccessId() {
        return programAccessId;
    }

    public void setProgramAccessId(int programAccessId) {
        this.programAccessId = programAccessId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(String accessDate) {
        this.accessDate = accessDate;
    }
    
}
