/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.chon.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author marcogante
 */
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    private BigDecimal idVentaPk;
    private Date fechaVenta;
    private Date fechaPromesaPago;
    private Usuario idClienteFk;
    private Usuario idVendedorFk;

    public Venta() {
    }

    public Venta(BigDecimal idVentaPk) {
        this.idVentaPk = idVentaPk;
    }

    public BigDecimal getIdVentaPk() {
        return idVentaPk;
    }

    public void setIdVentaPk(BigDecimal idVentaPk) {
        this.idVentaPk = idVentaPk;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaPromesaPago() {
        return fechaPromesaPago;
    }

    public void setFechaPromesaPago(Date fechaPromesaPago) {
        this.fechaPromesaPago = fechaPromesaPago;
    }

    public Usuario getIdClienteFk() {
        return idClienteFk;
    }

    public void setIdClienteFk(Usuario idClienteFk) {
        this.idClienteFk = idClienteFk;
    }

    public Usuario getIdVendedorFk() {
        return idVendedorFk;
    }

    public void setIdVendedorFk(Usuario idVendedorFk) {
        this.idVendedorFk = idVendedorFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentaPk != null ? idVentaPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVentaPk == null && other.idVentaPk != null) || (this.idVentaPk != null && !this.idVentaPk.equals(other.idVentaPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.chon.entities.Venta[ idVentaPk=" + idVentaPk + " ]";
    }
    
}
