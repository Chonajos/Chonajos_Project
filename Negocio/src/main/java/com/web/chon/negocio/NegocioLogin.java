package com.web.chon.negocio;

import com.web.chon.dominio.Usuario;
import javax.ejb.Remote;

/**
 *
 * @author marcogante
 */
@Remote
public interface NegocioLogin {
    Usuario validarLogin(Usuario obj) throws Exception;
}
