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
@Table(name = "Usuario")
public class Usuario {

    @Id
    @Column(name = "usuario_id")
    @SequenceGenerator(name = "usuarioGenerator", sequenceName = "usuario_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioGenerator")
    private int id;
    @Column(name = "usuarioFirstName")
    private String usuarioFirstName;
    @Column(name = "usuarioLastName")
    private String usuarioLastName;
    @Column(name = "usuarioEmail")
    private String usuarioEmail;
    
    public Usuario(){
        
    }

    public Usuario(int id, String usuarioFirstName, String usuarioLastName, String usuarioEmail) {
        this.id = id;
        this.usuarioFirstName = usuarioFirstName;
        this.usuarioLastName = usuarioLastName;
        this.usuarioEmail = usuarioEmail;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuarioFirstName() {
        return usuarioFirstName;
    }

    public void setUsuarioFirstName(String usuarioFirstName) {
        this.usuarioFirstName = usuarioFirstName;
    }

    public String getUsuarioLastName() {
        return usuarioLastName;
    }

    public void setUsuarioLastName(String usuarioLastName) {
        this.usuarioLastName = usuarioLastName;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String email) {
        this.usuarioEmail = email;
    }

}
