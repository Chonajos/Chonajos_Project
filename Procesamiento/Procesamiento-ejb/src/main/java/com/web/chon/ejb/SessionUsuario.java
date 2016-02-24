/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.chon.ejb;

import com.web.chon.dominio.Usuario;
import com.web.chon.negocio.NegocioLogin;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author marcogante
 */
@Stateless(mappedName = "ejbUsuario")
public class SessionUsuario implements NegocioLogin {

    @PersistenceContext(unitName = "persistenceJR")
    EntityManager em;

    @Override
    public Usuario validarLogin(Usuario obj) throws Exception {

        try {
            Query query = em.createNamedQuery("Usuario.findByClaveUsuarioAndContrasenaUsuario");
            query.setParameter("claveUsuario", obj.getClaveUsuario().trim());
            query.setParameter("contrasenaUsuario", obj.getContrasenaUsuario().trim());
            System.out.println("paso query " + query );
            List lista = query.getResultList();
            System.out.println("datos de lista" + lista.toString());
            if (lista.size() > 0) {
                System.out.println("usuario encontrado");
                obj.setMensaje("Usuario encontrado");
                obj.setStatus(true);
            } else {
                System.out.println("NO ENCONTRADO");
                obj.setMensaje("Usuario no encontrado");
                obj.setStatus(false);
            }

            return obj;
        } catch (Exception ex) {
            throw new Exception("Error al validar el usuario " + ex.getMessage());
        }
    }
}
