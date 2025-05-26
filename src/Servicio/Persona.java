package Servicio;

import lombok.Getter;

public class Persona {
    @Getter private int clave;
    @Getter private String nombre;
    @Getter private String correo;
    @Getter private String cargo;
    @Getter private double sueldo;

    public Persona(double sueldo, String cargo, String correo, String nombre, int clave) {
        this.sueldo = sueldo;
        this.cargo = cargo;
        this.correo = correo;
        this.nombre = nombre;
        this.clave = clave;
    }
}
