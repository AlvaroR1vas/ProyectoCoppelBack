package com.BackEnd.BackEnd.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity

public class Poliza {

    @Id
    @GeneratedValue
    private Long idpoliza;
    private Long empleadogenero;
    private Long sku;
    private Long cantidad;

    private Date Fecha;

    public Long getIdpoliza() {
        return idpoliza;
    }

    public void setIdpoliza(Long idpoliza) {
        this.idpoliza = idpoliza;
    }

    public Long getEmpleadogenero() {
        return empleadogenero;
    }

    public void setEmpleadogenero(Long empleadogenero) {
        this.empleadogenero = empleadogenero;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }
}
