/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author JoseRene
 */
@Named(value = "producto")
@RequestScoped
public class Producto implements Serializable {

    private static String auxTipo;
    private static String auxPrecio;

    public static String getAuxPrecio() {
        return auxPrecio;
    }

    public static void setAuxPrecio(String auxPrecio) {
        Producto.auxPrecio = auxPrecio;
    }

    public static String getAuxTipo() {
        return auxTipo;
    }

    public static void setAuxTipo(String auxTipo) {
        Producto.auxTipo = auxTipo;
    }

    List<Producto_Final> imagenes = new ArrayList<>();

    private String tipo_producto, precio;

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
        auxPrecio = this.precio;
        if (precio.equals("asc") && auxTipo != null) {
            Conexion con = new Conexion();
            imagenes = con.filtroTipoComidaPrecioMenorMayor(Integer.parseInt(auxTipo));
        } else if (precio.equals("desc") && auxTipo != null) {
            Conexion con = new Conexion();
            imagenes = con.filtroTipoComidaPrecioMayorMenor(Integer.parseInt(auxTipo));
        }

        if (precio.equals("asc") && auxTipo == null) {
            Conexion con = new Conexion();
            imagenes = con.flitroSoloPrecioMenorMayor();
        } else if (precio.equals("desc") && auxTipo == null) {
            Conexion con = new Conexion();
            imagenes = con.flitroSoloPrecioMayorMenor();
        }
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
        auxTipo = this.tipo_producto;

        if (auxPrecio == null) {
            Conexion con = new Conexion();
            imagenes = con.filtroTipoComida(Integer.parseInt(tipo_producto));
        }
        if (auxPrecio != null) {
            if (auxPrecio.equals("asc")) {
                Conexion con = new Conexion();
                imagenes = con.filtroTipoComidaPrecioMenorMayor(Integer.parseInt(auxTipo));
            } else if (auxPrecio.equals("desc")) {
                Conexion con = new Conexion();
                imagenes = con.filtroTipoComidaPrecioMayorMenor(Integer.parseInt(auxTipo));
            }
        }

    }

    public List<Producto_Final> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Producto_Final> imagenes) {
        this.imagenes = imagenes;
    }

    @PostConstruct
    public void init() {
        Conexion con = new Conexion();
        imagenes = con.fotosProdcuto();
    }

    public Producto() {
    }

}
