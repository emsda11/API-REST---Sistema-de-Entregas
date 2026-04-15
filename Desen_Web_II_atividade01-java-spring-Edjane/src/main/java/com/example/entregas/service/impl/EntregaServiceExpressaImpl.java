package com.example.entregas.service.impl;

import com.example.entregas.dto.EntregaRequestDTO;
import com.example.entregas.exception.RegraNegocioException;
import com.example.entregas.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("expressa")
public class EntregaServiceExpressaImpl extends BaseEntregaService {

    public EntregaServiceExpressaImpl(EntregaRepository repository) {
        super(repository);
    }

    @Override
    protected double calcularValor(EntregaRequestDTO dto) {
        return dto.getQuantidadeCaixas() > 10 ? 180.0 : 120.0;
    }

    @Override
    protected void validarRegraNegocio(EntregaRequestDTO dto) {
        if (dto.getCategoria().name().equals("SIMPLES")) {
            throw new RegraNegocioException("A implementação expressa aceita apenas categoria EXPRESSA.");
        }
    }
}