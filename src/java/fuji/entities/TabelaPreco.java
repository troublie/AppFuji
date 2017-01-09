/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.entities;

/**
 *
 * @author juliano.lopes
 */
public class TabelaPreco {
    private int id;
    private String duhn;
    private String duhe;
    private String duhe2;
    private String ddu;
    private String fshn;
    private String fshe;
    private String fshe2;
    private String dfs;
    
    public TabelaPreco (int id, String nome, String duhn, String duhe, String duhe2, String ddu, String fshn, String fshe, String fshe2, String dfs){
        this.id = id;
        this.duhn = duhn;
        this.duhe = duhe;
        this.duhe2 = duhe2;
        this.ddu = ddu;
        this.fshn = fshn;
        this.fshe = fshe;
        this.fshe2 = fshe2;
        this.dfs = dfs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuhn() {
        return duhn;
    }

    public void setDuhn(String duhn) {
        this.duhn = duhn;
    }

    public String getDuhe() {
        return duhe;
    }

    public void setDuhe(String duhe) {
        this.duhe = duhe;
    }

    public String getDuhe2() {
        return duhe2;
    }

    public void setDuhe2(String duhe2) {
        this.duhe2 = duhe2;
    }

    public String getDdu() {
        return ddu;
    }

    public void setDdu(String ddu) {
        this.ddu = ddu;
    }

    public String getFshn() {
        return fshn;
    }

    public void setFshn(String fshn) {
        this.fshn = fshn;
    }

    public String getFshe() {
        return fshe;
    }

    public void setFshe(String fshe) {
        this.fshe = fshe;
    }

    public String getFshe2() {
        return fshe2;
    }

    public void setFshe2(String fshe2) {
        this.fshe2 = fshe2;
    }

    public String getDfs() {
        return dfs;
    }

    public void setDfs(String dfs) {
        this.dfs = dfs;
    }
    
}
