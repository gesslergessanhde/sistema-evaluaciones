package com.universidad.tests.dto.response;

public class TestResumenResponse {
    private Long id;
    private String codigo;
    private String nombre;
    private int numeroSubpruebas;

    public TestResumenResponse() {}

    public TestResumenResponse(Long id, String codigo, String nombre, int numeroSubpruebas) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.numeroSubpruebas = numeroSubpruebas;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getNumeroSubpruebas() { return numeroSubpruebas; }
    public void setNumeroSubpruebas(int numeroSubpruebas) { this.numeroSubpruebas = numeroSubpruebas; }
}