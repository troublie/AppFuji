/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.entities;

import java.util.Date;
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
@Table(name = "cotacao")
public class Cotacao {

    @Id
    @Column(name = "cotacao_id")
    @SequenceGenerator(name = "cotacaoGenerator", sequenceName = "cotacao_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cotacaoGenerator")
    private int id;
    @Column(name = "contatoNome")
    private String contatoNome;
    @Column(name = "data")
    private Date date;
    @Column(name = "usuarioFirstName")
    private String usuarioFirstName;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "ref")
    private String ref;
    @Column(name = "os")
    private String os;
    @Column(name = "totalgeral")
    private double total;
    
    public Cotacao(){
        
    }

    public Cotacao(int id, String contatoNome, Date date, String usuarioFirstName,
            String descricao, String ref, String os, Double total) {
        
        this.id = id;
        this.contatoNome = contatoNome;
        this.date = date;
        this.usuarioFirstName = usuarioFirstName;
        this.descricao = descricao;
        this.ref = ref;
        this.os = os;
        this.total = total;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContatoNome() {
        return contatoNome;
    }

    public void setContatoNome(String contatoNome) {
        this.contatoNome = contatoNome;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsuarioFirstName() {
        return usuarioFirstName;
    }

    public void setUsuarioFirstName(String usuarioFirstName) {
        this.usuarioFirstName = usuarioFirstName;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
