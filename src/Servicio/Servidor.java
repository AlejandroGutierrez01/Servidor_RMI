package Servicio;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Servidor extends Remote {
    //Consultar id del empleado, devuleve un string
    public String consultar(int id) throws Exception;
    public String registrarPersona(Persona persona) throws Exception;
    public String eliminarPersona(int id) throws Exception;
    public String modificarPersona(Persona persona) throws Exception;
}
