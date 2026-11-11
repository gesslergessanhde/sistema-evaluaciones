package com.universidad.tests.domain.model;

import java.util.Collections;
import java.util.List;

public class Test {
    private final Long id;
    private final String codigo;
    private final String nombre;
    private final String descripcion;
    private final Boolean activo;
    private final List<Subprueba> subpruebas;

    public Test(Long id, String codigo, String nombre, String descripcion, Boolean activo, List<Subprueba> subpruebas) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
        this.subpruebas = subpruebas != null ? subpruebas : Collections.emptyList();
    }

    public Long getId() { return id; }
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public Boolean getActivo() { return activo; }
    public List<Subprueba> getSubpruebas() { return subpruebas; }
    public int getNumeroSubpruebas() { return subpruebas.size(); }
}