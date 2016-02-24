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
public class VentaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    private BigDecimal idVentaProductoPk;
    private BigInteger precioProducto;
    private BigInteger kilosVendidos;
    private Producto idProductoFk;
    private TipoEmpaque idTipoEmpaqueFk;
    private TipoVenta idTipoVentaFk;

    public VentaProducto() {
    }

    public VentaProducto(BigDecimal idVentaProductoPk) {
        this.idVentaProductoPk = idVentaProductoPk;
    }

    public BigDecimal getIdVentaProductoPk() {
        return idVentaProductoPk;
    }

    public void setIdVentaProductoPk(BigDecimal idVentaProductoPk) {
        this.idVentaProductoPk = idVentaProductoPk;
    }

    public BigInteger getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigInteger precioProducto) {
        this.precioProducto = precioProducto;
    }

    public BigInteger getKilosVendidos() {
        return kilosVendidos;
    }

    public void setKilosVendidos(BigInteger kilosVendidos) {
        this.kilosVendidos = kilosVendidos;
    }

    public Producto getIdProductoFk() {
        return idProductoFk;
    }

    public void setIdProductoFk(Producto idProductoFk) {
        this.idProductoFk = idProductoFk;
    }

    public TipoEmpaque getIdTipoEmpaqueFk() {
        return idTipoEmpaqueFk;
    }

    public void setIdTipoEmpaqueFk(TipoEmpaque idTipoEmpaqueFk) {
        this.idTipoEmpaqueFk = idTipoEmpaqueFk;
    }

    public TipoVenta getIdTipoVentaFk() {
        return idTipoVentaFk;
    }

    public void setIdTipoVentaFk(TipoVenta idTipoVentaFk) {
        this.idTipoVentaFk = idTipoVentaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentaProductoPk != null ? idVentaProductoPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaProducto)) {
            return false;
        }
        VentaProducto other = (VentaProducto) object;
        if ((this.idVentaProductoPk == null && other.idVentaProductoPk != null) || (this.idVentaProductoPk != null && !this.idVentaProductoPk.equals(other.idVentaProductoPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.chon.entities.VentaProducto[ idVentaProductoPk=" + idVentaProductoPk + " ]";
    }
    
}
