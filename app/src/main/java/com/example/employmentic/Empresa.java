package com.example.employmentic;

public class Empresa {

    String nombreEmpresa;
    String ubicacionEmpresa;
    int imagenEmpresa;
    Boolean selected;

    public Empresa(String nombreEmpresa, String ubicacionEmpresa, int imagenEmpresa, Boolean selected) {
        this.nombreEmpresa = nombreEmpresa;
        this.ubicacionEmpresa = ubicacionEmpresa;
        this.imagenEmpresa = imagenEmpresa;
        this.selected = selected;
    }
}
