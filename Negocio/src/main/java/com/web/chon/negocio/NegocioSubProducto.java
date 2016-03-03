package com.web.chon.negocio;

import com.web.chon.dominio.Subproducto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author marcogante
 */
@Remote
public interface NegocioSubProducto {
    
    public List<Object[]> getSubProductos();
    public int deleteSubProducto(String idProducto);
    public int insertarSubProducto(Subproducto subProducto);
    public int updateSubProducto(Subproducto subProducto);
    
    /**
     * Devuelve el id del siguiente id a registrar en productos 
     * @param idCategoria
     * @return 
     */
    public int getLastIdProducto(String idCategoria);
    

}
