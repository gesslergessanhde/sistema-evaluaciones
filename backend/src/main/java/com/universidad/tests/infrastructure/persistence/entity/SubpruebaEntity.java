package com.universidad.tests.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subpruebas")
public class SubpruebaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "orden_aplicacion", nullable = false)
    private Integer orden;

    @Column(name = "duracion_minutos")
    private Integer duracionMinutos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_test", nullable = false)
    private TestEntity test;

    public SubpruebaEntity() {}

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
    public TestEntity getTest() { return test; }
    public void setTest(TestEntity test) { this.test = test; }
}