package Servicio;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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
}
