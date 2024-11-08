package com.example.lab8_20206464.Beans;

public class Actor {
    private int idActor;
    private String Nombre;
    private String Apellido;
    private int anoNacimiento;
    private int premioOscar;

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(int anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public int getPremioOscar() {
        return premioOscar;
    }

    public void setPremioOscar(int premioOscar) {
        this.premioOscar = premioOscar;
    }
}