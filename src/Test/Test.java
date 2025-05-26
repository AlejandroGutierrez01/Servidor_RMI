package Test;

import Servicio.ServidorIImpl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Test {
    public static void main(String[] args) throws Exception {
        //ServidorIImpl server = new ServidorIImpl();
        //server.consultar(5);
        LocateRegistry.createRegistry(1099);
        ServidorIImpl serv = new ServidorIImpl();
        String rmiObjecName = "rmi://localhost/Datos";
        Naming.rebind(rmiObjecName, serv);
        System.out.println("Servidor conectado");
    }
}
