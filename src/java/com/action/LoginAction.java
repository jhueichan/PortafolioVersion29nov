
package com.action;

import com.dao.DaoEmpleado;
import com.model.Empleado;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

public class LoginAction extends ActionSupport{
  private DaoEmpleado dao = new DaoEmpleado();
   private Empleado record;
   private String usu;
   private String cla;
    
    public String iniciarSesion() throws Exception{      
        try{
            System.out.println(usu+" - "+cla);
//           record = dao.validarUsuarioEmp(usu, cla);
           System.out.println("bienvenido: "+record.getNombres()+" desde el metodo iniciar sesion ");
        }catch(Exception e){
            System.out.println("error validacion en el action ----> IniciarSesion"+e.getMessage());
            e.printStackTrace();
        }
        if(record.getRut()!=null && !record.getRut().isEmpty()){
            Map<String, Object>sesionEmpleado = ActionContext.getContext().getSession();
            sesionEmpleado.put("sesionEmpleado",record);    
            addActionMessage("Bienvenido : " +record.getRut());
            //return SUCCESS;
            return Action.SUCCESS;
        }else{
            addActionError("Empleado y Clave son Incorrecto");
            //return ERROR;
            return Action.ERROR;
        }
    } 
    
     public String cerrarSesion() {
        Map sessionLogout = ActionContext.getContext().getSession();
        sessionLogout.remove("sesionEmpleado");
        addActionMessage("Has salido de su sesion");
        return SUCCESS;
     
     }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }
     
     
     
     
}