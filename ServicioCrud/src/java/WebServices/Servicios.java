/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Dao.PersonaDao;
import Dao.TarjetaDao;
import Modelo.Persona;
import Modelo.Tarjeta;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author SirGohan
 */
@WebService(serviceName = "Servicios")
public class Servicios {
   
    PersonaDao Pdao = new PersonaDao();
    TarjetaDao Tdao = new TarjetaDao();
    //metodo para consultar una lista de personas
    @WebMethod(operationName = "listarPersona")  
    public List<Persona> listarPersona() {
        List datos = Pdao.listar();
        return datos;
    }
   //metodo para agregar una persona
    @WebMethod(operationName = "agregarPersona")
    public String agregarPersona(@WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "telefono") String telefono, @WebParam(name = "direccion") String direccion, @WebParam(name = "correo") String correo , @WebParam(name = "idTarjeta") int idtarjeta) {
       String datos= Pdao.add(nombres, apellidos, telefono, direccion, correo,idtarjeta);
       return datos;
    }
   //metodo para Consultar una persona
    @WebMethod(operationName = "personaId")
    public Persona personaId(@WebParam(name = "id") int id) {
      Persona per= Pdao.listarId(id);
        return per;
    }
  //metodo para editar una persona
    @WebMethod(operationName = "editarPersona")
    public String editarPersona(@WebParam(name = "id") int id, @WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "telefono") String telefono, @WebParam(name = "direccion") String direccion, @WebParam(name = "correo") String correo, @WebParam(name = "idTarjeta") int idtarjeta) {
        String datos= Pdao.edit(id,nombres, apellidos, telefono, direccion, correo,idtarjeta);
       return datos;
    }
     //metodo para eliminar una persona
    @WebMethod(operationName = "eliminarPersona")
    public String eliminarPersona(@WebParam(name = "id") int id) {
        String datos= Pdao.delete(id);
       return datos;
    }

     //metodo para consultar una lista de personas
    @WebMethod(operationName = "listarTarjetas")  
    public List<Tarjeta> listarTarjetas() {
        List datos = Tdao.listarTajeta();
        return datos;
    }
    //metodo para consultar una lista de personas
    @WebMethod(operationName = "listarTarjetasLibres")  
    public List<Tarjeta> listarTarjetasLibres() {
        List datos = Tdao.listarTajetasLibres();
        return datos;
    }
   //metodo para agregar una persona
    @WebMethod(operationName = "agregarTarjeta")
    public String agregarTarjeta(@WebParam(name = "nombres") String nombres, @WebParam(name = "agno") int agno, @WebParam(name = "mes") int mes, @WebParam(name = "codigo") int codigo) {
       String datos= Tdao.addTarjeta(nombres, agno, mes, codigo);
       return datos;
    }
   //metodo para Consultar una persona
    @WebMethod(operationName = "tarjetaId")
    public Tarjeta tarjetaId(@WebParam(name = "id") int id) {
      Tarjeta tar= Tdao.tarjetaId(id);
        return tar;
    }
  //metodo para editar una persona
    @WebMethod(operationName = "editarTarjeta")
    public String editarTarjeta(@WebParam(name = "id") int id,@WebParam(name = "nombres") String nombres, @WebParam(name = "agno") int agno, @WebParam(name = "mes") int mes, @WebParam(name = "codigo") int codigo) {
        String datos= Tdao.editTarjeta(id,nombres, agno, mes, codigo);
       return datos;
    }
     //metodo para eliminar una persona
    @WebMethod(operationName = "eliminarTarjeta")
    public String eliminarTarjeta(@WebParam(name = "id") int id) {
        String datos= Tdao.deleteTarjeta(id);
       return datos;
    }
    
}
