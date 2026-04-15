package com.example.entregas.model;

import com.example.entregas.enums.CategoriaEntrega;

public class Entrega {

    private Long id;
    private String cliente;
    private Integer quantidadeCaixas;
    private Double valor;
    private CategoriaEntrega categoria;

    public Entrega() {
    }

    public Entrega(Long id, String cliente, Integer quantidadeCaixas, Double valor, CategoriaEntrega categoria) {
        this.id = id;
        this.cliente = cliente;
        this.quantidadeCaixas = quantidadeCaixas;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getQuantidadeCaixas() {
        return quantidadeCaixas;
    }

    public void setQuantidadeCaixas(Integer quantidadeCaixas) {
        this.quantidadeCaixas = quantidadeCaixas;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public CategoriaEntrega getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntrega categoria) {
        this.categoria = categoria;
    }
}
