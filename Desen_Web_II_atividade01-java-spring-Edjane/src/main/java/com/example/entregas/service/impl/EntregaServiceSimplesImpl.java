package com.example.entregas.service.impl;

import com.example.entregas.dto.EntregaRequestDTO;
import com.example.entregas.exception.RegraNegocioException;
import com.example.entregas.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("simples")
public class EntregaServiceSimplesImpl extends BaseEntregaService {

    public EntregaServiceSimplesImpl(EntregaRepository repository) {
        super(repository);
    }

    @Override
    protected double calcularValor(EntregaRequestDTO dto) {
        return dto.getQuantidadeCaixas() > 10 ? 100.0 : 50.0;
    }

    @Override
    protected void validarRegraNegocio(EntregaRequestDTO dto) {
        if (dto.getCategoria().name().equals("EXPRESSA")) {
            throw new RegraNegocioException("A implementação simples aceita apenas categoria SIMPLES.");
        }
    }
}