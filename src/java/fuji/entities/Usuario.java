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
public class Usuario {

    private int id;
    private String usuarioFirstName;
    private String usuarioLastName;
    private String usuarioEmail;

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
