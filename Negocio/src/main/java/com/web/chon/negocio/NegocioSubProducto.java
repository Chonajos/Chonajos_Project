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
    public int deleteSubProducto(int idProducto);
    public int insertarSubProducto(Subproducto subProducto);
    public int updateSubProducto(Subproducto subProducto);
    

}
