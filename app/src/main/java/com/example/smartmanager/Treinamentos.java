package com.example.smartmanager;

public class Treinamentos {
    private Long id;
    private String nome;
    private String ementa;
    private String cargahoraria;

    public Treinamentos(Long id, String nome, String ementa, String cargahoraria) {
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

    public String getCargahoraria() {
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

    public void setCargahoraria(String cargahoraria) {
        this.cargahoraria = cargahoraria;
    }
}
