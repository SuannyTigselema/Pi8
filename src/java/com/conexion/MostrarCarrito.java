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
import javax.faces.view.ViewScoped;

/**
 *
 * @author Cristhian
 */
@Named(value = "mostrarCarrito")
@ViewScoped
public class MostrarCarrito implements Serializable{

    /**
     * Creates a new instance of MostrarCarrito
     */
    private List<ControladorCarrito> listacarrito;
    private VistaProducto vp;
    private ControladorCarrito conCartCl;
    private ControladorCarrito conCart;
    private ControladorCarrito conCartless;
    private String cantidad="1", subtotal, total;
    private float aux=0,aux2=0, precio=0; 
    
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    public ControladorCarrito getConCartCl() {
        return conCartCl;
    }

    public void setConCartCl(ControladorCarrito conCartCl) {
        this.conCartCl = conCartCl;
        listacarrito.remove(conCartCl);
    }
   
    
    public ControladorCarrito getConCartless() {
        return conCartless;
    }

    public void setConCartless(ControladorCarrito conCartless) {
        this.conCartless = conCartless;
        
        if(aux>1){
            aux= Float.parseFloat(cantidad)-1;
            setCantidad(String.valueOf(Math.round(aux)));
        }
        aux2=Float.parseFloat(cantidad)*Float.parseFloat(conCartless.getPrecioP());
         setSubtotal(String.valueOf(aux2));
         setTotal(String.valueOf(aux2));
    }
    
    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }
    

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    public ControladorCarrito getConCart() {
        return conCart;
    }

    public void setConCart(ControladorCarrito conCart) {
        this.conCart = conCart;
        //listacarrito.remove(conCart);
       // aux=aux+1;
       // precio= Integer.parseInt( conCart.getPrecioP());
       // setCantidad(String.valueOf(Integer.parseInt(String.valueOf(aux))));
       // setSubtotal(String.valueOf(aux*precio));
       aux= Float.parseFloat(cantidad)+1;
        setCantidad(String.valueOf(Math.round(aux)));
        
        aux2=Float.parseFloat(cantidad)*Float.parseFloat(conCart.getPrecioP());
         setSubtotal(String.valueOf(aux2));
         setTotal(String.valueOf(aux2));
    }
    public List<ControladorCarrito> getListacarrito() {
        return listacarrito;
    }

    public void setListacarrito(List<ControladorCarrito> listacarrito) {
        this.listacarrito = listacarrito;
    }

    public VistaProducto getVp() {
        return vp;
    }

    public void setVp(VistaProducto vp) {
        this.vp = vp;
    }
    public MostrarCarrito() {
    }
    
    @PostConstruct
    public void init(){
        listacarrito= new ArrayList<>();
        listacarrito=vp.getListacarrito();
       setTotal("0");
    }
    
}
