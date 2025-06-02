package Servicio;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Objects;

public class ServidorIImpl extends UnicastRemoteObject implements Servidor {

    public ServidorIImpl() throws RemoteException {
        super();
    }

    @Override
    public String consultar(int id) throws Exception {
        ArrayList<Persona> listaPersonas = Consulta.getPersonas();

        // Validar si existe el empleado
        if (id > 0 && id <= listaPersonas.size()) {
            Persona persona = listaPersonas.get(id - 1);
            System.out.println(persona. getNombre() + " " +  persona.getCorreo()+ " " + persona.getCargo()+ " " + persona.getSueldo() );
            return "Nombre: " + persona.getNombre() + "\n" +
                    "Correo: " + persona.getCorreo() + "\n" +
                    "Cargo: " + persona.getCargo() + "\n" +
                    "Sueldo: " + persona.getSueldo() + "\n";

        } else {
            return "No existen los datos del empleado";
        }
    }

    @Override
    public String eliminarPersona(int id) throws Exception {
        try {
            Consulta.deletePersona(id);
            return "Empleado eliminado";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar al empleado";
        }
    }
    @Override
    public String registrarPersona(Persona persona) throws Exception {
        try {
            int id = persona.getId();
            if(Objects.equals(consultar(id), "No existen los datos del empleado")){
                Consulta.addPersona(persona);
            }
            else {
                return "El id ya esta registrado";
            }
            return "Empleado registrado";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar al empleado";
        }
    }
    @Override
    public String modificarPersona(Persona persona) throws Exception {
        try {
            Consulta.updatePersona(persona);
            return "Empleado actualizado";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error al actualizar al empleado";
        }
    }
}
