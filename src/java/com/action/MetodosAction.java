
package com.action;

import com.dao.DaoEmpleado;
import com.model.Empleado;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;

public class MetodosAction extends ActionSupport{
    
    
   // int idEmpleado, idCliente;
    String usu;
    String cla;
   // public int tip;
   // List<Pagina> listarPaginas = null;
//     public String IniciarSesion() throws Exception{
//        Empleado usuario = new Empleado();
//         DaoEmpleado ud = new DaoEmpleado();
//        try{
//            usuario = ud.validarEmpleado(usu, cla);
//        }catch(Exception e){
//            System.out.println("error valida en el action ----> IniciarSesion"+e.getMessage());
//            e.printStackTrace();
//        }
//        if(usuario.getEmpleado()!=null){
//            Map<String, Object>sesionEmpleado = ActionContext.getContext().getSession();
//            sesionEmpleado.put("sesionEmpleado", usuario);
//            if(usuario.getTipo().getIdTipo() == 1){
//                        //con esto listo los datos del cliente
//                        idEmpleado = usuario.getIdEmpleado();
//                        DatosCliente(idEmpleado);
//                //pregunto qe tipo de usuario es para listar el menu dinamico
//                tip = 1;
//                ListarPaginas(tip);
//            }else if(usuario.getTipo().getIdTipo() == 2){
//                tip = 2;
//                ListarPaginas(tip);
//            }else{
//                tip = 3;
//                ListarPaginas(tip);
//            }
//            addActionMessage("Bienvenido : " + usuario.getEmpleado());
//            return SUCCESS;
//        }else{
//            addActionError("Empleado y Clave son Incorrecto");
//            return ERROR;
//        }
//    }
}
