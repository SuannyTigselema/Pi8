/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author JoseRene
 */
@Named(value = "ingresarLogin")
@SessionScoped
public class IngresarLogin implements Serializable {

    
    private String usu,contra;

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    public String conectar()
    {
        Conexion con= new Conexion();
        int id;
        id=con.id(usu,contra);
        if(id!=0){
            
           return "faces/inicio.xhtml";
        }
        else{
            System.err.println("No vale");
        }
        return "";
    }
    public String pb(){
         return "faces/RegistrarCliente.xhtml";
    }
    
   
    
    
    public IngresarLogin() {
    }
    
}
