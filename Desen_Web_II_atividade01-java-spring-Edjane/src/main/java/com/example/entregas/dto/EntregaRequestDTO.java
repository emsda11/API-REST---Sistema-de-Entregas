package com.example.entregas.dto;

import com.example.entregas.enums.CategoriaEntrega;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EntregaRequestDTO {

    @NotBlank(message = "O campo cliente é obrigatório.")
    private String cliente;

    @NotNull(message = "O campo quantidadeCaixas é obrigatório.")
    @Min(value = 1, message = "O campo quantidadeCaixas deve ser maior ou igual a 1.")
    private Integer quantidadeCaixas;

    @NotNull(message = "O campo categoria é obrigatório.")
    private CategoriaEntrega categoria;

    public EntregaRequestDTO() {
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

    public CategoriaEntrega getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntrega categoria) {
        this.categoria = categoria;
    }
}
