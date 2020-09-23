
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
    private String subtotal, total;
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
          listacarrito= new ArrayList<>();
        listacarrito=vp.getListacarrito();
        float aux3=0;
        for (int i = 0; i < listacarrito.size(); i++) {
            aux3= (Float.parseFloat(listacarrito.get(i).getPrecioP())*Float.parseFloat(listacarrito.get(i).getCantidad()))+aux3; 
        }
        setTotal(String.valueOf(aux3));
    }
   
    
    public ControladorCarrito getConCartless() {
        return conCartless;
    }

    public void setConCartless(ControladorCarrito conCartless) {
        this.conCartless = conCartless;
        //conCartless.setCantidad(cantidad);
        if(aux>1){
            aux= Float.parseFloat(conCartless.getCantidad())-1;
            conCartless.setCantidad(String.valueOf(Math.round(aux)));
        }
        aux2=Float.parseFloat(conCartless.getCantidad())*Float.parseFloat(conCartless.getPrecioP());
         conCart.setSubtotal(String.valueOf(aux2));

         listacarrito= new ArrayList<>();
        listacarrito=vp.getListacarrito();
        float aux3=0;
        for (int i = 0; i < listacarrito.size(); i++) {
            aux3= (Float.parseFloat(listacarrito.get(i).getPrecioP())*Float.parseFloat(listacarrito.get(i).getCantidad()))+aux3; 
        }
        setTotal(String.valueOf(aux3));
         
         
    }
    
    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
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
       aux= Float.parseFloat(conCart.getCantidad())+1;
        conCart.setCantidad(String.valueOf(Math.round(aux)));
        
        aux2=Float.parseFloat(conCart.getCantidad())*Float.parseFloat(conCart.getPrecioP());
         conCart.setSubtotal(String.valueOf(aux2));
        
        
         listacarrito= new ArrayList<>();
        listacarrito=vp.getListacarrito();
        float aux3=0;
        for (int i = 0; i < listacarrito.size(); i++) {
            aux3= (Float.parseFloat(listacarrito.get(i).getPrecioP())*Float.parseFloat(listacarrito.get(i).getCantidad()))+aux3; 
        }
        setTotal(String.valueOf(aux3));
         
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
        float aux3=0;
        for (int i = 0; i < listacarrito.size(); i++) {
            aux3= Float.parseFloat(listacarrito.get(i).getPrecioP())+aux3; 
        }
        setTotal(String.valueOf(aux3));
    }
    
}
