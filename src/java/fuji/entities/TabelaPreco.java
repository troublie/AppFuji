/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author juliano.lopes
 */
@Entity
@Table(name = "TabelaPreco")
public class TabelaPreco {

    @Id
    @Column(name = "tabelapreco_id")
    @SequenceGenerator(name = "tabelaPrecoGenerator", sequenceName = "tabelapreco_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tabelaPrecoGenerator")
    private int id;

    @Column(name = "TabelaPrecoNome")
    private String nome;
    @Column(name = "duhn")
    private String duhn;
    @Column(name = "duhe")
    private String duhe;
    @Column(name = "duhe2")
    private String duhe2;
    @Column(name = "ddu")
    private String ddu;
    @Column(name = "fshn")
    private String fshn;
    @Column(name = "fshe")
    private String fshe;
    @Column(name = "fshe2")
    private String fshe2;
    @Column(name = "dfs")
    private String dfs;

    public TabelaPreco() {

    }

    public TabelaPreco(int id, String nome, String duhn, String duhe,
            String duhe2, String ddu, String fshn, String fshe,
            String fshe2, String dfs) {

        this.id = id;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
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
