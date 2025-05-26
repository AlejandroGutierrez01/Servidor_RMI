package Servicio;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServidorIImpl extends UnicastRemoteObject implements Servidor {
    private static ArrayList<Persona> listaPersonas(){
     ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(new Persona(2500,"Admin","alejandro@gmail.com","Alejandro",1));
        listaPersonas.add(new Persona(2500,"Cargo x","pedro@gmail.com","Pedro",2));
        listaPersonas.add(new Persona(2500,"Tecnico","marco@gmail.com","Marco",3));
        listaPersonas.add(new Persona(2500,"Secreterio","polo@gmail.com","Polo",4));
        listaPersonas.add(new Persona(2500,"Colaborador","cintia@gmail.com","Cintia",5));
        listaPersonas.add(new Persona(2500,"Admin","carlo@gmail.com","Carlo",6));
        listaPersonas.add(new Persona(2500,"Admin","david@gmail.com","David",7));
        listaPersonas.add(new Persona(2500,"Admin","comodo@gmail.com","Comodo",8));
        listaPersonas.add(new Persona(2500,"Admin","alejandro@gmail.com","Alejandro",9));
        return listaPersonas;
    }
    private static String getPersona(int id){
        return "Nombre: " + listaPersonas().get(id-1).getNombre()+"\n" +
                "Correo: " + listaPersonas().get(id-1).getCorreo()+"\n" +
                "Cargo: " + listaPersonas().get(id-1).getCargo()+"\n"+
                "Sueldo: " + listaPersonas().get(id-1).getSueldo()+"\n";
    }

    public ServidorIImpl() throws RemoteException {
        super();
    }
    @Override
    public String consultar (int id) throws Exception {
        if(id<listaPersonas().size()+1){
            return getPersona(id);
        }
        else{
            return "No existen los datos del empleado";
        }
    }

}


