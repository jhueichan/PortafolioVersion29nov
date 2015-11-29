/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author jorge
 */
public class Material {
  
    private int codigo;
    private String articulo;
    private String marca;
    private String u_medida;
     
     
     
     
     
    public Material(int codigo, String articulo, String u_medida, String marca) {
        this.codigo = codigo;
        this.articulo = articulo;
        this.u_medida = u_medida;
        this.marca = marca;
    }

    public Material() {
    }
    
 

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getU_medida() {
        return u_medida;
    }

    public void setU_medida(String u_medida) {
        this.u_medida = u_medida;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
       
}
