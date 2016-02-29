package com.web.chon.bean;

import com.web.chon.dominio.Usuario;
import com.web.chon.service.ServiceUsuario;
import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
       
        try {
            usuario = getServiceUsuario().validarLogin(usuario);
            
            if (usuario.getStatus()) {
                  ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                context.redirect(context.getRequestContextPath() + "/views/welcome.jr");

                return "/content/welcome";
            } else {
                return "login";
            }
            
        } catch (Exception e) {
            return "login";
        }
        
    }
    
     public String doLogout() throws IOException{
        
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                context.redirect(context.getRequestContextPath() + "/login.jr");
        
        return "login";
    
    }

}
