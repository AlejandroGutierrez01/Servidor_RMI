package Servicio;

import lombok.Getter;
import lombok.Setter;

public class Persona {
    @Getter @Setter int id;
    @Getter @Setter private String nombre;
    @Getter @Setter private String correo;
    @Getter @Setter private String cargo;
    @Getter @Setter private double sueldo;

    public Persona(int id, String nombre, String correo, String cargo, double sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }
}
