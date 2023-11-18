package com.example.smartmanager;

public class Treinamentos {
    private Long id;
    private String nome;
    private String ementa;
    private Integer cargahoraria;

    public Treinamentos(Long id, String nome, String ementa, Integer cargahoraria) {
        this.id = id;
        this.nome = nome;
        this.ementa = ementa;
        this.cargahoraria = cargahoraria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public Integer getCargahoraria() {
        return cargahoraria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public void setCargahoraria(Integer cargahoraria) {
        this.cargahoraria = cargahoraria;
    }
}
