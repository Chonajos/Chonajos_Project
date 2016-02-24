package com.web.chon.bean;

import com.web.chon.dominio.Usuario;
import com.web.chon.service.ServiceUsuario;

/**
 *
 * @author marcogante
 */
public class BeanUsuario {

    private Usuario usuario;
    private ServiceUsuario serviceUsuario;

    public ServiceUsuario getServiceUsuario() {
        return serviceUsuario;
    }

    public void setServiceUsuario(ServiceUsuario serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String validarLogin() {
        System.out.println("Ususario : " + getUsuario().getClaveUsuario());
        System.out.println("Password : " + getUsuario().getContrasenaUsuario());
        try {
            usuario = getServiceUsuario().validarLogin(usuario);
            
            if (usuario.getStatus()) {
                return "/content/welcome";
            } else {
                return "login";
            }
            
        } catch (Exception e) {
            return "login";
        }
        
    }

}
