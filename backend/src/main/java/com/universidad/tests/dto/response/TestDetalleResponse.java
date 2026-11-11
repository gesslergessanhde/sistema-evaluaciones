package com.universidad.tests.dto.response;

import java.util.List;

public class TestDetalleResponse {
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private List<SubpruebaDetalleResponse> subpruebas;

    public TestDetalleResponse() {}

    public TestDetalleResponse(Long id, String codigo, String nombre, String descripcion, List<SubpruebaDetalleResponse> subpruebas) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.subpruebas = subpruebas;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public List<SubpruebaDetalleResponse> getSubpruebas() { return subpruebas; }
    public void setSubpruebas(List<SubpruebaDetalleResponse> subpruebas) { this.subpruebas = subpruebas; }
}