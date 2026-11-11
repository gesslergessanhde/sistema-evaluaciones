package com.universidad.tests.dto.response;

public class SubpruebaDetalleResponse {
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Integer orden;
    private Integer duracionMinutos;

    public SubpruebaDetalleResponse() {}

    public SubpruebaDetalleResponse(Long id, String codigo, String nombre, String descripcion, Integer orden, Integer duracionMinutos) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.orden = orden;
        this.duracionMinutos = duracionMinutos;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Integer getOrden() { return orden; }
    public void setOrden(Integer orden) { this.orden = orden; }
    public Integer getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(Integer duracionMinutos) { this.duracionMinutos = duracionMinutos; }
}