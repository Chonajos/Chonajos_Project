/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.chon.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author marcogante
 */
public class Subproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    private BigDecimal idSubproductoPk;
    private String nombreSubproducto;
    private String descripcionSubproducto;
    private String urlImagenSubproducto;
    private BigInteger precioMinimo;
    private BigInteger precioMaximo;
    private Producto idProductoFk;

    public Subproducto() {
    }

    public Subproducto(BigDecimal idSubproductoPk) {
        this.idSubproductoPk = idSubproductoPk;
    }

    public Subproducto(BigDecimal idSubproductoPk, String nombreSubproducto) {
        this.idSubproductoPk = idSubproductoPk;
        this.nombreSubproducto = nombreSubproducto;
    }

    public BigDecimal getIdSubproductoPk() {
        return idSubproductoPk;
    }

    public void setIdSubproductoPk(BigDecimal idSubproductoPk) {
        this.idSubproductoPk = idSubproductoPk;
    }

    public String getNombreSubproducto() {
        return nombreSubproducto;
    }

    public void setNombreSubproducto(String nombreSubproducto) {
        this.nombreSubproducto = nombreSubproducto;
    }

    public String getDescripcionSubproducto() {
        return descripcionSubproducto;
    }

    public void setDescripcionSubproducto(String descripcionSubproducto) {
        this.descripcionSubproducto = descripcionSubproducto;
    }

    public String getUrlImagenSubproducto() {
        return urlImagenSubproducto;
    }

    public void setUrlImagenSubproducto(String urlImagenSubproducto) {
        this.urlImagenSubproducto = urlImagenSubproducto;
    }

    public BigInteger getPrecioMinimo() {
        return precioMinimo;
    }

    public void setPrecioMinimo(BigInteger precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    public BigInteger getPrecioMaximo() {
        return precioMaximo;
    }

    public void setPrecioMaximo(BigInteger precioMaximo) {
        this.precioMaximo = precioMaximo;
    }

    public Producto getIdProductoFk() {
        return idProductoFk;
    }

    public void setIdProductoFk(Producto idProductoFk) {
        this.idProductoFk = idProductoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubproductoPk != null ? idSubproductoPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subproducto)) {
            return false;
        }
        Subproducto other = (Subproducto) object;
        if ((this.idSubproductoPk == null && other.idSubproductoPk != null) || (this.idSubproductoPk != null && !this.idSubproductoPk.equals(other.idSubproductoPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.chon.entities.Subproducto[ idSubproductoPk=" + idSubproductoPk + " ]";
    }
    
}
