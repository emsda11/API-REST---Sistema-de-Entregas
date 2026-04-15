package com.example.entregas.service;

import com.example.entregas.dto.EntregaRequestDTO;
import com.example.entregas.dto.EntregaResponseDTO;
import com.example.entregas.enums.CategoriaEntrega;

import java.util.List;

public interface EntregaService {
    EntregaResponseDTO criar(EntregaRequestDTO dto);
    List<EntregaResponseDTO> listar();
    EntregaResponseDTO buscarPorId(Long id);
    EntregaResponseDTO atualizar(Long id, EntregaRequestDTO dto);
    void deletar(Long id);
    List<EntregaResponseDTO> buscarPorCategoria(CategoriaEntrega categoria);
}