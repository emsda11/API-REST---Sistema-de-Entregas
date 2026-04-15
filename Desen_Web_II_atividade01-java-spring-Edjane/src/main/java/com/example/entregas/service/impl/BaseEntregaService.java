package com.example.entregas.service.impl;

import com.example.entregas.dto.EntregaRequestDTO;
import com.example.entregas.dto.EntregaResponseDTO;
import com.example.entregas.enums.CategoriaEntrega;
import com.example.entregas.exception.RecursoNaoEncontradoException;
import com.example.entregas.model.Entrega;
import com.example.entregas.repository.EntregaRepository;
import com.example.entregas.service.EntregaService;

import java.util.List;

public abstract class BaseEntregaService implements EntregaService {

    protected final EntregaRepository repository;

    protected BaseEntregaService(EntregaRepository repository) {
        this.repository = repository;
    }

    protected abstract double calcularValor(EntregaRequestDTO dto);

    protected void validarRegraNegocio(EntregaRequestDTO dto) {
    }

    @Override
    public EntregaResponseDTO criar(EntregaRequestDTO dto) {
        validarRegraNegocio(dto);

        Entrega entrega = new Entrega();
        entrega.setCliente(dto.getCliente());
        entrega.setQuantidadeCaixas(dto.getQuantidadeCaixas());
        entrega.setCategoria(dto.getCategoria());
        entrega.setValor(calcularValor(dto));

        return toResponse(repository.save(entrega));
    }

    @Override
    public List<EntregaResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public EntregaResponseDTO buscarPorId(Long id) {
        Entrega entrega = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Entrega com id " + id + " não encontrada."));
        return toResponse(entrega);
    }

    @Override
    public EntregaResponseDTO atualizar(Long id, EntregaRequestDTO dto) {
        validarRegraNegocio(dto);

        Entrega entrega = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Entrega com id " + id + " não encontrada."));

        entrega.setCliente(dto.getCliente());
        entrega.setQuantidadeCaixas(dto.getQuantidadeCaixas());
        entrega.setCategoria(dto.getCategoria());
        entrega.setValor(calcularValor(dto));

        return toResponse(repository.save(entrega));
    }

    @Override
    public void deletar(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Entrega com id " + id + " não encontrada."));
        repository.deleteById(id);
    }

    @Override
    public List<EntregaResponseDTO> buscarPorCategoria(CategoriaEntrega categoria) {
        return repository.buscarPorCategoria(categoria)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    protected EntregaResponseDTO toResponse(Entrega entrega) {
        return new EntregaResponseDTO(
                entrega.getId(),
                entrega.getCliente(),
                entrega.getQuantidadeCaixas(),
                entrega.getValor(),
                entrega.getCategoria()
        );
    }
}