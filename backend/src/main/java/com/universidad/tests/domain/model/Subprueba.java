package com.universidad.tests.domain.model;

public class Subprueba {
    private final Long id;
    private final String codigo;
    private final String nombre;
    private final String descripcion;
    private final Integer orden;
    private final Integer duracionMinutos;

    public Subprueba(Long id, String codigo, String nombre, String descripcion, Integer orden, Integer duracionMinutos) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.orden = orden;
        this.duracionMinutos = duracionMinutos;
    }

    public Long getId() { return id; }
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public Integer getOrden() { return orden; }
    public Integer getDuracionMinutos() { return duracionMinutos; }
}