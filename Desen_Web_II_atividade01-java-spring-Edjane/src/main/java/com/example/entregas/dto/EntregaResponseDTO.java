package com.example.entregas.dto;

import com.example.entregas.enums.CategoriaEntrega;

public class EntregaResponseDTO {

    private Long id;
    private String cliente;
    private Integer quantidadeCaixas;
    private Double valor;
    private CategoriaEntrega categoria;

    public EntregaResponseDTO() {
    }

    public EntregaResponseDTO(Long id, String cliente, Integer quantidadeCaixas, Double valor, CategoriaEntrega categoria) {
        this.id = id;
        this.cliente = cliente;
        this.quantidadeCaixas = quantidadeCaixas;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public Integer getQuantidadeCaixas() {
        return quantidadeCaixas;
    }

    public Double getValor() {
        return valor;
    }

    public CategoriaEntrega getCategoria() {
        return categoria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setQuantidadeCaixas(Integer quantidadeCaixas) {
        this.quantidadeCaixas = quantidadeCaixas;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setCategoria(CategoriaEntrega categoria) {
        this.categoria = categoria;
    }
}