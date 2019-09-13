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
public class ProgramUpdateMasterBean {
    private int programUpdateId,programId;
    private String updateDate;

    public int getProgramUpdateId() {
        return programUpdateId;
    }

    public void setProgramUpdateId(int programUpdateId) {
        this.programUpdateId = programUpdateId;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
    
}


