
package com.model;
public class Proveedor {
    
    private String rut,razon_social,direccion,contacto,telefono,email,website,activo;
    private String ciudad;
    private String formaPago;
    

    public Proveedor(String rut, String razon_social, String direccion, String contacto, String telefono, String email, String website, String activo, String  ciudad, String formaPago) {
        this.rut = rut;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.contacto = contacto;
        this.telefono = telefono;
        this.email = email;
        this.website = website;
        this.activo = activo;
        this.ciudad = ciudad;
        this.formaPago = formaPago;
    }

   
    
    public Proveedor() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

  
    
    
}
